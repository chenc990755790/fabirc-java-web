package com.ideal.blockchain.req.loan;

import com.ideal.blockchain.entity.loan.CompanyRating;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import lombok.Data;

import javax.validation.Valid;

@Data
public class CompanyRatingReq  extends InvokeChainCodeArgsReq {

    @Valid
    private CompanyRating companyRating;

}
