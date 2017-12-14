package com.funbox.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "MT_VM_PROP")
public class MtVmProp {
    @Id
    @Column(name = "VM_ID")
    private BigDecimal vmId;

    @Column(name = "VF_ID")
    private BigDecimal vfId;

    @Column(name = "VM_ONLY_CODE")
    private String vmOnlyCode;

    @Column(name = "VM_HEIGHT")
    private BigDecimal vmHeight;

    @Column(name = "VM_WIDTH")
    private BigDecimal vmWidth;

    @Column(name = "VM_LONG")
    private BigDecimal vmLong;

    @Column(name = "VM_RUN_TYPE")
    private Short vmRunType;

    @Column(name = "FACTORY_CTIME")
    private Date factoryCtime;

    @Column(name = "PRINTER_STATUS")
    private String printerStatus;

    @Column(name = "POS_STATUS")
    private String posStatus;

    @Column(name = "REMARKS")
    private String remarks;

    @Column(name = "CS")
    private String cs;

    @Column(name = "LVM_NAME")
    private String lvmName;

    @Column(name = "LVM_PASSWORD")
    private String lvmPassword;

    @Column(name = "IS_TEST_VM")
    private Short isTestVm;

    @Column(name = "CAMERA_STATUS")
    private String cameraStatus;

    @Column(name = "CC_STATUS")
    private String ccStatus;

    @Column(name = "AVAILABLE")
    private Short available;

    @Column(name = "ORG_ID")
    private BigDecimal orgId;

    @Column(name = "SYNC_MARK")
    private Short syncMark;

    @Column(name = "PLAY_LIST")
    private String playList;

    @Column(name = "CVC_VERSION")
    private String cvcVersion;

    @Column(name = "CVPN_VRESION")
    private String cvpnVresion;

    @Column(name = "OPERATOR")
    private String operator;

    @Column(name = "TS")
    private Date ts;

    @Column(name = "DELETE_MARK")
    private Short deleteMark;

    @Column(name = "LSYNC_TS")
    private Date lsyncTs;

    @Column(name = "RESOLUTION")
    private String resolution;

    @Column(name = "SIM_CODE")
    private String simCode;

    @Column(name = "INNER_CODE")
    private String innerCode;

    @Column(name = "LP_CREATOR")
    private String lpCreator;

    @Column(name = "LP_CTIME")
    private Date lpCtime;

    @Column(name = "LP_OPERATOR")
    private String lpOperator;

    @Column(name = "LP_TS")
    private Date lpTs;

    @Column(name = "FORCE_SOFT")
    private Short forceSoft;

    @Column(name = "OPERATING_SYSTEM")
    private String operatingSystem;

    @Column(name = "ISO_VERSION")
    private String isoVersion;

    @Column(name = "DEVICE_INFO_ID")
    private BigDecimal deviceInfoId;

    @Column(name = "VMC_VERSION")
    private String vmcVersion;

    @Column(name = "COINS_LIMIT")
    private String coinsLimit;

    @Column(name = "VIRTUAL_PRICE")
    private BigDecimal virtualPrice;

    @Column(name = "VMC_VERSON")
    private String vmcVerson;

    @Column(name = "VMC_SOFT_VERSON")
    private String vmcSoftVerson;

    @Column(name = "VMC_SOFT_VERSION")
    private String vmcSoftVersion;

    @Column(name = "MDSE_LIMIT")
    private BigDecimal mdseLimit;

    @Column(name = "SALE_BTIME")
    private String saleBtime;

    @Column(name = "SALE_ETIME")
    private String saleEtime;

    @Column(name = "PARTNER_ID")
    private BigDecimal partnerId;

    @Column(name = "OP_PASSWORD")
    private String opPassword;

    @Column(name = "BS_BEGIN")
    private String bsBegin;

    @Column(name = "BS_END")
    private String bsEnd;

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
     * @return VF_ID
     */
    public BigDecimal getVfId() {
        return vfId;
    }

    /**
     * @param vfId
     */
    public void setVfId(BigDecimal vfId) {
        this.vfId = vfId;
    }

    /**
     * @return VM_ONLY_CODE
     */
    public String getVmOnlyCode() {
        return vmOnlyCode;
    }

    /**
     * @param vmOnlyCode
     */
    public void setVmOnlyCode(String vmOnlyCode) {
        this.vmOnlyCode = vmOnlyCode;
    }

    /**
     * @return VM_HEIGHT
     */
    public BigDecimal getVmHeight() {
        return vmHeight;
    }

    /**
     * @param vmHeight
     */
    public void setVmHeight(BigDecimal vmHeight) {
        this.vmHeight = vmHeight;
    }

    /**
     * @return VM_WIDTH
     */
    public BigDecimal getVmWidth() {
        return vmWidth;
    }

