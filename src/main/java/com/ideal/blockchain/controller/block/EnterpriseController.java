package com.ideal.blockchain.controller.block;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ideal.blockchain.config.ChannelContext;
import com.ideal.blockchain.controller.BaseController;
import com.ideal.blockchain.dto.request.EnterpriseReq;
import com.ideal.blockchain.dto.request.InvokeChainCodeArgsDto;
import com.ideal.blockchain.dto.response.ResultInfo;
import com.ideal.blockchain.entity.Enterprise;
import com.ideal.blockchain.enums.ResponseCodeEnum;
import com.ideal.blockchain.service.block.ChainCodeService;
import com.ideal.blockchain.service.block.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/enterprise")
public class EnterpriseController extends BaseController {

    private final Gson gson = new GsonBuilder().create();

    @Autowired
    private ChainCodeService chainCodeService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo invokeChaincode(@RequestBody EnterpriseReq chaincodeDto) {
        try {
            if (StringUtils.isEmpty(chaincodeDto.getUserName())) {
                return new ResultInfo(ResponseCodeEnum.FAILURE, "please enter username in reques body!");
            }
//            if (StringUtils.isEmpty(chaincodeDto.getPassWord())) {
//                return new ResultInfo(ResponseCodeEnum.FAILURE, "please enter passwords in request body");
//            }
            if ((chaincodeDto.getFunction()) == null) {
                return new ResultInfo(ResponseCodeEnum.FAILURE, "function not present in method body");
            }

            if ((chaincodeDto.getPeerWithOrgs()) == null || chaincodeDto.getPeerWithOrgs().length == 0) {
                return new ResultInfo(ResponseCodeEnum.FAILURE, "please enter peerWithOrgs in request body");
            }
            if (StringUtils.isEmpty(chaincodeDto.getBelongWithOrg())) {
                return new ResultInfo(ResponseCodeEnum.FAILURE, "please enter peerWithOrg in request body");
            }
            if (StringUtils.isEmpty(chaincodeDto.getChannelName())) {
                return new ResultInfo(ResponseCodeEnum.FAILURE, "please enter channelName in request body");
            }
            if (StringUtils.isEmpty(chaincodeDto.getChainCodeName())) {
                return new ResultInfo(ResponseCodeEnum.FAILURE, "please enter ChainCodeName in request body");
            }
            if (StringUtils.isEmpty(chaincodeDto.getChainCodeVersion())) {
                return new ResultInfo(ResponseCodeEnum.FAILURE, "please enter ChainCodeVersion in request body");
            }
            if (chaincodeDto.getEnterprise() == null) {
                return new ResultInfo(ResponseCodeEnum.FAILURE, "args not present in method body");
            }
            String uname = chaincodeDto.getUserName();
            String result = userService.loadUserFromPersistence(uname, chaincodeDto.getPassWord(), chaincodeDto.getBelongWithOrg());
            if (result == "Successfully loaded member from persistence") {
                Enterprise enterprise = chaincodeDto.getEnterprise();
                String entergson = gson.toJson(enterprise);
                String[] newArgs = addArgsForCollectionName(userService.getCollectionName(uname), new String[]{entergson});
                String response = chainCodeService.invokeChaincode(uname, chaincodeDto.getBelongWithOrg(), chaincodeDto.getPeerWithOrgs(), chaincodeDto.getChannelName(),
                        chaincodeDto.getChainCodeName(), chaincodeDto.getFunction(), newArgs, chaincodeDto.getChainCodeVersion());
                if (response == "Transaction invoked successfully") {
                    return new ResultInfo(ResponseCodeEnum.SUCCESS, response);
                } else {
                    return new ResultInfo(ResponseCodeEnum.FAILURE, response);
                }
            } else {
                return new ResultInfo(ResponseCodeEnum.FAILURE, "Something went wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return new ResultInfo(ResponseCodeEnum.FAILURE, e.getMessage());
        } finally {
            ChannelContext.clear();
        }
    }
}
