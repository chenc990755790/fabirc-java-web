package com.ideal.blockchain.entity.loan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "LMT_PROJECT_BASIC")
@Entity
@Data
public class ProjectBasic {

    private static final String OBJECT_TYPE_NAME = "ProjectBasic";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;

    @ApiModelProperty(value = "项目ID")
    @Id
    @Column(name = "PROJECT_ID")
    public String projectId;

    @ApiModelProperty(value = "项目名称")
    @Column(name = "PROJECT_NAME")
    public String projectName;

    @ApiModelProperty(value = "项目编号")
    @Column(name = "PROJECT_NO")
    public String projectNo;

    @ApiModelProperty(value = "项目类型ID")
    @Column(name = "PROJECT_TYPE")
    public String projectType;

    @ApiModelProperty(value = "项目类型")
    @Column(name = "PROJECT_TYPE_TEXT")
    public String projectTypeText;

    @ApiModelProperty(value = "项目背景")
    @Column(name = "PROJECT_BACKGROUND")
    public String projectBackground;

    @ApiModelProperty(value = "交易结构")
    @Column(name = "EXCHANGE_STRUCTRUE")
    public String exchangeStructrue;

    @ApiModelProperty(value = "投资金额")
    @Column(name = "INVESTMENT_AMOUNT")
    public String investmentAmount;

    @ApiModelProperty(value = "投资期限")
    @Column(name = "INVESTMENT_TERM")
    public String investmentTerm;

    @ApiModelProperty(value = "预期收益率")
    @Column(name = "EXPECT_INCOME_RATE")
    public String expectIncomeRate;

    @ApiModelProperty(value = "资产类型ID")
    @Column(name = "LOAN_TYPE")
    public String loanType;

    @ApiModelProperty(value = "资产类型")
    @Column(name = "LOAN_TYPE_TEXT")
    public String loanTypeText;

    @ApiModelProperty(value = "第一还款来源")
    @Column(name = "FIRST_REPAYMENT_SOURCE")
    public String firstRepaymentSource;

    @ApiModelProperty(value = "资金用途")
    @Column(name = "USE_OF_FUNDS")
    public String useOfFunds;

    @ApiModelProperty(value = "抵押物类型ID")
    @Column(name = "COLLATERAL_TYPE")
    public String collateralType;

    @ApiModelProperty(value = "抵押物类型")
    @Column(name = "COLLATERALT_YPE_TEXT")
    public String collateralTypeText;

    @ApiModelProperty(value = "抵押率")
    @Column(name = "MORTGAGE_RATE")
    public String mortgageRate;

    @ApiModelProperty(value = "质押物类型ID")
    @Column(name = "PLEDGE_TYPE")
    public String pledgeType;

    @ApiModelProperty(value = "质押物类型")
    @Column(name = "PLEDGE_TYPE_TEXT")
    public String pledgeTypeText;

    @ApiModelProperty(value = "质押率")
    @Column(name = "PLEDGE_RATE")
    public String pledgeRate;

    @ApiModelProperty(value = "资金来源ID")
    @Column(name = "FUNDS_SOURCE")
    public String fundsSource;

    @ApiModelProperty(value = "资金来源")
    @Column(name = "FUNDS_SOURCE_TEXT")
    public String fundsSourceText;

    @ApiModelProperty(value = "项目阶段ID")
    @Column(name = "PROJECT_STAGE")
    public String projectStage;

    @ApiModelProperty(value = "项目阶段")
    @Column(name = "PROJECT_STAGE_TEXT")
    public String projectStageText;

    @ApiModelProperty(value = "业务处理专员")
    @Column(name = "BUSINESS_MANGER")
    public String businessManger;

    @ApiModelProperty(value = "业务处理团队")
    @Column(name = "BUSINESS_TEAM")
    public String businessTeam;

    @ApiModelProperty(value = "录入人员")
    @Column(name = "INPUTUSER")
    public String inputuser;

    @ApiModelProperty(value = "业务团队负责人")
    @Column(name = "BUSINESS_TEAMUSER")
    public String businessTeamuser;

    @ApiModelProperty(value = "机构负责人")
    @Column(name = "INSTITUTIONAL_DIRECTOR")
    public String institutionalDirector;

    @ApiModelProperty(value = "尽调人员")
    @Column(name = "DUE_DILIGENCE_USER")
    public String dueDiligenceUser;

    @ApiModelProperty(value = "融资主体")
    @Column(name = "FINANCING_COMPANY")
    public String financingCompany;

    @ApiModelProperty(value = "录入日期")
    @Column(name = "CREATED_TIME")
    public Date createdTime;

    @ApiModelProperty(value = "录入人")
    @Column(name = "CREATED_USER")
    public String createdUser;

    @ApiModelProperty(value = "修改日期")
    @Column(name = "MODIFED_TIME")
    public Date modifedTime;

    @ApiModelProperty(value = "数据日期")
    @Column(name = "DATA_DATE")
    public Date dataDate;

}
