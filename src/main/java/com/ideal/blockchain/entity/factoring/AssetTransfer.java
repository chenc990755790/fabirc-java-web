package com.ideal.blockchain.entity.factoring;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class AssetTransfer {

    private static final String OBJECT_TYPE_NAME = "assetTransfer";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;

    private String assetPackageReqId;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateTime;

    private String status;
    private String statusText;

    private String transferType;
    private String transferStatus;
    private String transferStatusText;

    private String channelSocialCreditCode;
    private String channelCompanyName;

    private String factoringSocialCreditCode;
    private String factoringCompanyName;

    private String fundingSocialCreditCode;
    private String fundingCompanyName;

    private String financingAccountName;
    private String openBankBranchName;
    private String financingAccountNo;

    private String transferContractNo;
    private String transferContractReceiptNo;

    private BigDecimal totalAmount;
    private BigDecimal totalInvoiceAmount;

    private String operatorId;

    private String operatorName;

    private String reviewComment;

    private String operationType;

    private List<AssetNotices> assetNotices;
}
