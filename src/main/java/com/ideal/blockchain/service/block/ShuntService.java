package com.ideal.blockchain.service.block;

import com.ideal.blockchain.config.DataSourcePostgresConfig;
import com.ideal.blockchain.dto.request.BlockDto;
import com.ideal.blockchain.dto.response.ResultInfo;
import com.ideal.blockchain.enums.ResponseCodeEnum;
import com.ideal.blockchain.req.ShuntReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

@Service
@Slf4j
public class ShuntService extends BaseService {

    @Autowired
    private BlockService blockService;

    @Autowired
    private UserService userService;

    @Autowired
    private DataSourcePostgresConfig dataSourcePostgresConfig;

    public ResultInfo saveFactoring(ShuntReq req, String userName, String password) {
        invokeReq.setFunction("saveFactoring");
        return invokeChain(req, userName, password);
    }

    public ResultInfo saveTransfer(ShuntReq req, String userName, String password) {
        invokeReq.setFunction("saveTransfer");
        return invokeChain(req, userName, password);
    }

    public ResultInfo saveEnterprise(ShuntReq req, String userName, String password) {
        invokeReq.setFunction("saveEnterprise");
        return invokeChain(req, userName, password);
    }

    public ResultInfo blockInfoByTxIds(BlockDto blockDto) throws Exception {
        userService.loadUserFromPersistence(blockDto.getUserName(), blockDto.getPassWord(), blockDto.getPeerWithOrg());
        ArrayList<Object> blockList = new ArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(blockDto.getTxIdList().length);
        Semaphore semaphore = new Semaphore(10);
        for (int i = 0; i < blockDto.getTxIdList().length; i++) {
            semaphore.acquire();
            blockService.asynGetBlockByTxId(semaphore,blockList, blockDto, countDownLatch, i);
        }
        countDownLatch.await();
        return new ResultInfo(ResponseCodeEnum.SUCCESS, blockList);
    }


}