    /**
     * @param vmWidth
     */
    public void setVmWidth(BigDecimal vmWidth) {
        this.vmWidth = vmWidth;
    }

    /**
     * @return VM_LONG
     */
    public BigDecimal getVmLong() {
        return vmLong;
    }

    /**
     * @param vmLong
     */
    public void setVmLong(BigDecimal vmLong) {
        this.vmLong = vmLong;
    }

    /**
     * @return VM_RUN_TYPE
     */
    public Short getVmRunType() {
        return vmRunType;
    }

    /**
     * @param vmRunType
     */
    public void setVmRunType(Short vmRunType) {
        this.vmRunType = vmRunType;
    }

    /**
     * @return FACTORY_CTIME
     */
    public Date getFactoryCtime() {
        return factoryCtime;
    }

    /**
     * @param factoryCtime
     */
    public void setFactoryCtime(Date factoryCtime) {
        this.factoryCtime = factoryCtime;
    }

    /**
     * @return PRINTER_STATUS
     */
    public String getPrinterStatus() {
        return printerStatus;
    }

    /**
     * @param printerStatus
     */
    public void setPrinterStatus(String printerStatus) {
        this.printerStatus = printerStatus;
    }

    /**
     * @return POS_STATUS
     */
    public String getPosStatus() {
        return posStatus;
    }

