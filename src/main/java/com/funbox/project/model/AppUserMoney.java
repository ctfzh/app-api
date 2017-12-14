package com.funbox.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "app_user_money")
public class AppUserMoney {
    /**
     * 自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户Id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户余额: 单位（分）
     */
    private Integer money;

    /**
     * 修改时间
     */
    private Date modified;

    /**
     * 鲜食币：0个人账户;1公司账户；2福利账户
     */
    private Integer flag;

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
     * 获取用户余额: 单位（分）
     *
     * @return money - 用户余额: 单位（分）
     */
    public Integer getMoney() {
        return money;
    }

    /**
     * 设置用户余额: 单位（分）
     *
     * @param money 用户余额: 单位（分）
     */
    public void setMoney(Integer money) {
        this.money = money;
    }

    /**
     * 获取修改时间
     *
     * @return modified - 修改时间
     */
    public Date getModified() {
        return modified;
    }

    /**
     * 设置修改时间
     *
     * @param modified 修改时间
     */
    public void setModified(Date modified) {
        this.modified = modified;
    }

    /**
     * 获取鲜食币：0个人账户;1公司账户；2福利账户
     *
     * @return flag - 鲜食币：0个人账户;1公司账户；2福利账户
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * 设置鲜食币：0个人账户;1公司账户；2福利账户
     *
     * @param flag 鲜食币：0个人账户;1公司账户；2福利账户
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}