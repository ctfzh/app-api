package com.funbox.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "MT_MERCHANDISE")
public class MtMerchandise {
    @Id
    @Column(name = "MDSE_ID")
    private BigDecimal mdseId;

    @Column(name = "MDSE_TYPE_ID")
    private BigDecimal mdseTypeId;

    @Column(name = "NAME_PY")
    private String namePy;

    @Column(name = "MDSE_NAME")
    private String mdseName;

    @Column(name = "REMARKS")
    private String remarks;

    @Column(name = "IMG_URL")
    private String imgUrl;

    @Column(name = "DELETE_MARK")
    private Short deleteMark;

    @Column(name = "CREATOR")
    private String creator;

    @Column(name = "CTIME")
    private Date ctime;

    @Column(name = "LOCK_MARK")
    private Short lockMark;

    @Column(name = "SHORT_NAME")
    private String shortName;

    @Column(name = "RECOMMEND")
    private Short recommend;

    @Column(name = "UTOR")
    private String utor;

    @Column(name = "UTIME")
    private Date utime;

    @Column(name = "MDSE_COLOR")
    private BigDecimal mdseColor;

    @Column(name = "COME_PRICE")
    private BigDecimal comePrice;

    @Column(name = "OFFER_PRICE")
    private BigDecimal offerPrice;

    @Column(name = "AUDIT_STATUS")
    private BigDecimal auditStatus;

    @Column(name = "AUDITOR")
    private String auditor;

    @Column(name = "AUDITIME")
    private Date auditime;

    @Column(name = "MDSE_NICKNAME")
    private String mdseNickname;

    @Column(name = "MDSE_STAPLEFOOD")
    private String mdseStaplefood;

    @Column(name = "MDSE_SUBGRID")
    private String mdseSubgrid;

    @Column(name = "MDSE_SMALLGRID")
    private String mdseSmallgrid;

    @Column(name = "APP_WX_PRICE")
    private BigDecimal appWxPrice;

    @Column(name = "APP_ZFB_PRICE")
    private BigDecimal appZfbPrice;

    @Column(name = "APP_YL_PRICE")
    private BigDecimal appYlPrice;

    @Column(name = "WX_PRICE")
    private BigDecimal wxPrice;

    @Column(name = "ZFB_PRICE")
    private BigDecimal zfbPrice;

    @Column(name = "YL_PRICE")
    private BigDecimal ylPrice;

    @Column(name = "IMG_MD5")
    private String imgMd5;

    @Column(name = "ORG_ID")
    private BigDecimal orgId;

    @Column(name = "MATERIAL_GROUP")
    private String materialGroup;

    @Column(name = "MATERIAL_CODE")
    private String materialCode;

    @Column(name = "BOX_LONG")
    private BigDecimal boxLong;

    @Column(name = "BOX_WIDTH")
    private BigDecimal boxWidth;

    @Column(name = "BOX_HIGH")
    private BigDecimal boxHigh;

    @Column(name = "YE_PRICE")
    private BigDecimal yePrice;

    @Column(name = "BT_TYPE")
    private String btType;

    @Column(name = "SHELF_LIFE")
    private BigDecimal shelfLife;

    @Column(name = "SPACE_TYPE")
    private String spaceType;

    @Column(name = "RESERVE_PRICE")
    private BigDecimal reservePrice;

    @Column(name = "STORAGE_ID")
    private BigDecimal storageId;

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
     * @return MDSE_TYPE_ID
     */
    public BigDecimal getMdseTypeId() {
        return mdseTypeId;
    }

    /**
     * @param mdseTypeId
     */
    public void setMdseTypeId(BigDecimal mdseTypeId) {
        this.mdseTypeId = mdseTypeId;
    }

    /**
     * @return NAME_PY
     */
    public String getNamePy() {
        return namePy;
    }

