package org.hyperledger.fabric.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.protobuf.ByteString;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hyperledger.fabric.example.entity.EnterpriseInfo;
import org.hyperledger.fabric.example.entity.SettlementAccount;
import org.hyperledger.fabric.shim.Chaincode;
import org.hyperledger.fabric.shim.ChaincodeStub;

import java.util.Arrays;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hyperledger.fabric.shim.ResponseUtils.newErrorResponse;
import static org.hyperledger.fabric.shim.ResponseUtils.newSuccessResponse;

public class EnterpriseChainCode {

    private static Log _logger = LogFactory.getLog(SimpleChaincode.class);
    private final Gson gson = new GsonBuilder().create();

    public Chaincode.Response saveEnterpriseInfo(ChaincodeStub stub, List<String> args) {
        if (args.size() != 1) {
            return newErrorResponse("Incorrect number of arguments. Expecting 1");
        }
        _logger.info("args  parameter is" + args.get(0));
        EnterpriseInfo enterpriseInfo = gson.fromJson(args.get(0), EnterpriseInfo.class);

        _logger.info("conversion  SettlementAccount is" + enterpriseInfo);
        String key = enterpriseInfo.getObjectType() + enterpriseInfo.getCompanyId();

        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);

        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }

    public Chaincode.Response getEnterpriseById(ChaincodeStub stub, List<String> args) {
        if (args.size() != 1) {
            _logger.info("params size :" + args.size());
            return newErrorResponse("Incorrect number of arguments. Expecting name of the person to query:" + args.toString());
        }
        String key = args.get(0);
        //byte[] stateBytes
        String val = stub.getStringState(EnterpriseInfo.OBJECT_TYPE_NAME + key);
        if (val == null) {
            return newErrorResponse(String.format("Error: state for %s is null", key));
        }
//        String queryString = QueryUtil.getRichQueryString(Arrays.asList("objectType", SettlementAccount.OBJECT_TYPE_NAME, "companyId", key),false);
//        String settleAccountValue = QueryUtil.getQueryForResult(stub, queryString);
        return newSuccessResponse(val, ByteString.copyFrom(val, UTF_8).toByteArray());
    }

    public Chaincode.Response queryEnterpriseByIdOrName(ChaincodeStub stub, List<String> args) {
        if (args.size() == 0 || args.size() % 2 != 0) {
            _logger.info("params size :" + args.size());
            return newErrorResponse("Incorrect number of arguments. Expecting name of the person to query:" + args.toString());
        }
        String sb = QueryUtil.getQueryForResult(stub, QueryUtil.getRichQueryString(args, true));
        return newSuccessResponse(sb, ByteString.copyFrom(sb, UTF_8).toByteArray());
    }

}
