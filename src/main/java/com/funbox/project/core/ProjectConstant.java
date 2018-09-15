package com.funbox.project.core;

/**
 * 项目常量
 */
public final class ProjectConstant {
    public static final String BASE_PACKAGE = "com.langdong";//项目基础包名称，根据自己公司的项目修改

    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".model";//Model所在包
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";//Mapper所在包
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";//Service所在包
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";//ServiceImpl所在包
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".web";//Controller所在包

    public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".core.MyMapper";//Mapper插件基础接口的完全限定名

    public static final String FUNBOX_APi = "funbox_api_";

//    public final static String APPID = "wxf2663fcf4454caec";// APPID
//    public final static String SECERT = "7beec73bea4b5cde661be3e416b9d40e";// 秘钥
//    public final static long MAX_TIME = 6200 * 1000;// 微信允许最长Access_token有效时间（ms）。注意，我们设置为6200*1000，少于文档给的7200*1000
//    public final static String token = "wgyscsf";// 全局的token
//    public static final String url = "42.96.144.28/WeixinApiDemo";
//
//    //微信支付的商户id
//    public static final String mch_id = "1489007712";
//    //微信支付的商户密钥
//    public static final String key = "1zNRmt9YNM1cub9adwZDqESYGNf3oE8Q";
//    //支付成功后的服务器回调url
//    public static final String notify_url = "http://yqnpr3.natappfree.cc/oauth/wxNotify";
//    //签名方式，固定值
//    public static final String SIGNTYPE = "MD5";
//    //交易类型，小程序支付的固定值为JSAPI
//    public static final String TRADETYPE = "JSAPI";
//    //微信统一下单接口地址
//    public static final String pay_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
//
//
//
//    //支付成功后的服务器回调url
//    public static final String sdj_notify_url = "http://dii6gc.natappfree.cc/app/wx/callback";
}