    /**
     * @param namePy
     */
    public void setNamePy(String namePy) {
        this.namePy = namePy;
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
     * @return REMARKS
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * @return IMG_URL
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * @param imgUrl
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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
     * @return CREATOR
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @param creator
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * @return CTIME
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * @param ctime
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /**
     * @return LOCK_MARK
     */
    public Short getLockMark() {
        return lockMark;
    }

    /**
     * @param lockMark
     */
    public void setLockMark(Short lockMark) {
        this.lockMark = lockMark;
    }

    /**
     * @return SHORT_NAME
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * @param shortName
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * @return RECOMMEND
     */
    public Short getRecommend() {
        return recommend;
    }

    /**
     * @param recommend
     */
    public void setRecommend(Short recommend) {
        this.recommend = recommend;
    }

    /**
     * @return UTOR
     */
    public String getUtor() {
        return utor;
    }

    /**
     * @param utor
     */
    public void setUtor(String utor) {
        this.utor = utor;
    }

    /**
     * @return UTIME
     */
    public Date getUtime() {
        return utime;
    }

    /**
     * @param utime
     */
    public void setUtime(Date utime) {
        this.utime = utime;
    }

    /**
     * @return MDSE_COLOR
     */
    public BigDecimal getMdseColor() {
        return mdseColor;
    }

    /**
     * @param mdseColor
     */
    public void setMdseColor(BigDecimal mdseColor) {
        this.mdseColor = mdseColor;
    }

    /**
     * @return COME_PRICE
     */
    public BigDecimal getComePrice() {
        return comePrice;
    }

    /**
     * @param comePrice
     */
    public void setComePrice(BigDecimal comePrice) {
        this.comePrice = comePrice;
    }

    /**
     * @return OFFER_PRICE
     */
    public BigDecimal getOfferPrice() {
        return offerPrice;
    }

    /**
     * @param offerPrice
     */
    public void setOfferPrice(BigDecimal offerPrice) {
        this.offerPrice = offerPrice;
    }

    /**
     * @return AUDIT_STATUS
     */
    public BigDecimal getAuditStatus() {
        return auditStatus;
    }

    /**
     * @param auditStatus
     */
    public void setAuditStatus(BigDecimal auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * @return AUDITOR
     */
    public String getAuditor() {
        return auditor;
    }

    /**
     * @param auditor
     */
    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    /**
     * @return AUDITIME
     */
    public Date getAuditime() {
        return auditime;
    }

    /**
     * @param auditime
     */
    public void setAuditime(Date auditime) {
        this.auditime = auditime;
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
     * @return APP_WX_PRICE
     */
    public BigDecimal getAppWxPrice() {
        return appWxPrice;
    }

    /**
     * @param appWxPrice
     */
    public void setAppWxPrice(BigDecimal appWxPrice) {
        this.appWxPrice = appWxPrice;
    }

    /**
     * @return APP_ZFB_PRICE
     */
    public BigDecimal getAppZfbPrice() {
        return appZfbPrice;
    }

    /**
     * @param appZfbPrice
     */
    public void setAppZfbPrice(BigDecimal appZfbPrice) {
        this.appZfbPrice = appZfbPrice;
    }

    /**
     * @return APP_YL_PRICE
     */
    public BigDecimal getAppYlPrice() {
        return appYlPrice;
    }

    /**
     * @param appYlPrice
     */
    public void setAppYlPrice(BigDecimal appYlPrice) {
        this.appYlPrice = appYlPrice;
    }

    /**
     * @return WX_PRICE
     */
    public BigDecimal getWxPrice() {
        return wxPrice;
    }

    /**
     * @param wxPrice
     */
    public void setWxPrice(BigDecimal wxPrice) {
        this.wxPrice = wxPrice;
    }

    /**
     * @return ZFB_PRICE
     */
    public BigDecimal getZfbPrice() {
        return zfbPrice;
    }

    /**
     * @param zfbPrice
     */
    public void setZfbPrice(BigDecimal zfbPrice) {
        this.zfbPrice = zfbPrice;
    }

    /**
     * @return YL_PRICE
     */
    public BigDecimal getYlPrice() {
        return ylPrice;
    }

    /**
     * @param ylPrice
     */
    public void setYlPrice(BigDecimal ylPrice) {
        this.ylPrice = ylPrice;
    }

    /**
     * @return IMG_MD5
     */
    public String getImgMd5() {
        return imgMd5;
    }

    /**
     * @param imgMd5
     */
    public void setImgMd5(String imgMd5) {
        this.imgMd5 = imgMd5;
    }

    /**
     * @return ORG_ID
     */
    public BigDecimal getOrgId() {
        return orgId;
    }

    /**
     * @param orgId
     */
    public void setOrgId(BigDecimal orgId) {
        this.orgId = orgId;
    }

    /**
     * @return MATERIAL_GROUP
     */
    public String getMaterialGroup() {
        return materialGroup;
    }

    /**
     * @param materialGroup
     */
    public void setMaterialGroup(String materialGroup) {
        this.materialGroup = materialGroup;
    }

    /**
     * @return MATERIAL_CODE
     */
    public String getMaterialCode() {
        return materialCode;
    }

    /**
     * @param materialCode
     */
    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    /**
     * @return BOX_LONG
     */
    public BigDecimal getBoxLong() {
        return boxLong;
    }

    /**
     * @param boxLong
     */
    public void setBoxLong(BigDecimal boxLong) {
        this.boxLong = boxLong;
    }

    /**
     * @return BOX_WIDTH
     */
    public BigDecimal getBoxWidth() {
        return boxWidth;
    }

    /**
     * @param boxWidth
     */
    public void setBoxWidth(BigDecimal boxWidth) {
        this.boxWidth = boxWidth;
    }

    /**
     * @return BOX_HIGH
     */
    public BigDecimal getBoxHigh() {
        return boxHigh;
    }

    /**
     * @param boxHigh
     */
    public void setBoxHigh(BigDecimal boxHigh) {
        this.boxHigh = boxHigh;
    }

    /**
     * @return YE_PRICE
     */
    public BigDecimal getYePrice() {
        return yePrice;
    }

    /**
     * @param yePrice
     */
    public void setYePrice(BigDecimal yePrice) {
        this.yePrice = yePrice;
    }

    /**
     * @return BT_TYPE
     */
    public String getBtType() {
        return btType;
    }

    /**
     * @param btType
     */
    public void setBtType(String btType) {
        this.btType = btType;
    }

    /**
     * @return SHELF_LIFE
     */
    public BigDecimal getShelfLife() {
        return shelfLife;
    }

    /**
     * @param shelfLife
     */
    public void setShelfLife(BigDecimal shelfLife) {
        this.shelfLife = shelfLife;
    }

    /**
     * @return SPACE_TYPE
     */
    public String getSpaceType() {
        return spaceType;
    }

    /**
     * @param spaceType
     */
    public void setSpaceType(String spaceType) {
        this.spaceType = spaceType;
    }

    /**
     * @return RESERVE_PRICE
     */
    public BigDecimal getReservePrice() {
        return reservePrice;
    }

    /**
     * @param reservePrice
     */
    public void setReservePrice(BigDecimal reservePrice) {
        this.reservePrice = reservePrice;
    }

    /**
     * @return STORAGE_ID
     */
    public BigDecimal getStorageId() {
        return storageId;
    }

    /**
     * @param storageId
     */
    public void setStorageId(BigDecimal storageId) {
        this.storageId = storageId;
    }
}