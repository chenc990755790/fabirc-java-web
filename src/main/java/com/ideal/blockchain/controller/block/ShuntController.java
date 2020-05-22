package com.ideal.blockchain.controller.block;

import com.ideal.blockchain.dto.response.ResultInfo;
import com.ideal.blockchain.entity.factoring.AssetTransfer;
import com.ideal.blockchain.entity.factoring.Enterprise;
import com.ideal.blockchain.entity.factoring.Factoring;
import com.ideal.blockchain.enums.BlockBusinessTypeEnum;
import com.ideal.blockchain.enums.ResponseCodeEnum;
import com.ideal.blockchain.req.ShuntReq;
import com.ideal.blockchain.service.block.ShuntService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
public class ShuntController {

    @Resource
    private ShuntService shuntService;

    @RequestMapping("/shunt")
    @ResponseBody
    public ResultInfo shunt(@Valid @RequestBody ShuntReq req, @RequestHeader String username, @RequestHeader String password,BindingResult result) {
        if (result.hasErrors()) {
            return new ResultInfo(ResponseCodeEnum.FAILURE, result.getFieldError().getDefaultMessage());
        } else {
            if (req.getBlockBusinessType().equals(BlockBusinessTypeEnum.FACTORING.getCode())) {
                ShuntReq<Factoring> reqData = req;
                return shuntService.saveFactoring(reqData, username, password);
            } else if (req.getBlockBusinessType().equals(BlockBusinessTypeEnum.TRANSFER.getCode())) {
                ShuntReq<AssetTransfer> reqData = req;
                return shuntService.saveTransfer(req, username, password);
            } else if (req.getBlockBusinessType().equals(BlockBusinessTypeEnum.ENTERPRISE.getCode())) {
                ShuntReq<Enterprise> reqData = req;
                return shuntService.saveEnterprise(reqData, username, password);
            } else {
                return new ResultInfo(ResponseCodeEnum.FAILURE, "参数类型错误");
            }
        }
    }
}
