/*
Copyright IBM Corp., DTCC All Rights Reserved.

SPDX-License-Identifier: Apache-2.0
*/
package org.hyperledger.fabric.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.protobuf.ByteString;
import io.netty.handler.ssl.OpenSsl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hyperledger.fabric.example.entity.Enterprise;
import org.hyperledger.fabric.shim.ChaincodeBase;
import org.hyperledger.fabric.shim.ChaincodeStub;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SimpleChaincode extends ChaincodeBase {

    private static final String FUNCTION_QUERY = "query";

    private static final String FUNCTION_SAVEENTERPRISE = "saveEnterprise";

    private static final String FUNCTION_DELETEENTERPRISE = "deleteEnterprise";

    private static final String FUNCTION_QUERYENTERPRISE = "queryEnterprise";

    private static final String FUNCTION_QUERYENTERPRISE_ALL = "queryAllEnterprise";

    private static final String FUNCTION_SAVEPRIVATE = "savePrivate";

    private static final String FUNCTION_DELETEPRIVATE = "delPrivate";

    private static final String FUNCTION_QUERYPRIVATE = "queryPrivate";

    private static Log _logger = LogFactory.getLog(SimpleChaincode.class);
    private final Gson gson = new GsonBuilder().create();

    @Override
    public Response init(ChaincodeStub stub) {
        try {
            _logger.info("Init java simple chaincode");
            String func = stub.getFunction();
            if (!func.equals("init")) {
                return newErrorResponse("function other than init is not supported");
            }
            return newSuccessResponse();
        } catch (Throwable e) {
            return newErrorResponse(e);
        }
    }

    @Override
    public Response invoke(ChaincodeStub stub) {
        try {
            _logger.info("Invoke java simple chaincode");
            String func = stub.getFunction();
            List<String> params = stub.getParameters();
            if (FUNCTION_SAVEENTERPRISE.equals(func)) {
                params.remove(0);
                return saveEnterprise(stub, params);
            }
            if (FUNCTION_QUERYENTERPRISE.equals(func)) {
                params.remove(0);
                return queryEnterprise(stub, params);
            }
            if (FUNCTION_QUERYENTERPRISE_ALL.equals(func)) {
                params.remove(0);
                return queryAllEnterprise(stub, params);
            }
            if (FUNCTION_QUERY.equals(func)) {
                params.remove(0);
                return query(stub, params);
            }
            if (FUNCTION_DELETEENTERPRISE.equals(func)) {
                params.remove(0);
                return deleteEnterprise(stub, params);
            }
            if (FUNCTION_SAVEPRIVATE.equals(func)) {
                return savePrivate(stub, params);
            }
            if (FUNCTION_DELETEPRIVATE.equals(func)) {
                return delPrivate(stub, params);
            }
            if (FUNCTION_QUERYPRIVATE.equals(func)) {
                return queryPrivate(stub, params);
            }
            return newErrorResponse("Invalid invoke function name :" + func);
        } catch (Throwable e) {

            return newErrorResponse(e);
        }
    }

    private Response delPrivate(ChaincodeStub stub, List<String> args) {
        if (args.size() != 2) {
            return newErrorResponse("Incorrect number of arguments. Expecting 3");
        }
        stub.delPrivateData(args.get(0), args.get(1));
        return newSuccessResponse("delete private finished successfully");
    }

    private Response savePrivate(ChaincodeStub stub, List<String> args) {
        stub.putPrivateData(args.get(0), args.get(1), args.subList(1, args.size()).toString());
        return newSuccessResponse("save private finished successfully");

    }

    private Response queryPrivate(ChaincodeStub stub, List<String> args) {
        if (args.size() != 2) {
            return newErrorResponse("Incorrect number of arguments. Expecting name of the person to query");
        }
        String key = args.get(0);
        //byte[] stateBytes
        byte[] val = stub.getPrivateData(key, args.get(1));
        if (val == null) {
            return newErrorResponse(String.format("Error: state for %s is null", key));
        }
        _logger.info(String.format("Query Response:\nName: %s, Amount: %s\n", key, val));
        return newSuccessResponse(val.toString(), val);
    }

    private Response saveEnterprise(ChaincodeStub stub, List<String> args) {
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


    private Response deleteEnterprise(ChaincodeStub stub, List<String> args) {
        if (args.size() != 1) {
            return newErrorResponse("Incorrect number of arguments. Expecting 3");
        }
        stub.delState(args.get(0));
        return newSuccessResponse("delete enterprise finished successfully");
    }

    // query callback representing the query of a chaincode
    private Response query(ChaincodeStub stub, List<String> args) {
        if (args.size() != 1) {
            _logger.info("params size :" + args.size());
            return newErrorResponse("Incorrect number of arguments. Expecting name of the person to query:" + args.toString());
        }
        String key = args.get(0);
        //byte[] stateBytes
        String val = stub.getStringState(key);
        if (val == null) {
            return newErrorResponse(String.format("Error: state for %s is null", key));
        }
        _logger.info(String.format("Query Response:\nName: %s, Amount: %s\n", key, val));
        return newSuccessResponse(val, ByteString.copyFrom(val, UTF_8).toByteArray());
    }

    private Response queryEnterprise(ChaincodeStub stub, List<String> args) {
        if (args.size() != 1) {
            _logger.info("params size :" + args.size());
            return newErrorResponse("Incorrect number of arguments. Expecting name of the person to query:" + args.toString());
        }
        String key = args.get(0);
        //byte[] stateBytes
        String val = stub.getStringState(key);
        if (val == null) {
            return newErrorResponse(String.format("Error: state for %s is null", key));
        }
        _logger.info(String.format("Query Response:\nName: %s, Amount: %s\n", key, val));
        return newSuccessResponse(val, ByteString.copyFrom(val, UTF_8).toByteArray());
    }

    private Response queryAllEnterprise(ChaincodeStub stub, List<String> args) {
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

    public static void main(String[] args) {
        System.out.println("OpenSSL avaliable: " + OpenSsl.isAvailable());
        new SimpleChaincode().start(args);
    }

}
