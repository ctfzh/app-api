package com.funbox.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "MT_VM_CHANNEL_CONFIG_INFO")
public class MtVmChannelConfigInfo {
    @Id
    @Column(name = "VCCI_ID")
    private Long vcciId;

    @Column(name = "NODE_ID")
    private Long nodeId;

    @Column(name = "VM_ID")
    private Long vmId;

    @Column(name = "CL_CODE")
    private String clCode;

    @Column(name = "TOTAL_NUM")
    private Long totalNum;

    @Column(name = "REPLEN_NUM")
    private Long replenNum;

    @Column(name = "MDSE_ID")
    private Long mdseId;

    @Column(name = "MDSE_NAME")
    private String mdseName;

    @Column(name = "VALID_TS")
    private Date validTs;

    @Column(name = "SYNC_TS")
    private Date syncTs;

    @Column(name = "IS_SYNC")
    private Short isSync;

    @Column(name = "COME_PRICE")
    private BigDecimal comePrice;

    @Column(name = "OFFER_PRICE")
    private BigDecimal offerPrice;

    @Column(name = "REAL_PRICE")
    private BigDecimal realPrice;

    @Column(name = "CONF_STATUS")
    private Short confStatus;

    @Column(name = "REPLENISH_STATUS")
    private String replenishStatus;

    @Column(name = "CURR_NUM")
    private Long currNum;

    @Column(name = "CL_COLOR")
    private String clColor;

    @Column(name = "CREATOR")
    private String creator;

    @Column(name = "CREATIME")
    private Date creatime;

    @Column(name = "UTOR")
    private String utor;

    @Column(name = "UTIME")
    private Date utime;

    @Column(name = "INNER_CODE")
    private String innerCode;

    @Column(name = "PC_TYPE")
    private String pcType;

    @Column(name = "DAY_TITLE")
    private String dayTitle;

    @Column(name = "SUCC_NUM")
    private Integer succNum;

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

    @Column(name = "YE_PRICE")
    private BigDecimal yePrice;

    @Column(name = "REAL_RELEN_NUM")
    private BigDecimal realRelenNum;

    @Column(name = "REPLEN_USER")
    private String replenUser;

    @Column(name = "REPLEN_TIME")
    private Date replenTime;

    @Column(name = "SHELF_LIFE")
    private BigDecimal shelfLife;

    @Column(name = "CONF_TYPE")
    private String confType;

    @Column(name = "RESERVE_PRICE")
    private BigDecimal reservePrice;

    /**
     * @return VCCI_ID
     */
    public Long getVcciId() {
        return vcciId;
    }

    /**
     * @param vcciId
     */
    public void setVcciId(Long vcciId) {
        this.vcciId = vcciId;
    }

    /**
     * @return NODE_ID
     */
    public Long getNodeId() {
        return nodeId;
    }

    /**
     * @param nodeId
     */
    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * @return VM_ID
     */
    public Long getVmId() {
        return vmId;
    }

    /**
     * @param vmId
     */
    public void setVmId(Long vmId) {
        this.vmId = vmId;
    }

    /**
     * @return CL_CODE
     */
    public String getClCode() {
        return clCode;
    }

    /**
     * @param clCode
     */
    public void setClCode(String clCode) {
        this.clCode = clCode;
    }

    /**
     * @return TOTAL_NUM
     */
    public Long getTotalNum() {
        return totalNum;
    }

