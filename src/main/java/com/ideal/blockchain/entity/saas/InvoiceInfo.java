package com.ideal.blockchain.entity.saas;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@ApiModel(description = "AC_INVOICE_INFO")
@Entity
@Table(name = "AC_INVOICE_INFO")
public class InvoiceInfo {
    private static final String OBJECT_TYPE_NAME = "enterprise_invoice";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;

    @NotBlank(message = "公司编号不能为空")
    @Column(name="COMPANY_ID")
    @Id
    private String companyId;

    @NotBlank(message = "公司名称不能为空")
    @Column(name="COMPANY_NAME")
    private String companyName;
    @Column(name="TAXPAYER_IDENTIFY_NO")
    @NotBlank(message = "纳税人识别号不能为空")
    private String taxpayerIdentifyNo;

    @NotBlank(message = "公司注册地址不能为空")
    private String address;
    @Column(name="COMPANY_MOBILE")
    @NotBlank(message = "公司电话不能为空")
    private String companyMobile;
    @Column(name="OPEN_ACCOUNT_BANK_NAME")
    @NotBlank(message = "公司开户行支行不能为空")
    private String openAccountBankName;
    @Column(name="BANK_ACCOUNT_NO")
    @NotBlank(message = "公司银行账号不能为空")
    private String bankAccountNo;
    @Column(name="ADDRESSEE_NAME")
    @NotBlank(message = "发票邮寄收件人名称不能为空")
    private String addresseeName;
    @Column(name="ADDRESSEE_MOBILE")
    @NotBlank(message = "发票邮寄收件人手机号不能为空")
    private String addresseeMobile;
    @Column(name="ADDRESSEE_ADDRESS")
    @NotBlank(message = "发票邮寄收件人地址不能为空")
    private String addresseeAddress;

    private String remark;
}
