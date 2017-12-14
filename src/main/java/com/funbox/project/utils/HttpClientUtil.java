package com.funbox.project.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;



public final class HttpClientUtil {
    private final static int CONNECT_TIMEOUT = 5000; // in milliseconds  连接超时的时间
    private final static String DEFAULT_ENCODING = "UTF-8";  //字符串编码

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    public static void main(String[] args) {
//        String sign = EncryptUtil.encryptMD5UTF8(appSecretKey + appID + userName + now);
        long now = System.currentTimeMillis();
//        String sign = EncryptUtil.encryptMD5UTF8("T3WGHJFKD6786567GH67FGFGJKKG864Q" + "BA6AFC875DFD9871703DD8F953EB2DEB" + "yukaile" + now);

        Map<String, String> headers = new HashMap<String, String>();
//        headers.put("KS-USER-ID", "yukaile");
//        headers.put("KS-APPID", "BA6AFC875DFD9871703DD8F953EB2DEB");
//        headers.put("KS-TIME", now + "");
//        headers.put("KS-SIGN", sign);
        String url= "http://si.800617.com:4400/SendSms.aspx?un=bjsq-1&pwd=eaf9ba&mobile=15950081243&msg=test";

//        String url = "http://127.0.0.1:8080/bams/v1/bank/add";
//        String postBody = "{}";
//        String reString = doPost(url, postBody, headers);
        String reString = doGet(url, headers);
        System.out.println(reString);

    }

    public static String doPost(String url, String postBody, Map<String, String> headers) {
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse response = null;
        FileInputStream inputStream = null;
        try {
            httpclient = HttpClients.createDefault();
            HttpPost post = new HttpPost(url);
            if (NullUtil.isNotNull(headers)) {
                for (Entry<String, String> entry : headers.entrySet()) {
                    String name = entry.getKey();
                    String value = entry.getValue();
                    if (StringUtils.isBlank(name) || StringUtils.isBlank(value)) {
                        continue;
                    }
                    Header header = new BasicHeader(name, URLEncoder.encode(value,"UTF-8"));
                    post.addHeader(header);
                }
            }
            if (!StringUtils.isBlank(postBody)) {
                post.setEntity(new StringEntity(postBody, Consts.UTF_8));
                post.setHeader("Content-Type", "application/json;charset=utf-8");
            }

            logger.info("{} \n post body : {},{}",url, postBody,post.getAllHeaders());

            response = httpclient.execute(post);
            HttpEntity entity = response.getEntity();

            logger.info("----------------------------------------");
            logger.info("res StatusLine: {}", response.getStatusLine());
            String reString = null;
            if (entity != null) {
                reString = EntityUtils.toString(entity, Consts.UTF_8);
                logger.info("Response content length{}", entity.getContentLength());
                logger.info("Response content toString{}", reString);
            }
            EntityUtils.consume(entity);
            post.abort();
            logger.info("response:\r\n {}", reString);
            return reString;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close(httpclient, response, inputStream);
        }
    }

    public static String postData(String urlStr, String data){
        return postData(urlStr, data, null);
    }
    /**
     * post数据请求
     * @param urlStr
     * @param data
     * @param contentType
     * @return
     */
    public static String postData(String urlStr, String data, String contentType){
        BufferedReader reader = null;
        try {
            URL url = new URL(urlStr);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            conn.setConnectTimeout(CONNECT_TIMEOUT);
            conn.setReadTimeout(CONNECT_TIMEOUT);
            if(contentType != null)
                conn.setRequestProperty("content-type", contentType);
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream(), DEFAULT_ENCODING);
            if(data == null)
                data = "";
            writer.write(data);
            writer.flush();
            writer.close();

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), DEFAULT_ENCODING));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\r\n");
            }
            return sb.toString();
        } catch (IOException e) {
            logger.info("Error connecting to " + urlStr + ": " + e.getMessage());
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
            }
        }
        return null;
    }

    public static String doGet(String url, Map<String, String> headers) {
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse response = null;
        FileInputStream inputStream = null;
        try {
            httpclient = HttpClients.createDefault();

            HttpGet get = new HttpGet(url);

            if (null != headers && headers.size() > 0) {
                for (Entry<String, String> entry : headers.entrySet()) {
                    String name = entry.getKey();
                    String value = entry.getValue();
                    if ("".equals(name) || "".equals(value)) {
                        continue;
                    }
                    Header header = new BasicHeader(name, URLEncoder.encode(value,"UTF-8"));
                    get.addHeader(header);
                }
            }

            response = httpclient.execute(get);
            HttpEntity entity = response.getEntity();

            logger.info("----------------------------------------");
            logger.info("res StatusLine: {}", response.getStatusLine());

            String reString = null;
            if (entity != null) {
                reString = EntityUtils.toString(entity, Consts.UTF_8);
            }
            EntityUtils.consume(entity);
            get.abort();
            logger.info("response:\r\n {}", reString);
            return reString;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } finally {
            close(httpclient, response, inputStream);
        }
    }

    private static void close(CloseableHttpClient httpclient, CloseableHttpResponse response, InputStream instream) {
        if (null != instream) {
            try {
                instream.close();
            } catch (Exception e2) {
                // 忽略
                e2.printStackTrace();
            }
        }
        if (null != response) {
            try {
                response.close();
            } catch (Exception e2) {
                // 忽略
                e2.printStackTrace();
            }
        }
        if (null != httpclient) {
            try {
                httpclient.close();
            } catch (Exception e2) {
                // 忽略
                e2.printStackTrace();
            }
        }

    }
}
