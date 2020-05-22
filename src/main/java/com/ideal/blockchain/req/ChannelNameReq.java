package com.ideal.blockchain.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class ChannelNameReq extends BaseReq{

    @NotEmpty(message = "please enter peerWithOrg in request body")
    private String peerWithOrg;

    @NotBlank(message = "please enter channelName in request body")
    private String channelName;

}
