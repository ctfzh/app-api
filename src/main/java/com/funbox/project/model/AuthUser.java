package com.funbox.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "auth_user")
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 登录名
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 密码:MD5加密
     */
    private String password;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 分公司，对应auth_district.id (type==1||3）的情况
     */
    @Column(name = "district_id")
    private Integer districtId;

    /**
     * 0:未定义,1:男,2:女
     */
    private Byte sex;

    /**
     * email地址
     */
    private String email;

    /**
     * 加密的key
     */
    private String key;

    /**
     * 帐号等级
     */
    private String level;

    /**
     * 状态
     */
    private String status;

    /**
     * 登录次数
     */
    @Column(name = "login_count")
    private Integer loginCount;

    /**
     * 登录时间
     */
    @Column(name = "last_time")
    private Date lastTime;

    /**
     * 登录id
     */
    @Column(name = "last_ip")
    private String lastIp;

    /**
     * 注备
     */
    private String comment;

    @Column(name = "create_dt")
    private Date createDt;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "update_dt")
    private Date updateDt;

    @Column(name = "update_by")
    private String updateBy;

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
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取登录名
     *
     * @return login_name - 登录名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置登录名
     *
     * @param loginName 登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * 获取密码:MD5加密
     *
     * @return password - 密码:MD5加密
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码:MD5加密
     *
     * @param password 密码:MD5加密
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取手机号码
     *
     * @return mobile - 手机号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号码
     *
     * @param mobile 手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取分公司，对应auth_district.id (type==1||3）的情况
     *
     * @return district_id - 分公司，对应auth_district.id (type==1||3）的情况
     */
    public Integer getDistrictId() {
        return districtId;
    }

    /**
     * 设置分公司，对应auth_district.id (type==1||3）的情况
     *
     * @param districtId 分公司，对应auth_district.id (type==1||3）的情况
     */
    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    /**
     * 获取0:未定义,1:男,2:女
     *
     * @return sex - 0:未定义,1:男,2:女
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 设置0:未定义,1:男,2:女
     *
     * @param sex 0:未定义,1:男,2:女
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 获取email地址
     *
     * @return email - email地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置email地址
     *
     * @param email email地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取加密的key
     *
     * @return key - 加密的key
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置加密的key
     *
     * @param key 加密的key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 获取帐号等级
     *
     * @return level - 帐号等级
     */
    public String getLevel() {
        return level;
    }

    /**
     * 设置帐号等级
     *
     * @param level 帐号等级
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取登录次数
     *
     * @return login_count - 登录次数
     */
    public Integer getLoginCount() {
        return loginCount;
    }

    /**
     * 设置登录次数
     *
     * @param loginCount 登录次数
     */
    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    /**
     * 获取登录时间
     *
     * @return last_time - 登录时间
     */
    public Date getLastTime() {
        return lastTime;
    }

    /**
     * 设置登录时间
     *
     * @param lastTime 登录时间
     */
    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    /**
     * 获取登录id
     *
     * @return last_ip - 登录id
     */
    public String getLastIp() {
        return lastIp;
    }

    /**
     * 设置登录id
     *
     * @param lastIp 登录id
     */
    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    /**
     * 获取注备
     *
     * @return comment - 注备
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置注备
     *
     * @param comment 注备
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return create_dt
     */
    public Date getCreateDt() {
        return createDt;
    }

    /**
     * @param createDt
     */
    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    /**
     * @return create_by
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * @return update_dt
     */
    public Date getUpdateDt() {
        return updateDt;
    }

    /**
     * @param updateDt
     */
    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }

    /**
     * @return update_by
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * @param updateBy
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}