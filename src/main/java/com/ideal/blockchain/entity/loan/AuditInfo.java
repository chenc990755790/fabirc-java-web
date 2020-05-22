package com.ideal.blockchain.entity.loan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "LMT_AUDIT_INFO")
@Entity
@Data
public class AuditInfo {


    private static final String OBJECT_TYPE_NAME = "AuditInfo";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;

    @ApiModelProperty(value = "（资产池编号）资产批次编号")
    @Id
    @Column(name = "LOAN_NO")
    public String loanNo;

    @ApiModelProperty(value = "资产状态---无字典")
    @Column(name = "LOAN_STATUS_TEXT")
    public String loanStatusText;

    @ApiModelProperty(value = "审核时间")
    @Column(name = "OPERATE_TIME")
    public Date operateTime;

    @ApiModelProperty(value = "数据日期")
    @Column(name = "UPDATE_DATE")
    public Date updateDate;

    @ApiModelProperty(value = "项目编号")
    @Column(name = "PROJECT_NO")
    public String projectNo;

    @ApiModelProperty(value = "项目名称")
    @Column(name = "PROJECT_NAME")
    public String projectName;

    @ApiModelProperty(value = "项目类型")
    @Column(name = "PROJECT_TYPE")
    public String projectType;

    @ApiModelProperty(value = "企业名称")
    @Column(name = "COMPANY_NAME")
    public String companyName;

    @ApiModelProperty(value = "评级日期（YYYY-MM-DD）")
    @Column(name = "RATING_DATE")
    public Date ratingDate;

    @ApiModelProperty(value = "评级标准---中文")
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

    @ApiModelProperty(value = "连接地址")
    @Column(name = "LINK_ADDR")
    public String linkAddr;
}
