package org.hyperledger.fabric.example.entity.factoring;

public class ShuntData <T> {

    private String blockChainReqId;
    private String businessTypeText;
    private String businessType;
    private T requestData;

    public String getBlockChainReqId() {
        return blockChainReqId;
    }

    public void setBlockChainReqId(String blockChainReqId) {
        this.blockChainReqId = blockChainReqId;
    }

    public String getBusinessTypeText() {
        return businessTypeText;
    }

    public void setBusinessTypeText(String businessTypeText) {
        this.businessTypeText = businessTypeText;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public T getRequestData() {
        return requestData;
    }

    public void setRequestData(T requestData) {
        this.requestData = requestData;
    }
}
