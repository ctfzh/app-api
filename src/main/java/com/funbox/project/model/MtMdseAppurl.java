package com.funbox.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "MT_MDSE_APPURL")
public class MtMdseAppurl {
    @Id
    @Column(name = "MA_ID")
    private BigDecimal maId;

    @Column(name = "MDSE_ID")
    private BigDecimal mdseId;

    @Column(name = "MDSE_NAME")
    private String mdseName;

    @Column(name = "APP_URL")
    private String appUrl;

    @Column(name = "PHOTO_TYPE")
    private Short photoType;

    @Column(name = "URL_WEIGHT")
    private BigDecimal urlWeight;

    @Column(name = "DELETE_MARK")
    private Short deleteMark;

    @Column(name = "CREATE_USER")
    private BigDecimal createUser;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "DELETE_USER")
    private BigDecimal deleteUser;

    @Column(name = "DELETE_TIME")
    private Date deleteTime;

    /**
     * @return MA_ID
     */
    public BigDecimal getMaId() {
        return maId;
    }

    /**
     * @param maId
     */
    public void setMaId(BigDecimal maId) {
        this.maId = maId;
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
     * @return APP_URL
     */
    public String getAppUrl() {
        return appUrl;
    }

    /**
     * @param appUrl
     */
    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    /**
     * @return PHOTO_TYPE
     */
    public Short getPhotoType() {
        return photoType;
    }

    /**
     * @param photoType
     */
    public void setPhotoType(Short photoType) {
        this.photoType = photoType;
    }

    /**
     * @return URL_WEIGHT
     */
    public BigDecimal getUrlWeight() {
        return urlWeight;
    }

    /**
     * @param urlWeight
     */
    public void setUrlWeight(BigDecimal urlWeight) {
        this.urlWeight = urlWeight;
    }

    /**
     * @return DELETE_MARK
     */
    public Short getDeleteMark() {
        return deleteMark;
    }

    /**
     * @param deleteMark
     */
    public void setDeleteMark(Short deleteMark) {
        this.deleteMark = deleteMark;
    }

    /**
     * @return CREATE_USER
     */
    public BigDecimal getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser
     */
    public void setCreateUser(BigDecimal createUser) {
        this.createUser = createUser;
    }

    /**
     * @return CREATE_TIME
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return DELETE_USER
     */
    public BigDecimal getDeleteUser() {
        return deleteUser;
    }

    /**
     * @param deleteUser
     */
    public void setDeleteUser(BigDecimal deleteUser) {
        this.deleteUser = deleteUser;
    }

    /**
     * @return DELETE_TIME
     */
    public Date getDeleteTime() {
        return deleteTime;
    }

    /**
     * @param deleteTime
     */
    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }
}