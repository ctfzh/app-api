package com.funbox.project.utils;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

/**
 * 获取初始化的AlipayClient
 * 包括沙箱及正式版(网关地址,APPID,私钥,公钥均不同)
 */
public class AlipayConfig {
    //网关地址
    public static final String URL = "https://openapi.alipay.com/gateway.do"; //(正式环境)
//    public static final String URL = "https://openapi.alipaydev.com/gateway.do"; //沙箱(测试环境)

    //APPID
//    public static final String ALIPAY_APPID = "2016090900468493";

    //私钥
//    public static String APP_PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKTSZbeqf1ecTbC47pmzDCoBxZNAL9iGlCmSeYCCJy3iMqX5BEdfMWWxQNLaQwy5wf/MgZf7UHEc/RItWZO7mvjJgOrSUKl4hNYu+e+P+MAh9Y8zKVqmfQYj80Sg6PEo0bNNUVvyPFVI7HbDN1QtKt3iUb2Iq0MupTogkg8UoKUTAgMBAAECgYB+zGX4YDBLRDH4jKzyjW4EOwy2daDZYN9HBCp5FKfzgpsYWHRUPAWSiESoccU3WwjGM5xXQb3m5zhB7aWGI8PZ9ljFgglMGfZ5KqR1x1gfnxJ7Ux4lgFgxQmjXqDhBkFephX6bg33bSOFsQVxw0b/5EfZrC50lS9l+9/zsCtEQoQJBAOzRwgkWSfuySimtgN/03AmoP1SPaV2QJiHwII9GKW0g0ryXnkX2g4HDB2J69UxwtAiV4hN9pS/WMJqFm/6oJokCQQCyK9WSLurW9Mtc0TAaR1iwk8a3fI+Hg0OTWgHfCyfMIs7ZVXl16mjPo0Ut77v1Y4lJ2+GfKI4okpmbWsaVGMe7AkEAmrD1lyv5DbFLYmgUS7ZNWP2OyLSY9eXoErkg+5WwD7mmDkzXtQmuoz96/mgk/VaNMyJ8t5CWK2Y0/2qRGEpMSQJAb58qo/Skx5qBNVsQycXc+HL8UcPFn95KnawL9BJnEmrUMDBuccMzerINCyRgGvIK9qy8gxvDRAPkHAIY2xu1NQJAPGLpq1jqA6Kl7UrpHoa10sSz/4AMfWXpMmnHwMbKw5Y30zll97aXvRIx2S6hspkT1iJ+o6Mn7k+y+I9GfvMzvg==";
    //支付宝公钥
//    public static String ALIPAY_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB";

    /**生产环境*/
    //APPID
    public static final String ALIPAY_APPID = "2017111309911746";

