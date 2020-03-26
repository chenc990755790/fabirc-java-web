package com.ideal.blockchain.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class InvoiceInfo {
    private static final String OBJECT_TYPE_NAME="enterprise_invoice";

    private static final String objectType = OBJECT_TYPE_NAME;

    @NotBlank(message = "公司编号不能为空")
    private String companyId;

    @NotBlank(message = "公司名称不能为空")
    private String companyName;

    @NotBlank(message = "纳税人识别号不能为空")
    private String taxpayerIdentifyNo;

    @NotBlank(message = "公司注册地址不能为空")
    private String address;

    @NotBlank(message = "公司电话不能为空")
    private String companyMobile;

    @NotBlank(message = "公司开户行支行不能为空")
    private String openAccountBankName;

    @NotBlank(message = "公司银行账号不能为空")
    private String bankAccountNo;

    @NotBlank(message = "发票邮寄收件人名称不能为空")
    private String addresseeName;

    @NotBlank(message = "发票邮寄收件人手机号不能为空")
    private String addresseeMobile;

    @NotBlank(message = "发票邮寄收件人地址不能为空")
    private String addresseeAddress;

    private String remark;
}
