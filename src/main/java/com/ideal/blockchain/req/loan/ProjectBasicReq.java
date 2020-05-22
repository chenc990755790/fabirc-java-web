package com.ideal.blockchain.req.loan;

import com.ideal.blockchain.entity.loan.ProjectBasic;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import lombok.Data;

import javax.validation.Valid;

@Data
public class ProjectBasicReq  extends InvokeChainCodeArgsReq {

    @Valid
    private ProjectBasic projectBasic;
}