    //私钥
    public static String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC0KQamk4JyPPDuiNUkqWHlnJN37AwCsl7sXmLNtoV/V+FjbgrLNpR3oP5qYY5fXG1M/tM+pxGIVsVLn/YEUD8Ff8FBsMm0AqpvmdlFS7scUqAyHyWiqoGAGTzZek9YF/RaC+um3U8jnnQTgi6u5R181xEuiKMJyeeB7idvi4lqFUGOww7IJWPrJftZCb950go66fkAMuCSXob3Q9SK7f14OrWERzeqNs7AVd8cm1h3Qc+qaXw5Uzlag3pOzPu1fqHN8iIfmCkkKg8f22O786251BHCLyHXFBAdUADZb8zXtTcBVgyZnMEf8PKI7qdBDUAPLnFDEvg+pXEpfe6/hb9lAgMBAAECggEAMa9m0CW6QfsgjwhZj+TOxN4rpVUJ8uxyVUmqggUmR/pahGtiuqxwwZU61OfWteHtmuBkLdExeqJDgxm4ZXQkDUYwbAdveR+LFYAedYfvMF5xI6GHZZcUY9mR+IBMxYTFtNe4w6ohGzel14N9kGpLeZRufqDcJeTy3dhqM88NtJ11lOSn891MCzgXKJQZLZWNZ5F9j6HrmZd9iuPHW/7P4KkxpMantm8xlWk3uHqzeMWqnrbrXORlvMSpEAKm2j6u64j8m3JA0y6iLNsZRHxYwp/5OGzuHZb1wLyQD2Mdhm7F5F6wegk9EVZ1g+H+B39zfXuM0mDhLyBlLQQEafwgeQKBgQDdwrWFBgYtBArVWOfT6QQztjd2NTM0mxEi+ZjFejCGPgwZhaQ2Sz77Qr+VOeHmFlAl3herYspbj0FEY5cyKbzYj6qcw3I/JQQvo4gqLKnyEqFgG8SgR+aycwOXTrL+82FGB9Rl+eGFTjf5sxdBSjjttJyBmMpC7jaSY4mZNzdJhwKBgQDP+gadNlV9/6odS1qUYGjVrlOnHzJjw9CeOlP5n9KD5biedaqs4akaN4yHG1FXln8ADSs7YdrlMwv3BWrj2ZSdY3JvkdFEJPH09ypfx7HK2frOFfDxa0x6tKl8m320dbPwtBg6/uOdHiE8OQZPiR9ZOWldv60GGwMw9gnX11V6swKBgCcP3RmJbh0P0TizaGKTcQIK3sobpOFnTyVyAc8HLvT2iPsV508JAhcQMt7+SyRUWdnRvSmbRTnLihuZz1Auue0LoWnro3wr8QjTLXEAXQ8e6P4c5g21nJViXQeR/UWbaU8Eog00bt0kYgfB3B7MDCsS3V6Wo0oW29X9YodyinKRAoGBAJcTwfA8AviHWxTyozb7ncvzWbMiF2GfYhE+v7eqoKrNmkIJqdTyC/wOdBfFAV7F5TWtW0VEvVUXss5bch1X9fwqvHtNip2c1OKlFXQERSPdGrLP/3nv/tt4F1J8RWFsyyzENoHMnJ2KwIvVxL7MFiijauX+EftIbhYH9HiFZQO/AoGBAKN2ldXZ5LQHfQbdzOaFK2Ug1VuAGcNfVTcTycDb+da2jctRbUj0tQhv+jYQ6hu70I2gKOruu4Bl+Hs7rzjwF98I5hMARTYTjVbX3m54155KsZPp/Hy+WvN0b7JrKIJAKsdYhUMMfDCkD7gq/zUgTWoA7dpVTgnxcnluskAT5DEu";
    //支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqL6V+BOyzZm5MR6YMmvKx+eSOF4Q392sk2YpNp/cEHHWo1eSq61mTJSLjg8W8dnhWzdYp2jjDnpscGnB8qgbUiT+6NobnUDAt4luR8N5N4MRw+rsG1VhQJRCaRl70G0pjexzMOgyAFdYQLMproNRS1md5vf3h3yxfSZ/doK6wEsdx0j0qJfnX3cZsWen8YO43BtY649FEpfQGGNtUMvIMdL+UDpvBESBpHXNsyx2DI72puYEk4t5KOoXz81+P/J2RvXancbBpXLu3R8gLwdyD0L1UNzPZsknZ7p1wk6fV10INALpDp/zRmo+39ngTnn6vrGlusYtFseBvrD0qt6VewIDAQAB";

    //签名算法类型(根据生成私钥的算法,RSA2或RSA)
    public static final String SIGNTYPE = "RSA2";

    public static final String FORMAT = "json";//请求数据格式
    public static final String CHARSET = "utf-8";//编码集

    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static final String notify_url = "http://....../alipay/notify";//公众号
    public static final String APPnotify = "http://....../alipay/APPnotify";//APP
    public static final String OWnotify_url = "http://w4amgj.natappfree.cc/ali/callback";//网站扫码
    // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static final String return_url = "https://www.xxx.com/";
    public static final String OWreturn_url = "http://w4amgj.natappfree.cc/ali/callback";//网站扫码

    public static final String diamond_url = "http://w4amgj.natappfree.cc/ali/callback";//公众号充值钻石表(这里是从另一个服务器获取的,也可以存在redis或数据库中)

    // 统一收单交易创建接口
    private static AlipayClient alipayClient = null;

    /**获得初始化的AlipayClient
     * @return 支付宝客户端
     */
    public static AlipayClient getAlipayClient() {
        if (alipayClient == null) {
            synchronized (AlipayConfig.class) {
                if (null == alipayClient) {
                    alipayClient = new DefaultAlipayClient(URL, ALIPAY_APPID, APP_PRIVATE_KEY, FORMAT, CHARSET,ALIPAY_PUBLIC_KEY,SIGNTYPE);
                }
            }
        }
        return alipayClient;
    }
}