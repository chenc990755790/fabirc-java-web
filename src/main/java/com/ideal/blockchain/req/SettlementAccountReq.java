package com.ideal.blockchain.req;

import com.ideal.blockchain.entity.saas.SettlementAccount;
import lombok.Data;

import javax.validation.Valid;

@Data
public class SettlementAccountReq extends InvokeChainCodeArgsReq {

    @Valid
    private SettlementAccount settlementAccount;

    public SettlementAccountReq(){

    }

    public SettlementAccountReq(String username,String password,String channelName,String chaincodeName,String chaincodeversion,
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
