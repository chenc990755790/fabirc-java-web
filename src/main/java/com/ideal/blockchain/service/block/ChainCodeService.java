package com.ideal.blockchain.service.block;

import com.ideal.blockchain.config.ChannelContext;
import com.ideal.blockchain.config.HyperledgerConfiguration;
import com.ideal.blockchain.model.Org;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import com.ideal.blockchain.req.QueryArgsReq;
import lombok.extern.slf4j.Slf4j;
import org.hyperledger.fabric.sdk.*;
import org.hyperledger.fabric.sdk.TransactionRequest.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hyperledger.fabric.sdk.Channel.NOfEvents.createNofEvents;

/**
 * @author: LeonMa
 * @date: 2019/01/10 12:01
 */
@Service
@Slf4j
public class ChainCodeService {

    @Autowired
    private HyperledgerConfiguration hyperledgerConfiguration;

    @Autowired
    private ChannelService channelService;

    Type CHAIN_CODE_LANG = Type.JAVA;

    private void waitOnFabric(int additional) {

    }

    public String installChaincode(String name, String peerWithOrg, String channelName,
                                   String chaincodeName, String chainCodeVersion) throws Exception {
        HFClient client = HFClient.createNewInstance();
        hyperledgerConfiguration.checkConfig(client);

        hyperledgerConfiguration.loadOrderersAndPeers(client, peerWithOrg);
        Org sampleOrg = HyperledgerConfiguration.config.getSampleOrg(peerWithOrg);
        client.setUserContext(sampleOrg.getPeerAdmin());

        ChaincodeID chaincodeID = hyperledgerConfiguration.getChaincodeId(chaincodeName, chainCodeVersion);

        log.info("Running channel " + channelName);

        log.info("Creating install proposal");
        InstallProposalRequest installProposalRequest = client.newInstallProposalRequest();
        installProposalRequest.setChaincodeID(chaincodeID);
        installProposalRequest.setChaincodeSourceLocation(new File(HyperledgerConfiguration.PATH
                + "/artifacts/src/github.com/chaincode_java06"));
        installProposalRequest.setChaincodeVersion(chainCodeVersion);
        installProposalRequest.setChaincodeLanguage(CHAIN_CODE_LANG);
        installProposalRequest.setUserContext(sampleOrg.getPeerAdmin());
        log.info("Sending install proposal");
        int numInstallProposal = 0;

        Collection<ProposalResponse> responses;
        Collection<ProposalResponse> successful = new LinkedList<>();
        Collection<ProposalResponse> failed = new LinkedList<>();
        Collection<Peer> peers = sampleOrg.getPeers();
        numInstallProposal = numInstallProposal + peers.size();
        responses = client.sendInstallProposal(installProposalRequest, peers);

        for (ProposalResponse response : responses) {
            if (response.getStatus() == ProposalResponse.Status.SUCCESS) {
                log.info("Successful install proposal response Txid: " + response.getTransactionID() + " from peer " + response.getPeer().getName());
                successful.add(response);
            } else {
                failed.add(response);
            }
        }

        //   }
        log.info("Received " + numInstallProposal + " install proposal responses. Successful+verified: " + successful.size() + " . Failed: " + failed.size());

        if (failed.size() > 0) {
            ProposalResponse first = failed.iterator().next();
            log.error("Not enough endorsers for install :" + successful.size() + ".  " + first.getMessage());
            return "Not enough endorsers for install :" + first.getMessage();
        }


        return "Chaincode installed successfully";

    }


