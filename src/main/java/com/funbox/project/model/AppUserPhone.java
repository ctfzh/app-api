package com.funbox.project.model;

import javax.persistence.*;

@Table(name = "app_user_phone")
public class AppUserPhone {
    /**
     * 自增id
     */
    @Id
    private Integer id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 绑定时间
     */
    private Integer created;

    /**
     * 获取自增id
     *
     * @return id - 自增id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增id
     *
     * @param id 自增id
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
     * 获取手机号码
     *
     * @return phone - 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号码
     *
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取绑定时间
     *
     * @return created - 绑定时间
     */
    public Integer getCreated() {
        return created;
    }

    /**
     * 设置绑定时间
     *
     * @param created 绑定时间
     */
    public void setCreated(Integer created) {
        this.created = created;
    }
}