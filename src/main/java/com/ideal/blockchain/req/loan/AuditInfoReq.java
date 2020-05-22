package com.ideal.blockchain.req.loan;

import com.ideal.blockchain.entity.loan.AuditInfo;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import lombok.Data;

import javax.validation.Valid;

@Data
public class AuditInfoReq  extends InvokeChainCodeArgsReq  {

    @Valid
    private AuditInfo auditInfo;
}