    public String instantiateChaincode(String name, String belongWithOrg, String[] peerWithOrgs, String channelName, String chaincodeName, String chaincodeFunction, String[] chaincodeArgs, String chainCodeVersion) throws Exception {
        HFClient client = HFClient.createNewInstance();
        hyperledgerConfiguration.checkConfig(client);

        client.setUserContext(HyperledgerConfiguration.config.getSampleOrg(belongWithOrg).getPeerAdmin());

        ChaincodeID chaincodeID = hyperledgerConfiguration.getChaincodeId(chaincodeName, chainCodeVersion);
        channelService.reconstructChannel(peerWithOrgs, channelName, client);
        Channel channel = ChannelContext.get();

        log.info("Running channel " + channelName);


        Collection<Orderer> orderers = channel.getOrderers();

        InstantiateProposalRequest instantiateProposalRequest = client.newInstantiationProposalRequest();
        instantiateProposalRequest.setProposalWaitTime(HyperledgerConfiguration.config.getProposalWaitTime());
        instantiateProposalRequest.setChaincodeID(chaincodeID);
        instantiateProposalRequest.setChaincodeLanguage(CHAIN_CODE_LANG);
        instantiateProposalRequest.setFcn(chaincodeFunction);
        instantiateProposalRequest.setArgs(chaincodeArgs);
        instantiateProposalRequest.setChaincodeVersion(chainCodeVersion);
        instantiateProposalRequest.setUserContext(HyperledgerConfiguration.config.getSampleOrg(belongWithOrg).getPeerAdmin());
        instantiateProposalRequest.setChaincodeCollectionConfiguration(ChaincodeCollectionConfiguration.fromYamlFile(
                new File(HyperledgerConfiguration.PATH + "/artifacts/PrivateDataIT.yaml")));
        Map<String, byte[]> tm = new HashMap<>();
        tm.put("HyperLedgerFabric", "InstantiateProposalRequest:JavaSDK".getBytes(UTF_8));
        tm.put("method", "InstantiateProposalRequest".getBytes(UTF_8));
        instantiateProposalRequest.setTransientMap(tm);

        ChaincodeEndorsementPolicy chaincodeEndorsementPolicy = new ChaincodeEndorsementPolicy();
        chaincodeEndorsementPolicy
                .fromYamlFile(new File(HyperledgerConfiguration.PATH + "/artifacts/chaincodeendorsementpolicy.yaml"));
        instantiateProposalRequest.setChaincodeEndorsementPolicy(chaincodeEndorsementPolicy);
        Collection<ProposalResponse> responses;
        Collection<ProposalResponse> successful = new LinkedList<>();
        Collection<ProposalResponse> failed = new LinkedList<>();

        log.info("Sending instantiateProposalRequest to all peers with arguments: " + chaincodeArgs);
        successful.clear();
        failed.clear();

        responses = channel.sendInstantiationProposal(instantiateProposalRequest, channel.getPeers());

        for (ProposalResponse response : responses) {
            if (response.isVerified() && response.getStatus() == ProposalResponse.Status.SUCCESS) {
                successful.add(response);
                log.info("Succesful instantiate proposal response Txid: " + response.getTransactionID() + " from peer " + response.getPeer().getName());
            } else {
                failed.add(response);
            }
        }
        log.info("Received " + responses.size() + " instantiate proposal responses. Successful+verified: " + successful.size() + " . Failed: " + failed.size());
        if (failed.size() > 0) {
            for (ProposalResponse fail : failed) {

                log.info("Not enough endorsers for instantiate :" + successful.size() + "endorser failed with " + fail.getMessage() + ", on peer" + fail.getPeer());

            }
            ProposalResponse first = failed.iterator().next();
            log.error("Not enough endorsers for instantiate :" + successful.size() + "endorser failed with " + first.getMessage() + ". Was verified:" + first.isVerified());
            return "endorser failed";
        }
        log.info("Sending instantiateTransaction to orderer ");
        log.info("orderers" + orderers);
        //Specify what events should complete the interest in this transaction. This is the default
        // for all to complete. It's possible to specify many different combinations like
        //any from a group, all from one group and just one from another or even None(NOfEvents.createNoEvents).
        // See. Channel.NOfEvents
        Channel.NOfEvents nOfEvents = createNofEvents();
        if (!channel.getPeers(EnumSet.of(Peer.PeerRole.EVENT_SOURCE)).isEmpty()) {
            nOfEvents.addPeers(channel.getPeers(EnumSet.of(Peer.PeerRole.EVENT_SOURCE)));
        }
        if (!channel.getEventHubs().isEmpty()) {
            nOfEvents.addEventHubs(channel.getEventHubs());
        }
        String result = channel.sendTransaction(successful, orderers, HyperledgerConfiguration.config.getSampleOrg(belongWithOrg).getPeerAdmin()).thenApply(transactionEvent -> {
            waitOnFabric(0);
//            BlockEvent blockEvent = transactionEvent.getBlockEvent();

            log.info("Finished instantiate transaction with transaction id " + transactionEvent.getTransactionID());
            return "Chaincode instantiated Successfully";
        }).exceptionally(e -> {
            e.printStackTrace();
            log.info(" failed with " + e.getClass().getName() + " exception " + e.getMessage());
            return " failed with " + e.getClass().getName() + " exception " + e.getMessage();
        }).get(HyperledgerConfiguration.config.getTransactionWaitTime(), TimeUnit.SECONDS);

        return result;
    }


