package com.blockchain.test;

import com.alibaba.fastjson.JSON;
import com.ideal.blockchain.FabricSdkApiStart;
import com.ideal.blockchain.dao.oracle.*;
import com.ideal.blockchain.dao.postgres.BlocksRepository;
import com.ideal.blockchain.dao.postgres.PeerRepository;
import com.ideal.blockchain.dao.postgres.TransactionsRepository;
import com.ideal.blockchain.entity.postgres.Blocks;
import com.ideal.blockchain.entity.postgres.Peer;
import com.ideal.blockchain.entity.postgres.TransactionStatics;
import com.ideal.blockchain.entity.postgres.Transactions;
import com.ideal.blockchain.entity.saas.*;
import com.ideal.blockchain.req.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = FabricSdkApiStart.class)
@AutoConfigureMockMvc
//@MapperScan("com.ideal.blockchain.dao.mapper")
public class JunitTest {

    @Autowired
    private MockMvc mockMvc;

    private final EnterpriseInfoReq req = new EnterpriseInfoReq("chenchao", "123456", "bhfaechannel",
            "java0416", "1.0", "peerOrg1", new String[]{"peerOrg1"}, "saveEnterpriseInfo", new String[]{});
    private final InvoiceInfoReq InvoiceInfoReq = new InvoiceInfoReq("chenchao", "123456", "bhfaechannel",
            "java0416", "1.0", "peerOrg1", new String[]{"peerOrg1"}, "saveEnterpriseInvoice", new String[]{});

    private final SettlementAccountReq SettlementAccountReq = new SettlementAccountReq("chenchao", "123456", "bhfaechannel",
            "java0416", "1.0", "peerOrg1", new String[]{"peerOrg1"}, "saveSettlementAccount", new String[]{});

    private final UserInfoReq UserInfoReq = new UserInfoReq("chenchao", "123456", "bhfaechannel",
            "java0416", "1.0", "peerOrg1", new String[]{"peerOrg1"}, "saveUserInfo", new String[]{});

    private final ReceivableReq ReceivableReq = new ReceivableReq("chenchao", "123456", "bhfaechannel",
            "java0416", "1.0", "peerOrg1", new String[]{"peerOrg1"}, "saveReceivable", new String[]{});

//    @Autowired
//    private EnterpriseInfoRepository enterpriseInfoRepository;
//    @Autowired
//    private InvoiceRepository invoiceRepository;
//    @Autowired
//    private ReceivableRepository receivableRepository;
//    @Autowired
//    private SettlementAccountRepository settlementAccountRepository;
//    @Autowired
//    private UserInfoRepository userInfoRepository;
    @Autowired
    private BlocksRepository blocksRepository;
    @Autowired
    private PeerRepository peerRepository;
    @Autowired
    private TransactionsRepository transactionsRepository;

    @Test
    public void testPost(){
        List<Blocks> all = blocksRepository.findAll();
        System.out.println(all.size());
        System.out.println(all);
    }

//    @Test
//    public void test0() {
//        Optional<EnterpriseInfo> byId = enterpriseInfoRepository.findById("100180");
//        System.out.println(byId);
//        long count = enterpriseInfoRepository.count();
//        System.out.println(count);
//    }
//
//    @Test
//    public void uploadAllEnterpriseInfo() throws Exception {
//        List<EnterpriseInfo> all = enterpriseInfoRepository.findAll();
//        for (EnterpriseInfo info : all) {
//            req.setEnterpriseInfo(info);
//            MvcResult mvcResult = mockMvc.perform(
//                    post("/enterprise/saveEnterpriseInfo")
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content(JSON.toJSONString(req)))
//                    .andReturn();
//            System.out.println(mvcResult.getResponse().getContentAsString());
//        }
//        //75
//    }
//
//    @Test
//    public void uploadInvoice()throws Exception {
//        List<InvoiceInfo> all = invoiceRepository.findAll();
//        for (InvoiceInfo info : all) {
//            InvoiceInfoReq.setInvoiceInfo(info);
//            MvcResult mvcResult = mockMvc.perform(
//                    post("/enterprise/saveInvoice")
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content(JSON.toJSONString(InvoiceInfoReq)))
//                    .andReturn();
//            System.out.println(mvcResult.getResponse().getContentAsString());
//        }
//        System.out.println(all.size());//13
//    }
//    //不考录私密数据
//    @Test
//    public void uploadReceive()throws Exception{
//        List<Receivable> all = receivableRepository.findAll();
//        for (Receivable info : all) {
//            ReceivableReq.setReceivable(info);
//            MvcResult mvcResult = mockMvc.perform(
//                    post("/receivable/saveReceivable")
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content(JSON.toJSONString(ReceivableReq)))
//                    .andReturn();
//            System.out.println(mvcResult.getResponse().getContentAsString());
//        }
//        System.out.println(all.size());//
//    }
//
//    @Test
//    public void uploadSettleAccount()throws Exception{
//        List<SettlementAccount> all = settlementAccountRepository.findAll();
//        for (SettlementAccount info : all) {
//            SettlementAccountReq.setSettlementAccount(info);
//            MvcResult mvcResult = mockMvc.perform(
//                    post("/enterprise/saveBankAccount")
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content(JSON.toJSONString(SettlementAccountReq)))
//                    .andReturn();
//            System.out.println(mvcResult.getResponse().getContentAsString());
//        }
//        System.out.println(all.size());//120
//    }
//
//    @Test
//    public void uploadUserInfo() throws Exception{
//        List<UserInfo> all = userInfoRepository.findAll();
//        for (UserInfo info : all) {
//            UserInfoReq.setUserInfo(info);
//            MvcResult mvcResult = mockMvc.perform(
//                    post("/user/saveUserInfo")
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content(JSON.toJSONString(UserInfoReq)))
//                    .andReturn();
//            System.out.println(mvcResult.getResponse().getContentAsString());
//        }
//        System.out.println(all.size());//229
//    }

    @Test
    public void testPeer(){
        List<Peer> all = peerRepository.findAll();
        for (Peer peer :all) {

        }
    }

    @Test
    public void test(){
        int i = blocksRepository.countByCreatedt("2020-05-14", "2020-05-20");
        System.out.println(i);
        Page<Blocks> blocks = blocksRepository.queryByCreatedt("2020-05-14","2020-05-20",PageRequest.of(2,20));
        System.out.println(blocks);

//        Page<Blocks> byIdBetween = blocksRepository.findByIdBetween(1, 200,PageRequest.of(1,10));
//        System.out.println(byIdBetween.getContent());
//        Page<Blocks> byTxcountEquals = blocksRepository.findByTxcountEquals(1, PageRequest.of(1, 10));
//        System.out.println(byTxcountEquals);
    }





}
