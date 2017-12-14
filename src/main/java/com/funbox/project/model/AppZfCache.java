package com.funbox.project.model;

import javax.persistence.*;

@Table(name = "app_zf_cache")
public class AppZfCache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 售卖机编码
     */
    @Column(name = "inner_code")
    private String innerCode;

    /**
     * 支付类型
     */
    @Column(name = "pay_type")
    private Integer payType;

    /**
     * 是否当日
     */
    @Column(name = "from_today")
    private Integer fromToday;

    /**
     * 商品id
     */
    @Column(name = "mdse_id")
    private Integer mdseId;

    /**
     * 主订单id
     */
    @Column(name = "main_order_id")
    private Integer mainOrderId;

    /**
     * 商户订单号
     */
    @Column(name = "out_trade_no")
    private String outTradeNo;

    /**
     * 1:小程序 2：速冻机
     */
    private Integer channel;

    /**
     * 商品名称
     */
    @Column(name = "mdse_name")
    private String mdseName;

    /**
     * 用户标识
     */
    private String openid;

    /**
     * 下单求情的参数
     */
    private String menu;

    private String ip;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取售卖机编码
     *
     * @return inner_code - 售卖机编码
     */
    public String getInnerCode() {
        return innerCode;
    }

    /**
     * 设置售卖机编码
     *
     * @param innerCode 售卖机编码
     */
    public void setInnerCode(String innerCode) {
        this.innerCode = innerCode;
    }

    /**
     * 获取支付类型
     *
     * @return pay_type - 支付类型
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * 设置支付类型
     *
     * @param payType 支付类型
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * 获取是否当日
     *
     * @return from_today - 是否当日
     */
    public Integer getFromToday() {
        return fromToday;
    }

    /**
     * 设置是否当日
     *
     * @param fromToday 是否当日
     */
    public void setFromToday(Integer fromToday) {
        this.fromToday = fromToday;
    }

    /**
     * 获取商品id
     *
     * @return mdse_id - 商品id
     */
    public Integer getMdseId() {
        return mdseId;
    }

    /**
     * 设置商品id
     *
     * @param mdseId 商品id
     */
    public void setMdseId(Integer mdseId) {
        this.mdseId = mdseId;
    }

    /**
     * 获取主订单id
     *
     * @return main_order_id - 主订单id
     */
    public Integer getMainOrderId() {
        return mainOrderId;
    }

    /**
     * 设置主订单id
     *
     * @param mainOrderId 主订单id
     */
    public void setMainOrderId(Integer mainOrderId) {
        this.mainOrderId = mainOrderId;
    }

    /**
     * 获取商户订单号
     *
     * @return out_trade_no - 商户订单号
     */
    public String getOutTradeNo() {
        return outTradeNo;
    }

    /**
     * 设置商户订单号
     *
     * @param outTradeNo 商户订单号
     */
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    /**
     * 获取1:小程序 2：速冻机
     *
     * @return channel - 1:小程序 2：速冻机
     */
    public Integer getChannel() {
        return channel;
    }

    /**
     * 设置1:小程序 2：速冻机
     *
     * @param channel 1:小程序 2：速冻机
     */
    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    /**
     * 获取商品名称
     *
     * @return mdse_name - 商品名称
     */
    public String getMdseName() {
        return mdseName;
    }

    /**
     * 设置商品名称
     *
     * @param mdseName 商品名称
     */
    public void setMdseName(String mdseName) {
        this.mdseName = mdseName;
    }

    /**
     * 获取用户标识
     *
     * @return openid - 用户标识
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置用户标识
     *
     * @param openid 用户标识
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 获取下单求情的参数
     *
     * @return menu - 下单求情的参数
     */
    public String getMenu() {
        return menu;
    }

    /**
     * 设置下单求情的参数
     *
     * @param menu 下单求情的参数
     */
    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}