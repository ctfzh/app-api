package com.funbox.project.bean;

import java.math.BigDecimal;

/**
 * Created by zhao6 on 2017/11/3.
 */
public class Code {
    private BigDecimal mvcccId;
    private String clCode;
    private String cariCode;
    private String cariStatus;
    private String validDate;
    private BigDecimal mdseId;

    public BigDecimal getMvcccId() {
        return mvcccId;
    }

    public void setMvcccId(BigDecimal mvcccId) {
        this.mvcccId = mvcccId;
    }

    public String getClCode() {
        return clCode;
    }

    public void setClCode(String clCode) {
        this.clCode = clCode;
    }

    public String getCariCode() {
        return cariCode;
    }

    public void setCariCode(String cariCode) {
        this.cariCode = cariCode;
    }

    public String getCariStatus() {
        return cariStatus;
    }

    public void setCariStatus(String cariStatus) {
        this.cariStatus = cariStatus;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public BigDecimal getMdseId() {
        return mdseId;
    }

    public void setMdseId(BigDecimal mdseId) {
        this.mdseId = mdseId;
    }
}
