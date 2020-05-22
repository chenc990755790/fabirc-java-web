package com.ideal.blockchain.controller.block;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ideal.blockchain.dto.response.ResultInfo;
import com.ideal.blockchain.req.loan.*;
import com.ideal.blockchain.service.block.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController()
@RequestMapping(value = "/asset")
public class WholeController {

    @Autowired
    private BaseService baseService;

    private final Gson gson = new GsonBuilder().create();

    @RequestMapping(value = "/saveAssetInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveAssetInfo(@RequestBody AssetInfoReq req) {
        String assetInfoJson = gson.toJson(req.getAssetInfo());
        String[] newArgs = new String[]{assetInfoJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/saveAuditInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveAuditInfo(@RequestBody AuditInfoReq req) {
        String auditInfoJson = gson.toJson(req.getAuditInfo());
        String[] newArgs = new String[]{auditInfoJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/saveBalance", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveBalance(@RequestBody BalanceReq req) {
        String balanceJson = gson.toJson(req.getBalance());
        String[] newArgs = new String[]{balanceJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/saveBillInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveBillInfo(@RequestBody BillInfoReq req) {
        String billInfoJson = gson.toJson(req.getBillInfo());
        String[] newArgs = new String[]{billInfoJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/saveCapitalDivert", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveCapitalDivert(@RequestBody CapitalDivertReq req) {
        String capitalDivertJson = gson.toJson(req.getCapitalDivert());
        String[] newArgs = new String[]{capitalDivertJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/saveCapitalNotice", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveCapitalNotice(@RequestBody CapitalNoticeReq req) {
        String capitalNoticeJson = gson.toJson(req.getCapitalNotice());
        String[] newArgs = new String[]{capitalNoticeJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/saveCompanyInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveCompanyInfo(@RequestBody CompanyInfoReq req) {
        String companyInfoJson = gson.toJson(req.getCompanyInfo());
        String[] newArgs = new String[]{companyInfoJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/saveCompanyRating", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveCompanyRating(@RequestBody CompanyRatingReq req) {
        String companyRatingJson = gson.toJson(req.getCompanyRating());
        String[] newArgs = new String[]{companyRatingJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/saveContractInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveContractInfo(@RequestBody ContractInfoReq req) {
        String contractInfoJson = gson.toJson(req.getContractInfo());
        String[] newArgs = new String[]{contractInfoJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/saveCustAccountInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveCustAccountInfo(@RequestBody CustAccountInfoReq req) {
        String custAccountInfoJson = gson.toJson(req.getCustAccountInfo());
        String[] newArgs = new String[]{custAccountInfoJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/saveCustInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveCustInfo(@RequestBody CustInfoReq req) {
        String custInfoJson = gson.toJson(req.getCustInfo());
        String[] newArgs = new String[]{custInfoJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/saveCustPayment", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveCustPayment(@RequestBody CustPaymentReq req) {
        String custPaymentJson = gson.toJson(req.getCustPayment());
        String[] newArgs = new String[]{custPaymentJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/saveDetailAsset", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveDetailAsset(@RequestBody DetailAssetReq req) {
        String detailAssetJson = gson.toJson(req.getDetailAsset());
        String[] newArgs = new String[]{detailAssetJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/savePlatAccount", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo savePlatAccount(@RequestBody PlatAccountReq req) {
        String platAccountJson = gson.toJson(req.getPlatAccount());
        String[] newArgs = new String[]{platAccountJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/savePledgeNote", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo savePledgeNote(@RequestBody PledgeNoteReq req) {
        String pledgeNoteJson = gson.toJson(req.getPledgeNote());
        String[] newArgs = new String[]{pledgeNoteJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/saveProductInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveProductInfo(@RequestBody ProductInfoReq req) {
        String productInfoJson = gson.toJson(req.getProductInfo());
        String[] newArgs = new String[]{productInfoJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/saveProjectBasic", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveProjectBasic(@RequestBody ProjectBasicReq req) {
        String projectBasicJson = gson.toJson(req.getProjectBasic());
        String[] newArgs = new String[]{projectBasicJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/saveRepayInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveRepayInfo(@RequestBody RepayInfoReq req) {
        String repayInfoJson = gson.toJson(req.getRepayInfo());
        String[] newArgs = new String[]{repayInfoJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/saveRepayPlan", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveRepayPlan(@RequestBody RepayPlanReq req) {
        String repayPlanJson = gson.toJson(req.getRepayPlan());
        String[] newArgs = new String[]{repayPlanJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/saveSelfProdChange", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveSelfProdChange(@RequestBody SelfProdChangeReq req) {
        String selfProdChangeJson = gson.toJson(req.getSelfProdChange());
        String[] newArgs = new String[]{selfProdChangeJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/saveSelfProdPayment", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveSelfProdPayment(@RequestBody SelfProdPaymentReq req) {
        String SelfProdPaymentJson = gson.toJson(req.getSelfProdPayment());
        String[] newArgs = new String[]{SelfProdPaymentJson};
        return baseService.invokeChainCode(req, newArgs);
    }
}
