package com.funbox.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "MT_VM_CHANNEL_CONFIG_CARI")
public class MtVmChannelConfigCari {
    @Id
    @Column(name = "MVCCC_ID")
    private BigDecimal mvcccId;

    @Column(name = "VM_ID")
    private BigDecimal vmId;

    @Column(name = "INNER_CODE")
    private String innerCode;

    @Column(name = "TS")
    private Date ts;

    @Column(name = "CL_CODE")
    private String clCode;

    @Column(name = "CARI_CODE")
    private String cariCode;

    @Column(name = "VALID_TS")
    private Date validTs;

    @Column(name = "CARI_STATUS")
    private String cariStatus;

    @Column(name = "SALE_TIME")
    private Date saleTime;

    @Column(name = "CTS")
    private Date cts;

    @Column(name = "REMARKS")
    private String remarks;

    @Column(name = "IS_SYNC")
    private Short isSync;

    @Column(name = "SYNC_DATE")
    private Date syncDate;

    @Column(name = "LOCK_TIME")
    private Date lockTime;

    @Column(name = "PC_TYPE")
    private String pcType;

    @Column(name = "VT_ID")
    private BigDecimal vtId;

    @Column(name = "ORDER_ID")
    private String orderId;

    @Column(name = "MDSE_ID")
    private BigDecimal mdseId;

    /**
     * @return MVCCC_ID
     */
    public BigDecimal getMvcccId() {
        return mvcccId;
    }

    /**
     * @param mvcccId
     */
    public void setMvcccId(BigDecimal mvcccId) {
        this.mvcccId = mvcccId;
    }

    /**
     * @return VM_ID
     */
    public BigDecimal getVmId() {
        return vmId;
    }

    /**
     * @param vmId
     */
    public void setVmId(BigDecimal vmId) {
        this.vmId = vmId;
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
     * @return TS
     */
    public Date getTs() {
        return ts;
    }

    /**
     * @param ts
     */
    public void setTs(Date ts) {
        this.ts = ts;
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
     * @return CARI_CODE
     */
    public String getCariCode() {
        return cariCode;
    }

    /**
     * @param cariCode
     */
    public void setCariCode(String cariCode) {
        this.cariCode = cariCode;
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
     * @return CARI_STATUS
     */
    public String getCariStatus() {
        return cariStatus;
    }

    /**
     * @param cariStatus
     */
    public void setCariStatus(String cariStatus) {
        this.cariStatus = cariStatus;
    }

    /**
     * @return SALE_TIME
     */
    public Date getSaleTime() {
        return saleTime;
    }

    /**
     * @param saleTime
     */
    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    /**
     * @return CTS
     */
    public Date getCts() {
        return cts;
    }

    /**
     * @param cts
     */
    public void setCts(Date cts) {
        this.cts = cts;
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
     * @return SYNC_DATE
     */
    public Date getSyncDate() {
        return syncDate;
    }

    /**
     * @param syncDate
     */
    public void setSyncDate(Date syncDate) {
        this.syncDate = syncDate;
    }

    /**
     * @return LOCK_TIME
     */
    public Date getLockTime() {
        return lockTime;
    }

    /**
     * @param lockTime
     */
    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
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
     * @return VT_ID
     */
    public BigDecimal getVtId() {
        return vtId;
    }

    /**
     * @param vtId
     */
    public void setVtId(BigDecimal vtId) {
        this.vtId = vtId;
    }

    /**
     * @return ORDER_ID
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
}