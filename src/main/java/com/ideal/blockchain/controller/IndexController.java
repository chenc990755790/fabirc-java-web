package com.ideal.blockchain.controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ideal.blockchain.dao.model.FabricCaUser;
import com.ideal.blockchain.dto.response.ResultInfo;
import com.ideal.blockchain.entity.saas.*;
import com.ideal.blockchain.enums.ResponseCodeEnum;
import com.ideal.blockchain.req.BaseReq;
import com.ideal.blockchain.req.QueryArgsReq;
import com.ideal.blockchain.service.FabricCaUserServiceImpl;
import com.ideal.blockchain.service.block.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    private FabricCaUserServiceImpl fabricCaUserService;

    @Autowired
    private BaseService baseService;

    protected Gson gson = new GsonBuilder().create();

    @Autowired
    @Qualifier("queryArgsReq")
    private QueryArgsReq chaincodeNameReq;

    @PostMapping("/login")
    @ResponseBody
    public ResultInfo login(@RequestBody BaseReq req) {
        FabricCaUser fabricCaUser = fabricCaUserService.selFabricCaUserByNameAndEnrollmentSecret(req.getUserName(), chaincodeNameReq.getPeerWithOrg(), req.getPassWord());
        if (fabricCaUser == null) {
            return new ResultInfo(ResponseCodeEnum.FAILURE, "用户名或密码错误");
        }
        chaincodeNameReq.setUserName(req.getUserName());
        chaincodeNameReq.setPassWord(req.getPassWord());
        return new ResultInfo(ResponseCodeEnum.SUCCESS);
    }

    @PostMapping("/getEnterpriseByIdOrName")
    @ResponseBody
    public ResultInfo getEnterpriseByIdOrName(@RequestBody String companyId) {
        chaincodeNameReq.setArgs(new String[]{"objectType", "\"enterpriseInfo\"", "$or", getIdOrNameString(companyId)});
        chaincodeNameReq.setFunction("queryByReges");
        String s = baseService.getQueryResponse(chaincodeNameReq).getData().toString();
        EnterpriseInfo[] enterpriseInfos = gson.fromJson(s, EnterpriseInfo[].class);
        return new ResultInfo(ResponseCodeEnum.SUCCESS, enterpriseInfos);
    }

    private String getIdOrNameString(String args) {
        return "[\n" +
                "         {" +
                "            \"companyName\": {" +
                "               \"$regex\": \"" + args + "\"" +
                "            }" +
                "         }," +
                "         {" +
                "            \"companyId\": {\n" +
                "               \"$regex\": \"" + args + "\"" +
                "            }" +
                "         }" +
                "      ]";
    }

    @PostMapping("/getInvoiceById")
    @ResponseBody
    public ResultInfo getInvoiceByIdOrName(@RequestBody String companyId) {
        chaincodeNameReq.setArgs(new String[]{"objectType", "enterprise_invoice", "companyId", companyId});
        chaincodeNameReq.setFunction("richQuery");
        String s = baseService.getQueryResponse(chaincodeNameReq).getData().toString();
        InvoiceInfo[] invoiceInfos = gson.fromJson(s, InvoiceInfo[].class);
        return new ResultInfo(ResponseCodeEnum.SUCCESS, invoiceInfos);
    }

    @PostMapping("/getUserInfoById")
    @ResponseBody
    public ResultInfo getUserInfoById(@RequestBody String companyId) {
        chaincodeNameReq.setArgs(new String[]{"objectType", "userInfo", "companyId", companyId});
        chaincodeNameReq.setFunction("richQuery");
        String s = baseService.getQueryResponse(chaincodeNameReq).getData().toString();
        UserInfo[] userInfos = gson.fromJson(s, UserInfo[].class);
        return new ResultInfo(ResponseCodeEnum.SUCCESS, userInfos);
    }

    @PostMapping("/getSettleAccountById")
    @ResponseBody
    public ResultInfo getSettleAccountById(@RequestBody String companyId) {
        chaincodeNameReq.setArgs(new String[]{"objectType", "enterprise_account", "companyId", companyId});
        String s = baseService.getQueryResponse(chaincodeNameReq).getData().toString();
        chaincodeNameReq.setFunction("richQuery");
        SettlementAccount[] settlementAccounts = gson.fromJson(s, SettlementAccount[].class);
        return new ResultInfo(ResponseCodeEnum.SUCCESS, settlementAccounts);
    }

    @PostMapping("/getReceivableById")
    @ResponseBody
    public ResultInfo getReceivableById(@RequestBody String companyId) {
        chaincodeNameReq.setArgs(new String[]{"objectType", "\"receivable\"", "$or", getString(companyId)});
        chaincodeNameReq.setFunction("queryByReges");
        String s = baseService.getQueryResponse(chaincodeNameReq).getData().toString();
        Receivable[] receivables = gson.fromJson(s, Receivable[].class);
        return new ResultInfo(ResponseCodeEnum.SUCCESS, receivables);
    }

    private String getString(String args) {
        return "[\n" +
                "         {" +
                "            \"issueEnterpriseId\": {" +
                "               \"$regex\": \"" + args + "\"" +
                "            }" +
                "         }," +
                "         {" +
                "            \"acceptEnterpriseId\": {\n" +
                "               \"$regex\": \"" + args + "\"" +
                "            }" +
                "         }" +
                "      ]";
    }

}
