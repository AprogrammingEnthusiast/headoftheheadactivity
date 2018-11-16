package com.yiscn.common.http;

import com.yiscn.common.util.SpringBootLogger;
import org.apache.http.*;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 *    IHttpService 实现
 *
 * @author wangj
 * @date 2018/7/6 11:27
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Component
public class HttpClient {
    private String className = this.getClass().getName();
    private  PoolingHttpClientConnectionManager cm;
    private  CloseableHttpClient closeableHttpClientClient;
    private  SocketConfig socketConfig;
    private RequestConfig requestConfig;
    private  HttpHost proxy;
    //超时控制
    private int timeOut = 60 * 1000;
    private  String defaultUserAgent =  "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.59 Safari/537.36";
    {
        //cm = new PoolingHttpClientConnectionManager();
        cm = HttpConnectionPoolManager.getInstance().getPoolingHttpClientConnectionManager();
        socketConfig = SocketConfig.custom().setSoKeepAlive(true).build();
        cm.setDefaultSocketConfig(socketConfig);
        requestConfig = RequestConfig
                .custom()
                .setCookieSpec(CookieSpecs.STANDARD_STRICT)
                .setConnectTimeout(timeOut)
                .setConnectionRequestTimeout(timeOut)
                .setSocketTimeout(timeOut)
                .build();
        HttpClientBuilder httpClientBuilder = HttpClients.custom()
                .setConnectionManager(cm)
                //使用长连接(默认的长连接策略)
                .setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE)
                //请求配置
                .setDefaultRequestConfig(requestConfig)
                //重试策略
                .setRetryHandler(HttpRequestRetryHandlerManager.getInstance().getHttpRequestRetryHandler());
        //设置代理
        //proxy = new HttpHost("127.0.0.1",8888);
        //  httpClientBuilder.setProxy(proxy);

