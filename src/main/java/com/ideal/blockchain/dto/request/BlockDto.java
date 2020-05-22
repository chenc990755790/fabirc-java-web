package com.ideal.blockchain.dto.request;

import com.ideal.blockchain.req.ChannelNameReq;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class BlockDto extends ChannelNameReq {

    @NotEmpty(message = "交易id不能为空")
    private String[] txIdList;


}
