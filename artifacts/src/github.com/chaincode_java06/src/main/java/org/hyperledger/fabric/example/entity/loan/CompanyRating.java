package org.hyperledger.fabric.example.entity.loan;


import java.util.Date;

public class CompanyRating {

    private static final String OBJECT_TYPE_NAME = "CompanyRating";
    private String objectType = OBJECT_TYPE_NAME;
    public String companyRateId;

    public String companyId;

    public String companyName;

    public String unifiedSocialCreditCode;

    public Date ratingDate;

    public String ratingStandard;

    public String ratingScale;

    public String ratingOutlook;

    public String ratingAgencies;

    public String linkAddr;

    public Date dataDate;

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getCompanyRateId() {
        return companyRateId;
    }

    public void setCompanyRateId(String companyRateId) {
        this.companyRateId = companyRateId;
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

    public String getUnifiedSocialCreditCode() {
        return unifiedSocialCreditCode;
    }

    public void setUnifiedSocialCreditCode(String unifiedSocialCreditCode) {
        this.unifiedSocialCreditCode = unifiedSocialCreditCode;
    }

    public Date getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(Date ratingDate) {
        this.ratingDate = ratingDate;
    }

    public String getRatingStandard() {
        return ratingStandard;
    }

    public void setRatingStandard(String ratingStandard) {
        this.ratingStandard = ratingStandard;
    }

    public String getRatingScale() {
        return ratingScale;
    }

    public void setRatingScale(String ratingScale) {
        this.ratingScale = ratingScale;
    }

    public String getRatingOutlook() {
        return ratingOutlook;
    }

    public void setRatingOutlook(String ratingOutlook) {
        this.ratingOutlook = ratingOutlook;
    }

    public String getRatingAgencies() {
        return ratingAgencies;
    }

    public void setRatingAgencies(String ratingAgencies) {
        this.ratingAgencies = ratingAgencies;
    }

    public String getLinkAddr() {
        return linkAddr;
    }

    public void setLinkAddr(String linkAddr) {
        this.linkAddr = linkAddr;
    }

    public Date getDataDate() {
        return dataDate;
    }

    public void setDataDate(Date dataDate) {
        this.dataDate = dataDate;
    }
}
