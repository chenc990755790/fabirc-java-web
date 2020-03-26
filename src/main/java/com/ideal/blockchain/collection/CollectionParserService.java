package com.ideal.blockchain.collection;

import com.ideal.blockchain.config.HyperledgerConfiguration;
import com.ideal.blockchain.dao.mapper.PrivateCollectionMapper;
import com.ideal.blockchain.dao.model.CollectionEntity;
import lombok.extern.slf4j.Slf4j;
import org.hyperledger.fabric.protos.common.Collection;
import org.hyperledger.fabric.sdk.ChaincodeCollectionConfiguration;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
@Slf4j
public class CollectionParserService implements InitializingBean {

    @Value("${COLLECTION_FILE}")
    private String collectFilePath;

    @Autowired
    private PrivateCollectionMapper privateCollectionMapper;

    private final Set<String> collectNameList = new LinkedHashSet<String>();

    private File f;

    public Set<String> getCollectNameList() {
        return collectNameList;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        f = new File(HyperledgerConfiguration.PATH + collectFilePath);
        ChaincodeCollectionConfiguration config = ChaincodeCollectionConfiguration.fromYamlFile(f);
        byte[] configAsBytes = config.getAsBytes();
        Collection.CollectionConfigPackage collectionConfigPackage = Collection.CollectionConfigPackage.parseFrom(configAsBytes);

        for (int i = 0; i < collectionConfigPackage.getConfigCount(); i++) {
            Collection.CollectionConfig colConfig = collectionConfigPackage.getConfig(i);
            Collection.StaticCollectionConfig staticCollectionConfig = colConfig.getStaticCollectionConfig();
            collectNameList.add(staticCollectionConfig.getName());
        }
        log.info("current has collection num:" + collectNameList.size());
    }


    public String addCollectionName(String collectionName) {
        if (collectNameList.contains(collectionName)) {
            log.info("collection name exists: " + collectionName);
            return collectionName;
        }
        String yaml = getCollectionString(collectionName);
        writeToColletionFile(yaml);
        collectNameList.add(collectionName);
        return "";
    }

    public String addCollectionName(List<String> collectNameList) throws Exception {
        String yaml = "";
        for (String collectionName : collectNameList) {
            if (collectNameList.contains(collectionName)) {
                log.info("collection name exists: " + collectionName);
                return collectionName;
            }
            yaml += getCollectionString(collectionName);
        }
        writeToColletionFile(yaml);
        collectNameList.addAll(collectNameList);
        return "";
    }

    private static String getCollectionString(String collectionName) {
        return "\n" +
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
                "               - signed-by: \"user1\"\n" +
                "               - signed-by: \"user2\"";
    }

    private void writeToColletionFile(String yaml) {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(f, true);
            outputStream.write(yaml.getBytes(UTF_8));
        } catch (Exception e) {

        } finally {
            if (outputStream != null)
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                }

        }

    }

    public void insertCollectionConfig(CollectionEntity entity) {
        privateCollectionMapper.insert(entity);
    }

    public void updateCollectionConfig(CollectionEntity entity) {
        privateCollectionMapper.updateByCollectionName(entity);
    }
}
