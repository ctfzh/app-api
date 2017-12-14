package com.funbox.project.bean;

import java.math.BigDecimal;

/**
 * Created by zhao6 on 2017/11/2.
 */
public class MtVmNode {
    private BigDecimal vmId;
    private BigDecimal vtId;
    private String innerCode;
    private BigDecimal nodeId;
    private String nodeName;
    private String nodeAddress;
    private String longitude;
    private String dimensions;

    public BigDecimal getVmId() {
        return vmId;
    }

    public void setVmId(BigDecimal vmId) {
        this.vmId = vmId;
    }

    public BigDecimal getVtId() {
        return vtId;
    }

    public void setVtId(BigDecimal vtId) {
        this.vtId = vtId;
    }

    public String getInnerCode() {
        return innerCode;
    }

    public void setInnerCode(String innerCode) {
        this.innerCode = innerCode;
    }

    public BigDecimal getNodeId() {
        return nodeId;
    }

    public void setNodeId(BigDecimal nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeAddress() {
        return nodeAddress;
    }

    public void setNodeAddress(String nodeAddress) {
        this.nodeAddress = nodeAddress;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
}
