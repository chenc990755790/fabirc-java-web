package com.ideal.blockchain.service.block;

import com.ideal.blockchain.config.ChannelContext;
import com.ideal.blockchain.config.HyperledgerConfiguration;
import com.ideal.blockchain.dto.request.BlockDto;
import com.ideal.blockchain.dto.response.BlockMessage;
import com.ideal.blockchain.model.Org;
import com.ideal.blockchain.utils.ByteConvertUtil;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.util.encoders.Hex;
import org.hyperledger.fabric.sdk.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @author: LeonMa
 * @date: 2019/01/10 12:02
 */
@Slf4j
@Service
public class BlockService {

    @Autowired
    private HyperledgerConfiguration hyperledgerConfiguration;

    @Autowired
    private ChannelService channelService;

    public BlockInfo blockchainInfo(String name, String peerWithOrg, String channelName) throws Exception {
        HFClient client = HFClient.createNewInstance();
        hyperledgerConfiguration.checkConfig(client);

        Org sampleOrg = HyperledgerConfiguration.config.getSampleOrg(peerWithOrg);
        client.setUserContext(sampleOrg.getUser(name));
        channelService.reconstructChannel(peerWithOrg, channelName, client);
        Channel channel = ChannelContext.get();

        BlockchainInfo blockchainInfo = channel.queryBlockchainInfo();

        log.info("Channel info for : " + channelName);
        log.info("Channel height: " + blockchainInfo.getHeight());
        String chainCurrentHash = Hex.toHexString(blockchainInfo.getCurrentBlockHash());
        String chainPreviousHash = Hex.toHexString(blockchainInfo.getPreviousBlockHash());
        log.info("Chain current block hash: " + chainCurrentHash);
        log.info("Chain previous block hash: " + chainPreviousHash);

        BlockInfo returnedBlock = channel.queryBlockByNumber(blockchainInfo.getHeight() - 1);
        String previousHash = Hex.toHexString(returnedBlock.getPreviousHash());
        log.info("queryBlockByNumber returned correct block with blockNumber " + returnedBlock.getBlockNumber()
                + " \n previous_hash " + previousHash);

        byte[] hashQuery = returnedBlock.getPreviousHash();
        returnedBlock = channel.queryBlockByHash(hashQuery);
        log.info("queryBlockByHash returned block with blockNumber " + returnedBlock.getBlockNumber());

        return returnedBlock;
    }

    public TransactionInfo blockchainInfo(String name, String peerWithOrg, String channelName, String txId) throws Exception {
        HFClient client = HFClient.createNewInstance();
        hyperledgerConfiguration.checkConfig(client);

        Org sampleOrg = HyperledgerConfiguration.config.getSampleOrg(peerWithOrg);
        client.setUserContext(sampleOrg.getUser(name));
        channelService.reconstructChannel(peerWithOrg, channelName, client);
        Channel channel = ChannelContext.get();

        TransactionInfo transactionInfo = channel.queryTransactionByID(txId);

        return transactionInfo;
    }


    public BlockInfo blockChainInfoByTxnId(String name, String peerWithOrg, String channelName, String txId) throws Exception {
        HFClient client = HFClient.createNewInstance();
        hyperledgerConfiguration.checkConfig(client);

        Org sampleOrg = HyperledgerConfiguration.config.getSampleOrg(peerWithOrg);
        client.setUserContext(sampleOrg.getUser(name));
        channelService.reconstructChannel(peerWithOrg, channelName, client);
        Channel channel = ChannelContext.get();


        BlockInfo blockInfo = channel.queryBlockByTransactionID(txId);
        return blockInfo;
    }

    @Async("taskExecutor")
    public void asynGetBlockByTxId(Semaphore semaphore,List blockList, BlockDto blockDto, CountDownLatch countDownLatch, int i){
        log.info(Thread.currentThread().getName());
        try {
            BlockInfo blockInfo = blockChainInfoByTxnId(blockDto.getUserName(), blockDto.getPeerWithOrg(), blockDto.getChannelName(), blockDto.getTxIdList()[i]);
            BlockMessage blockMessage = new BlockMessage();
            blockMessage.setTxid(blockDto.getTxIdList()[i]);
            blockMessage.setBlockNumber(blockInfo.getBlockNumber());
            blockMessage.setChannelId(blockInfo.getChannelId());
            blockMessage.setDataHash(ByteConvertUtil.bytesToHexString(blockInfo.getDataHash()));
            blockMessage.setPreviousHash(ByteConvertUtil.bytesToHexString(blockInfo.getPreviousHash()));
            blockMessage.setEnvelopeCount(blockInfo.getEnvelopeCount());
            blockMessage.setTransactionCount(blockInfo.getTransactionCount());
            blockMessage.setTransActionsMetaData(ByteConvertUtil.bytesToHexString(blockInfo.getTransActionsMetaData()));
            blockList.add(blockMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
            countDownLatch.countDown();
        }
    }

    public BlockInfo blockChainInfoByNum(String name, String peerWithOrg, String channelName, int num) throws Exception {
        HFClient client = HFClient.createNewInstance();
        hyperledgerConfiguration.checkConfig(client);

        Org sampleOrg = HyperledgerConfiguration.config.getSampleOrg(peerWithOrg);
        client.setUserContext(sampleOrg.getUser(name));
        channelService.reconstructChannel(peerWithOrg, channelName, client);
        Channel channel = ChannelContext.get();


        BlockInfo blockInfo = channel.queryBlockByNumber(num);

        return blockInfo;
    }

}
