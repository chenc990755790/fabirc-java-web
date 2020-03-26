package org.hyperledger.fabric.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.protobuf.ByteString;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hyperledger.fabric.example.entity.Enterprise;
import org.hyperledger.fabric.shim.Chaincode;
import org.hyperledger.fabric.shim.ChaincodeStub;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hyperledger.fabric.shim.ResponseUtils.newErrorResponse;
import static org.hyperledger.fabric.shim.ResponseUtils.newSuccessResponse;

public class EnterpriseChainCode {

    private static Log _logger = LogFactory.getLog(SimpleChaincode.class);
    private final Gson gson = new GsonBuilder().create();

    public Chaincode.Response saveEnterprise(ChaincodeStub stub, List<String> args) {
        if (args.size() != 1) {
            return newErrorResponse("Incorrect number of arguments. Expecting 1");
        }
        _logger.info("args  parameter is" + args.get(0));
        Enterprise enterprise = gson.fromJson(args.get(0), Enterprise.class);
        _logger.info("conversion  Enterprise is" + enterprise);
        String key = enterprise.getObjectType() + enterprise.getId();
        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);

        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }


    public Chaincode.Response deleteEnterprise(ChaincodeStub stub, List<String> args) {
        if (args.size() != 1) {
            return newErrorResponse("Incorrect number of arguments. Expecting 3");
        }
        stub.delState(args.get(0));
        return newSuccessResponse("delete enterprise finished successfully");
    }

    public Chaincode.Response getEnterpriseById(ChaincodeStub stub, List<String> args) {
        if (args.size() != 1) {
            _logger.info("params size :" + args.size());
            return newErrorResponse("Incorrect number of arguments. Expecting name of the person to query:" + args.toString());
        }
        String key = args.get(0);
        //byte[] stateBytes
        String val = stub.getStringState(Enterprise.OBJECT_TYPE_NAME + key);
        if (val == null) {
            return newErrorResponse(String.format("Error: state for %s is null", key));
        }
        return newSuccessResponse(val, ByteString.copyFrom(val, UTF_8).toByteArray());
    }

    public Chaincode.Response queryAllEnterprise(ChaincodeStub stub, List<String> args) {
        if (args.size() > 0) {
            _logger.info("params size :" + args.size());
            return newErrorResponse("Incorrect number of arguments. Expecting name of the person to query:" + args.toString());
        }
        List<String> enterList;
        try {
            Iterator iterator = stub.getStateByPartialCompositeKey(Enterprise.OBJECT_TYPE_NAME, Enterprise.OBJECT_TYPE_NAME).iterator();
            enterList = new ArrayList<>();
            while (iterator.hasNext()) {
                String value = (String) iterator.next();
                enterList.add(value);
            }
        } catch (Exception e) {
            return newErrorResponse(e);
        }
        return newSuccessResponse(enterList.toString(), ByteString.copyFrom(enterList.toString(), UTF_8).toByteArray());
    }
}
