package org.hyperledger.fabric.example.entity.loan;


public class CompanyInfo {
    private static final String OBJECT_TYPE_NAME = "CompanyInfo";
    private String objectType = OBJECT_TYPE_NAME;
    private String companyName;
    private String socialCreditCode;
    private String registeredCapitalAmount;
    private String legalRepresentativeName;
    private String registerAddress;
    private String businessAddress;
    private String companyType;
    private String isListed;
    private String industryText;
    private String updateDate;
    private String province;
    private String city;
    private String part;

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSocialCreditCode() {
        return socialCreditCode;
    }

    public void setSocialCreditCode(String socialCreditCode) {
        this.socialCreditCode = socialCreditCode;
    }

    public String getRegisteredCapitalAmount() {
        return registeredCapitalAmount;
    }

    public void setRegisteredCapitalAmount(String registeredCapitalAmount) {
        this.registeredCapitalAmount = registeredCapitalAmount;
    }

    public String getLegalRepresentativeName() {
        return legalRepresentativeName;
    }

    public void setLegalRepresentativeName(String legalRepresentativeName) {
        this.legalRepresentativeName = legalRepresentativeName;
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getIsListed() {
        return isListed;
    }

    public void setIsListed(String isListed) {
        this.isListed = isListed;
    }

    public String getIndustryText() {
        return industryText;
    }

    public void setIndustryText(String industryText) {
        this.industryText = industryText;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }
}
