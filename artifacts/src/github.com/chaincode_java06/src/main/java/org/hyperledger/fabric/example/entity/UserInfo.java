package org.hyperledger.fabric.example.entity;

import java.util.Date;

public class UserInfo{

    private static final String OBJECT_TYPE_NAME="userInfo";

    private static final String objectType = OBJECT_TYPE_NAME;


    private String userName;

    private String passWord;

    private String peerWithOrg;

    private String collectionName;

    private String userId;

    private String mobile;

    private String loginPassword;

    private String companyId;

    private Date loginLastTime;

    private Date loginPasswordErrorLastTime;

    private Long loginPasswordErrorTimes;

    private Date loginPasswordUpdateTime;

    private String status;

    private Date createTime;

    private Date lastUpdateTime;

    private Date lastLoginTime;

    private String isContact;

    private String name;

    public String getObjectType() {
        return objectType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPeerWithOrg() {
        return peerWithOrg;
    }

    public void setPeerWithOrg(String peerWithOrg) {
        this.peerWithOrg = peerWithOrg;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public Date getLoginLastTime() {
        return loginLastTime;
    }

    public void setLoginLastTime(Date loginLastTime) {
        this.loginLastTime = loginLastTime;
    }

    public Date getLoginPasswordErrorLastTime() {
        return loginPasswordErrorLastTime;
    }

    public void setLoginPasswordErrorLastTime(Date loginPasswordErrorLastTime) {
        this.loginPasswordErrorLastTime = loginPasswordErrorLastTime;
    }

    public Long getLoginPasswordErrorTimes() {
        return loginPasswordErrorTimes;
    }

    public void setLoginPasswordErrorTimes(Long loginPasswordErrorTimes) {
        this.loginPasswordErrorTimes = loginPasswordErrorTimes;
    }

    public Date getLoginPasswordUpdateTime() {
        return loginPasswordUpdateTime;
    }

    public void setLoginPasswordUpdateTime(Date loginPasswordUpdateTime) {
        this.loginPasswordUpdateTime = loginPasswordUpdateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getIsContact() {
        return isContact;
    }

    public void setIsContact(String isContact) {
        this.isContact = isContact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
