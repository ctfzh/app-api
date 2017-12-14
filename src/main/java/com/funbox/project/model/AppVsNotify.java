package com.funbox.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "app_vs_notify")
public class AppVsNotify {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 售货机编号
     */
    @Column(name = "inner_code")
    private String innerCode;

    /**
     * 通知类型
     */
    @Column(name = "notify_flag")
    private String notifyFlag;

    /**
     * 主订单id
     */
    @Column(name = "main_order_id")
    private Integer mainOrderId;

    /**
     * 0未成功,1成功
     */
    private Integer result;

    /**
     * 创建时间
     */
    private Integer created;

    /**
     * 修改时间
     */
    private Integer modified;

    /**
     * 最大日期
     */
    @Column(name = "max_food_date")
    private Date maxFoodDate;

    /**
     * 通知消息体
     */
    @Column(name = "request_content")
    private String requestContent;

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
     * 获取通知类型
     *
     * @return notify_flag - 通知类型
     */
    public String getNotifyFlag() {
        return notifyFlag;
    }

    /**
     * 设置通知类型
     *
     * @param notifyFlag 通知类型
     */
    public void setNotifyFlag(String notifyFlag) {
        this.notifyFlag = notifyFlag;
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
     * 获取0未成功,1成功
     *
     * @return result - 0未成功,1成功
     */
    public Integer getResult() {
        return result;
    }

    /**
     * 设置0未成功,1成功
     *
     * @param result 0未成功,1成功
     */
    public void setResult(Integer result) {
        this.result = result;
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
     * 获取修改时间
     *
     * @return modified - 修改时间
     */
    public Integer getModified() {
        return modified;
    }

    /**
     * 设置修改时间
     *
     * @param modified 修改时间
     */
    public void setModified(Integer modified) {
        this.modified = modified;
    }

    /**
     * 获取最大日期
     *
     * @return max_food_date - 最大日期
     */
    public Date getMaxFoodDate() {
        return maxFoodDate;
    }

    /**
     * 设置最大日期
     *
     * @param maxFoodDate 最大日期
     */
    public void setMaxFoodDate(Date maxFoodDate) {
        this.maxFoodDate = maxFoodDate;
    }

    /**
     * 获取通知消息体
     *
     * @return request_content - 通知消息体
     */
    public String getRequestContent() {
        return requestContent;
    }

    /**
     * 设置通知消息体
     *
     * @param requestContent 通知消息体
     */
    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }
}