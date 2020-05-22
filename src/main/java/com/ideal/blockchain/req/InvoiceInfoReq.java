package com.ideal.blockchain.req;

import com.ideal.blockchain.entity.saas.InvoiceInfo;
import lombok.Data;

import javax.validation.Valid;

@Data
public class InvoiceInfoReq extends InvokeChainCodeArgsReq {

    @Valid
    private InvoiceInfo invoiceInfo;

    public InvoiceInfoReq() {

    }

    public InvoiceInfoReq(String username, String password, String channelName, String chaincodeName, String chaincodeversion,
                          String belongWithOrg, String[] peerWithOrgs, String funcation, String[] args) {
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
