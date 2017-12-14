package com.funbox.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "MT_VM_CHANNEL")
public class MtVmChannel {
    @Id
    @Column(name = "CL_ID")
    private BigDecimal clId;

    @Column(name = "VM_ID")
    private BigDecimal vmId;

    @Column(name = "CL_CODE")
    private String clCode;

    @Column(name = "CS")
    private String cs;

    @Column(name = "REMARKS")
    private String remarks;

    @Column(name = "DELETE_MARK")
    private Short deleteMark;

    @Column(name = "LSYNC_TS")
    private Date lsyncTs;

    @Column(name = "C_LONG")
    private BigDecimal cLong;

    @Column(name = "C_WIDTH")
    private BigDecimal cWidth;

    @Column(name = "C_HEIGHT")
    private BigDecimal cHeight;

    @Column(name = "SYNC_MARK")
    private Short syncMark;

    @Column(name = "CREATOR")
    private String creator;

    @Column(name = "CTIME")
    private Date ctime;

    @Column(name = "T_CAPACITY")
    private Short tCapacity;

    @Column(name = "VM_CLAYERS")
    private Short vmClayers;

    @Column(name = "IS_WEAL_MDSE")
    private Short isWealMdse;

    @Column(name = "GUID")
    private BigDecimal guid;

    @Column(name = "CL_COLOR")
    private String clColor;

    @Column(name = "UTOR")
    private String utor;

    @Column(name = "UTIME")
    private Date utime;

    @Column(name = "PC_TYPE")
    private String pcType;

    @Column(name = "BT_TYPE")
    private String btType;

    @Column(name = "SEALS_TYPE")
    private Short sealsType;

    @Column(name = "SPACE_TYPE")
    private String spaceType;

    /**
     * @return CL_ID
     */
    public BigDecimal getClId() {
        return clId;
    }

    /**
     * @param clId
     */
    public void setClId(BigDecimal clId) {
        this.clId = clId;
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
     * @return CS
     */
    public String getCs() {
        return cs;
    }

    /**
     * @param cs
     */
    public void setCs(String cs) {
        this.cs = cs;
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
     * @return C_LONG
     */
    public BigDecimal getcLong() {
        return cLong;
    }

    /**
     * @param cLong
     */
    public void setcLong(BigDecimal cLong) {
        this.cLong = cLong;
    }

    /**
     * @return C_WIDTH
     */
    public BigDecimal getcWidth() {
        return cWidth;
    }

    /**
     * @param cWidth
     */
    public void setcWidth(BigDecimal cWidth) {
        this.cWidth = cWidth;
    }

    /**
     * @return C_HEIGHT
     */
    public BigDecimal getcHeight() {
        return cHeight;
    }

    /**
     * @param cHeight
     */
    public void setcHeight(BigDecimal cHeight) {
        this.cHeight = cHeight;
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
     * @return T_CAPACITY
     */
    public Short gettCapacity() {
        return tCapacity;
    }

    /**
     * @param tCapacity
     */
    public void settCapacity(Short tCapacity) {
        this.tCapacity = tCapacity;
    }

    /**
     * @return VM_CLAYERS
     */
    public Short getVmClayers() {
        return vmClayers;
    }

    /**
     * @param vmClayers
     */
    public void setVmClayers(Short vmClayers) {
        this.vmClayers = vmClayers;
    }

    /**
     * @return IS_WEAL_MDSE
     */
    public Short getIsWealMdse() {
        return isWealMdse;
    }

    /**
     * @param isWealMdse
     */
    public void setIsWealMdse(Short isWealMdse) {
        this.isWealMdse = isWealMdse;
    }

    /**
     * @return GUID
     */
    public BigDecimal getGuid() {
        return guid;
    }

    /**
     * @param guid
     */
    public void setGuid(BigDecimal guid) {
        this.guid = guid;
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
     * @return SEALS_TYPE
     */
    public Short getSealsType() {
        return sealsType;
    }

    /**
     * @param sealsType
     */
    public void setSealsType(Short sealsType) {
        this.sealsType = sealsType;
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
}