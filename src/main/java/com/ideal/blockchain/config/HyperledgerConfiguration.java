package com.ideal.blockchain.config;

import com.ideal.blockchain.model.Org;
import lombok.Data;
import org.hyperledger.fabric.sdk.ChaincodeID;
import org.hyperledger.fabric.sdk.HFClient;
import org.hyperledger.fabric.sdk.Peer;
import org.hyperledger.fabric.sdk.security.CryptoSuite;
import org.hyperledger.fabric_ca.sdk.HFCAClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.Properties;

/**
 * @author:
 * @date:
 */
@PropertySource("classpath:hyperledger.properties")
@Component
@Data
public class HyperledgerConfiguration {

    public static String PATH = System.getProperty("user.dir");

    public static Config config ;

    private final ConfigHelper configHelper = new ConfigHelper();

    private Collection<Org> SampleOrgs;

    @Value("${fabric.config}")
    private String fabricConfig;

    @Value("${ADMIN_NAME}")
    private String adminName;

    @Value("${ADMIN_PWD}")
    private String adminPwd;

    private String FIXTURES_PATH = PATH + "/";

    @Value("${CHAIN_CODE_PATH}")
    private String chainCodePath;

    /**
     * checking config at starting
     */
    public void checkConfig(HFClient client) throws Exception {
        config=Config.getConfig(fabricConfig);
        SampleOrgs = config.getSampleOrgs();

        client.setCryptoSuite(CryptoSuite.Factory.getCryptoSuite());

        // Set up hfca for each sample org

        for (Org sampleOrg : SampleOrgs) {
            try {
                sampleOrg.setCAClient(HFCAClient.createNewInstance(sampleOrg.getCALocation(), sampleOrg.getCAProperties()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * checking config at starting
     */
    public void loadOrderersAndPeers(HFClient client, String peerWtihOrg) throws Exception {
        config=Config.getConfig(fabricConfig);
        // Set up hfca for each sample org

        Org sampleOrg = config.getSampleOrg(peerWtihOrg);
        client.setUserContext(sampleOrg.getPeerAdmin());
        for (String orderName : sampleOrg.getOrdererNames()) {
            Properties ordererProperties = config.getOrdererProperties(orderName);

            sampleOrg.addOrderer(client.newOrderer(orderName, sampleOrg.getOrdererLocation(orderName),
                    ordererProperties));
        }
        for (String peerName : sampleOrg.getPeerNames()) {
            String peerLocation = sampleOrg.getPeerLocation(peerName);

            Properties peerProperties = config.getPeerProperties(peerName);

            if (peerProperties == null) {
                peerProperties = new Properties();
            }


            Peer peer = client.newPeer(peerName, peerLocation, peerProperties);

            sampleOrg.addPeer(peer);
        }
    }

    public ChaincodeID getChaincodeId(String chaincodeName, String chainCodeVersion) {
        ChaincodeID chaincodeID = ChaincodeID.newBuilder().setName(chaincodeName).setVersion(chainCodeVersion)
                .build();
        return chaincodeID;
    }
}
