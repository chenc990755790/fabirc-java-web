package com.ideal.blockchain.controller.block;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ideal.blockchain.dto.request.UserDto;
import com.ideal.blockchain.dto.response.ResultInfo;
import com.ideal.blockchain.enums.ResponseCodeEnum;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import com.ideal.blockchain.req.UserInfoReq;
import com.ideal.blockchain.service.block.BaseService;
import com.ideal.blockchain.service.block.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

/**
 * @author: LeonMa
 * @date: 2019/01/10 12:02
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController  {

    private final Gson gson = new GsonBuilder().create();

    @Autowired
    private UserService userService;

    @Autowired
    private BaseService baseService;

    @RequestMapping(value = "/enroll", method = RequestMethod.POST)
    @ResponseBody
    @ApiIgnore
    public ResultInfo enroll(@RequestBody @Valid UserDto user) {
        try {
            String result = userService.register(user.getUserName(), user.getPassWord(), user.getPeerWithOrg(), null);
            return new ResultInfo(ResponseCodeEnum.SUCCESS, result);

        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return new ResultInfo(ResponseCodeEnum.FAILURE, e.getMessage());
        }
    }

    @RequestMapping(value = "/saveUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo saveUserInfo(@RequestBody  UserInfoReq req) {
        try {
            userService.register(req.getUserInfo().getUserId(), req.getUserInfo().getLoginPassword(), req.getPeerWithOrgs()[0], req.getUserInfo().getCompanyId());
            String userInfoJson = gson.toJson(req.getUserInfo());
            String[] newArgs = new String[]{userInfoJson};
            return baseService.invokeChainCode(req, newArgs);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return new ResultInfo(ResponseCodeEnum.FAILURE, "注册企业用户失败，请查看日志");
        }
    }

    @RequestMapping(value = "/modifyUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo modifyUserInfo(@RequestBody @Valid UserInfoReq req) {
        String userInfoJson = gson.toJson(req.getUserInfo());
        String[] newArgs = new String[]{userInfoJson};
        return baseService.invokeChainCode(req, newArgs);
    }

    @RequestMapping(value = "/deleteUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo deleteUserInfo(@RequestBody @Valid InvokeChainCodeArgsReq req) {
        return baseService.invokeChainCode(req);
    }

}
