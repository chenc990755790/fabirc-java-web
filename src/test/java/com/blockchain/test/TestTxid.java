package com.blockchain.test;

import com.alibaba.fastjson.JSON;
import com.ideal.blockchain.FabricSdkApiStart;
import com.ideal.blockchain.dto.request.BlockDto;
import com.ideal.blockchain.entity.saas.SettlementAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FabricSdkApiStart.class)
@AutoConfigureMockMvc
public class TestTxid {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void queryTxid() throws Exception {
        BlockDto o = new BlockDto();
        o.setUserName("shengnan");
        o.setPassWord("123456");
        o.setChannelName("bhfaechannel");
        o.setPeerWithOrg("peerOrg1");
        o.setTxIdList(new String[]{"f2cb6f131cf070f3f9ce01c4dc2ab945ffe935499ccf23e19b1922184739780e",
                "51906e864a878e60119408fad288b3b06366a0861b0cffa332f887452be4f54c",
                "8f0e749c6be08f85454627f038ebe00cd4ab7085984f2a7213eec443dc3ebce4",
                "e7e6dcb88500f2b8d6b1d55eb8950e74bbb185e7c9d6223ef333161ed7a16abe",
                "503ed412001009985dd97c28232cc534504fe2118110c41461ed3c053da42104",
                "edf3d338c18d1260679908ec478e034a3bbb83543397ca8d34731eedd26c2792",
                "ea8625db1767e8aa18e23a67719108dfee22004bb83ce12a24297ef2dba9ac5d",
                "cd68d085809e394a0ca0df2e8f5f0cd66df5f381b0c00cfcc6aa110ed45221df",
                "14fef767641a9ff4972a5e10082dbff1aaebe275920e4e48fa30bcd2888caf6f",
                "5f35650ff582075c19bf97acf9a96fdb1b23b78a1210c9425d681e1d670a17d8",
                "061f78ae593b158095629e6771db934309055de072c3dc8c1e1040f668a17560",
                "e093b7021bf18396506632b7848bb35bb3349ba90bbbf29eab2a5072a3de1302",
                "c1816b7b0c81b41139bc04032f6d2607e894d426d3d97b5d4921dd168afd292b",
                "fbc732df41d0fcd229bc4e81332b6d9782ce38a6a542fbb31fc70a9bbaf07d8f",
                "76e93dbc6a8f406dcbada1418d42f0daa0c6c2af574760f2196fd1b3d8639fe3",
                "ba3891d95627576bd322bf6a3e6b4b68a908c8cdfeb97a2535fc3a905c05813d",
                "00b919b118a3288368485a5898081e54cee08f0bd05283cc8bdf16a81b865411",
                "5733b3e35d5154d1cfea33e4ca781464f7b0acf668fd2e3925f1cd02b2b03266",
                "0b3f4d23448165048aa1bebf6892b955d8966743f64e7b4c9ed8790dac51f652"});
        long millis = System.currentTimeMillis();
        MvcResult mvcResult = mockMvc.perform(
                post("/blockInfo/withTxid")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(o)))
                .andReturn();
//        System.out.println("返回值数量"+mvcResult);
        long l = System.currentTimeMillis() - millis;
        System.out.println(l);
        System.out.println("返回值"+mvcResult.getResponse().getContentAsString());
    }

}
