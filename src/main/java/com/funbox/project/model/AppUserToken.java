package com.funbox.project.model;

import javax.persistence.*;

@Table(name = "app_user_token")
public class AppUserToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 客户端
     */
    @Column(name = "user_client")
    private String userClient;

    /**
     * token
     */
    private String token;

    /**
     * 修改时间
     */
    private Integer modified;

    @Column(name = "registration_id")
    private String registrationId;

    /**
     * MAC or UUID
     */
    private String mac;

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
     * 获取客户端
     *
     * @return user_client - 客户端
     */
    public String getUserClient() {
        return userClient;
    }

    /**
     * 设置客户端
     *
     * @param userClient 客户端
     */
    public void setUserClient(String userClient) {
        this.userClient = userClient;
    }

    /**
     * 获取token
     *
     * @return token - token
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置token
     *
     * @param token token
     */
    public void setToken(String token) {
        this.token = token;
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
     * @return registration_id
     */
    public String getRegistrationId() {
        return registrationId;
    }

    /**
     * @param registrationId
     */
    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    /**
     * 获取MAC or UUID
     *
     * @return mac - MAC or UUID
     */
    public String getMac() {
        return mac;
    }

    /**
     * 设置MAC or UUID
     *
     * @param mac MAC or UUID
     */
    public void setMac(String mac) {
        this.mac = mac;
    }
}