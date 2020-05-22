package com.ideal.blockchain.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BaseReq {

    @NotBlank(message = "please enter username in request body!")
    private String userName ;

    @NotBlank(message = "please enter passWord in request body!")
    private String passWord ;
}
