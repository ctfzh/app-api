package com.funbox.project.configurer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.funbox", ignoreUnknownFields = false)
public class FunboxProperties {
    public  String appid = "wxf2663fcf4454caec";// APPID
    public  String secert = "7beec73bea4b5cde661be3e416b9d40e";// 秘钥
    public  long max_time = 6200 * 1000;// 微信允许最长Access_token有效时间（ms）。注意，我们设置为6200*1000，少于文档给的7200*1000
    public  String token = "wgyscsf";// 全局的token
    public  String url = "42.96.144.28/WeixinApiDemo";
    //微信支付的商户id
    public  String mch_id = "1489007712";
    //微信支付的商户密钥
    public  String key = "1zNRmt9YNM1cub9adwZDqESYGNf3oE8Q";
    //支付成功后的服务器回调url
    public  String notify_url = "http://yqnpr3.natappfree.cc/oauth/wxNotify";
    //签名方式，固定值
    public  String signtype = "MD5";
    //交易类型，小程序支付的固定值为JSAPI
    public  String tradetype = "JSAPI";
    //微信统一下单接口地址
    public  String pay_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    //支付成功后的服务器回调url
    public  String sdj_notify_url = "http://dii6gc.natappfree.cc/app/wx/callback";

    //vs地址
    public String vsurl;

    //支付宝回调地址
    public String zfb_notify_url;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecert() {
        return secert;
    }

    public void setSecert(String secert) {
        this.secert = secert;
    }

    public long getMax_time() {
        return max_time;
    }

    public void setMax_time(long max_time) {
        this.max_time = max_time;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getSigntype() {
        return signtype;
    }

    public void setSigntype(String signtype) {
        this.signtype = signtype;
    }

    public String getTradetype() {
        return tradetype;
    }

    public void setTradetype(String tradetype) {
        this.tradetype = tradetype;
    }

    public String getPay_url() {
        return pay_url;
    }

    public void setPay_url(String pay_url) {
        this.pay_url = pay_url;
    }

    public String getSdj_notify_url() {
        return sdj_notify_url;
    }

    public void setSdj_notify_url(String sdj_notify_url) {
        this.sdj_notify_url = sdj_notify_url;
    }

    public String getVsurl() {
        return vsurl;
    }

    public void setVsurl(String vsurl) {
        this.vsurl = vsurl;
    }

    public String getZfb_notify_url() {
        return zfb_notify_url;
    }

    public void setZfb_notify_url(String zfb_notify_url) {
        this.zfb_notify_url = zfb_notify_url;
    }
}