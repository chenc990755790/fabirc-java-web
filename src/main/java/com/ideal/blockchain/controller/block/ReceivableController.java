package com.ideal.blockchain.controller.block;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ideal.blockchain.controller.BaseController;
import com.ideal.blockchain.dto.response.ResultInfo;
import com.ideal.blockchain.entity.Receivable;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import com.ideal.blockchain.req.QueryArgsReq;
import com.ideal.blockchain.req.ReceivableReq;
import com.ideal.blockchain.service.block.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/receivable")
public class ReceivableController extends BaseController {

    @Autowired
    private UserService userService;

    private final Gson gson = new GsonBuilder().create();

    @RequestMapping(value = "/queryReceivable", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo queryReceivable(@RequestBody @Valid QueryArgsReq req) {
        return queryPrivateChainCode(req);
    }


    @RequestMapping(value = "/saveReceivable", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveReceivable(@RequestBody @Valid ReceivableReq req) {
        String[] newArgs = getNewArgs(req);
        return invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/modifyReceivable", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo modifyReceivable(@RequestBody @Valid ReceivableReq req) {
        String[] newArgs = getNewArgs(req);
        return invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/deleteReceivable", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo deleteReceivable(@RequestBody @Valid InvokeChainCodeArgsReq req) {
        return invokeChainCode(req);
    }

    private String[] getNewArgs(@Valid @RequestBody ReceivableReq req) {
        Receivable receivable = req.getReceivable();
        String receivableJson = gson.toJson(receivable);
        return addArgsForCollectionName(userService.getCollectionName(req.getUserName()), new String[] {receivableJson});
    }

}
