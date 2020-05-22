package com.ideal.blockchain.controller.block;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ideal.blockchain.dto.response.ResultInfo;
import com.ideal.blockchain.enums.ResponseCodeEnum;
import com.ideal.blockchain.req.*;
import com.ideal.blockchain.service.block.BaseService;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    private final Gson gson = new GsonBuilder().create();

    @Autowired
    private BaseService baseService;

    @RequestMapping(value = "/queryEnterpriseById", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo queryEnterpriseById(@RequestBody QueryArgsReq req) {
        return baseService.getQueryResponse(req);
    }

    @RequestMapping(value = "/saveEnterpriseInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveEnterpriseInfo(@RequestBody EnterpriseInfoReq req) {
        String enterpriseJson = gson.toJson(req.getEnterpriseInfo());
        String[] newArgs = new String[]{enterpriseJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/queryEnterpriseInfo", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo queryEnterpriseInfo(@RequestBody QueryArgsReq req) {
        req.setArgs(new String[]{"objectType", "enterpriseInfo"});
        return baseService.getQueryResponse(req);
    }

    @RequestMapping(value = "/modifyEnterpriseInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo modifyEnterpriseInfo(@RequestBody @Valid EnterpriseInfoReq req) {
        String enterpriseJson = gson.toJson(req.getEnterpriseInfo());
        String[] newArgs = new String[]{enterpriseJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/deleteEnterpriseInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo deleteEnterpriseInfo(@RequestBody @Valid InvokeChainCodeArgsReq req) {
        return baseService.invokeChainCode(req);
    }

    @RequestMapping(value = "/saveInvoice", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveInvoiceInfo(@RequestBody InvoiceInfoReq req) {
        String invoiceJson = gson.toJson(req.getInvoiceInfo());
        String[] newArgs = new String[]{invoiceJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/modifyInvoice", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo modifyInvoiceInfo(@RequestBody @Valid InvoiceInfoReq req) {
        String invoiceJson = gson.toJson(req.getInvoiceInfo());
        String[] newArgs = new String[]{invoiceJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/queryInvoice", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo queryInvoice(@RequestBody QueryArgsReq req) {
        req.setArgs(new String[]{"objectType", "enterprise_invoice"});
        return baseService.getQueryResponse(req);
    }

    @RequestMapping(value = "/deleteInvoice", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo deleteInvoiceInfo(@RequestBody @Valid InvokeChainCodeArgsReq req) {
        return baseService.invokeChainCode(req);
    }

    @RequestMapping(value = "/saveBankAccount", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveBankAccount(@RequestBody  SettlementAccountReq req) {
        String bankAccountJson = gson.toJson(req.getSettlementAccount());
        String[] newArgs = new String[]{bankAccountJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/modifyBankAccount", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo modifyBankAccount(@RequestBody @Valid SettlementAccountReq req) {
        String bankAccountJson = gson.toJson(req.getSettlementAccount());
        String[] newArgs = new String[]{bankAccountJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/deleteBankAccount", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo deleteBankAccount(@RequestBody @Valid InvokeChainCodeArgsReq req) {
        return baseService.invokeChainCode(req);
    }

    @RequestMapping(value = "/queryBankAccount", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo queryBankAccount(@RequestBody QueryArgsReq req) {
        req.setArgs(new String[]{"objectType", "enterprise_account"});
        return baseService.getQueryResponse(req);
    }

    @RequestMapping(value = "/queryUserInfo", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo queryUserInfo(@RequestBody QueryArgsReq req) {
        req.setArgs(new String[]{"objectType", "userInfo"});
        return baseService.getQueryResponse(req);
    }


}
