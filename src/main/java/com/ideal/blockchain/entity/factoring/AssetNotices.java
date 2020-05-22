package com.ideal.blockchain.entity.factoring;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class AssetNotices {
    private String assetNoticeReqId;

    private String assetPackageReqId;

    private String downstreamSocialCreditCode;
    private String downstreamCompanyName;

    private BigDecimal noticeTotalAmount;

    private BigDecimal noticeTotalInvoiceAmount;

    private String noticeStatus;

    private String noticeStatusText;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date noticeTime;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date receiptTime;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String noticeContractNo;

    private String noticeContractReceiptNo;

    private List<Factoring> factoring;
}