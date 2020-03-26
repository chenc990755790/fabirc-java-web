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
import org.hyperledger.fabric.example.entity.InvoiceInfo;
import org.hyperledger.fabric.example.entity.Receivable;
import org.hyperledger.fabric.example.entity.SettlementAccount;
import org.hyperledger.fabric.shim.ChaincodeBase;
import org.hyperledger.fabric.shim.ChaincodeStub;
import org.hyperledger.fabric.shim.ledger.KeyValue;
import org.hyperledger.fabric.shim.ledger.QueryResultsIterator;

import java.util.Iterator;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;


public class SimpleChaincode extends ChaincodeBase {

    private static final String QUERY = "query";

    private static final String RICH_QUERY = "richQuery";

    private static final String SAVE_ENTERPRISE = "saveEnterprise";

    private static final String DELETE_ENTERPRISE = "deleteEnterprise";

    private static final String QUERY_ENTERPRISE = "queryEnterprise";

    private static final String QUERY_ENTERPRISE_ALL = "queryAllEnterprise";

    private static final String SAVE_PRIVATE = "savePrivate";

    private static final String DELETE_PRIVATE = "delPrivate";

    private static final String QUERY_PRIVATE = "queryPrivate";

    private static final String SAVE_ENTERPRISE_INVOICE = "saveEnterpriseInvoice";

    private static final String SAVE_SETTLEMENT_ACCOUNT = "saveSettlementAccount";

    private static Log _logger = LogFactory.getLog(SimpleChaincode.class);

    private final Gson gson = new GsonBuilder().create();

