package com.ideal.blockchain.req.loan;

import com.ideal.blockchain.entity.loan.CapitalNotice;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import lombok.Data;

import javax.validation.Valid;

@Data
public class CapitalNoticeReq  extends InvokeChainCodeArgsReq {

    @Valid
    private CapitalNotice capitalNotice;
}
