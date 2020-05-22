package com.ideal.blockchain.entity.loan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "LMT_COMPANY_RATING")
@Entity
@Data
public class CompanyRating {

    private static final String OBJECT_TYPE_NAME = "CompanyRating";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;

    @ApiModelProperty(value = "企业历史外部评级ID")
    @Id
    @Column(name = "COMPANY_RATE_ID")
    public String companyRateId;

    @ApiModelProperty(value = "企业ID")
    @Column(name = "COMPANY_ID")
    public String companyId;

    @ApiModelProperty(value = "企业名称")
    @Column(name = "COMPANY_NAME")
    public String companyName;

    @ApiModelProperty(value = "统一社会信用代码")
    @Column(name = "UNIFIED_SOCIAL_CREDIT_CODE")
    public String unifiedSocialCreditCode;

    @ApiModelProperty(value = "评级日期")
    @Column(name = "RATING_DATE")
    public Date ratingDate;

    @ApiModelProperty(value = "评级标准")
    @Column(name = "RATING_STANDARD")
    public String ratingStandard;

    @ApiModelProperty(value = "信用评级")
    @Column(name = "RATING_SCALE")
    public String ratingScale;

    @ApiModelProperty(value = "评级展望")
    @Column(name = "RATING_OUTLOOK")
    public String ratingOutlook;

    @ApiModelProperty(value = "评级机构")
    @Column(name = "RATING_AGENCIES")
    public String ratingAgencies;

    @ApiModelProperty(value = "链接地址")
    @Column(name = "LINK_ADDR")
    public String linkAddr;

    @ApiModelProperty(value = "数据日期")
    @Column(name = "DATA_DATE")
    public Date dataDate;

}