    /**
     * @param totalNum
     */
    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
    }

    /**
     * @return REPLEN_NUM
     */
    public Long getReplenNum() {
        return replenNum;
    }

    /**
     * @param replenNum
     */
    public void setReplenNum(Long replenNum) {
        this.replenNum = replenNum;
    }

    /**
     * @return MDSE_ID
     */
    public Long getMdseId() {
        return mdseId;
    }

    /**
     * @param mdseId
     */
    public void setMdseId(Long mdseId) {
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
     * @return VALID_TS
     */
    public Date getValidTs() {
        return validTs;
    }

    /**
     * @param validTs
     */
    public void setValidTs(Date validTs) {
        this.validTs = validTs;
    }

    /**
     * @return SYNC_TS
     */
    public Date getSyncTs() {
        return syncTs;
    }

    /**
     * @param syncTs
     */
    public void setSyncTs(Date syncTs) {
        this.syncTs = syncTs;
    }

    /**
     * @return IS_SYNC
     */
    public Short getIsSync() {
        return isSync;
    }

    /**
     * @param isSync
     */
    public void setIsSync(Short isSync) {
        this.isSync = isSync;
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
     * @return REAL_PRICE
     */
    public BigDecimal getRealPrice() {
        return realPrice;
    }

    /**
     * @param realPrice
     */
    public void setRealPrice(BigDecimal realPrice) {
        this.realPrice = realPrice;
    }

    /**
     * @return CONF_STATUS
     */
    public Short getConfStatus() {
        return confStatus;
    }

    /**
     * @param confStatus
     */
    public void setConfStatus(Short confStatus) {
        this.confStatus = confStatus;
    }

    /**
     * @return REPLENISH_STATUS
     */
    public String getReplenishStatus() {
        return replenishStatus;
    }

    /**
     * @param replenishStatus
     */
    public void setReplenishStatus(String replenishStatus) {
        this.replenishStatus = replenishStatus;
    }

    /**
     * @return CURR_NUM
     */
    public Long getCurrNum() {
        return currNum;
    }

    /**
     * @param currNum
     */
    public void setCurrNum(Long currNum) {
        this.currNum = currNum;
    }

    /**
     * @return CL_COLOR
     */
    public String getClColor() {
        return clColor;
    }

    /**
     * @param clColor
     */
    public void setClColor(String clColor) {
        this.clColor = clColor;
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
     * @return CREATIME
     */
    public Date getCreatime() {
        return creatime;
    }

    /**
     * @param creatime
     */
    public void setCreatime(Date creatime) {
        this.creatime = creatime;
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
     * @return INNER_CODE
     */
    public String getInnerCode() {
        return innerCode;
    }

    /**
     * @param innerCode
     */
    public void setInnerCode(String innerCode) {
        this.innerCode = innerCode;
    }

    /**
     * @return PC_TYPE
     */
    public String getPcType() {
        return pcType;
    }

    /**
     * @param pcType
     */
    public void setPcType(String pcType) {
        this.pcType = pcType;
    }

    /**
     * @return DAY_TITLE
     */
    public String getDayTitle() {
        return dayTitle;
    }

    /**
     * @param dayTitle
     */
    public void setDayTitle(String dayTitle) {
        this.dayTitle = dayTitle;
    }

    /**
     * @return SUCC_NUM
     */
    public Integer getSuccNum() {
        return succNum;
    }

    /**
     * @param succNum
     */
    public void setSuccNum(Integer succNum) {
        this.succNum = succNum;
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
     * @return REAL_RELEN_NUM
     */
    public BigDecimal getRealRelenNum() {
        return realRelenNum;
    }

    /**
     * @param realRelenNum
     */
    public void setRealRelenNum(BigDecimal realRelenNum) {
        this.realRelenNum = realRelenNum;
    }

    /**
     * @return REPLEN_USER
     */
    public String getReplenUser() {
        return replenUser;
    }

    /**
     * @param replenUser
     */
    public void setReplenUser(String replenUser) {
        this.replenUser = replenUser;
    }

    /**
     * @return REPLEN_TIME
     */
    public Date getReplenTime() {
        return replenTime;
    }

    /**
     * @param replenTime
     */
    public void setReplenTime(Date replenTime) {
        this.replenTime = replenTime;
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
     * @return CONF_TYPE
     */
    public String getConfType() {
        return confType;
    }

    /**
     * @param confType
     */
    public void setConfType(String confType) {
        this.confType = confType;
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
}