package org.hyperledger.fabric.example.entity.loan;


import java.util.Date;

public class AuditInfo {


    private static final String OBJECT_TYPE_NAME = "AuditInfo";
    private String objectType = OBJECT_TYPE_NAME;

    public String loanNo;
    public String loanStatusText;
    public Date operateTime;
    public Date updateDate;
    public String projectNo;
    public String projectName;
    public String projectType;
    public String companyName;
    public Date ratingDate;
    public String ratingStandard;
    public String ratingScale;
    public String ratingOutlook;
    public String ratingAgencies;
    public String linkAddr;

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }

    public String getLoanStatusText() {
        return loanStatusText;
    }

    public void setLoanStatusText(String loanStatusText) {
        this.loanStatusText = loanStatusText;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
}
