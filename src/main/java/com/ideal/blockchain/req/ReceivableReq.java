package com.ideal.blockchain.req;

import com.ideal.blockchain.entity.Receivable;
import lombok.Data;

import javax.validation.Valid;

@Data
public class ReceivableReq extends InvokeChainCodeArgsReq{

    @Valid
    private Receivable receivable;
}
