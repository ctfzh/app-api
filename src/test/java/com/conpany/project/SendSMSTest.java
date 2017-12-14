package com.conpany.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;


public class SendSMSTest {
    public static void main (String[] args) throws Exception {

        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod(" http://si.800617.com:4400/SendSms.aspx");
        post.addRequestHeader("Content-Type",
                "application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码
        NameValuePair[] data = { new NameValuePair("un", "bjsq-1"), // 注册的用户名
                new NameValuePair("pwd", "eaf9ba"), // 注册成功后,登录网站使用的密钥
                new NameValuePair("mobile", "15950081243"), // 手机号码
                new NameValuePair("msg", "java程序发的信息!!") };
        post.setRequestBody(data);

        client.executeMethod(post);
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:" + statusCode);
        for (Header h : headers) {
            System.out.println(h.toString());
        }
        String result = new String(post.getResponseBodyAsString().getBytes(
                "gbk"));
        System.out.println(result);
        post.releaseConnection();

    }


}