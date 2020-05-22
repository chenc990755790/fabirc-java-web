package com.ideal.blockchain.controller.postgres;

import com.ideal.blockchain.dao.postgres.TransactionsRepository;
import com.ideal.blockchain.dto.response.ResultInfo;
import com.ideal.blockchain.entity.postgres.Blocks;
import com.ideal.blockchain.entity.postgres.Transactions;
import com.ideal.blockchain.enums.ResponseCodeEnum;
import com.ideal.blockchain.req.DateRequest;
import com.ideal.blockchain.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import java.util.Date;

@RestController
@Slf4j
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionsRepository transactionsRepository;

    @RequestMapping(value = "/queryTransactionsData", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo queryTransactionsData(DateRequest request) {
        if (StringUtils.isEmpty(request.getStartDate())) {
            request.setStartDate(DateUtil.DEFAULT_START_DATE);
        }
        if (StringUtils.isEmpty(request.getEndDate()) ){
            request.setEndDate(DateUtil.formatDate(new Date()));
        }
        int i = transactionsRepository.countByCreatedt(request.getStartDate(), request.getEndDate());
        if (i==0) {
            new ResultInfo(ResponseCodeEnum.SUCCESS, null,0);
        }
        Page<Transactions> blocks = transactionsRepository.queryByCreatedt(request.getStartDate(),
                request.getEndDate(), PageRequest.of(request.getCurrentPage()-1, request.getPageSize()));
        return new ResultInfo(ResponseCodeEnum.SUCCESS, blocks.getContent(),i);
    }
}
