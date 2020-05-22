package com.ideal.blockchain.entity.loan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Table(name = "LMT_COMPANY_INFO")
@Entity
@Data
public class CompanyInfo {
    private static final String OBJECT_TYPE_NAME = "CompanyInfo";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;
    @Column(name = "COMPANY_NAME")
    @ApiModelProperty(value = "公司名称")
    private String companyName;
    @Id
    @Column(name = "SOCIAL_CREDIT_CODE")
    @ApiModelProperty(value = "社会统一代码")
    private String socialCreditCode;
    @Column(name = "REGISTERED_CAPITAL_AMOUNT")
    @ApiModelProperty(value = "注册资本")
    private String registeredCapitalAmount;
    @Column(name = "LEGAL_REPRESENTATIVE_NAME")
    @ApiModelProperty(value = "法人姓名")
    private String legalRepresentativeName;
    @Column(name = "REGISTER_ADDRESS")
    @ApiModelProperty(value = "注册地址/邮编")
    private String registerAddress;
    @Column(name = "BUSINESS_ADDRESS")
    @ApiModelProperty(value = "办公地址/邮编")
    private String businessAddress;
    @Column(name = "COMPANY_TYPE")
    @ApiModelProperty(value = "公司类型")
    private String companyType;
    @Column(name = "IS_LISTED")
    @ApiModelProperty(value = "是否上市公司")
    private String isListed;
    @Column(name = "INDUSTRY_TEXT")
    @ApiModelProperty(value = "行业分类")
    private String industryText;
    @Column(name = "UPDATE_DATE")
    @ApiModelProperty(value = "数据更新日期")
    private String updateDate;
    @Column(name = "PROVINCE")
    @ApiModelProperty(value = "省份")
    private String province;
    @Column(name = "CITY")
    @ApiModelProperty(value = "城市")
    private String city;
    @Column(name = "PART")
    @ApiModelProperty(value = "区域")
    private String part;
}
