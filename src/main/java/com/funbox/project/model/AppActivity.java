package com.funbox.project.model;

import javax.persistence.*;

@Table(name = "app_activity")
public class AppActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 活动名称
     */
    private String title;

    /**
     * 图片URL
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * H5页面地址
     */
    private String url;

    /**
     * 创建时间
     */
    private Integer created;

    /**
     * 修改时间
     */
    private Integer modified;

    /**
     * 创建人
     */
    private Integer author;

    /**
     * 修改人
     */
    private Integer modifier;

    /**
     * 是否有效;0为无效，1有效
     */
    @Column(name = "is_valid")
    private Integer isValid;

    /**
     * 排序值;倒序
     */
    @Column(name = "sort_num")
    private Integer sortNum;

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
     * 获取活动名称
     *
     * @return title - 活动名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置活动名称
     *
     * @param title 活动名称
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取图片URL
     *
     * @return img_url - 图片URL
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置图片URL
     *
     * @param imgUrl 图片URL
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * 获取H5页面地址
     *
     * @return url - H5页面地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置H5页面地址
     *
     * @param url H5页面地址
     */
    public void setUrl(String url) {
        this.url = url;
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
     * 获取创建人
     *
     * @return author - 创建人
     */
    public Integer getAuthor() {
        return author;
    }

    /**
     * 设置创建人
     *
     * @param author 创建人
     */
    public void setAuthor(Integer author) {
        this.author = author;
    }

    /**
     * 获取修改人
     *
     * @return modifier - 修改人
     */
    public Integer getModifier() {
        return modifier;
    }

    /**
     * 设置修改人
     *
     * @param modifier 修改人
     */
    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }

    /**
     * 获取是否有效;0为无效，1有效
     *
     * @return is_valid - 是否有效;0为无效，1有效
     */
    public Integer getIsValid() {
        return isValid;
    }

    /**
     * 设置是否有效;0为无效，1有效
     *
     * @param isValid 是否有效;0为无效，1有效
     */
    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    /**
     * 获取排序值;倒序
     *
     * @return sort_num - 排序值;倒序
     */
    public Integer getSortNum() {
        return sortNum;
    }

    /**
     * 设置排序值;倒序
     *
     * @param sortNum 排序值;倒序
     */
    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }
}