    public String invokeChaincode(InvokeChainCodeArgsReq req) throws Exception {

        HFClient client = HFClient.createNewInstance();
        hyperledgerConfiguration.checkConfig(client);

        client.setUserContext(HyperledgerConfiguration.config.getSampleOrg(req.getPeerWithOrg()).getPeerAdmin());

        ChaincodeID chaincodeID = hyperledgerConfiguration.getChaincodeId(req.getChainCodeName(), req.getChainCodeVersion());
        channelService.reconstructChannel(req.getPeerWithOrgs(), req.getChannelName(), client);
        Channel channel = ChannelContext.get();

        log.info("Running channel " + req.getChannelName());


        log.debug("chaincodeFunction" + req.getFunction());
        log.debug("chaincodeArgs" + req.getArgs());


        TransactionProposalRequest transactionProposalRequest = client.newTransactionProposalRequest();
        transactionProposalRequest.setChaincodeID(chaincodeID);
        transactionProposalRequest.setChaincodeLanguage(CHAIN_CODE_LANG);
        transactionProposalRequest.setFcn(req.getFunction());
        transactionProposalRequest.setProposalWaitTime(HyperledgerConfiguration.config.getProposalWaitTime());
        transactionProposalRequest.setArgs(req.getArgs());
        transactionProposalRequest.setChaincodeVersion(req.getChainCodeVersion());
        transactionProposalRequest.setUserContext(HyperledgerConfiguration.config.getSampleOrg(req.getPeerWithOrg()).getUser(req.getUserName()));

//        ChaincodeEndorsementPolicy chaincodeEndorsementPolicy = new ChaincodeEndorsementPolicy();
//        chaincodeEndorsementPolicy
//                .fromYamlFile(new File(PATH + "/artifacts/chaincodeendorsementpolicy.yaml"));
//        transactionProposalRequest.setChaincodeEndorsementPolicy(chaincodeEndorsementPolicy);

        Map<String, byte[]> tm2 = new HashMap<>();
        tm2.put("HyperLedgerFabric", "TransactionProposalRequest:JavaSDK".getBytes(UTF_8));
        tm2.put("method", "TransactionProposalRequest".getBytes(UTF_8));
        tm2.put("result", ":)".getBytes(UTF_8)); /// This should be returned

        Collection<ProposalResponse> successful = new LinkedList<>();
        Collection<ProposalResponse> failed = new LinkedList<>();

        transactionProposalRequest.setTransientMap(tm2);

        log.info("sending transactionProposal to all peers with arguments: " + req.getFunction() + "," + req.getArgs());
        Collection<ProposalResponse> transactionPropResp = channel.sendTransactionProposal(transactionProposalRequest, channel.getPeers());
        for (ProposalResponse response : transactionPropResp) {
            if (response.getStatus() == ProposalResponse.Status.SUCCESS) {
                log.info("Successful transaction proposal response Txid: " + response.getTransactionID() + " from peer " + response.getPeer().getName());
                successful.add(response);
            } else {
                failed.add(response);
            }
        }

        // Check that all the proposals are consistent with each other. We should have only one set
        // where all the proposals above are consistent. Note the when sending to Orderer this is done automatically.
        //  Shown here as an example that applications can invoke and select.
        // See org.hyperledger.mapper.sdk.proposal.consistency_validation config property.
        Collection<Set<ProposalResponse>> proposalConsistencySets = SDKUtils.getProposalConsistencySets(transactionPropResp);
        if (proposalConsistencySets.size() != 1) {
            log.error(format("Expected only one set of consistent proposal responses but got " + proposalConsistencySets.size()));
        }

        log.info("Received " + transactionPropResp.size() + " transaction proposal responses. Successful+verified: " + successful.size() + " . Failed: " + failed.size());
        if (failed.size() > 0) {
            ProposalResponse firstTransactionProposalResponse = failed.iterator().next();
            log.error("Not enough endorsers for invoke:" + failed.size() + " endorser error: " +
                    firstTransactionProposalResponse.getMessage() +
                    ". Was verified: " + firstTransactionProposalResponse.isVerified());
            return firstTransactionProposalResponse.getMessage();
        }
        log.info("Successfully received transaction proposal responses.");
        ProposalResponse resp = successful.iterator().next();
        byte[] x = resp.getChaincodeActionResponsePayload(); // This is the data returned by the chaincode.
        String resultAsString = null;
        if (x != null) {
            resultAsString = new String(x, "UTF-8");
        }
        log.debug("getChaincodeActionResponseReadWriteSetInfo:::"
                + resp.getChaincodeActionResponseReadWriteSetInfo());
        ChaincodeID cid = resp.getChaincodeID();

        ////////////////////////////
        // Send Transaction Transaction to orderer
        log.info("Sending chaincode transaction " + req.getChainCodeName() + "_" + req.getChainCodeVersion() + " to orderer.");
        log.info("transactionID==>" + resp.getTransactionID());
        String result = "";
        try {
            BlockEvent.TransactionEvent event = channel.sendTransaction(successful).get(HyperledgerConfiguration.config.getTransactionWaitTime()
                    , TimeUnit.SECONDS);
            //������ɹ�
            if (event.isValid()) {
                result = resp.getTransactionID();
            } else {
                result = "Transaction invoked Failed";
            }
        } catch (Exception e) {
            log.error("IntermediateChaincodeID==>toOrdererResponse==>Exception:" + e.getMessage());
            result = "Transaction invoked Error";
        }
        log.info("Transaction invoked " + result);
        return result;
    }


