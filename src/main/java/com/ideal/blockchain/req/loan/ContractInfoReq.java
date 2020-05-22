package com.ideal.blockchain.req.loan;

import com.ideal.blockchain.entity.loan.ContractInfo;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import lombok.Data;

import javax.validation.Valid;

@Data
public class ContractInfoReq  extends InvokeChainCodeArgsReq {

    @Valid
    private ContractInfo contractInfo;
}
