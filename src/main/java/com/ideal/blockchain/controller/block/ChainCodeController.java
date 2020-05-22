package com.ideal.blockchain.controller.block;

import com.ideal.blockchain.config.ChannelContext;
import com.ideal.blockchain.dao.postgres.ChaincodesRepository;
import com.ideal.blockchain.dto.response.ResultInfo;
import com.ideal.blockchain.enums.ResponseCodeEnum;
import com.ideal.blockchain.req.ChaincodeNameReq;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import com.ideal.blockchain.req.QueryArgsReq;
import com.ideal.blockchain.service.block.ChainCodeService;
import com.ideal.blockchain.service.block.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author: LeonMa
 * @date: 2019/01/10 12:03
 */
@Slf4j
@RestController
@RequestMapping("/chaincode")
public class ChainCodeController {

    @Autowired
    private ChainCodeService chainCodeService;

    @Autowired
    private UserService userService;

    @Autowired
    private ChaincodesRepository chaincodesRepository;

    @RequestMapping(value = "/install", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo installChaincode(@Valid @RequestBody ChaincodeNameReq chaincodeName) {
        try {
            userService.loadUserFromPersistence(chaincodeName.getUserName(), chaincodeName.getPassWord(), chaincodeName.getPeerWithOrg());
            String response = chainCodeService.installChaincode(chaincodeName.getUserName(), chaincodeName.getPeerWithOrg(), chaincodeName.getChannelName(),
                    chaincodeName.getChainCodeName(), chaincodeName.getChainCodeVersion());
            if (response == "Chaincode installed successfully") {
                return new ResultInfo(ResponseCodeEnum.SUCCESS, response);
            } else {
                return new ResultInfo(ResponseCodeEnum.FAILURE, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return new ResultInfo(ResponseCodeEnum.FAILURE, e.getMessage());
        }
    }

    /**
     * takes input as function name (init), arguments , chaincode name and
     * authorization token.
     *
     * @return status as string
     */
    @RequestMapping(value = "/instantiate", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo instantiateChaincode(@RequestBody @Valid InvokeChainCodeArgsReq chaincodeDto) {
        try {
            userService.loadUserFromPersistence(chaincodeDto.getUserName(), chaincodeDto.getPassWord(), chaincodeDto.getPeerWithOrg());
            String response = chainCodeService.instantiateChaincode(chaincodeDto.getUserName(), chaincodeDto.getPeerWithOrg(), chaincodeDto.getPeerWithOrgs(),
                    chaincodeDto.getChannelName(), chaincodeDto.getChainCodeName(), chaincodeDto.getFunction(),
                    chaincodeDto.getArgs(), chaincodeDto.getChainCodeVersion());
            if (response == "Chaincode instantiated Successfully") {
                return new ResultInfo(ResponseCodeEnum.SUCCESS, response);
            } else {
                return new ResultInfo(ResponseCodeEnum.FAILURE, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return new ResultInfo(ResponseCodeEnum.FAILURE, e.getMessage());
        } finally {
            ChannelContext.clear();
        }
    }

    /**
     * takes input as function name (init), arguments , chaincode name and
     * authorization token.
     *
     * @return status as string
     */
    @RequestMapping(value = "/upgrade", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo upgradeChaincode(@RequestBody @Valid InvokeChainCodeArgsReq chaincodeDto) {
        try {
            userService.loadUserFromPersistence(chaincodeDto.getUserName(), chaincodeDto.getPassWord(), chaincodeDto.getPeerWithOrg());
            String response = chainCodeService.updateChaincode(chaincodeDto);
            if (response == "Chaincode upgrade Successfully") {
                return new ResultInfo(ResponseCodeEnum.SUCCESS, response);
            } else {
                return new ResultInfo(ResponseCodeEnum.FAILURE, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return new ResultInfo(ResponseCodeEnum.FAILURE, e.getMessage());
        } finally {
            ChannelContext.clear();
        }
    }

    /**
     * takes input as function name (invoke), arguments , chaincode name and
     * authorization token.
     *
     * @return status as string
     */
    @RequestMapping(value = "/invoke", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo invokeChaincode(@RequestBody @Valid InvokeChainCodeArgsReq chaincodeDto) {
        try {
            userService.loadUserFromPersistence(chaincodeDto.getUserName(), chaincodeDto.getPassWord(), chaincodeDto.getPeerWithOrg());
            String response = chainCodeService.invokeChaincode(chaincodeDto);
            if (response == "Transaction invoked successfully") {
                return new ResultInfo(ResponseCodeEnum.SUCCESS, response);
            } else {
                return new ResultInfo(ResponseCodeEnum.FAILURE, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return new ResultInfo(ResponseCodeEnum.FAILURE, e.getMessage());
        } finally {
            ChannelContext.clear();
        }
    }

    /**
     * @return payload returned from the chaincode
     */
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo queryChaincode(@RequestBody @Valid QueryArgsReq req) {
        try {
            userService.loadUserFromPersistence(req.getUserName(), req.getPassWord(), req.getPeerWithOrg());
            String response = chainCodeService.queryChainCode(req);
            if (response != "Caught an exception while quering chaincode") {
                return new ResultInfo(ResponseCodeEnum.SUCCESS, response);
            } else {
                return new ResultInfo(ResponseCodeEnum.FAILURE, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return new ResultInfo(ResponseCodeEnum.FAILURE, e.getMessage());
        } finally {
            ChannelContext.clear();
        }
    }

    @RequestMapping(value = "/queryChaincodesData", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo queryChaincodesData() {
        return new ResultInfo(ResponseCodeEnum.SUCCESS, chaincodesRepository.findAll());
    }
}
