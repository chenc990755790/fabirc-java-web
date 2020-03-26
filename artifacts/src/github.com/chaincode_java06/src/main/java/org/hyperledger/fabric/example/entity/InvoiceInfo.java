package org.hyperledger.fabric.example.entity;


public class InvoiceInfo {
    private static final String OBJECT_TYPE_NAME="enterprise_invoice";

    private static final String objectType = OBJECT_TYPE_NAME;

    private String companyId;

    private String companyName;

    private String taxpayerIdentifyNo;

    private String address;

    private String companyMobile;

    private String openAccountBankName;

    private String bankAccountNo;

    private String addresseeName;

    private String addresseeMobile;

    private String addresseeAddress;

    private String remark;

    public String getObjectType() {
        return objectType;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTaxpayerIdentifyNo() {
        return taxpayerIdentifyNo;
    }

    public void setTaxpayerIdentifyNo(String taxpayerIdentifyNo) {
        this.taxpayerIdentifyNo = taxpayerIdentifyNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyMobile() {
        return companyMobile;
    }

    public void setCompanyMobile(String companyMobile) {
        this.companyMobile = companyMobile;
    }

    public String getOpenAccountBankName() {
        return openAccountBankName;
    }

    public void setOpenAccountBankName(String openAccountBankName) {
        this.openAccountBankName = openAccountBankName;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getAddresseeName() {
        return addresseeName;
    }

    public void setAddresseeName(String addresseeName) {
        this.addresseeName = addresseeName;
    }

    public String getAddresseeMobile() {
        return addresseeMobile;
    }

    public void setAddresseeMobile(String addresseeMobile) {
        this.addresseeMobile = addresseeMobile;
    }

    public String getAddresseeAddress() {
        return addresseeAddress;
    }

    public void setAddresseeAddress(String addresseeAddress) {
        this.addresseeAddress = addresseeAddress;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}