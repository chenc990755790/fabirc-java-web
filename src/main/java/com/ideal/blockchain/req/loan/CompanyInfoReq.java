package com.ideal.blockchain.req.loan;

import com.ideal.blockchain.entity.loan.CompanyInfo;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import lombok.Data;

import javax.validation.Valid;

@Data
public class CompanyInfoReq  extends InvokeChainCodeArgsReq {

    @Valid
    private CompanyInfo companyInfo;
}
