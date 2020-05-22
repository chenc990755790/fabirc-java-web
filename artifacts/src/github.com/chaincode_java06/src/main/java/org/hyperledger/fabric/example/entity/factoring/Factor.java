package org.hyperledger.fabric.example.entity.factoring;

public class Factor {

    public static final String OBJECT_TYPE_NAME = "factor";

    private String objectType = OBJECT_TYPE_NAME;

    private String blockChainReqId;

    private String businessTypeText;

    private String businessType;

    private Factoring factoring;

    public String getObjectType() {
        return objectType;
    }

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

    public Factoring getFactoring() {
        return factoring;
    }

    public void setFactoring(Factoring factoring) {
        this.factoring = factoring;
    }
}
