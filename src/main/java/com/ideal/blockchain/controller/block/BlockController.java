package com.ideal.blockchain.controller.block;

import com.ideal.blockchain.config.ChannelContext;
import com.ideal.blockchain.dao.postgres.BlocksRepository;
import com.ideal.blockchain.dao.postgres.ChaincodesRepository;
import com.ideal.blockchain.dao.postgres.PeerRepository;
import com.ideal.blockchain.dao.postgres.TransactionsRepository;
import com.ideal.blockchain.dto.request.BlockDto;
import com.ideal.blockchain.dto.response.BlockLatestInfo;
import com.ideal.blockchain.dto.response.ResultInfo;
import com.ideal.blockchain.entity.postgres.Blocks;
import com.ideal.blockchain.entity.postgres.Peer;
import com.ideal.blockchain.entity.postgres.TransactionStatics;
import com.ideal.blockchain.entity.postgres.Transactions;
import com.ideal.blockchain.enums.ResponseCodeEnum;
import com.ideal.blockchain.req.DateRequest;
import com.ideal.blockchain.req.QueryArgsReq;
import com.ideal.blockchain.service.block.ShuntService;
import com.ideal.blockchain.service.postgres.TransactionService;
import com.ideal.blockchain.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.DateUtils;
import org.thymeleaf.util.StringUtils;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author: LeonMa
 * @date: 2019/01/10 12:03
 */
@RestController
@Slf4j
@RequestMapping("/blockInfo")
public class BlockController {

    @Autowired
    private ShuntService shuntService;

    @Autowired
    private BlocksRepository blocksRepository;

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private PeerRepository peerRepository;

    @Autowired
    private ChaincodesRepository chaincodesRepository;

    @Autowired
    private QueryArgsReq queryArgsReq;

    @RequestMapping(value = "/withTxid", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo blockInfoByTxId(@RequestBody @Valid BlockDto blockDto) throws Exception {
        try {
            log.debug(blockDto.getUserName());
            return shuntService.blockInfoByTxIds(blockDto);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return new ResultInfo(ResponseCodeEnum.FAILURE, e.getMessage());
        } finally {
            ChannelContext.clear();
        }

    }

    @RequestMapping(value = "/queryLatestInfo", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo blockInfoByTxId() {
        BlockLatestInfo blockLatestInfo = new BlockLatestInfo();
        blockLatestInfo.setBlocksCount(blocksRepository.count());
        blockLatestInfo.setTransactionsCount(transactionsRepository.count());
        blockLatestInfo.setPeerCount(peerRepository.count());
        blockLatestInfo.setChaincodesCount(chaincodesRepository.count());
        return new ResultInfo(ResponseCodeEnum.SUCCESS,blockLatestInfo);
    }

    @RequestMapping(value = "/queryPeersInfo", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo queryPeersInfo() {
        List<Peer> peerList = peerRepository.findAll();
        return new ResultInfo(ResponseCodeEnum.SUCCESS,peerList);
    }

    @RequestMapping(value = "/queryLatestBlock", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo queryLatestBlock() {
        Sort sort = new Sort(Sort.Direction.DESC, "blocknum");
        List<Blocks> blocksList = blocksRepository.findAll(sort).subList(0,5);
        return new ResultInfo(ResponseCodeEnum.SUCCESS,blocksList);
    }

    @RequestMapping(value = "/queryLatestTransaction", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo queryLatestTransaction() {
        Sort sort = new Sort(Sort.Direction.DESC, "createdt");
        List<Transactions> transactionsList = transactionsRepository.findAll(sort).subList(0,5);
        return new ResultInfo(ResponseCodeEnum.SUCCESS,transactionsList);
    }

    @RequestMapping(value = "/queryTransactionStatusData", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo queryTransactionStatusData() {
        List<TransactionStatics> convert = transactionService.convert();
        return new ResultInfo(ResponseCodeEnum.SUCCESS, convert);
    }

    @RequestMapping(value = "/queryBlocksData", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo queryBlocksData(DateRequest request) {
        if (StringUtils.isEmpty(request.getStartDate())) {
            request.setStartDate(DateUtil.DEFAULT_START_DATE);
        }
        if (StringUtils.isEmpty(request.getEndDate()) ){
            request.setEndDate(DateUtil.formatDate(new Date()));
        }
        int i = blocksRepository.countByCreatedt(request.getStartDate(), request.getEndDate());
        if (i==0) {
            new ResultInfo(ResponseCodeEnum.SUCCESS, null,0);
        }
        Page<Blocks> blocks = blocksRepository.queryByCreatedt(request.getStartDate(),
                request.getEndDate(), PageRequest.of(request.getCurrentPage()-1, request.getPageSize()));
        return new ResultInfo(ResponseCodeEnum.SUCCESS, blocks.getContent(),i);
    }
}
