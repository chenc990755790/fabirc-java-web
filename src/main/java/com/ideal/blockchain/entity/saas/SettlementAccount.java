package com.ideal.blockchain.entity.saas;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@ApiModel(description = "AC_SETTLEMENT_ACCOUNT")
@Entity
@Table(name="AC_SETTLEMENT_ACCOUNT")
public class SettlementAccount {
    private static final String OBJECT_TYPE_NAME="enterprise_account";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;

    @NotBlank(message = "银行账户编号不能为空")
    @Id
    @Column(name="BANK_ACCOUNT_ID")
    private String bankAccountId;
    @NotBlank(message = "公司编号不能为空")
    @Column(name="COMPANY_ID")
    private String companyId;
//    @NotBlank(message = "公司名称不能为空")
//    @Column(name="")
//    private String companyName;
    @NotBlank(message = "银行账号不能为空")
    @Column(name="BANK_ACCOUNT_NO")
    private String bankAccountNo;
    @NotBlank(message = "银行账户名称不能为空")
    @Column(name="BANK_ACCOUNT_NAME")
    private String bankAccountName;
    @Column(name="BANK_NAME")
    private String bankName;
    @Column(name="BANK_BRANCH_NAME")
    @NotBlank(message = "开户行支行不能为空")
    private String bankBranchName;
    @Column(name="BANK_PROVINCE")
    private String bankProvince;
    @Column(name="BANK_CITY")
    private String bankCity;
    @Column(name="BANK_CODE")
    private String bankCode;
    @Column(name="BANK_CNAPS_CODE")
    private String bankCnapsCode;
    @Column(name="BANK_USAGE")
    private String bankUsage;
    @Column(name="STATUS")
    @NotBlank(message = "银行账户状态不能为空")
    private String status;
    @Column(name="CREATE_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    @Column(name="LAST_UPDATE_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lastUpdateTime;
    @Column(name="BANK_ACCOUNT_CERTIFICATE")
    private String bankAccountCertificate;
}
