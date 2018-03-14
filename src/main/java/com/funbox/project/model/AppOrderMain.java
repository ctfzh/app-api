package com.funbox.project.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;

@Table(name = "app_order_main")
public class AppOrderMain {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal id;

    @Column(name = "USER_ID")
    private BigDecimal userId;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "ORDER_NAME")
    private String orderName;

    @Column(name = "ORDER_STATUS")
    private BigDecimal orderStatus;

    @Column(name = "PAY_TYPE")
    private BigDecimal payType;

//    @Column(name = "ORDERS_INFO")
//    private String ordersInfo;

    @Column(name = "SELLING_PRICE")
    private BigDecimal sellingPrice;

    @Column(name = "APP_PRICE")
    private BigDecimal appPrice;

    @Column(name = "PAY_PRICE")
    private BigDecimal payPrice;

    @Column(name = "COUPON_ID")
    private BigDecimal couponId;

    @Column(name = "COUPON_NAME")
    private String couponName;

    @Column(name = "INNER_CODE")
    private String innerCode;

    @Column(name = "VM_ID")
    private BigDecimal vmId;

    @Column(name = "NODE_NAME")
    private String nodeName;

    @Column(name = "NODE_ADDRESS")
    private String nodeAddress;

    @Column(name = "DISPOSE_LOG")
    private String disposeLog;

    @Column(name = "CREATED")
    private BigDecimal created;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "MODIFIED")
    private BigDecimal modified;

    @Column(name = "PAY_TIME")
    private BigDecimal payTime;

    @Column(name = "ISEXCEPTION")
    private BigDecimal isexception;

    @Column(name = "ISREFUND")
    private BigDecimal isrefund;

    @Column(name = "CHANNEL")
    private String channel;

    @Column(name = "REFUND_PRICE")
    private BigDecimal refundPrice;

    @Transient
    private  List<List<AppOrder>> orderList;

    /**
     * @return ID
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     * @return USER_ID
     */
    public BigDecimal getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    /**
     * @return USERNAME
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return NICKNAME
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return ORDER_NAME
     */
    public String getOrderName() {
        return orderName;
    }

    /**
     * @param orderName
     */
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    /**
     * @return ORDER_STATUS
     */
    public BigDecimal getOrderStatus() {
        return orderStatus;
    }

    /**
     * @param orderStatus
     */
    public void setOrderStatus(BigDecimal orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * @return PAY_TYPE
     */
    public BigDecimal getPayType() {
        return payType;
    }

    /**
     * @param payType
     */
    public void setPayType(BigDecimal payType) {
        this.payType = payType;
    }

    /**
     * @return ORDERS_INFO
     */
//    public String getOrdersInfo() {
//        return ordersInfo;
//    }
//
//    /**
//     * @param ordersInfo
//     */
//    public void setOrdersInfo(String ordersInfo) {
//        this.ordersInfo = ordersInfo;
//    }

    /**
     * @return SELLING_PRICE
     */
    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    /**
     * @param sellingPrice
     */
    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    /**
     * @return APP_PRICE
     */
    public BigDecimal getAppPrice() {
        return appPrice;
    }

    /**
     * @param appPrice
     */
    public void setAppPrice(BigDecimal appPrice) {
        this.appPrice = appPrice;
    }

    /**
     * @return PAY_PRICE
     */
    public BigDecimal getPayPrice() {
        return payPrice;
    }

    /**
     * @param payPrice
     */
    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    /**
     * @return COUPON_ID
     */
    public BigDecimal getCouponId() {
        return couponId;
    }

    /**
     * @param couponId
     */
    public void setCouponId(BigDecimal couponId) {
        this.couponId = couponId;
    }

    /**
     * @return COUPON_NAME
     */
    public String getCouponName() {
        return couponName;
    }

    /**
     * @param couponName
     */
    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    /**
     * @return INNER_CODE
     */
    public String getInnerCode() {
        return innerCode;
    }

    /**
     * @param innerCode
     */
    public void setInnerCode(String innerCode) {
        this.innerCode = innerCode;
    }

    /**
     * @return VM_ID
     */
    public BigDecimal getVmId() {
        return vmId;
    }

    /**
     * @param vmId
     */
    public void setVmId(BigDecimal vmId) {
        this.vmId = vmId;
    }

    /**
     * @return NODE_NAME
     */
    public String getNodeName() {
        return nodeName;
    }

    /**
     * @param nodeName
     */
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * @return NODE_ADDRESS
     */
    public String getNodeAddress() {
        return nodeAddress;
    }

    /**
     * @param nodeAddress
     */
    public void setNodeAddress(String nodeAddress) {
        this.nodeAddress = nodeAddress;
    }

    /**
     * @return DISPOSE_LOG
     */
    public String getDisposeLog() {
        return disposeLog;
    }

    /**
     * @param disposeLog
     */
    public void setDisposeLog(String disposeLog) {
        this.disposeLog = disposeLog;
    }

    /**
     * @return CREATED
     */
    public BigDecimal getCreated() {
        return created;
    }

    /**
     * @param created
     */
    public void setCreated(BigDecimal created) {
        this.created = created;
    }

    /**
     * @return CREATED_DATE
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return MODIFIED
     */
    public BigDecimal getModified() {
        return modified;
    }

    /**
     * @param modified
     */
    public void setModified(BigDecimal modified) {
        this.modified = modified;
    }

    /**
     * @return PAY_TIME
     */
    public BigDecimal getPayTime() {
        return payTime;
    }

    /**
     * @param payTime
     */
    public void setPayTime(BigDecimal payTime) {
        this.payTime = payTime;
    }

    /**
     * @return ISEXCEPTION
     */
    public BigDecimal getIsexception() {
        return isexception;
    }

    /**
     * @param isexception
     */
    public void setIsexception(BigDecimal isexception) {
        this.isexception = isexception;
    }

    /**
     * @return ISREFUND
     */
    public BigDecimal getIsrefund() {
        return isrefund;
    }

    /**
     * @param isrefund
     */
    public void setIsrefund(BigDecimal isrefund) {
        this.isrefund = isrefund;
    }

    /**
     * @return CHANNEL
     */
    public String getChannel() {
        return channel;
    }

    /**
     * @param channel
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * @return REFUND_PRICE
     */
    public BigDecimal getRefundPrice() {
        return refundPrice;
    }

    /**
     * @param refundPrice
     */
    public void setRefundPrice(BigDecimal refundPrice) {
        this.refundPrice = refundPrice;
    }

    public List<List<AppOrder>> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<List<AppOrder>> orderList) {
        this.orderList = orderList;
    }
}