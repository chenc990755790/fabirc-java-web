package com.ideal.blockchain.req;

import com.ideal.blockchain.entity.UserInfo;
import lombok.Data;

import javax.validation.Valid;
@Data
public class UserInfoReq extends InvokeChainCodeArgsReq {

    @Valid
    private UserInfo userInfo;

}
