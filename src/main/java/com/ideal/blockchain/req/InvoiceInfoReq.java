package com.ideal.blockchain.req;

import com.ideal.blockchain.entity.InvoiceInfo;
import lombok.Data;

import javax.validation.Valid;

@Data
public class InvoiceInfoReq extends InvokeChainCodeArgsReq {

    @Valid
    private InvoiceInfo invoiceInfo;
}
