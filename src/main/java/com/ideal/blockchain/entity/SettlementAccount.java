package com.ideal.blockchain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class SettlementAccount {
    private static final String OBJECT_TYPE_NAME="enterprise_account";

    private String objectType = OBJECT_TYPE_NAME;

    @NotBlank(message = "银行账户编号不能为空")
    private String bankAccountId;
    @NotBlank(message = "公司编号不能为空")
    private String companyId;
    @NotBlank(message = "公司名称不能为空")
    private String companyName;
    @NotBlank(message = "银行账号不能为空")
    private String bankAccountNo;
    @NotBlank(message = "银行账户名称不能为空")
    private String bankAccountName;

    private String bankName;

    @NotBlank(message = "开户行支行不能为空")
    private String bankBranchName;

    private String bankProvince;

    private String bankCity;

    private String bankCode;

    private String bankCnapsCode;

    private String bankUsage;
    @NotBlank(message = "银行账户状态不能为空")
    private String status;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lastUpdateTime;

    private String bankAccountCertificate;
}
