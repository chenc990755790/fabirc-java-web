package com.ideal.blockchain.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BlockMessage implements java.io.Serializable{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "区块号")
    private long blockNumber;
    @ApiModelProperty(name = "上一个区块哈希")
    private String previousHash;
    @ApiModelProperty(name = "当前区块哈希")
    private String dataHash;
    @ApiModelProperty(name = "通道名称")
    private String channelId;
    @ApiModelProperty(name = "过滤后的数据条数")
    private int envelopeCount;
    @ApiModelProperty(name = "交易数量")
    private int transactionCount;
    @ApiModelProperty(name = "交易元数据")
    private String transActionsMetaData;
    @ApiModelProperty(name = "交易id")
    private String txid;
}