    /**
     * @param posStatus
     */
    public void setPosStatus(String posStatus) {
        this.posStatus = posStatus;
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
     * @return LVM_NAME
     */
    public String getLvmName() {
        return lvmName;
    }

    /**
     * @param lvmName
     */
    public void setLvmName(String lvmName) {
        this.lvmName = lvmName;
    }

    /**
     * @return LVM_PASSWORD
     */
    public String getLvmPassword() {
        return lvmPassword;
    }

    /**
     * @param lvmPassword
     */
    public void setLvmPassword(String lvmPassword) {
        this.lvmPassword = lvmPassword;
    }

    /**
     * @return IS_TEST_VM
     */
    public Short getIsTestVm() {
        return isTestVm;
    }

    /**
     * @param isTestVm
     */
    public void setIsTestVm(Short isTestVm) {
        this.isTestVm = isTestVm;
    }

    /**
     * @return CAMERA_STATUS
     */
    public String getCameraStatus() {
        return cameraStatus;
    }

    /**
     * @param cameraStatus
     */
    public void setCameraStatus(String cameraStatus) {
        this.cameraStatus = cameraStatus;
    }

    /**
     * @return CC_STATUS
     */
    public String getCcStatus() {
        return ccStatus;
    }

    /**
     * @param ccStatus
     */
    public void setCcStatus(String ccStatus) {
        this.ccStatus = ccStatus;
    }

    /**
     * @return AVAILABLE
     */
    public Short getAvailable() {
        return available;
    }

    /**
     * @param available
     */
    public void setAvailable(Short available) {
        this.available = available;
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
     * @return PLAY_LIST
     */
    public String getPlayList() {
        return playList;
    }

    /**
     * @param playList
     */
    public void setPlayList(String playList) {
        this.playList = playList;
    }

    /**
     * @return CVC_VERSION
     */
    public String getCvcVersion() {
        return cvcVersion;
    }

    /**
     * @param cvcVersion
     */
    public void setCvcVersion(String cvcVersion) {
        this.cvcVersion = cvcVersion;
    }

    /**
     * @return CVPN_VRESION
     */
    public String getCvpnVresion() {
        return cvpnVresion;
    }

    /**
     * @param cvpnVresion
     */
    public void setCvpnVresion(String cvpnVresion) {
        this.cvpnVresion = cvpnVresion;
    }

    /**
     * @return OPERATOR
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator
     */
    public void setOperator(String operator) {
        this.operator = operator;
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
     * @return RESOLUTION
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * @param resolution
     */
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    /**
     * @return SIM_CODE
     */
    public String getSimCode() {
        return simCode;
    }

    /**
     * @param simCode
     */
    public void setSimCode(String simCode) {
        this.simCode = simCode;
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
     * @return LP_CREATOR
     */
    public String getLpCreator() {
        return lpCreator;
    }

    /**
     * @param lpCreator
     */
    public void setLpCreator(String lpCreator) {
        this.lpCreator = lpCreator;
    }

    /**
     * @return LP_CTIME
     */
    public Date getLpCtime() {
        return lpCtime;
    }

    /**
     * @param lpCtime
     */
    public void setLpCtime(Date lpCtime) {
        this.lpCtime = lpCtime;
    }

    /**
     * @return LP_OPERATOR
     */
    public String getLpOperator() {
        return lpOperator;
    }

    /**
     * @param lpOperator
     */
    public void setLpOperator(String lpOperator) {
        this.lpOperator = lpOperator;
    }

    /**
     * @return LP_TS
     */
    public Date getLpTs() {
        return lpTs;
    }

    /**
     * @param lpTs
     */
    public void setLpTs(Date lpTs) {
        this.lpTs = lpTs;
    }

    /**
     * @return FORCE_SOFT
     */
    public Short getForceSoft() {
        return forceSoft;
    }

    /**
     * @param forceSoft
     */
    public void setForceSoft(Short forceSoft) {
        this.forceSoft = forceSoft;
    }

    /**
     * @return OPERATING_SYSTEM
     */
    public String getOperatingSystem() {
        return operatingSystem;
    }

    /**
     * @param operatingSystem
     */
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    /**
     * @return ISO_VERSION
     */
    public String getIsoVersion() {
        return isoVersion;
    }

    /**
     * @param isoVersion
     */
    public void setIsoVersion(String isoVersion) {
        this.isoVersion = isoVersion;
    }

    /**
     * @return DEVICE_INFO_ID
     */
    public BigDecimal getDeviceInfoId() {
        return deviceInfoId;
    }

    /**
     * @param deviceInfoId
     */
    public void setDeviceInfoId(BigDecimal deviceInfoId) {
        this.deviceInfoId = deviceInfoId;
    }

    /**
     * @return VMC_VERSION
     */
    public String getVmcVersion() {
        return vmcVersion;
    }

    /**
     * @param vmcVersion
     */
    public void setVmcVersion(String vmcVersion) {
        this.vmcVersion = vmcVersion;
    }

    /**
     * @return COINS_LIMIT
     */
    public String getCoinsLimit() {
        return coinsLimit;
    }

    /**
     * @param coinsLimit
     */
    public void setCoinsLimit(String coinsLimit) {
        this.coinsLimit = coinsLimit;
    }

    /**
     * @return VIRTUAL_PRICE
     */
    public BigDecimal getVirtualPrice() {
        return virtualPrice;
    }

    /**
     * @param virtualPrice
     */
    public void setVirtualPrice(BigDecimal virtualPrice) {
        this.virtualPrice = virtualPrice;
    }

    /**
     * @return VMC_VERSON
     */
    public String getVmcVerson() {
        return vmcVerson;
    }

    /**
     * @param vmcVerson
     */
    public void setVmcVerson(String vmcVerson) {
        this.vmcVerson = vmcVerson;
    }

    /**
     * @return VMC_SOFT_VERSON
     */
    public String getVmcSoftVerson() {
        return vmcSoftVerson;
    }

    /**
     * @param vmcSoftVerson
     */
    public void setVmcSoftVerson(String vmcSoftVerson) {
        this.vmcSoftVerson = vmcSoftVerson;
    }

    /**
     * @return VMC_SOFT_VERSION
     */
    public String getVmcSoftVersion() {
        return vmcSoftVersion;
    }

    /**
     * @param vmcSoftVersion
     */
    public void setVmcSoftVersion(String vmcSoftVersion) {
        this.vmcSoftVersion = vmcSoftVersion;
    }

    /**
     * @return MDSE_LIMIT
     */
    public BigDecimal getMdseLimit() {
        return mdseLimit;
    }

    /**
     * @param mdseLimit
     */
    public void setMdseLimit(BigDecimal mdseLimit) {
        this.mdseLimit = mdseLimit;
    }

    /**
     * @return SALE_BTIME
     */
    public String getSaleBtime() {
        return saleBtime;
    }

    /**
     * @param saleBtime
     */
    public void setSaleBtime(String saleBtime) {
        this.saleBtime = saleBtime;
    }

    /**
     * @return SALE_ETIME
     */
    public String getSaleEtime() {
        return saleEtime;
    }

    /**
     * @param saleEtime
     */
    public void setSaleEtime(String saleEtime) {
        this.saleEtime = saleEtime;
    }

    /**
     * @return PARTNER_ID
     */
    public BigDecimal getPartnerId() {
        return partnerId;
    }

    /**
     * @param partnerId
     */
    public void setPartnerId(BigDecimal partnerId) {
        this.partnerId = partnerId;
    }

    /**
     * @return OP_PASSWORD
     */
    public String getOpPassword() {
        return opPassword;
    }

    /**
     * @param opPassword
     */
    public void setOpPassword(String opPassword) {
        this.opPassword = opPassword;
    }

    /**
     * @return BS_BEGIN
     */
    public String getBsBegin() {
        return bsBegin;
    }

    /**
     * @param bsBegin
     */
    public void setBsBegin(String bsBegin) {
        this.bsBegin = bsBegin;
    }

    /**
     * @return BS_END
     */
    public String getBsEnd() {
        return bsEnd;
    }

    /**
     * @param bsEnd
     */
    public void setBsEnd(String bsEnd) {
        this.bsEnd = bsEnd;
    }
}