package com.ideal.blockchain.controller;

import com.ideal.blockchain.config.ChannelContext;
import com.ideal.blockchain.dao.mapper.PrivateCollectionMapper;
import com.ideal.blockchain.dto.response.ResultInfo;
import com.ideal.blockchain.enums.ResponseCodeEnum;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import com.ideal.blockchain.req.QueryArgsReq;
import com.ideal.blockchain.service.block.ChainCodeService;
import com.ideal.blockchain.service.block.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BaseController {

    @Autowired
    private ChainCodeService chainCodeService;

    @Autowired
    private UserService userService;

    @Resource
    private PrivateCollectionMapper privateCollectionMapper;

    protected static String[] addArgsForCollectionName(String colName,String[] args){
        String[] newArgs = new String[args.length+1];
        System.arraycopy(args,0,newArgs,1,args.length);
        newArgs[0] = colName;
        return newArgs;
    }

    protected ResultInfo invokeChainCode(InvokeChainCodeArgsReq req) {
        return invokeChainCode(req, null);
    }

    protected ResultInfo invokeChainCode(InvokeChainCodeArgsReq req, String[] args) {
        try {
            String uname = req.getUserName();
            String [] newArgs = args == null ?  req.getArgs() : args;
            String result = userService.loadUserFromPersistence(uname, req.getPassWord(), req.getBelongWithOrg());
            if (result == "Successfully loaded member from persistence") {
                String response = chainCodeService
                        .invokeChaincode(uname, req.getBelongWithOrg(), req.getPeerWithOrgs(), req.getChannelName(), req.getChainCodeName(),
                                req.getFunction(), newArgs, req.getChainCodeVersion());
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

    protected ResultInfo queryPrivateChainCode(QueryArgsReq req) {
        try {
            String uname = req.getUserName();
            String result = userService.loadUserFromPersistence(uname, req.getPassWord(), req.getPeerWithOrg());
            if (result == "Successfully loaded member from persistence") {
                String companyId = userService.getCompanyIdByName(uname);
                if (StringUtils.isEmpty(companyId)){
                    return new ResultInfo(ResponseCodeEnum.FAILURE, "userName companyId is empty");
                }
                List<String> list = privateCollectionMapper.getCollectionNameList(companyId);
                if (StringUtils.isEmpty(list)){
                    return new ResultInfo(ResponseCodeEnum.FAILURE, "collectionName is not exist");
                }
                List<String> responseList = new ArrayList<>();
                for (String collectionName:list){
                    String[] args = addArgsForCollectionName(userService.getCollectionName(collectionName),req.getArgs());
                    String response = chainCodeService.queryChainCode(uname, req.getPeerWithOrg(), req.getChannelName(),
                            req.getChainCodeName(), req.getFunction(), args, req.getChainCodeVersion());
                    if (response != "Caught an exception while quering chaincode") {
                        responseList.add(response);
                    } else {
                        return new ResultInfo(ResponseCodeEnum.FAILURE, response);
                    }
                }
                return new ResultInfo(ResponseCodeEnum.FAILURE, responseList);
            } else {
                return new ResultInfo(ResponseCodeEnum.FAILURE, "Something went wrong");
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return new ResultInfo(ResponseCodeEnum.FAILURE, e.getMessage());
        }finally {
            ChannelContext.clear();
        }
    }
}
