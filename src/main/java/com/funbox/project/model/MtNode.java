package com.funbox.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "MT_NODE")
public class MtNode {
    @Id
    @Column(name = "NODE_ID")
    private BigDecimal nodeId;

    @Column(name = "STORAGE_ID")
    private BigDecimal storageId;

    @Column(name = "OPERATORS_ID")
    private BigDecimal operatorsId;

    @Column(name = "NODE_NAME")
    private String nodeName;

    @Column(name = "DELETE_MARK")
    private Short deleteMark;

    @Column(name = "AREA_CODE")
    private String areaCode;

    @Column(name = "NODE_ADDRESS")
    private String nodeAddress;

    @Column(name = "NODE_PLACE")
    private Short nodePlace;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    @Column(name = "LONGITUDE")
    private String longitude;

    @Column(name = "DIMENSIONS")
    private String dimensions;

    @Column(name = "SYNC_MARK")
    private Short syncMark;

    @Column(name = "LSYNC_TS")
    private Date lsyncTs;

    @Column(name = "CREATOR")
    private String creator;

    @Column(name = "CTIME")
    private Date ctime;

    @Column(name = "ABBR")
    private String abbr;

    @Column(name = "CARD_TYPE_ID")
    private BigDecimal cardTypeId;

    @Column(name = "NODE_AD")
    private String nodeAd;

    @Column(name = "CUSTOMER_ID")
    private String customerId;

    @Column(name = "UTOR")
    private String utor;

    @Column(name = "UTIME")
    private Date utime;

    @Column(name = "ORG_ID")
    private BigDecimal orgId;

    @Column(name = "BUSINESS_NAME")
    private String businessName;

    @Column(name = "BUILD_NAME")
    private String buildName;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    /**
     * @return NODE_ID
     */
    public BigDecimal getNodeId() {
        return nodeId;
    }

    /**
     * @param nodeId
     */
    public void setNodeId(BigDecimal nodeId) {
        this.nodeId = nodeId;
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

    /**
     * @return OPERATORS_ID
     */
    public BigDecimal getOperatorsId() {
        return operatorsId;
    }

    /**
     * @param operatorsId
     */
    public void setOperatorsId(BigDecimal operatorsId) {
        this.operatorsId = operatorsId;
    }

    /**
     * @return NODE_NAME
     */
    public String getNodeName() {
        return nodeName;
    }

    /**
     * @param nodeName
     */
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
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
     * @return AREA_CODE
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * @param areaCode
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * @return NODE_ADDRESS
     */
    public String getNodeAddress() {
        return nodeAddress;
    }

    /**
     * @param nodeAddress
     */
    public void setNodeAddress(String nodeAddress) {
        this.nodeAddress = nodeAddress;
    }

    /**
     * @return NODE_PLACE
     */
    public Short getNodePlace() {
        return nodePlace;
    }

    /**
     * @param nodePlace
     */
    public void setNodePlace(Short nodePlace) {
        this.nodePlace = nodePlace;
    }

    /**
     * @return ZIP_CODE
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return LONGITUDE
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * @return DIMENSIONS
     */
    public String getDimensions() {
        return dimensions;
    }

    /**
     * @param dimensions
     */
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    /**
     * @return SYNC_MARK
     */
    public Short getSyncMark() {
        return syncMark;
    }

    /**
     * @param syncMark
     */
    public void setSyncMark(Short syncMark) {
        this.syncMark = syncMark;
    }

    /**
     * @return LSYNC_TS
     */
    public Date getLsyncTs() {
        return lsyncTs;
    }

    /**
     * @param lsyncTs
     */
    public void setLsyncTs(Date lsyncTs) {
        this.lsyncTs = lsyncTs;
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
     * @return ABBR
     */
    public String getAbbr() {
        return abbr;
    }

    /**
     * @param abbr
     */
    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    /**
     * @return CARD_TYPE_ID
     */
    public BigDecimal getCardTypeId() {
        return cardTypeId;
    }

    /**
     * @param cardTypeId
     */
    public void setCardTypeId(BigDecimal cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    /**
     * @return NODE_AD
     */
    public String getNodeAd() {
        return nodeAd;
    }

    /**
     * @param nodeAd
     */
    public void setNodeAd(String nodeAd) {
        this.nodeAd = nodeAd;
    }

    /**
     * @return CUSTOMER_ID
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
     * @return BUSINESS_NAME
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * @param businessName
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    /**
     * @return BUILD_NAME
     */
    public String getBuildName() {
        return buildName;
    }

    /**
     * @param buildName
     */
    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    /**
     * @return COMPANY_NAME
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}