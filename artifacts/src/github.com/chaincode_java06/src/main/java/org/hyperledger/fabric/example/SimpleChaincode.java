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
import org.hyperledger.fabric.example.entity.SettlementAccount;
import org.hyperledger.fabric.example.entity.Receivable;
import org.hyperledger.fabric.example.entity.UserInfo;
import org.hyperledger.fabric.example.entity.factoring.Enterprise;
import org.hyperledger.fabric.example.entity.factoring.Factor;
import org.hyperledger.fabric.example.entity.factoring.AssetTransfer;
import org.hyperledger.fabric.example.entity.factoring.ShuntData;
import org.hyperledger.fabric.shim.ChaincodeBase;
import org.hyperledger.fabric.shim.ChaincodeStub;
import org.hyperledger.fabric.shim.ledger.KeyValue;
import org.hyperledger.fabric.shim.ledger.QueryResultsIterator;
import java.util.Iterator;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hyperledger.fabric.example.consts.FunctionConst.*;


public class SimpleChaincode extends ChaincodeBase {

    private final Gson gson = new GsonBuilder().create();

    private final EnterpriseChainCode enterpriseChainCode = new EnterpriseChainCode();

    private final LoanChainCode loanChainCode = new LoanChainCode();

    protected static final Log _logger = LogFactory.getLog(SimpleChaincode.class);

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
            if (FUNCTION_QUERYENTERPRISE.equals(func)) {
                return enterpriseChainCode.getEnterpriseById(stub, params);
            }
            if (QUERY_ENTERPRISE_ID_NANME.equals(func)) {
                return enterpriseChainCode.queryEnterpriseByIdOrName(stub, params);
            }
            if (FUNCTION_QUERY.equals(func)) {
                return query(stub, params);
            }
            if (RICH_QUERY.equals(func)) {
                return richQuery(stub, params);
            }
            if (DELETE.equals(func)) {
                return delete(stub, params);
            }
            if (FUNCTION_SAVEPRIVATE.equals(func)) {
                return savePrivate(stub, params);
            }
            if (FUNCTION_DELETEPRIVATE.equals(func)) {
                return delPrivate(stub, params);
            }
            if (QUERY_PRIVATE_ID.equals(func)) {
                return queryPrivateById(stub, params);
            }
            if (FUNCTION_QUERYPRIVATE.equals(func)) {
                return queryPrivate(stub, params);
            }
            if (SAVE_ENTERPRISE_INVOICE.equals(func)) {
                return saveEnterpriseInvoice(stub, params);
            }
            if (SAVE_SETTLEMENT_ACCOUNT.equals(func)) {
                return saveSettlementAccount(stub, params);
            }
            if (SAVE_USER_INFO.equals(func)) {
                return saveUserInfo(stub, params);
            }
            if (SAVE_ENTERPRISE_INFO.equals(func)) {
                return enterpriseChainCode.saveEnterpriseInfo(stub, params);
            }
            if (SAVE_RECEIVABLE.equals(func)) {
                return saveReceivable(stub, params);
            }
            if (FUNCTION_SAVEASSETINFO.equals(func)) {
                return loanChainCode.saveAssetInfo(stub, params);
            }
            if (FUNCTION_SAVEAUDITINFO.equals(func)) {
                return loanChainCode.saveAuditInfo(stub, params);
            }
            if (FUNCTION_SAVEBALANCE.equals(func)) {
                return loanChainCode.saveBalance(stub, params);
            }
            if (FUNCTION_SAVEBILLINFO.equals(func)) {
                return loanChainCode.saveBillInfo(stub, params);
            }
            if (FUNCTION_SAVECAPITALDIVERT.equals(func)) {
                return loanChainCode.saveCapitalDivert(stub, params);
            }
            if (FUNCTION_SAVECAPITALNOTICE.equals(func)) {
                return loanChainCode.saveCapitalNotice(stub, params);
            }
            if (FUNCTION_SAVECOMPANYINFO.equals(func)) {
                return loanChainCode.saveCompanyInfo(stub, params);
            }
            if (FUNCTION_SAVECOMPANYRATING.equals(func)) {
                return loanChainCode.saveCompanyRating(stub, params);
            }
            if (FUNCTION_SAVECONTRACTINFO.equals(func)) {
                return loanChainCode.saveContractInfo(stub, params);
            }
            if (FUNCTION_SAVECUSTACCOUNTINFO.equals(func)) {
                return loanChainCode.saveCustAccountInfo(stub, params);
            }
            if (FUNCTION_SAVECUSTINFO.equals(func)) {
                return loanChainCode.saveCustInfo(stub, params);
            }
            if (FUNCTION_SAVECUSTPAYMENT.equals(func)) {
                return loanChainCode.saveCustPayment(stub, params);
            }
            if (FUNCTION_SAVEDETAILASSET.equals(func)) {
                return loanChainCode.saveDetailAsset(stub, params);
            }
            if (FUNCTION_SAVEPLATACCOUNT.equals(func)) {
                return loanChainCode.savePlatAccount(stub, params);
            }
            if (FUNCTION_SAVEPLEDGENOTE.equals(func)) {
                return loanChainCode.savePledgeNote(stub, params);
            }
            if (FUNCTION_SAVEPRODUCTINFO.equals(func)) {
                return loanChainCode.saveProductInfo(stub, params);
            }
            if (FUNCTION_SAVEPROJECTBASIC.equals(func)) {
                return loanChainCode.saveProjectBasic(stub, params);
            }
            if (FUNCTION_SAVEREPAYINFO.equals(func)) {
                return loanChainCode.saveRepayInfo(stub, params);
            }
            if (FUNCTION_SAVEREPAYPLAN.equals(func)) {
                return loanChainCode.saveRepayPlan(stub, params);
            }
            if (FUNCTION_SAVESELFPRODCHANGE.equals(func)) {
                return loanChainCode.saveSelfProdChange(stub, params);
            }
            if (FUNCTION_SAVESELFPRODPAYMENT.equals(func)) {
                return loanChainCode.saveSelfProdPayment(stub, params);
            }
            if (FUNCTION_SAVEFACTORING.equals(func)) {
                return saveFactoring(stub, params);
            }if (FUNCTION_SAVEENTERPRISE.equals(func)) {
                return saveEnterprise(stub, params);
            }
            if (FUNCTION_SAVETRANSFER.equals(func)) {
                return saveTransfer(stub, params);
            }
            return newErrorResponse("Invalid invoke function name :" + func);
        } catch (IllegalArgumentException e) {
            return newErrorResponse(e.getMessage());
        } catch (Throwable e) {
            return newErrorResponse(e);
        }
    }

    private Response delete(ChaincodeStub stub, List<String> args) {
        if (args.size() != 1) {
            return newErrorResponse("Incorrect number of arguments. Expecting 1" + args);
        }
        stub.delState(args.get(0));
        return newSuccessResponse("delete finished successfully");
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

    private Response queryPrivateById(ChaincodeStub stub, List<String> args) {
        if (args.size() != 2) {
            return newErrorResponse(String.format("Incorrect number of arguments. Expecting 2. reality %s", args.size()));
        }
        String collectionName = args.get(0).replace("[", "").replace("]", "").split(",")[0];
        String privateKey = args.get(1);
        _logger.info(String.format("first parameter is %s , second parameter is %s", collectionName, privateKey));

        byte[] val = stub.getPrivateData(collectionName, privateKey);
        if (val == null) {
            return newErrorResponse("Error: data result is null");
        }
        _logger.info(String.format("Query Response:\nprivateKey: %s, val: %s\n", privateKey, val));
        return newSuccessResponse(val.toString(), val);
    }

    private Response queryPrivate(ChaincodeStub stub, List<String> args) {
        if (args.size() < 1 || args.size() % 2 == 0) {
            return newErrorResponse(String.format("Incorrect number of arguments. reality %s", args.toString()));
        }
        String[] collectionNameList = args.get(0).replace("[", "").replace("]", "")
                .replaceAll(" ", "").split(",");
        String richQueryString = QueryUtil.getRichQueryString(args.subList(1, args.size()), false);
        String queryString = String.format("{\"selector\":{%s}}", richQueryString);
        _logger.info("rich query string is :" + queryString);
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < collectionNameList.length; i++) {
            _logger.info("query from collection:" + collectionNameList[i]);
            QueryResultsIterator<KeyValue> values = stub.getPrivateDataQueryResult(collectionNameList[i], queryString);
            Iterator<KeyValue> iterator = values.iterator();
            while (iterator.hasNext()) {
                KeyValue keyValue = iterator.next();
                sb.append(keyValue.getStringValue());
                sb.append(",");
            }
        }
        if (sb.length() > 1)
            sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        _logger.info(String.format("Query Response:\nKey: %s, Value: %s\n", queryString, sb.toString()));
        return newSuccessResponse(sb.toString(), ByteString.copyFrom(sb.toString(), UTF_8).toByteArray());
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
        String sb = QueryUtil.getQueryForResult(stub, QueryUtil.getRichQueryString(args, false));
        return newSuccessResponse(sb, ByteString.copyFrom(sb, UTF_8).toByteArray());
    }

    private Response saveEnterpriseInvoice(ChaincodeStub stub, List<String> args) {
        if (args.size() != 1) {
            return newErrorResponse("Incorrect number of arguments. Expecting 1");
        }
        _logger.info("args  parameter is" + args.get(0));
        InvoiceInfo invoiceInfo = gson.fromJson(args.get(0), InvoiceInfo.class);

        _logger.info("conversion  InvoiceInfo is" + invoiceInfo);
        String key = invoiceInfo.getObjectType() + invoiceInfo.getCompanyId();

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

    private Response saveUserInfo(ChaincodeStub stub, List<String> args) {
        if (args.size() != 1) {
            return newErrorResponse("Incorrect number of arguments. Expecting 1");
        }
        _logger.info("args  parameter is" + args.get(0));
        UserInfo userInfo = gson.fromJson(args.get(0), UserInfo.class);

        _logger.info("conversion  SettlementAccount is" + userInfo);
        String key = userInfo.getObjectType() + userInfo.getUserId();

        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);

        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }

    private Response saveReceivable(ChaincodeStub stub, List<String> args) {
        if (args.size() != 1) {
            return newErrorResponse("Incorrect number of arguments. Expecting 1");
        }
        _logger.info("args  parameter is" + args.get(0));
        Receivable userInfo = gson.fromJson(args.get(0), Receivable.class);

        _logger.info("conversion  Receivable is" + userInfo);
        String key = userInfo.getObjectType() + userInfo.getReceivableRequestId();

        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);

        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }

    private Response saveFactoring(ChaincodeStub stub, List<String> args) {
        if (args.size() != 1) {
            return newErrorResponse("Incorrect number of arguments. Expecting 1");
        }
        _logger.info("args  parameter is" + args.get(0));
        Factor factor = gson.fromJson(args.get(0), Factor.class);

        _logger.info("conversion  factor is" + factor);
        String key = factor.getObjectType() + factor.getBlockChainReqId();

        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);

        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }

    private Response saveEnterprise(ChaincodeStub stub, List<String> args) {
        if (args.size() != 1) {
            return newErrorResponse("Incorrect number of arguments. Expecting 1");
        }
        _logger.info("args  parameter is" + args.get(0));
        ShuntData<Enterprise> enterprise = gson.fromJson(args.get(0), ShuntData.class);

        _logger.info("conversion  enterprise is" + enterprise);
        String key = Enterprise.OBJECT_TYPE_NAME + enterprise.getBlockChainReqId();

        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);

        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }

    private Response saveTransfer(ChaincodeStub stub, List<String> args) {
        if (args.size() != 1) {
            return newErrorResponse("Incorrect number of arguments. Expecting 1");
        }
        _logger.info("args  parameter is" + args.get(0));
        ShuntData<AssetTransfer> assetTransfer = gson.fromJson(args.get(0), ShuntData.class);

        _logger.info("conversion  assetTransfer is" + assetTransfer);
        String key = AssetTransfer.OBJECT_TYPE_NAME + assetTransfer.getBlockChainReqId();

        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);

        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }

    public static void main(String[] args) {
        System.out.println("OpenSSL avaliable: " + OpenSsl.isAvailable());

        new SimpleChaincode().start(args);
    }

}
