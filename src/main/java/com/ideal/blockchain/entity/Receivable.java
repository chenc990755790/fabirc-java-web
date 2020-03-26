package com.ideal.blockchain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Receivable {

    private static final String OBJECT_TYPE_NAME="receivable";

    private static final String objectType = OBJECT_TYPE_NAME;

    @NotBlank(message = "应收账款申请编号不能为空")
    private String receivableRequestId;

    @NotBlank(message = "链条编号不能为空")
    private String chainNo;

    private String blankNoteNo;

    private String blankNoteType;

    private String status;

    private String promisePayReviewStatus;

    private String platformReviewStatus;

    private String factorReviewStatus;

    private String loanEnterpriseReviewStatus;

    private BigDecimal amount;

    private BigDecimal remainAmount;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expireDate;

    private String issueEnterpriseName;

    private String issueEnterpriseId;

    private String commitmentPayEnterpriseName;

    private String commitmentPayEnterpriseId;

    private String isEnsure;

    private String ensureEnterpriseName;

    private String ensureEnterpriseId;

    private String financialOrgansName;

    private String financialOrgansId;

    private String holdEnterpriseName;

    private String holdEnterpriseId;

    private String lastBlankNoteNo;

    private String nextBlankNoteNo;

    private String isClear;

    private String remark3;

    private String remark2;

    private String remark;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lastUpdateTime;

    private String addUserId;

    private String productCode;

    private String acceptEnterpriseName;

    private String acceptEnterpriseId;

    private String factorTransferStatus;

    private String counterpartyEnterpriseId;

    private String counterpartyEnterpriseName;

    private String platformFirstReviewor;

    private String platformSecondReviewor;

    private String factorFirstReviewor;

    private String factorSecondReviewor;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date submitTime;
}
