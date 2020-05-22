package com.ideal.blockchain.entity.saas;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(description = "PD_RECEIVABLE_REQ")
@Entity
@Table(name = "PD_RECEIVABLE_REQ")
public class Receivable {

    private static final String OBJECT_TYPE_NAME="receivable";
    @Transient
    private  String objectType = OBJECT_TYPE_NAME;

    @NotBlank(message = "应收账款申请编号不能为空")
    @Id
    @Column(name="RECEIVABLE_REQUEST_ID")
    private String receivableRequestId;

    @NotBlank(message = "链条编号不能为空")
    @Column(name="CHAIN_NO")
    private String chainNo;
    @ApiModelProperty(value = "白条编号")
    @Column(name="BLANK_NOTE_NO")
    private String blankNoteNo;
    @Column(name="BLANK_NOTE_TYPE")
    private String blankNoteType;
    @ApiModelProperty(value = "状态")
    private String status;
    @Column(name="PROMISE_PAY_REVIEW_STATUS")
    @ApiModelProperty(value ="承诺付款企业审核状态")
    private String promisePayReviewStatus;
    @ApiModelProperty(value ="平台审核状态")
    @Column(name="PLATFORM_REVIEW_STATUS")
    private String platformReviewStatus;
    @ApiModelProperty(value ="保理商审核状态")
    @Column(name="FACTOR_REVIEW_STATUS")
    private String factorReviewStatus;
    @ApiModelProperty(value ="放款企业审核状态")
    @Column(name="LOAN_ENTERPRISE_REVIEW_STATUS")
    private String loanEnterpriseReviewStatus;
    @ApiModelProperty(value ="金额")
    private BigDecimal amount;
    @ApiModelProperty(value ="剩余金额")
    @Column(name="REMAIN_AMOUNT")
    private BigDecimal remainAmount;
    @ApiModelProperty(value ="到期日期/承诺付款日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name="EXPIRE_DATE")
    private Date expireDate;
    @ApiModelProperty(value ="签发企业名称")
    @Column(name="ISSUE_ENTERPRISE_NAME")
    private String issueEnterpriseName;
    @ApiModelProperty(value ="签发企业Id")
    @Column(name="ISSUE_ENTERPRISE_ID")
    private String issueEnterpriseId;
    @ApiModelProperty(value ="承诺付款企业名称")
    @Column(name="COMMITMENT_PAY_ENTERPRISE_NAME")
    private String commitmentPayEnterpriseName;
    @ApiModelProperty(value ="承诺付款企业Id")
    @Column(name="COMMITMENT_PAY_ENTERPRISE_ID")
    private String commitmentPayEnterpriseId;
    @ApiModelProperty(value ="是否有担保")
    @Column(name="IS_ENSURE")
    private String isEnsure;
    @Column(name="ENSURE_ENTERPRISE_NAME")
    @ApiModelProperty(value ="担保企业名称")
    private String ensureEnterpriseName;
    @ApiModelProperty(value ="担保企业Id")
    @Column(name="ENSURE_ENTERPRISE_ID")
    private String ensureEnterpriseId;
    @ApiModelProperty(value ="合作金融机构名称")
    @Column(name="FINANCIAL_ORGANS_NAME")
    private String financialOrgansName;
    @ApiModelProperty(value ="合作金融机构Id")
    @Column(name="FINANCIAL_ORGANS_ID")
    private String financialOrgansId;
    @ApiModelProperty(value ="白条持有企业名称")
    @Column(name="HOLD_ENTERPRISE_NAME")
    private String holdEnterpriseName;
    @ApiModelProperty(value ="白条持有企业Id")
    @Column(name="HOLD_ENTERPRISE_ID")
    private String holdEnterpriseId;
    @ApiModelProperty(value ="上一手白条编号")
    @Column(name="LAST_BLANK_NOTE_NO")
    private String lastBlankNoteNo;
    @ApiModelProperty(value ="下一手白条编号（多个以@拼接）")
    @Column(name="NEXT_BLANK_NOTE_NO")
    private String nextBlankNoteNo;
    @ApiModelProperty(value ="是否清分跑批")
    @Column(name="IS_CLEAR")
    private String isClear;
    @ApiModelProperty(value ="备注/摘要3")
    @Column(name="REMARK3")
    private String remark3;
    @ApiModelProperty(value ="备注/摘要2")
    @Column(name="REMARK2")
    private String remark2;
    @ApiModelProperty(value ="备注/摘要1")
    @Column(name="REMARK")
    private String remark;
    @ApiModelProperty(value ="创建时间")
    @Column(name="CREATE_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    @Column(name="LAST_UPDATE_TIME")
    @ApiModelProperty(value ="最后更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lastUpdateTime;
    @ApiModelProperty(value ="新增这条数据的用户id")
    @Column(name="ADD_USER_ID")
    private String addUserId;
    @ApiModelProperty(value ="平台产品编号")
    @Column(name="PRODUCT_CODE")
    private String productCode;
    @ApiModelProperty(value ="签收企业名称")
    @Column(name="ACCEPT_ENTERPRISE_NAME")
    private String acceptEnterpriseName;
    @ApiModelProperty(value ="签收企业Id")
    @Column(name="ACCEPT_ENTERPRISE_ID")
    private String acceptEnterpriseId;
    @ApiModelProperty(value ="保理商转让审核状态")
    @Column(name="FACTOR_TRANSFER_STATUS")
    private String factorTransferStatus;
    @ApiModelProperty(value ="交易对手企业ID")
    @Column(name="COUNTERPARTY_ENTERPRISE_ID")
    private String counterpartyEnterpriseId;
    @ApiModelProperty(value ="交易对手企业名称")
    @Column(name="COUNTERPARTY_ENTERPRISE_NAME")
    private String counterpartyEnterpriseName;
    @Column(name="PLATFORM_FIRST_REVIEWOR")
    @ApiModelProperty(value ="平台初审操作者")
    private String platformFirstReviewor;
    @ApiModelProperty(value ="平台复审操作者")
    @Column(name="PLATFORM_SECOND_REVIEWOR")
    private String platformSecondReviewor;
    @ApiModelProperty(value ="保理商初审操作者")
    @Column(name="FACTOR_FIRST_REVIEWOR")
    private String factorFirstReviewor;
    @ApiModelProperty(value ="保理商复审操作者")
    @Column(name="FACTOR_SECOND_REVIEWOR")
    private String factorSecondReviewor;
    @Column(name="SUBMIT_TIME")
    @ApiModelProperty(value ="提交时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date submitTime;
}
