package com.funbox.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "MT_MDSE_TYPE")
public class MtMdseType {
    @Id
    @Column(name = "MDSE_TYPE_ID")
    private BigDecimal mdseTypeId;

    @Column(name = "MDSE_TYPE_CODE")
    private Long mdseTypeCode;

    @Column(name = "MDSE_TYPE_NAME")
    private String mdseTypeName;

    @Column(name = "PARENT_ID")
    private BigDecimal parentId;

    @Column(name = "TS")
    private Date ts;

    @Column(name = "OPERATOR")
    private String operator;

    @Column(name = "DELETE_MARK")
    private Short deleteMark;

    @Column(name = "UTOR")
    private String utor;

    @Column(name = "UTIME")
    private Date utime;

    @Column(name = "TYPE_ICON")
    private String typeIcon;

    @Column(name = "TYPE_ORDER")
    private BigDecimal typeOrder;

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
     * @return MDSE_TYPE_CODE
     */
    public Long getMdseTypeCode() {
        return mdseTypeCode;
    }

    /**
     * @param mdseTypeCode
     */
    public void setMdseTypeCode(Long mdseTypeCode) {
        this.mdseTypeCode = mdseTypeCode;
    }

    /**
     * @return MDSE_TYPE_NAME
     */
    public String getMdseTypeName() {
        return mdseTypeName;
    }

    /**
     * @param mdseTypeName
     */
    public void setMdseTypeName(String mdseTypeName) {
        this.mdseTypeName = mdseTypeName;
    }

    /**
     * @return PARENT_ID
     */
    public BigDecimal getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(BigDecimal parentId) {
        this.parentId = parentId;
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
     * @return TYPE_ICON
     */
    public String getTypeIcon() {
        return typeIcon;
    }

    /**
     * @param typeIcon
     */
    public void setTypeIcon(String typeIcon) {
        this.typeIcon = typeIcon;
    }

    /**
     * @return TYPE_ORDER
     */
    public BigDecimal getTypeOrder() {
        return typeOrder;
    }

    /**
     * @param typeOrder
     */
    public void setTypeOrder(BigDecimal typeOrder) {
        this.typeOrder = typeOrder;
    }
}