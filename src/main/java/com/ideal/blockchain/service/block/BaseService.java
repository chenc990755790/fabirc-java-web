package com.ideal.blockchain.service.block;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ideal.blockchain.collection.CollectionParserService;
import com.ideal.blockchain.config.ChannelContext;
import com.ideal.blockchain.dao.mapper.PrivateCollectionMapper;
import com.ideal.blockchain.dto.response.ResultInfo;
import com.ideal.blockchain.enums.ResponseCodeEnum;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import com.ideal.blockchain.req.QueryArgsReq;
import com.ideal.blockchain.req.ShuntReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class BaseService {

    @Autowired
    protected ChainCodeService chainCodeService;

    @Autowired
    protected UserService userService;

    @Autowired
    protected CollectionParserService collectionParserService;

    protected Gson gson = new GsonBuilder().create();
    @Autowired
    protected InvokeChainCodeArgsReq invokeReq;

    @Resource
    private PrivateCollectionMapper privateCollectionMapper;

    public static String[] addArgsForCollectionName(String colName, String[] args) {
        String[] newArgs = new String[args.length + 1];
        System.arraycopy(args, 0, newArgs, 1, args.length);
        newArgs[0] = colName;
        return newArgs;
    }

    public static String[] addArgsForCollectionName(String[] args, String... colName) {
        String[] newArgs = new String[args.length + colName.length];
        System.arraycopy(args, 0, newArgs, 0, args.length);
        System.arraycopy(colName, 0, newArgs, args.length, colName.length);
        return newArgs;
    }

    public ResultInfo invokeChainCode(InvokeChainCodeArgsReq req) {
        return invokeChainCode(req, null);
    }

    public ResultInfo invokeChainCode(InvokeChainCodeArgsReq req, String[] args) {
        try {
            req.setArgs(args != null ? args : req.getArgs());
            userService.loadUserFromPersistence(req.getUserName(), req.getPassWord(), req.getPeerWithOrg());
            String response = chainCodeService
                    .invokeChaincode(req);
            if (response.equals("Transaction invoked Failed")) {
                return new ResultInfo(ResponseCodeEnum.FAILURE, response);
            } else {
                return new ResultInfo(ResponseCodeEnum.SUCCESS, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return new ResultInfo(ResponseCodeEnum.FAILURE, e.getMessage());
        } finally {
            ChannelContext.clear();
        }
    }

    public ResultInfo queryPrivateChainCode(QueryArgsReq req) {
        try {
            userService.loadUserFromPersistence(req.getUserName(), req.getPassWord(), req.getPeerWithOrg());
            String companyId = userService.getCompanyIdByName(req.getUserName());
            Set<String> list;
            if (StringUtils.isEmpty(companyId)) {
                list = collectionParserService.getCollectNameList();
            } else {
                list = privateCollectionMapper.getCollectionNameList(companyId);
            }
            if (CollectionUtils.isEmpty(list)) {
                return new ResultInfo(ResponseCodeEnum.FAILURE, "collectionName is not exist");
            }
            List<String> responseList = new ArrayList<>();
            req.setArgs(new String[]{"objectType", "receivable"});
            req.setArgs(addArgsForCollectionName(Arrays.toString(list.toArray(new String[list.size()])), req.getArgs()));
            String response = chainCodeService.queryChainCode(req);
            if (response != "Caught an exception while quering chaincode") {
                responseList.add(response);
            } else {
                return new ResultInfo(ResponseCodeEnum.FAILURE, response);
            }
            return new ResultInfo(ResponseCodeEnum.SUCCESS, responseList);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return new ResultInfo(ResponseCodeEnum.FAILURE, e.getMessage());
        } finally {
            ChannelContext.clear();
        }
    }

    public ResultInfo getQueryResponse(QueryArgsReq req) {
        try {
            userService.loadUserFromPersistence(req.getUserName(), req.getPassWord(), req.getPeerWithOrg());
            String companyIdByName = userService.getCompanyIdByName(req.getUserName());
            if (io.micrometer.core.instrument.util.StringUtils.isNotEmpty(companyIdByName)) {
                req.setArgs(addArgsForCollectionName(req.getArgs(), "companyId", companyIdByName));
            }
            String response = chainCodeService.queryChainCode(req);
            if (response != "Caught an exception while quering chaincode") {
                return new ResultInfo(ResponseCodeEnum.SUCCESS, response);
            } else {
                return new ResultInfo(ResponseCodeEnum.FAILURE, response);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResultInfo(ResponseCodeEnum.FAILURE, e.getMessage());
        }
    }

    protected ResultInfo invokeChain(ShuntReq req, String userName, String password) {
        log.info("校验用户，密码是否正确");
        invokeReq.setUserName(userName);
        invokeReq.setPassWord(password);
        String[] newArgs = new String[]{JSON.toJSONString(req.getShuntData())};
        return invokeChainCode(invokeReq, newArgs);
    }
}
