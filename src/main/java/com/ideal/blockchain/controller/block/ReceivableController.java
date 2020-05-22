package com.ideal.blockchain.controller.block;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ideal.blockchain.collection.CollectionParserService;
import com.ideal.blockchain.dto.response.ResultInfo;
import com.ideal.blockchain.entity.saas.Receivable;
import com.ideal.blockchain.enums.ResponseCodeEnum;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import com.ideal.blockchain.req.QueryArgsReq;
import com.ideal.blockchain.req.ReceivableReq;
import com.ideal.blockchain.service.block.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/receivable")
public class ReceivableController  {

    @Autowired
    private BaseService baseService;

    @Autowired
    protected CollectionParserService collectionParserService;

    private final Gson gson = new GsonBuilder().create();

    @RequestMapping(value = "/queryReceivable", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo queryReceivable(@RequestBody @Valid QueryArgsReq req) {
        return baseService.queryPrivateChainCode(req);
    }


    @RequestMapping(value = "/saveReceivablePrivate", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveReceivablePrivate(@RequestBody @Valid ReceivableReq req) {
        if (!collectionParserService.getCollectNameList().contains(req.getCollectionName())) {
            return new ResultInfo(ResponseCodeEnum.COLLECTION_NOT_EXISTS);
        }
        String[] newArgs = getNewArgs(req);
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/saveReceivable", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveReceivable(@RequestBody ReceivableReq req) {
        String receiveJson = gson.toJson(req.getReceivable());
        String[] newArgs = new String[]{receiveJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/modifyReceivable", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo modifyReceivable(@RequestBody @Valid ReceivableReq req) {
        if (!collectionParserService.getCollectNameList().contains(req.getCollectionName())) {
            return new ResultInfo(ResponseCodeEnum.COLLECTION_NOT_EXISTS);
        }
        String[] newArgs = getNewArgs(req);
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/deleteReceivable", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo deleteReceivable(@RequestBody @Valid InvokeChainCodeArgsReq req) {
        return baseService.invokeChainCode(req);
    }

    private String[] getNewArgs(@Valid @RequestBody ReceivableReq req) {
        Receivable receivable = req.getReceivable();
        String receivableJson = gson.toJson(receivable);
        return baseService.addArgsForCollectionName(req.getCollectionName(), new String[]{receivableJson});
    }

}
