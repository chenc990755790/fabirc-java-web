package com.ideal.blockchain.controller.block;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ideal.blockchain.dto.response.ResultInfo;
import com.ideal.blockchain.entity.factoring.Factor;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import com.ideal.blockchain.service.block.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController()
@RequestMapping(value = "/factoring")
public class FactoringController  {

    private final Gson gson = new GsonBuilder().create();

    @Autowired
    private InvokeChainCodeArgsReq invokeReq;

    @Autowired
    private BaseService baseService;

    @RequestMapping(value = "/saveFactoring", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveFactoring(@RequestBody Factor factoring,String userName,String password) {
        //TODO
        log.info("校验用户，密码是否正确");
        String s = JSON.toJSONString(factoring);
        String factorReqJson = gson.toJson(factoring);
        String[] newArgs = new String[]{factorReqJson};
        invokeReq.setFunction("saveFactoring");
        invokeReq.setUserName(userName);
        invokeReq.setPassWord(password);
        return baseService.invokeChainCode(invokeReq, newArgs);
    }

}
