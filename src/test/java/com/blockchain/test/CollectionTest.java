package com.blockchain.test;

import com.ideal.blockchain.config.HyperledgerConfiguration;
import org.hyperledger.fabric.protos.common.Collection;
import org.hyperledger.fabric.sdk.ChaincodeCollectionConfiguration;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;


public class CollectionTest {

    private final List<String> collectNameList = new ArrayList<String>();

    @Test
    public void test() throws Exception{
        File f = new File(HyperledgerConfiguration.PATH + "/artifacts/PrivateDataIT.yaml");
        ChaincodeCollectionConfiguration config = ChaincodeCollectionConfiguration.fromYamlFile(f);
        byte[] configAsBytes = config.getAsBytes();
        Collection.CollectionConfigPackage collectionConfigPackage = Collection.CollectionConfigPackage.parseFrom(configAsBytes);
        System.out.println(collectionConfigPackage.getConfigCount());
        for (int i=0;i<collectionConfigPackage.getConfigCount();i++){
            Collection.CollectionConfig colConfig = collectionConfigPackage.getConfig(i);
            Collection.StaticCollectionConfig staticCollectionConfig = colConfig.getStaticCollectionConfig();
            collectNameList.add(staticCollectionConfig.getName());
        }
        String collectionName = "testPrivate";
        String yaml = "\n" +
                "  - StaticCollectionConfig: \n" +
                "       name: " + collectionName + "\n" +
                "       blockToLive: 9999 \n" +
                "       maximumPeerCount: 0\n" +
                "       requiredPeerCount: 0\n" +
                "       SignaturePolicyEnvelope:\n" +
                "         identities:\n" +
                "             - user1: {\"role\": {\"name\": \"member\", \"mspId\": \"Org1MSP\"}}\n" +
                "             - user2: {\"role\": {\"name\": \"member\", \"mspId\": \"Org2MSP\"}}\n" +

                "         policy:\n" +
                "             1-of:\n" +
                "               - signed-by: \"user1\"\n"+
                "               - signed-by: \"user2\"";

        FileOutputStream outputStream = new FileOutputStream(f,true);
        outputStream.write(yaml.getBytes(UTF_8));
        outputStream.close();
        collectNameList.add(collectionName);
        System.out.println(collectNameList);
    }
}
