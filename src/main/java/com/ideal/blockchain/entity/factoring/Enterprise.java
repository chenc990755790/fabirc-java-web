package com.ideal.blockchain.entity.factoring;

import lombok.Data;

import javax.persistence.Transient;
import java.util.Date;
@Data
public class Enterprise {

    private static final String OBJECT_TYPE_NAME = "enterprise";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;

    private String socialCreditCode;

    private String companyName;

    private String companyRegisterCapital;

    private String belongOrg;

    private String companyStatus;

    private String companyRegisterAddress;

    private Date openStartDate;

    private Date openEndDate;

    private Date startDate;

    private Date endDate;

    private Date checkDate;

    private String originalName;

    private String isOnStock;

    private String orgNo;

    private String econKing;

    private String companyBusinessScope;

    private String province;

    private String legalPersonName;

    private String legalPersonIdNo;

    private Date createTime;

    private String companyLogo;

    private String enterpriseType;

    private String enterpriseTypeText;


}
