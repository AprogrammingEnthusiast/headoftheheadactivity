package com.yiscn.common.http;

import com.yiscn.common.util.SpringBootLogger;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.protocol.HttpContext;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

/**
 *
 *    http请求重试策略
 *
 * @author wangj
 * @date 2018/7/6 11:26
 * Life is so short,do something to make yourself happy,such as coding
 */
public class HttpRequestRetryHandlerManager {
    private static HttpRequestRetryHandlerManager manager = new HttpRequestRetryHandlerManager();
    /**
     * 请求重试处理
     */
    private HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
        @Override
        public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
            SpringBootLogger.info("http请求重试次数:"+executionCount);
            // 重试次数
            if (executionCount >= 0) {
                return false;
            }
            // 如果服务器丢掉了连接，那么就重试
            if (exception instanceof NoHttpResponseException) {
                return true;
            }
            // 不要重试SSL握手异常
            if (exception instanceof SSLHandshakeException) {
                return false;
            }
            // 超时
            if (exception instanceof InterruptedIOException) {
                //重试
                return true;
            }
            // 目标服务器不可达
            if (exception instanceof UnknownHostException) {
                return false;
            }
            // 连接被拒绝
            if (exception instanceof ConnectTimeoutException) {
                return false;
            }
            // ssl握手异常
            if (exception instanceof SSLException) {
                return false;
            }

            HttpClientContext clientContext = HttpClientContext.adapt(context);
            HttpRequest request = clientContext.getRequest();
            // 如果请求是幂等的，就再次尝试
            if (!(request instanceof HttpEntityEnclosingRequest)) {
                return true;
            }
            return false;
        }
    };
    public static  HttpRequestRetryHandlerManager getInstance(){
        return manager;
    }

    public   HttpRequestRetryHandler getHttpRequestRetryHandler(){
            return httpRequestRetryHandler;
    }

}