        closeableHttpClientClient = httpClientBuilder.build();
    }
    /**
     * get请求
     * @param url 请求地址
     * @param params 参数 可为null
     * @param headers 请求头 可为null
     * @param charset 字符集
     * @return
     */
    public String doGet(String url, Map<String, String> params, Map<String, String> headers, String charset) throws Exception {
        String resultString = null;
        CloseableHttpResponse response = null;

            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (params != null) {
                for (String key : params.keySet()) {
                    builder.addParameter(key, params.get(key));
                }
            }
            URI uri = builder.build();
             //LogUtil.info("url地址:"+uri.toString());
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            //设置请求头
            if(headers != null){
                for(Map.Entry<String,String> entry : headers.entrySet()){
                    //httpPost.setHeader("Content-Type","application/json;charset=utf-8");
                    httpGet.setHeader(entry.getKey(),entry.getValue());
                }
            }

            // 执行请求
            response = closeableHttpClientClient.execute(httpGet);
            HttpEntity httpEntity =  response.getEntity();
            // 判断返回状态是否为200
             int statusCode = response.getStatusLine().getStatusCode();
             resultString = EntityUtils.toString(httpEntity, charset);

            //释放输入流
            EntityUtils.consumeQuietly(httpEntity);
            //关闭response
            response.close();
            //释放连接
            httpGet.releaseConnection();
            if(statusCode == 200){
                return resultString;
            }else{
                throw new RuntimeException("http请求返回状态码非200,状态码:"+statusCode+",信息:"+resultString);
            }

    }

    /**
     * post请求
     * @param url 请求地址
     * @param headers 请求头
     * @param params 参数
     * @param charset 字符集
     * @return
     */
    public String doPost(String url, Map<String, String> headers, Map<String, String> params, String charset) throws Exception {

            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            if(headers != null){
                for(Map.Entry<String,String> entry : headers.entrySet()){
                    //httpPost.setHeader("Content-Type","application/json;charset=utf-8");
                    httpPost.setHeader(entry.getKey(),entry.getValue());
                    SpringBootLogger.info("请求头:"+entry.getKey()+"-->"+entry.getValue());
                }
            }
            // 创建参数列表
            if (params != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (String key : params.keySet()) {
                    SpringBootLogger.info("请求参数:"+key+"--->"+params.get(key));
                    paramList.add(new BasicNameValuePair(key, params.get(key)));
                }
                // 模拟表单(内部会进行url编码)
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList,charset);

                httpPost.setEntity(entity);
            }

            // 执行http请求
        CloseableHttpResponse response = closeableHttpClientClient.execute(httpPost);
            // 判断返回状态是否为200
            HttpEntity httpEntity =  response.getEntity();
        // 判断返回状态是否为200
        int statusCode = response.getStatusLine().getStatusCode();
        String resultString = EntityUtils.toString(httpEntity, charset);

        //释放输入流
        EntityUtils.consumeQuietly(httpEntity);
        //关闭response
        response.close();
        //释放连接
        httpPost.releaseConnection();
        if(statusCode == 200){
            return resultString;
        }else{
            throw new HttpStatusCodeException("http请求返回状态码非200,状态码:"+statusCode+",信息:"+resultString);
        }
    }

    /**
     * post提交
     * @param url 请求地址
     * @param headers 请求头
     * @param body 字符串请求体
     * @param contentType
     * @param charset 字符集
     * @return
     */
    public String doStringEntityPost(String url, Map<String, String> headers,
                                     String body, ContentType contentType, String charset) throws Exception {


            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            if(headers != null){
                for(Map.Entry<String,String> entry : headers.entrySet()){
                    //httpPost.setHeader("Content-Type","application/json;charset=utf-8");
                    httpPost.setHeader(entry.getKey(),entry.getValue());
                }
            }
            // 创建请求内容
            StringEntity entity = new StringEntity(body, contentType);
            httpPost.setEntity(entity);
            // 执行http请求
        // 执行http请求
        CloseableHttpResponse response = closeableHttpClientClient.execute(httpPost);
        // 判断返回状态是否为200
        HttpEntity httpEntity =  response.getEntity();
        // 判断返回状态是否为200
        int statusCode = response.getStatusLine().getStatusCode();
        String resultString = EntityUtils.toString(httpEntity, charset);

        //释放输入流
        EntityUtils.consumeQuietly(httpEntity);
        //关闭response
        response.close();
        //释放连接
        httpPost.releaseConnection();
        if(statusCode == 200){
            return resultString;
        }else{
            throw new HttpStatusCodeException("http请求返回状态码非200,状态码:"+statusCode+",信息:"+resultString);
        }

    }

    /**
     * 下载文件
     * @param url 下载地址
     * @param fileDir 文件存放的路径
     * @return 文件路径
     */
    public String downloadFile(String url, String fileDir) {

        try{
            HttpGet get = new HttpGet(url);
            CloseableHttpResponse httpResponse = closeableHttpClientClient.execute(get);
            String fileName = getFileName(httpResponse);
            String filePath = "";
            if(fileDir.endsWith(File.separator)){
                filePath = fileDir+fileName;
            }else{
                filePath = fileDir+File.separator+fileName;
            }
            File file = new File(filePath);
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            //获取输入流
            InputStream content = httpResponse.getEntity().getContent();
            //输入缓冲流
            BufferedInputStream bufi = new BufferedInputStream(content);
            //文件输出流
            FileOutputStream fos = new FileOutputStream(file);
            //输出缓冲流
            BufferedOutputStream bufo = new BufferedOutputStream(fos);
            int len = 0;
            byte[] buf = new byte[1024];
            //达末尾则返回-1
            while((len=bufi.read(buf,0,1024)) != -1){
                bufo.write(buf,0,len);
            }
            bufo.close();
            HttpEntity httpEntity =  httpResponse.getEntity();
            // 判断返回状态是否为200
            if (httpResponse.getStatusLine().getStatusCode() != 200) {
                //释放输入流
                EntityUtils.consumeQuietly(httpEntity);
                //关闭response
                httpResponse.close();
                //释放连接
                get.releaseConnection();
               throw new HttpStatusCodeException("下载异常");
            }
            //释放输入流
            EntityUtils.consumeQuietly(httpEntity);
            //关闭response
            httpResponse.close();
            //释放连接
            get.releaseConnection();
            return filePath;
        }catch(Exception e){
            e.printStackTrace();
            SpringBootLogger.error(className+"->downloadFile()",e);
            throw new RuntimeException("下载异常");
        }
    }

    /**
     * 上传文件
     * @param url 上传地址
     * @param paramsName 参数名
     * @param srcFile 文件
     * @return
     */
    public String uploadFile(String url, String paramsName, File srcFile) {
        String result = "";
        try {
            if(!srcFile.exists()){
                throw new RuntimeException("文件不存在");
            }
            if(paramsName == null || paramsName.length() == 0){
                paramsName = "file";
            }
            FileInputStream fis = new FileInputStream(srcFile);
            HttpPost httpPost = new HttpPost(url);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            // 文件流
            builder.addBinaryBody(paramsName, fis, ContentType.MULTIPART_FORM_DATA, srcFile.getName());
            // 类似浏览器表单提交，对应input的name和value
            builder.addTextBody("filename", srcFile.getName());
            HttpEntity entity = builder.build();
            httpPost.setEntity(entity);
            // 执行提交
            CloseableHttpResponse response = closeableHttpClientClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                // 将响应内容转换为字符串
                result = EntityUtils.toString(responseEntity, Charset.forName("UTF-8"));
            }

            //释放输入流
            EntityUtils.consumeQuietly(responseEntity);
            //关闭response
            response.close();
            //释放连接
            httpPost.releaseConnection();
            fis.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            SpringBootLogger.error(className+"->uploadFile()",e);
           throw new RuntimeException("上传异常");
        } catch (Exception e) {
            e.printStackTrace();
            SpringBootLogger.error(className+"->uploadFile()",e);
            throw new RuntimeException("上传异常");
        }
    }

    /**
     * 获取下载的文件名
     * @param response
     * @return
     */
    private  String getFileName(HttpResponse response) {
        Header contentHeader = response.getFirstHeader("Content-Disposition");
        String filename = null;
        if (contentHeader != null) {
            HeaderElement[] values = contentHeader.getElements();
            if (values.length == 1) {
                NameValuePair param = values[0].getParameterByName("filename");
                if (param != null) {
                    try {
                        //filename = new String(param.getValue().toString().getBytes(), "utf-8");
                        //filename=URLDecoder.decode(param.getValue(),"utf-8");
                        filename = param.getValue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return filename;
    }

}
