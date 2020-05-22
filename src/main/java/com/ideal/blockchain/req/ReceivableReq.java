package com.ideal.blockchain.req;

import com.ideal.blockchain.entity.saas.Receivable;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
public class ReceivableReq extends InvokeChainCodeArgsReq{

    @Valid
    private Receivable receivable;

    @NotBlank
    private String collectionName;

    public ReceivableReq(){

    }

    public ReceivableReq(String username,String password,String channelName,String chaincodeName,String chaincodeversion,
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