    private final EnterpriseChainCode enterpriseChainCode = new EnterpriseChainCode();

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
            if (SAVE_ENTERPRISE.equals(func)) {
                params.remove(0);
                return enterpriseChainCode.saveEnterprise(stub, params);
            }
            if (QUERY_ENTERPRISE.equals(func)) {
                params.remove(0);
                return enterpriseChainCode.getEnterpriseById(stub, params);
            }
            if (QUERY_ENTERPRISE_ALL.equals(func)) {
                params.remove(0);
                return enterpriseChainCode.queryAllEnterprise(stub, params);
            }
            if (QUERY.equals(func)) {
                params.remove(0);
                return query(stub, params);
            }
            if (RICH_QUERY.equals(func)) {
                params.remove(0);
                return richQuery(stub, params);
            }
            if (DELETE_ENTERPRISE.equals(func)) {
                params.remove(0);
                return enterpriseChainCode.deleteEnterprise(stub, params);
            }
            if (SAVE_PRIVATE.equals(func)) {
                return savePrivate(stub, params);
            }
            if (DELETE_PRIVATE.equals(func)) {
                return delPrivate(stub, params);
            }
            if (QUERY_PRIVATE.equals(func)) {
                return queryPrivate(stub, params);
            }
            if (QUERY_PRIVATE.equals(func)) {
                return queryPrivate(stub, params);
            }
            if (SAVE_ENTERPRISE_INVOICE.equals(func)) {
                return saveEnterpriseInvoice(stub, params);
            }
            if (SAVE_SETTLEMENT_ACCOUNT.equals(func)) {
                return saveSettlementAccount(stub, params);
            }
            return newErrorResponse("Invalid invoke function name :" + func);
        } catch (Throwable e) {

            return newErrorResponse(e);
        }
    }

    private Response delPrivate(ChaincodeStub stub, List<String> args) {
        if (args.size() != 2) {
            return newErrorResponse("Incorrect number of arguments. Expecting 2");
        }
        stub.delPrivateData(args.get(0), args.get(1));
        return newSuccessResponse("delete private finished successfully");
    }

    private Response savePrivate(ChaincodeStub stub, List<String> args) {
        if (args.size() != 2) {
            return newErrorResponse(String.format("Incorrect number of arguments. Expecting 2. reality %s", args.size()));
        }
        _logger.info(String.format("first parameter is %s , second parameter is %s", args.get(0), args.get(1)));

        Receivable receivable = gson.fromJson(args.get(1), Receivable.class);
        _logger.info("conversion  Receivable is" + receivable);

        String key = receivable.getObjectType() + receivable.getReceivableRequestId();

        stub.putPrivateData(args.get(0), key, args.get(1));
        return newSuccessResponse("save private finished successfully");

    }

    private Response queryPrivate(ChaincodeStub stub, List<String> args) {
        if (args.size() != 2) {
            return newErrorResponse(String.format("Incorrect number of arguments. Expecting 2. reality %s", args.size()));
        }
        String collectionName = args.get(0);
        String privateKey = args.get(1);
        _logger.info(String.format("first parameter is %s , second parameter is %s", collectionName, privateKey));

        byte[] val = stub.getPrivateData(collectionName, privateKey);
        if (val == null) {
            return newErrorResponse("Error: data result is null");
        }
        _logger.info(String.format("Query Response:\nprivateKey: %s, val: %s\n", privateKey, val));
        return newSuccessResponse(val.toString(), val);
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

    private Response richQuery(ChaincodeStub stub, List<String> args) {
        if (args.size() == 0 || args.size() % 2 != 0) {
            _logger.info("params size :" + args.size());
            return newErrorResponse("Incorrect number of arguments. Expecting name of the person to query:" + args.toString());
        }
        String richQueryString = getRichQueryString(args);
        String queryString = String.format("{\"selector\":{%s}}", richQueryString);
        _logger.info("rich query string is :" + queryString);
        QueryResultsIterator<KeyValue> values = stub.getQueryResult(queryString);
        if (values == null) {
            return newErrorResponse(String.format("Error: KeyValue state for %s is null", queryString));
        }
        Iterator<KeyValue> iterator = values.iterator();
        StringBuilder sb = new StringBuilder("[");
        while (iterator.hasNext()) {
            KeyValue keyValue = iterator.next();
            sb.append(keyValue.getStringValue());
            sb.append(",");
        }
        if (sb.length() > 1)
            sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        _logger.info(String.format("Query Response:\nKey: %s, Value: %s\n", queryString, sb.toString()));
        return newSuccessResponse(sb.toString(), ByteString.copyFrom(sb.toString(), UTF_8).toByteArray());
    }

    private String getRichQueryString(List<String> args) {
        StringBuilder sb = new StringBuilder();
        int k = args.size() / 2;
        for (int i = 0; i < k; i++) {
            sb.append(String.format("\"%s\":\"%s\"", args.get(i * 2), args.get(i * 2 + 1))).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }


    private Response saveEnterpriseInvoice(ChaincodeStub stub, List<String> args) {
        if (args.size() != 1) {
            return newErrorResponse("Incorrect number of arguments. Expecting 1");
        }
        _logger.info("args  parameter is" + args.get(0));
        InvoiceInfo invoiceInfo = gson.fromJson(args.get(0), InvoiceInfo.class);

        _logger.info("conversion  InvoiceInfo is" + invoiceInfo);
        String key = invoiceInfo.getObjectType() + invoiceInfo.getTaxpayerIdentifyNo();

        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);

        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }

    private Response saveSettlementAccount(ChaincodeStub stub, List<String> args) {
        if (args.size() != 1) {
            return newErrorResponse("Incorrect number of arguments. Expecting 1");
        }
        _logger.info("args  parameter is" + args.get(0));
        SettlementAccount settlementAccount = gson.fromJson(args.get(0), SettlementAccount.class);

        _logger.info("conversion  SettlementAccount is" + settlementAccount);
        String key = settlementAccount.getObjectType() + settlementAccount.getBankAccountId();

        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);

        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }

    public static void main(String[] args) {
        System.out.println("OpenSSL avaliable: " + OpenSsl.isAvailable());
        new SimpleChaincode().start(args);
    }

}
