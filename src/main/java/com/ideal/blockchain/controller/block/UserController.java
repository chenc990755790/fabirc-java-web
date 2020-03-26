package com.ideal.blockchain.controller.block;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ideal.blockchain.controller.BaseController;
import com.ideal.blockchain.dto.request.UserDto;
import com.ideal.blockchain.dto.response.ResultInfo;
import com.ideal.blockchain.entity.UserInfo;
import com.ideal.blockchain.enums.ResponseCodeEnum;
import com.ideal.blockchain.req.EnterpriseReq;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import com.ideal.blockchain.req.UserInfoReq;
import com.ideal.blockchain.service.block.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author: LeonMa
 * @date: 2019/01/10 12:02
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private final Gson gson = new GsonBuilder().create();

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/enroll", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo enroll(@RequestBody UserDto user) {
        try {
            if (StringUtils.isEmpty(user.getUserName())) {
                return new ResultInfo(ResponseCodeEnum.FAILURE, "please enter username in reques body!");
            }
//            if (StringUtils.isEmpty(user.getPassWord())) {
//                return new ResultInfo(ResponseCodeEnum.FAILURE, "please enter password in request body");
//            }
            if (StringUtils.isEmpty(user.getPeerWithOrg())) {
                return new ResultInfo(ResponseCodeEnum.FAILURE, "please enter peerWithOrg in request body");
            }
            String result;
            if (StringUtils.isEmpty(user.getCollectionName())) {
                 result = userService.register(user.getUserName(), user.getPassWord(), user.getPeerWithOrg());
            } else {
                result = userService.register(user.getUserName(), user.getPassWord(), user.getPeerWithOrg(),user.getCollectionName());
            }
            return new ResultInfo(ResponseCodeEnum.SUCCESS, result);

        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return new ResultInfo(ResponseCodeEnum.FAILURE, e.getMessage());
        }
    }

    @RequestMapping(value = "/saveUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveUserInfo(@RequestBody @Validated UserInfoReq req) {
        String userInfoJson = gson.toJson(req.getUserInfo());
        String[] newArgs = new String[] {userInfoJson};
        return invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/modifyUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo modifyUserInfo(@RequestBody @Valid UserInfoReq req) {
        String userInfoJson = gson.toJson(req.getUserInfo());
        String[] newArgs = new String[] {userInfoJson};
        return invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/deleteUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo deleteUserInfo(@RequestBody @Valid InvokeChainCodeArgsReq req) {
        return invokeChainCode(req);
    }

}