    public String queryChainCode(QueryArgsReq req) throws Exception {
        HFClient client = HFClient.createNewInstance();
        hyperledgerConfiguration.checkConfig(client);
        client.setUserContext(HyperledgerConfiguration.config.getSampleOrg(req.getPeerWithOrg()).getPeerAdmin());

        ChaincodeID chaincodeID = hyperledgerConfiguration.getChaincodeId(req.getChainCodeName(), req.getChainCodeVersion());
        channelService.reconstructChannel(req.getPeerWithOrg(), req.getChannelName(), client);
        Channel channel = ChannelContext.get();

        log.info("Running channel " + req.getChannelName());
        QueryByChaincodeRequest queryByChaincodeRequest = client.newQueryProposalRequest();
        queryByChaincodeRequest.setArgs(req.getArgs());
        queryByChaincodeRequest.setFcn(req.getFunction());
        queryByChaincodeRequest.setChaincodeID(chaincodeID);
        queryByChaincodeRequest.setChaincodeVersion(req.getChainCodeVersion());
        queryByChaincodeRequest.setChaincodeLanguage(CHAIN_CODE_LANG);
        queryByChaincodeRequest.setUserContext(HyperledgerConfiguration.config.getSampleOrg(req.getPeerWithOrg()).getUser(req.getUserName()));

        Map<String, byte[]> tm2 = new HashMap<>();
        tm2.put("HyperLedgerFabric", "QueryByChaincodeRequest:JavaSDK".getBytes(UTF_8));
        tm2.put("method", "QueryByChaincodeRequest".getBytes(UTF_8));
        queryByChaincodeRequest.setTransientMap(tm2);


        Collection<ProposalResponse> queryProposals = channel.queryByChaincode(queryByChaincodeRequest, channel.getPeers());
        for (ProposalResponse proposalResponse : queryProposals) {
            if (!proposalResponse.isVerified() || proposalResponse.getStatus() != ProposalResponse.Status.SUCCESS) {
                log.error("Failed query proposal from peer " + proposalResponse.getPeer().getName() + " status: " + proposalResponse.getStatus() +
                        ". Messages: " + proposalResponse.getMessage()
                        + ". Was verified : " + proposalResponse.isVerified());
                throw new Exception(proposalResponse.getMessage());
            } else {
                String payload = proposalResponse.getProposalResponse().getResponse().getPayload().toStringUtf8();
                log.info("Query payload of b from peer" + proposalResponse.getPeer().getName() + " returned " + payload);
                return payload;
            }
        }

        return "Caught an exception while quering chaincode";
    }


