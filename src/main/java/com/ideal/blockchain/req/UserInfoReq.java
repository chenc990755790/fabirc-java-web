package com.ideal.blockchain.req;

import com.ideal.blockchain.entity.saas.UserInfo;
import lombok.Data;

import javax.validation.Valid;
@Data
public class UserInfoReq extends InvokeChainCodeArgsReq {

    @Valid
    private UserInfo userInfo;
    public UserInfoReq(){

    }

    public UserInfoReq(String username,String password,String channelName,String chaincodeName,String chaincodeversion,
                                String belongWithOrg,String[] peerWithOrgs,String funcation,String[] args){
        setUserName(username);
        setPassWord(password);
        setChannelName(channelName);
        setChainCodeName(chaincodeName);
        setChainCodeVersion(chaincodeversion);
        setPeerWithOrg(belongWithOrg);
        setPeerWithOrgs(peerWithOrgs);
        setFunction(funcation);
        setArgs(args);
    }
}
