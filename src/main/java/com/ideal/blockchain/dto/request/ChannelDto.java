package com.ideal.blockchain.dto.request;

import com.ideal.blockchain.req.BaseReq;

public class ChannelDto extends BaseReq {



    private String channelName;

    private String peerWithOrg ;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getPeerWithOrg() {
        return peerWithOrg;
    }

    public void setPeerWithOrg(String peerWithOrg) {
        this.peerWithOrg = peerWithOrg;
    }


}
