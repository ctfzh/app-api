package com.funbox.project.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "app_user")
public class AppOracleUser {
    /**
     * 用户Id
     */
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String passwd;

    /**
     * 注册方式;0 普通注册；1 手机注册；2 微信注册；
     */
    private Integer flag;

    /**
     * 状态;0 正常用户；1 被锁定不让登录
     */
    @Column(name = "isLocked")
    private Integer islocked;

    /**
     * 生日-月份
     */
    private Integer bmonth;

    /**
     * 生日-天
     */
    private Integer bday;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 口味
     */
    private String flavor;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别;1为男,2为女
     */
    private Integer sex;

    /**
     * 地址
     */
    private String location;

    /**
     * 接受推送消息;0不接受；1接受
     */
    @Column(name = "accept_message")
    private Integer acceptMessage;

    /**
     * 接受匿名赠餐;0不接受；1接受
     */
    @Column(name = "accept_anonymous")
    private Integer acceptAnonymous;

    /**
     * 创建时间
     */
    private Integer created;

    /**
     * 渠道
     */
    private String channel;

    /**
     * MAC or UUID
     */
    private String mac;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 获取用户Id
     *
     * @return user_id - 用户Id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户Id
     *
     * @param userId 用户Id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return passwd - 密码
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * 设置密码
     *
     * @param passwd 密码
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * 获取注册方式;0 普通注册；1 手机注册；2 微信注册；
     *
     * @return flag - 注册方式;0 普通注册；1 手机注册；2 微信注册；
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * 设置注册方式;0 普通注册；1 手机注册；2 微信注册；
     *
     * @param flag 注册方式;0 普通注册；1 手机注册；2 微信注册；
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /**
     * 获取状态;0 正常用户；1 被锁定不让登录
     *
     * @return isLocked - 状态;0 正常用户；1 被锁定不让登录
     */
    public Integer getIslocked() {
        return islocked;
    }

    /**
     * 设置状态;0 正常用户；1 被锁定不让登录
     *
     * @param islocked 状态;0 正常用户；1 被锁定不让登录
     */
    public void setIslocked(Integer islocked) {
        this.islocked = islocked;
    }

    /**
     * 获取生日-月份
     *
     * @return bmonth - 生日-月份
     */
    public Integer getBmonth() {
        return bmonth;
    }

    /**
     * 设置生日-月份
     *
     * @param bmonth 生日-月份
     */
    public void setBmonth(Integer bmonth) {
        this.bmonth = bmonth;
    }

    /**
     * 获取生日-天
     *
     * @return bday - 生日-天
     */
    public Integer getBday() {
        return bday;
    }

    /**
     * 设置生日-天
     *
     * @param bday 生日-天
     */
    public void setBday(Integer bday) {
        this.bday = bday;
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取口味
     *
     * @return flavor - 口味
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * 设置口味
     *
     * @param flavor 口味
     */
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取性别;1为男,2为女
     *
     * @return sex - 性别;1为男,2为女
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别;1为男,2为女
     *
     * @param sex 性别;1为男,2为女
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取地址
     *
     * @return location - 地址
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置地址
     *
     * @param location 地址
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * 获取接受推送消息;0不接受；1接受
     *
     * @return accept_message - 接受推送消息;0不接受；1接受
     */
    public Integer getAcceptMessage() {
        return acceptMessage;
    }

    /**
     * 设置接受推送消息;0不接受；1接受
     *
     * @param acceptMessage 接受推送消息;0不接受；1接受
     */
    public void setAcceptMessage(Integer acceptMessage) {
        this.acceptMessage = acceptMessage;
    }

    /**
     * 获取接受匿名赠餐;0不接受；1接受
     *
     * @return accept_anonymous - 接受匿名赠餐;0不接受；1接受
     */
    public Integer getAcceptAnonymous() {
        return acceptAnonymous;
    }

    /**
     * 设置接受匿名赠餐;0不接受；1接受
     *
     * @param acceptAnonymous 接受匿名赠餐;0不接受；1接受
     */
    public void setAcceptAnonymous(Integer acceptAnonymous) {
        this.acceptAnonymous = acceptAnonymous;
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
     * 获取渠道
     *
     * @return channel - 渠道
     */
    public String getChannel() {
        return channel;
    }

    /**
     * 设置渠道
     *
     * @param channel 渠道
     */
    public void setChannel(String channel) {
        this.channel = channel;
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

    /**
     * 获取头像
     *
     * @return avatar - 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}