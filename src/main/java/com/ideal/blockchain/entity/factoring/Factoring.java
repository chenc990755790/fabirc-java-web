package com.ideal.blockchain.entity.factoring;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Factoring {

    private static final String OBJECT_TYPE_NAME = "factoring";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;

    private String factoringReqId;

    private String upstreamSocialCreditCode;

    private String factoringSocialCreditCode;

    private String downstreamSocialCreditCode;

    private String upstreamCompanyName;

    private String downstreamCompanyName;

    private String receivablesBankAccountNo;

    private String receivablesBankName;

    private String receivablesBankBranch;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date receivablesDate;

    private String financingBankName;

    private String financingBankBranch;

    private String financingBankAccountNo;

    private String contractName;

    private String contractNo;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date cooperateYears;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date obligorCooperateYears;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date financingTimeStart;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date financingTimeEnd;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date receivablesTransferDate;

    private BigDecimal receivablesAmount;

    private BigDecimal financingAmount;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date requestTime;

    private String status;

    private String statusText;

    private String reviewContent;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date financingTimeStartLog;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date financingTimeEndLog;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date overdueDate;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateTime;

    private BigDecimal financingAmountLog;

    private String reviewOperator;

    private String fundingPretrialStatus;

    private String fundingPretrialStatusText;

    private String invoiceNo;

    private BigDecimal invoiceAmount;

    // 以下操作账户信息
    private String operatorId;

    private String operatorName;

    private String reviewComment;

    private String operationType;


}
