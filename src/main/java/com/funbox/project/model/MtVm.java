package com.funbox.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "MT_VM")
public class MtVm {
    @Id
    @Column(name = "VM_ID")
    private BigDecimal vmId;

    @Column(name = "VT_ID")
    private BigDecimal vtId;

    @Column(name = "VM_MODEL_ID")
    private BigDecimal vmModelId;

    @Column(name = "VM_CLAYERS")
    private Short vmClayers;

    @Column(name = "SP_QTY")
    private BigDecimal spQty;

    @Column(name = "CHANNEL_QTY")
    private BigDecimal channelQty;

    @Column(name = "SP_SUPPORT")
    private Short spSupport;

    @Column(name = "TOUCH_SUPPORT")
    private Short touchSupport;

    @Column(name = "PRINTER_SUPPORT")
    private Short printerSupport;

    @Column(name = "POS_SUPPORT")
    private Short posSupport;

    @Column(name = "RTGY_SUPPORT")
    private Short rtgySupport;

    @Column(name = "DELETE_MARK")
    private Short deleteMark;

    @Column(name = "CAMERA_SUPPORT")
    private Short cameraSupport;

    @Column(name = "CC_SUPPORT")
    private Short ccSupport;

    @Column(name = "NODE_ID")
    private BigDecimal nodeId;

    @Column(name = "INNER_CODE")
    private String innerCode;

    @Column(name = "CREATOR")
    private String creator;

    @Column(name = "CTIME")
    private Date ctime;

    @Column(name = "VM_HARD_SEQ")
    private String vmHardSeq;

    @Column(name = "COIN_DEVICE_SUPPORT")
    private Short coinDeviceSupport;

    @Column(name = "NOTE_DEVICE_SUPPORT")
    private Short noteDeviceSupport;

    @Column(name = "ACOUSTIC_WAVE_SUPPORT")
    private Short acousticWaveSupport;

    @Column(name = "CHECKER_BOARD_SUPPORT")
    private Short checkerBoardSupport;

    @Column(name = "QR_PAY_TYPE")
    private BigDecimal qrPayType;

    @Column(name = "I_TYPE")
    private Short iType;

    @Column(name = "CHANNEL_TYPE")
    private String channelType;

    @Column(name = "UTOR")
    private String utor;

    @Column(name = "UTIME")
    private Date utime;

    @Column(name = "STORAGE_ID")
    private BigDecimal storageId;

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
     * @return VM_MODEL_ID
     */
    public BigDecimal getVmModelId() {
        return vmModelId;
    }

    /**
     * @param vmModelId
     */
    public void setVmModelId(BigDecimal vmModelId) {
        this.vmModelId = vmModelId;
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
     * @return SP_QTY
     */
    public BigDecimal getSpQty() {
        return spQty;
    }

    /**
     * @param spQty
     */
    public void setSpQty(BigDecimal spQty) {
        this.spQty = spQty;
    }

    /**
     * @return CHANNEL_QTY
     */
    public BigDecimal getChannelQty() {
        return channelQty;
    }

    /**
     * @param channelQty
     */
    public void setChannelQty(BigDecimal channelQty) {
        this.channelQty = channelQty;
    }

    /**
     * @return SP_SUPPORT
     */
    public Short getSpSupport() {
        return spSupport;
    }

    /**
     * @param spSupport
     */
    public void setSpSupport(Short spSupport) {
        this.spSupport = spSupport;
    }

    /**
     * @return TOUCH_SUPPORT
     */
    public Short getTouchSupport() {
        return touchSupport;
    }

    /**
     * @param touchSupport
     */
    public void setTouchSupport(Short touchSupport) {
        this.touchSupport = touchSupport;
    }

    /**
     * @return PRINTER_SUPPORT
     */
    public Short getPrinterSupport() {
        return printerSupport;
    }

    /**
     * @param printerSupport
     */
    public void setPrinterSupport(Short printerSupport) {
        this.printerSupport = printerSupport;
    }

    /**
     * @return POS_SUPPORT
     */
    public Short getPosSupport() {
        return posSupport;
    }

    /**
     * @param posSupport
     */
    public void setPosSupport(Short posSupport) {
        this.posSupport = posSupport;
    }

    /**
     * @return RTGY_SUPPORT
     */
    public Short getRtgySupport() {
        return rtgySupport;
    }

    /**
     * @param rtgySupport
     */
    public void setRtgySupport(Short rtgySupport) {
        this.rtgySupport = rtgySupport;
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
     * @return CAMERA_SUPPORT
     */
    public Short getCameraSupport() {
        return cameraSupport;
    }

    /**
     * @param cameraSupport
     */
    public void setCameraSupport(Short cameraSupport) {
        this.cameraSupport = cameraSupport;
    }

    /**
     * @return CC_SUPPORT
     */
    public Short getCcSupport() {
        return ccSupport;
    }

    /**
     * @param ccSupport
     */
    public void setCcSupport(Short ccSupport) {
        this.ccSupport = ccSupport;
    }

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
     * @return VM_HARD_SEQ
     */
    public String getVmHardSeq() {
        return vmHardSeq;
    }

    /**
     * @param vmHardSeq
     */
    public void setVmHardSeq(String vmHardSeq) {
        this.vmHardSeq = vmHardSeq;
    }

    /**
     * @return COIN_DEVICE_SUPPORT
     */
    public Short getCoinDeviceSupport() {
        return coinDeviceSupport;
    }

    /**
     * @param coinDeviceSupport
     */
    public void setCoinDeviceSupport(Short coinDeviceSupport) {
        this.coinDeviceSupport = coinDeviceSupport;
    }

    /**
     * @return NOTE_DEVICE_SUPPORT
     */
    public Short getNoteDeviceSupport() {
        return noteDeviceSupport;
    }

    /**
     * @param noteDeviceSupport
     */
    public void setNoteDeviceSupport(Short noteDeviceSupport) {
        this.noteDeviceSupport = noteDeviceSupport;
    }

    /**
     * @return ACOUSTIC_WAVE_SUPPORT
     */
    public Short getAcousticWaveSupport() {
        return acousticWaveSupport;
    }

    /**
     * @param acousticWaveSupport
     */
    public void setAcousticWaveSupport(Short acousticWaveSupport) {
        this.acousticWaveSupport = acousticWaveSupport;
    }

    /**
     * @return CHECKER_BOARD_SUPPORT
     */
    public Short getCheckerBoardSupport() {
        return checkerBoardSupport;
    }

    /**
     * @param checkerBoardSupport
     */
    public void setCheckerBoardSupport(Short checkerBoardSupport) {
        this.checkerBoardSupport = checkerBoardSupport;
    }

    /**
     * @return QR_PAY_TYPE
     */
    public BigDecimal getQrPayType() {
        return qrPayType;
    }

    /**
     * @param qrPayType
     */
    public void setQrPayType(BigDecimal qrPayType) {
        this.qrPayType = qrPayType;
    }

    /**
     * @return I_TYPE
     */
    public Short getiType() {
        return iType;
    }

    /**
     * @param iType
     */
    public void setiType(Short iType) {
        this.iType = iType;
    }

    /**
     * @return CHANNEL_TYPE
     */
    public String getChannelType() {
        return channelType;
    }

    /**
     * @param channelType
     */
    public void setChannelType(String channelType) {
        this.channelType = channelType;
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