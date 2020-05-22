package com.ideal.blockchain.req.loan;

import com.ideal.blockchain.entity.loan.PledgeNote;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import lombok.Data;

import javax.validation.Valid;

@Data
public class PledgeNoteReq extends InvokeChainCodeArgsReq {

    @Valid
    private PledgeNote pledgeNote;
}
