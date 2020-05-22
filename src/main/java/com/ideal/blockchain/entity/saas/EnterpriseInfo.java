package com.ideal.blockchain.entity.saas;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(description = "AC_COMPANY_INFO")
@Entity
@Table(name = "AC_COMPANY_INFO")
public class EnterpriseInfo {
    private static final String OBJECT_TYPE_NAME = "enterpriseInfo";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;

    @NotBlank(message = "公司编号不能为空")
    @Id
    @Column(name = "COMPANY_ID")
    private String companyId;

    @NotBlank(message = "统一社会信用代码/营业执照不能为空")
    @Column(name = "SOCIAL_CREDIT_CODE")
    private String socialCreditCode;

    @NotBlank(message = "行业类型不能为空")
    @Column(name = "INDUSTRY_TYPE")
    private String industryType;

    @NotBlank(message = "公司名称不能为空")
    @Column(name="COMPANY_NAME")
    private String companyName;

    @NotBlank(message = "公司注册资本不能为空")
    @Column(name="COMPANY_REGISTER_CAPITAL")
    private String companyRegisterCapital;

    @NotBlank(message = "公司注册号不能为空")
    @Column(name="COMPANY_REGISTER_NO")
    private String companyRegisterNo;

    @NotBlank(message = "登记机关不能为空")
    @Column(name="BELONG_ORG")
    private String belongOrg;

    @NotBlank(message = "公司状态不能为空")
    @Column(name = "COMPANY_STATUS")
    private String companyStatus;

    @NotBlank(message = "公司注册地址不能为空")
    @Column(name="COMPANY_REGISTER_ADDRESS")
    private String companyRegisterAddress;

    @NotBlank(message = "营业开始日期不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "OPEN_START_DATE")
    private Date openStartDate;

    @NotBlank(message = "营业结束日期不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "OPEN_END_DATE")
    private Date openEndDate;

    @NotBlank(message = "成立日期不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "START_DATE")
    private Date startDate;

    @NotBlank(message = "吊销日期不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "END_DATE")
    private Date endDate;

    @NotBlank(message = "发照日期不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name="CHECK_DATE")
    private Date checkDate;

    @NotBlank(message = "企业名变更时间不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "NAME_CHANGE_DATE")
    private Date nameChangeDate;

    @NotBlank(message = "工商信息更新时间不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "BUSINESS_INFO_UPDATE_DATE")
    private Date businessInfoUpdateDate;

    @NotBlank(message = "曾用名不能为空")
    private String originalname;

    @NotBlank(message = "是否上市不能为空")
    @Column(name = "IS_ON_STOCK")
    private String isOnStock;

    @NotBlank(message = "上市类型不能为空")
    @Column(name = "STOCK_TYPE")
    private String stockType;

    @NotBlank(message = "上市公司代码不能为空")
    @Column(name = "STOCK_NUMBER")
    private String stockNumber;

    @NotBlank(message = "组织机构代码不能为空")
    @Column(name = "ORG_NO")
    private String orgNo;

    @NotBlank(message = "企业类型/公司性质不能为空")
    @Column(name = "ECON_KING")
    private String econKing;

    @NotBlank(message = "经营范围不能为空")
    @Column(name="COMPANY_BUSINESS_SCOPE")
    private String companyBusinessScope;

    @NotBlank(message = "注册省份不能为空")
    private String province;

    @NotBlank(message = "公司电话不能为空")
    @Column(name = "COMPANY_TELEPHONE")
    private String companyTelephone;

    @NotBlank(message = "公司传真不能为空")
    @Column(name="COMPANY_FAX")
    private String companyFax;

    @NotBlank(message = "备注不能为空")
    private String remark;

    @NotBlank(message = "创建时间不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "CREATE_TIME")
    private Date createTime;

    @NotBlank(message = "最后修改时间不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "LAST_UPDATE_TIME")
    private Date lastUpdateTime;

    @NotBlank(message = "公司签章创建状态不能为空")
    @Column(name="COMPANY_SIGN_STATUS")
    private String companySignStatus;

    @NotBlank(message = "公司LOGO不能为空")
    @Column(name="COMPANY_LOGO")
    private String companyLogo;

    @NotBlank(message = "公司邮编不能为空")
    @Column(name="COMPANY_POSTCODE")
    private String companyPostcode;

    @NotBlank(message = "电子签名时间不能为空")
    @Column(name = "ELECTRONIC_SIGN_TIME")
    private Date electronicSignTime;

    @NotBlank(message = "公司ICON不能为空")
    @Column(name="COMPANY_ICON")
    private String companyIcon;

    @NotBlank(message = "实缴资本不能为空")
    @Column(name = "ISSUED_CAPIT")
    private BigDecimal issuedCapit;

    @NotBlank(message = "资本币种不能为空")
    @Column(name="CAPIT_CURRENCY")
    private String capitCurrency;

    @NotBlank(message = "是否三证合一不能为空")
    @Column(name = "IS_CERTIFICATE_MERGE")
    private String isCertificateMerge;

    @NotBlank(message = "税务登记证号不能为空")
    @Column(name = "TAX_REGISTRATION_NO")
    private String taxRegistrationNo;

    @NotBlank(message = "注册城市不能为空")
    private String city;

    @NotBlank(message = "是否允许使用电子签章不能为空")
    @Column(name="ALLOW_SIGN")
    private String allowSign;

    @NotBlank(message = "统一社会信用代码/营业执照号核准日期不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "EXPIRY_DATE_SOCIAL_CREDIT_CODE")
    private Date expiryDateSocialCreditCode;

    @NotBlank(message = "组织机构代码证到期日不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "EXPIRY_DATE_ORG_NO")
    private Date expiryDateOrgNo;

    @NotBlank(message = "税务登记证到期日不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "EXPIRY_DATE_TAX_REGISTRATION")
    private Date expiryDateTaxRegistration;

    @NotBlank(message = "企业类型不能为空")
    @Column(name = "ENTERPRISE_TYPE")
    private String enterpriseType;

    @NotBlank(message = "公司邮箱不能为空")
    @Column(name="COMPANY_EMAIL")
    private String companyEmail;

    @NotBlank(message = "企业状态不能为空")
    private String status;

    @NotBlank(message = "启用状态不能为空")
    @Column(name = "ENABLE_STATUS")
    private String enableStatus;

    @NotBlank(message = "审核岗位不能为空")
    @Column(name = "REVIEW_STATION")
    private String reviewStation;
    @Column(name = "IS_PLATFORM")
    private String isPlatform;
}
