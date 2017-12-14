package com.funbox.project.model;

import javax.persistence.*;

@Table(name = "app_invoice")
public class AppInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 发票金额（单位:分）
     */
    @Column(name = "Invoicesum")
    private Integer invoicesum;

    /**
     * 发票抬头
     */
    @Column(name = "InvoiceName")
    private String invoicename;

    /**
     * 邮寄地址
     */
    @Column(name = "Address")
    private String address;

    /**
     * 收件人
     */
    @Column(name = "RealName")
    private String realname;

    /**
     * 联系电话
     */
    @Column(name = "Mobileno")
    private String mobileno;

    /**
     * 平邮/快递
     */
    @Column(name = "SendType")
    private String sendtype;

    /**
     * 0已申请;1已开
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Integer created;

    /**
     * 税号
     */
    @Column(name = "dutyNumber")
    private Integer dutynumber;

    /**
     * 0：公司 1：个人
     */
    @Column(name = "companySelf")
    private Integer companyself;

    /**
     * 所属区域
     */
    private String area;

    /**
     * 订单号
     */
    @Column(name = "Order_ids")
    private String orderIds;

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
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取发票金额（单位:分）
     *
     * @return Invoicesum - 发票金额（单位:分）
     */
    public Integer getInvoicesum() {
        return invoicesum;
    }

    /**
     * 设置发票金额（单位:分）
     *
     * @param invoicesum 发票金额（单位:分）
     */
    public void setInvoicesum(Integer invoicesum) {
        this.invoicesum = invoicesum;
    }

    /**
     * 获取发票抬头
     *
     * @return InvoiceName - 发票抬头
     */
    public String getInvoicename() {
        return invoicename;
    }

    /**
     * 设置发票抬头
     *
     * @param invoicename 发票抬头
     */
    public void setInvoicename(String invoicename) {
        this.invoicename = invoicename;
    }

    /**
     * 获取邮寄地址
     *
     * @return Address - 邮寄地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置邮寄地址
     *
     * @param address 邮寄地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取收件人
     *
     * @return RealName - 收件人
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 设置收件人
     *
     * @param realname 收件人
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * 获取联系电话
     *
     * @return Mobileno - 联系电话
     */
    public String getMobileno() {
        return mobileno;
    }

    /**
     * 设置联系电话
     *
     * @param mobileno 联系电话
     */
    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    /**
     * 获取平邮/快递
     *
     * @return SendType - 平邮/快递
     */
    public String getSendtype() {
        return sendtype;
    }

    /**
     * 设置平邮/快递
     *
     * @param sendtype 平邮/快递
     */
    public void setSendtype(String sendtype) {
        this.sendtype = sendtype;
    }

    /**
     * 获取0已申请;1已开
     *
     * @return status - 0已申请;1已开
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0已申请;1已开
     *
     * @param status 0已申请;1已开
     */
    public void setStatus(Integer status) {
        this.status = status;
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
     * 获取税号
     *
     * @return dutyNumber - 税号
     */
    public Integer getDutynumber() {
        return dutynumber;
    }

    /**
     * 设置税号
     *
     * @param dutynumber 税号
     */
    public void setDutynumber(Integer dutynumber) {
        this.dutynumber = dutynumber;
    }

    /**
     * 获取0：公司 1：个人
     *
     * @return companySelf - 0：公司 1：个人
     */
    public Integer getCompanyself() {
        return companyself;
    }

    /**
     * 设置0：公司 1：个人
     *
     * @param companyself 0：公司 1：个人
     */
    public void setCompanyself(Integer companyself) {
        this.companyself = companyself;
    }

    /**
     * 获取所属区域
     *
     * @return area - 所属区域
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置所属区域
     *
     * @param area 所属区域
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取订单号
     *
     * @return Order_ids - 订单号
     */
    public String getOrderIds() {
        return orderIds;
    }

    /**
     * 设置订单号
     *
     * @param orderIds 订单号
     */
    public void setOrderIds(String orderIds) {
        this.orderIds = orderIds;
    }
}