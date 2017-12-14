package com.funbox.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "app_order")
public class AppOrder {
    @Id
    @Column(name = "ORDER_ID")
    private BigDecimal orderId;

    @Column(name = "USER_ID")
    private BigDecimal userId;

    @Column(name = "PARENT_ID")
    private BigDecimal parentId;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "ORDER_STATUS")
    private BigDecimal orderStatus;

    @Column(name = "PAY_TYPE")
    private BigDecimal payType;

    @Column(name = "INNER_CODE")
    private String innerCode;

    @Column(name = "VM_ID")
    private BigDecimal vmId;

    @Column(name = "NODE_ID")
    private BigDecimal nodeId;

    @Column(name = "NODE_NAME")
    private String nodeName;

    @Column(name = "NODE_ADDRESS")
    private String nodeAddress;

    @Column(name = "MDSE_ID")
    private BigDecimal mdseId;

    @Column(name = "MDSE_NAME")
    private String mdseName;

    @Column(name = "MDSE_NICKNAME")
    private String mdseNickname;

    @Column(name = "MDSE_SECOND_FOOD")
    private String mdseSecondFood;

    @Column(name = "MDSE_SUBGRID")
    private String mdseSubgrid;

    @Column(name = "MDSE_SMALLGRID")
    private String mdseSmallgrid;

    @Column(name = "MDSE_STAPLEFOOD")
    private String mdseStaplefood;

    @Column(name = "DISCOUNT_NAME")
    private String discountName;

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

    @Column(name = "FOOD_CODE")
    private String foodCode;

    @Column(name = "FOOD_DATE")
    private Date foodDate;

    @Column(name = "CL_CODE")
    private String clCode;

    @Column(name = "DISPOSE_LOG")
    private String disposeLog;

    @Column(name = "CREATED")
    private BigDecimal created;

    @Column(name = "MODIFIED")
    private BigDecimal modified;

    @Column(name = "DELIVERY_TIME")
    private BigDecimal deliveryTime;

    @Column(name = "ISMERGED")
    private BigDecimal ismerged;

    @Column(name = "MERGEDCODE")
    private String mergedcode;

    @Column(name = "ISEVALUATED")
    private BigDecimal isevaluated;

    @Column(name = "ISGIFTED")
    private BigDecimal isgifted;

    @Column(name = "ISINVOICED")
    private BigDecimal isinvoiced;

    @Column(name = "MVCCC_ID")
    private BigDecimal mvcccId;

    @Column(name = "CHANNEL")
    private String channel;

    @Column(name = "ISREFUND")
    private String isrefund;

    @Column(name = "REFUND_PRICE")
    private BigDecimal refundPrice;

    @Column(name = "REFUND_COUPON")
    private BigDecimal refundCoupon;

    @Column(name = "MONEY_COMPANY")
    private BigDecimal moneyCompany;

    @Column(name = "MONEY_PERSON")
    private BigDecimal moneyPerson;

    @Column(name = "MONEY_GIFT")
    private BigDecimal moneyGift;

    /**
     * @return ORDER_ID
     */
    public BigDecimal getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(BigDecimal orderId) {
        this.orderId = orderId;
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
     * @return PARENT_ID
     */
    public BigDecimal getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(BigDecimal parentId) {
        this.parentId = parentId;
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
     * @return NODE_ID
     */
    public BigDecimal getNodeId() {
        return nodeId;
    }

    /**
     * @param nodeId
     */
    public void setNodeId(BigDecimal nodeId) {
        this.nodeId = nodeId;
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
     * @return MDSE_ID
     */
    public BigDecimal getMdseId() {
        return mdseId;
    }

    /**
     * @param mdseId
     */
    public void setMdseId(BigDecimal mdseId) {
        this.mdseId = mdseId;
    }

    /**
     * @return MDSE_NAME
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
     * @return MDSE_NICKNAME
     */
    public String getMdseNickname() {
        return mdseNickname;
    }

    /**
     * @param mdseNickname
     */
    public void setMdseNickname(String mdseNickname) {
        this.mdseNickname = mdseNickname;
    }

    /**
     * @return MDSE_SECOND_FOOD
     */
    public String getMdseSecondFood() {
        return mdseSecondFood;
    }

    /**
     * @param mdseSecondFood
     */
    public void setMdseSecondFood(String mdseSecondFood) {
        this.mdseSecondFood = mdseSecondFood;
    }

    /**
     * @return MDSE_SUBGRID
     */
    public String getMdseSubgrid() {
        return mdseSubgrid;
    }

    /**
     * @param mdseSubgrid
     */
    public void setMdseSubgrid(String mdseSubgrid) {
        this.mdseSubgrid = mdseSubgrid;
    }

    /**
     * @return MDSE_SMALLGRID
     */
    public String getMdseSmallgrid() {
        return mdseSmallgrid;
    }

    /**
     * @param mdseSmallgrid
     */
    public void setMdseSmallgrid(String mdseSmallgrid) {
        this.mdseSmallgrid = mdseSmallgrid;
    }

    /**
     * @return MDSE_STAPLEFOOD
     */
    public String getMdseStaplefood() {
        return mdseStaplefood;
    }

    /**
     * @param mdseStaplefood
     */
    public void setMdseStaplefood(String mdseStaplefood) {
        this.mdseStaplefood = mdseStaplefood;
    }

    /**
     * @return DISCOUNT_NAME
     */
    public String getDiscountName() {
        return discountName;
    }

    /**
     * @param discountName
     */
    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

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
     * @return FOOD_CODE
     */
    public String getFoodCode() {
        return foodCode;
    }

    /**
     * @param foodCode
     */
    public void setFoodCode(String foodCode) {
        this.foodCode = foodCode;
    }

    /**
     * @return FOOD_DATE
     */
    public Date getFoodDate() {
        return foodDate;
    }

    /**
     * @param foodDate
     */
    public void setFoodDate(Date foodDate) {
        this.foodDate = foodDate;
    }

    /**
     * @return CL_CODE
     */
    public String getClCode() {
        return clCode;
    }

    /**
     * @param clCode
     */
    public void setClCode(String clCode) {
        this.clCode = clCode;
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
     * @return DELIVERY_TIME
     */
    public BigDecimal getDeliveryTime() {
        return deliveryTime;
    }

    /**
     * @param deliveryTime
     */
    public void setDeliveryTime(BigDecimal deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    /**
     * @return ISMERGED
     */
    public BigDecimal getIsmerged() {
        return ismerged;
    }

    /**
     * @param ismerged
     */
    public void setIsmerged(BigDecimal ismerged) {
        this.ismerged = ismerged;
    }

    /**
     * @return MERGEDCODE
     */
    public String getMergedcode() {
        return mergedcode;
    }

    /**
     * @param mergedcode
     */
    public void setMergedcode(String mergedcode) {
        this.mergedcode = mergedcode;
    }

    /**
     * @return ISEVALUATED
     */
    public BigDecimal getIsevaluated() {
        return isevaluated;
    }

    /**
     * @param isevaluated
     */
    public void setIsevaluated(BigDecimal isevaluated) {
        this.isevaluated = isevaluated;
    }

    /**
     * @return ISGIFTED
     */
    public BigDecimal getIsgifted() {
        return isgifted;
    }

    /**
     * @param isgifted
     */
    public void setIsgifted(BigDecimal isgifted) {
        this.isgifted = isgifted;
    }

    /**
     * @return ISINVOICED
     */
    public BigDecimal getIsinvoiced() {
        return isinvoiced;
    }

    /**
     * @param isinvoiced
     */
    public void setIsinvoiced(BigDecimal isinvoiced) {
        this.isinvoiced = isinvoiced;
    }

    /**
     * @return MVCCC_ID
     */
    public BigDecimal getMvcccId() {
        return mvcccId;
    }

    /**
     * @param mvcccId
     */
    public void setMvcccId(BigDecimal mvcccId) {
        this.mvcccId = mvcccId;
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
     * @return ISREFUND
     */
    public String getIsrefund() {
        return isrefund;
    }

    /**
     * @param isrefund
     */
    public void setIsrefund(String isrefund) {
        this.isrefund = isrefund;
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

    /**
     * @return REFUND_COUPON
     */
    public BigDecimal getRefundCoupon() {
        return refundCoupon;
    }

    /**
     * @param refundCoupon
     */
    public void setRefundCoupon(BigDecimal refundCoupon) {
        this.refundCoupon = refundCoupon;
    }

    /**
     * @return MONEY_COMPANY
     */
    public BigDecimal getMoneyCompany() {
        return moneyCompany;
    }

    /**
     * @param moneyCompany
     */
    public void setMoneyCompany(BigDecimal moneyCompany) {
        this.moneyCompany = moneyCompany;
    }

    /**
     * @return MONEY_PERSON
     */
    public BigDecimal getMoneyPerson() {
        return moneyPerson;
    }

    /**
     * @param moneyPerson
     */
    public void setMoneyPerson(BigDecimal moneyPerson) {
        this.moneyPerson = moneyPerson;
    }

    /**
     * @return MONEY_GIFT
     */
    public BigDecimal getMoneyGift() {
        return moneyGift;
    }

    /**
     * @param moneyGift
     */
    public void setMoneyGift(BigDecimal moneyGift) {
        this.moneyGift = moneyGift;
    }
}