    public String updateChaincode(InvokeChainCodeArgsReq req) throws Exception {
        HFClient client = HFClient.createNewInstance();
        hyperledgerConfiguration.checkConfig(client);
        client.setUserContext(HyperledgerConfiguration.config.getSampleOrg(req.getPeerWithOrg()).getPeerAdmin());
        ChaincodeID chaincodeID = hyperledgerConfiguration.getChaincodeId(req.getChainCodeName(), req.getChainCodeVersion());
        channelService.reconstructChannel(req.getPeerWithOrgs(), req.getChannelName(), client);
        Channel channel = ChannelContext.get();

        log.info("Running channel " + req.getChannelName());

        Collection<Orderer> orderers = channel.getOrderers();

        UpgradeProposalRequest upgradeProposalRequest = client.newUpgradeProposalRequest();
        upgradeProposalRequest.setProposalWaitTime(HyperledgerConfiguration.config.getProposalWaitTime());
        upgradeProposalRequest.setChaincodeID(chaincodeID);
        upgradeProposalRequest.setChaincodeLanguage(CHAIN_CODE_LANG);
        upgradeProposalRequest.setFcn(req.getFunction());
        upgradeProposalRequest.setArgs(req.getArgs());
        upgradeProposalRequest.setChaincodeVersion(req.getChainCodeVersion());
        upgradeProposalRequest.setUserContext(HyperledgerConfiguration.config.getSampleOrg(req.getPeerWithOrg()).getPeerAdmin());

        Map<String, byte[]> tm = new HashMap<>();
        tm.put("HyperLedgerFabric", "UpgradeProposalRequest:JavaSDK".getBytes(UTF_8));
        tm.put("method", "UpgradeProposalRequest".getBytes(UTF_8));
        upgradeProposalRequest.setTransientMap(tm);

        ChaincodeEndorsementPolicy chaincodeEndorsementPolicy = new ChaincodeEndorsementPolicy();
        chaincodeEndorsementPolicy
                .fromYamlFile(new File(HyperledgerConfiguration.PATH + "/artifacts/chaincodeendorsementpolicy.yaml"));
        upgradeProposalRequest.setChaincodeEndorsementPolicy(chaincodeEndorsementPolicy);
        upgradeProposalRequest.setChaincodeCollectionConfiguration(ChaincodeCollectionConfiguration.fromYamlFile(
                new File(HyperledgerConfiguration.PATH + "/artifacts/PrivateDataIT.yaml")));
        Collection<ProposalResponse> responses;
        Collection<ProposalResponse> successful = new LinkedList<>();
        Collection<ProposalResponse> failed = new LinkedList<>();

        log.info("Sending instantiateProposalRequest to all peers with arguments: " + req.getArgs());
        successful.clear();
        failed.clear();
        responses = channel.sendUpgradeProposal(upgradeProposalRequest, channel.getPeers());

        for (ProposalResponse response : responses) {
            if (response.isVerified() && response.getStatus() == ProposalResponse.Status.SUCCESS) {
                successful.add(response);
                log.info("Succesful update proposal response Txid: " + response.getTransactionID() + " from peer " + response.getPeer().getName());
            } else {
                failed.add(response);
            }
        }
        log.info("Received " + responses.size() + " update proposal responses. Successful+verified: " + successful.size() + " . Failed: " + failed.size());
        if (failed.size() > 0) {
            for (ProposalResponse fail : failed) {

                log.info("Not enough endorsers for instantiate :" + successful.size() + "endorser failed with " + fail.getMessage() + ", on peer" + fail.getPeer());

            }
            ProposalResponse first = failed.iterator().next();
            log.error("Not enough endorsers for instantiate :" + successful.size() + "endorser failed with " + first.getMessage() + ". Was verified:" + first.isVerified());
        }
        log.info("Sending updateTransaction to orderer ");
        log.info("orderers" + orderers);
        //Specify what events should complete the interest in this transaction. This is the default
        // for all to complete. It's possible to specify many different combinations like
        //any from a group, all from one group and just one from another or even None(NOfEvents.createNoEvents).
        // See. Channel.NOfEvents
        Channel.NOfEvents nOfEvents = createNofEvents();
        if (!channel.getPeers(EnumSet.of(Peer.PeerRole.EVENT_SOURCE)).isEmpty()) {
            nOfEvents.addPeers(channel.getPeers(EnumSet.of(Peer.PeerRole.EVENT_SOURCE)));
        }
        if (!channel.getEventHubs().isEmpty()) {
            nOfEvents.addEventHubs(channel.getEventHubs());
        }
        channel.sendTransaction(successful, orderers, HyperledgerConfiguration.config.getSampleOrg(req.getPeerWithOrg()).getPeerAdmin()).thenApply(transactionEvent -> {
            waitOnFabric(0);
            BlockEvent blockEvent = transactionEvent.getBlockEvent();
            log.info("Finished update transaction with transaction id " + transactionEvent.getTransactionID());
            return "Finished update transaction with transaction id " + transactionEvent.getTransactionID();
        }).exceptionally(e -> {
            e.printStackTrace();
            log.info(" failed with " + e.getClass().getName() + " exception " + e.getMessage());
            return " failed with " + e.getClass().getName() + " exception " + e.getMessage();
        }).get(HyperledgerConfiguration.config.getTransactionWaitTime(), TimeUnit.SECONDS);

        return "Chaincode upgrade Successfully";
    }

}
