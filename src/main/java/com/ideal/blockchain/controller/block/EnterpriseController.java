package com.ideal.blockchain.controller.block;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ideal.blockchain.controller.BaseController;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import com.ideal.blockchain.dto.response.ResultInfo;
import com.ideal.blockchain.req.EnterpriseReq;
import com.ideal.blockchain.req.InvoiceInfoReq;
import com.ideal.blockchain.req.SettlementAccountReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/enterprise")
public class EnterpriseController extends BaseController {

    private final Gson gson = new GsonBuilder().create();

    @RequestMapping(value = "/saveEnterprise", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveEnterprise(@RequestBody @Validated EnterpriseReq req) {
        String enterpriseJson = gson.toJson(req.getEnterprise());
        String[] newArgs = new String[] {enterpriseJson};
        return invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/modifyEnterprise", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo modifyEnterprise(@RequestBody @Valid EnterpriseReq req) {
        String enterpriseJson = gson.toJson(req.getEnterprise());
        String[] newArgs = new String[] {enterpriseJson};
        return invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/deleteEnterprise", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo deleteEnterprise(@RequestBody @Valid InvokeChainCodeArgsReq req) {
        return invokeChainCode(req);
    }

    @RequestMapping(value = "/saveInvoice", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveInvoiceInfo(@RequestBody @Valid InvoiceInfoReq req) {
        String invoiceJson = gson.toJson(req.getInvoiceInfo());
        String[] newArgs = new String[] {invoiceJson};
        return invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/modifyInvoice", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo modifyInvoiceInfo(@RequestBody @Valid InvoiceInfoReq req) {
        String invoiceJson = gson.toJson(req.getInvoiceInfo());
        String[] newArgs = new String[] {invoiceJson};
        return invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/deleteInvoice", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo deleteInvoiceInfo(@RequestBody @Valid InvokeChainCodeArgsReq req) {
        return invokeChainCode(req);
    }

    @RequestMapping(value = "/saveBankAccount", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveBankAccount(@RequestBody @Valid SettlementAccountReq req) {
        String bankAccountJson = gson.toJson(req.getSettlementAccount());
        String[] newArgs = new String[] {bankAccountJson};
        return invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/modifyBankAccount", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo modifyBankAccount(@RequestBody @Valid SettlementAccountReq req) {
        String bankAccountJson = gson.toJson(req.getSettlementAccount());
        String[] newArgs = new String[] {bankAccountJson};
        return invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/deleteBankAccount", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo deleteBankAccount(@RequestBody @Valid InvokeChainCodeArgsReq req) {
        return invokeChainCode(req);
    }

}
