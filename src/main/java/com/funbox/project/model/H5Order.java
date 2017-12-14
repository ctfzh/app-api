package com.funbox.project.model;

import javax.persistence.*;

@Table(name = "h5_order")
public class H5Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_id")
    private String orderId;

    /**
     * 订单状态：1新建2取消4已支付6订单完成
     */
    @Column(name = "order_status")
    private Integer orderStatus;

    private String title;

    /**
     * 支付方式：1余额2支付宝3微信
     */
    @Column(name = "pay_type")
    private Integer payType;

    /**
     * 售货机编号
     */
    @Column(name = "inner_code")
    private String innerCode;

    /**
     * 商品ID
     */
    @Column(name = "mdse_id")
    private Integer mdseId;

    @Column(name = "mdse_name")
    private String mdseName;

    /**
     * 单位：分
     */
    private Integer price;

    /**
     * 创建时间
     */
    private Integer created;

    /**
     * 支付时间
     */
    private Integer paytime;

    /**
     * 取货时间
     */
    private Integer deliverytime;

    /**
     * 流转日志
     */
    @Column(name = "dispose_log")
    private String disposeLog;

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
     * @return order_id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取订单状态：1新建2取消4已支付6订单完成
     *
     * @return order_status - 订单状态：1新建2取消4已支付6订单完成
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置订单状态：1新建2取消4已支付6订单完成
     *
     * @param orderStatus 订单状态：1新建2取消4已支付6订单完成
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取支付方式：1余额2支付宝3微信
     *
     * @return pay_type - 支付方式：1余额2支付宝3微信
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * 设置支付方式：1余额2支付宝3微信
     *
     * @param payType 支付方式：1余额2支付宝3微信
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * 获取售货机编号
     *
     * @return inner_code - 售货机编号
     */
    public String getInnerCode() {
        return innerCode;
    }

    /**
     * 设置售货机编号
     *
     * @param innerCode 售货机编号
     */
    public void setInnerCode(String innerCode) {
        this.innerCode = innerCode;
    }

    /**
     * 获取商品ID
     *
     * @return mdse_id - 商品ID
     */
    public Integer getMdseId() {
        return mdseId;
    }

    /**
     * 设置商品ID
     *
     * @param mdseId 商品ID
     */
    public void setMdseId(Integer mdseId) {
        this.mdseId = mdseId;
    }

    /**
     * @return mdse_name
     */
    public String getMdseName() {
        return mdseName;
    }

    /**
     * @param mdseName
     */
    public void setMdseName(String mdseName) {
        this.mdseName = mdseName;
    }

    /**
     * 获取单位：分
     *
     * @return price - 单位：分
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * 设置单位：分
     *
     * @param price 单位：分
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 获取创建时间
     *
     * @return created - 创建时间
     */
    public Integer getCreated() {
        return created;
    }

    /**
     * 设置创建时间
     *
     * @param created 创建时间
     */
    public void setCreated(Integer created) {
        this.created = created;
    }

    /**
     * 获取支付时间
     *
     * @return paytime - 支付时间
     */
    public Integer getPaytime() {
        return paytime;
    }

    /**
     * 设置支付时间
     *
     * @param paytime 支付时间
     */
    public void setPaytime(Integer paytime) {
        this.paytime = paytime;
    }

    /**
     * 获取取货时间
     *
     * @return deliverytime - 取货时间
     */
    public Integer getDeliverytime() {
        return deliverytime;
    }

    /**
     * 设置取货时间
     *
     * @param deliverytime 取货时间
     */
    public void setDeliverytime(Integer deliverytime) {
        this.deliverytime = deliverytime;
    }

    /**
     * 获取流转日志
     *
     * @return dispose_log - 流转日志
     */
    public String getDisposeLog() {
        return disposeLog;
    }

    /**
     * 设置流转日志
     *
     * @param disposeLog 流转日志
     */
    public void setDisposeLog(String disposeLog) {
        this.disposeLog = disposeLog;
    }
}