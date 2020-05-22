package com.ideal.blockchain.entity.factoring;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Transient;

@Data
public class Factor {

    private static final String OBJECT_TYPE_NAME = "factor";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;


    @ApiModelProperty(value = "区块链请求编号")
    @Id
    private String blockChainReqId;

    @ApiModelProperty(value = "业务类型")
    private String businessTypeText;

    @ApiModelProperty(value = "业务类型")
    private String businessType;

    private Factoring requestData;

}
