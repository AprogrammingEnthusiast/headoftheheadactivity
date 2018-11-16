package com.yiscn.common.http;


import org.apache.http.HttpHost;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

/**
 * Created by DengLibin on 2017/7/4.
 */
public class HttpConnectionPoolManager {
    private static HttpConnectionPoolManager manager = new HttpConnectionPoolManager();

    private PoolingHttpClientConnectionManager cm;
    private PoolingHttpClientConnectionManager sslCm;
    private SocketConfig socketConfig;
    private ConnectionConfig connectionConfig;
    //整个连接池最大连接数
    private  int connection_pool = 100;
    /**
     * 路由最大连接数，默认值是2,对于同一个目标机器的最大并发连接
     */
    private  int route_num = 1000;
    private SSLContext sslcontext;
    private SSLConnectionSocketFactory sslsf;
    private Registry<ConnectionSocketFactory> registry;
    private HttpHost proxy;
    {
        socketConfig = SocketConfig.custom().setSoKeepAlive(true).build();
        connectionConfig =ConnectionConfig.DEFAULT;

        //全部信任
        try {
            sslcontext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
                // .loadKeyMaterial()加载客户端证书
                //加载服务端提供的truststore(如果服务器提供truststore的话就不用忽略对服务器端证书的校验了)
                //.loadTrustMaterial(new File("D:\\truststore.jks"), "123456".toCharArray(),
                //        new TrustSelfSignedStrategy())
                //  .loadKeyMaterial(keyStore, "cmcc".toCharArray())
            }).build();

        sslsf = new SSLConnectionSocketFactory(sslcontext, new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2"}, null, NoopHostnameVerifier.INSTANCE);
        registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", new PlainConnectionSocketFactory())
                .register("https", sslsf)
                .build();
            cm = new PoolingHttpClientConnectionManager(registry);
            // 整个连接池最大连接数
            cm.setMaxTotal(connection_pool);
            // 每路由最大连接数，默认值是2,对于同一个目标机器的最大并发连接
            cm.setDefaultMaxPerRoute(route_num);
            cm.setDefaultSocketConfig(socketConfig);
            cm.setValidateAfterInactivity(200);
            cm.setDefaultConnectionConfig(connectionConfig);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
    }

    public static HttpConnectionPoolManager getInstance(){
        return manager;
    }

    public PoolingHttpClientConnectionManager getPoolingHttpClientConnectionManager(){
        return cm;
    }


    public void closeExpiredConnections(){
        cm.closeExpiredConnections();
    }

    public void closeIdleConnections(int seconds){
        cm.closeIdleConnections(seconds, TimeUnit.SECONDS);
    }
}
