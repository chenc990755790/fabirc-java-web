package org.hyperledger.fabric.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.protobuf.ByteString;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hyperledger.fabric.example.entity.loan.*;
import org.hyperledger.fabric.shim.Chaincode;
import org.hyperledger.fabric.shim.ChaincodeStub;

import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hyperledger.fabric.shim.ResponseUtils.newSuccessResponse;

public class LoanChainCode {

    private static Log _logger = LogFactory.getLog(SimpleChaincode.class);
    private final Gson gson = new GsonBuilder().create();

    private void checkSaveArgs(List<String> args){
        if (args.size() != 1) {
            _logger.info("args  parameter is" + args.get(0));
            throw new IllegalArgumentException("Incorrect number of arguments. Expecting 1");
        }
    }

    public Chaincode.Response saveAssetInfo(ChaincodeStub stub, List<String> args) {
        AssetInfo enterpriseInfo = gson.fromJson(args.get(0), AssetInfo.class);
        _logger.info("conversion  AssetInfo is" + enterpriseInfo);
        String key = enterpriseInfo.getObjectType() + enterpriseInfo.getLoanNo();
        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);
        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }

    public Chaincode.Response saveAuditInfo(ChaincodeStub stub, List<String> args) {
        AuditInfo enterpriseInfo = gson.fromJson(args.get(0), AuditInfo.class);
        _logger.info("conversion  AuditInfo is" + enterpriseInfo);
        String key = enterpriseInfo.getObjectType() + enterpriseInfo.getLoanNo();
        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);
        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }

    public Chaincode.Response saveBalance(ChaincodeStub stub, List<String> args) {
        Balance enterpriseInfo = gson.fromJson(args.get(0), Balance.class);
        _logger.info("conversion  Balance is" + enterpriseInfo);
        String key = enterpriseInfo.getObjectType() + enterpriseInfo.getTradeAccountId();
        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);
        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }

    public Chaincode.Response saveBillInfo(ChaincodeStub stub, List<String> args) {
        BillInfo enterpriseInfo = gson.fromJson(args.get(0), BillInfo.class);
        _logger.info("conversion  BillInfo is" + enterpriseInfo);
        String key = enterpriseInfo.getObjectType() + enterpriseInfo.getLoanNo();
        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);
        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }
    public Chaincode.Response saveCapitalDivert(ChaincodeStub stub, List<String> args) {
        CapitalDivert enterpriseInfo = gson.fromJson(args.get(0), CapitalDivert.class);
        _logger.info("conversion  CapitalDivert is" + enterpriseInfo);
        String key = enterpriseInfo.getObjectType() + enterpriseInfo.getCapitalDivertId();
        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);
        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }
    public Chaincode.Response saveCapitalNotice(ChaincodeStub stub, List<String> args) {
        CapitalNotice enterpriseInfo = gson.fromJson(args.get(0), CapitalNotice.class);
        _logger.info("conversion  CapitalNotice is" + enterpriseInfo);
        String key = enterpriseInfo.getObjectType() + enterpriseInfo.getCapitalNoticeId();
        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);
        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }
    public Chaincode.Response saveCompanyInfo(ChaincodeStub stub, List<String> args) {
        CompanyInfo enterpriseInfo = gson.fromJson(args.get(0), CompanyInfo.class);
        _logger.info("conversion  CompanyInfo is" + enterpriseInfo);
        String key = enterpriseInfo.getObjectType() + enterpriseInfo.getSocialCreditCode();
        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);
        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }
    public Chaincode.Response saveCompanyRating(ChaincodeStub stub, List<String> args) {
        CompanyRating enterpriseInfo = gson.fromJson(args.get(0), CompanyRating.class);
        _logger.info("conversion  CompanyRating is" + enterpriseInfo);
        String key = enterpriseInfo.getObjectType() + enterpriseInfo.getCompanyRateId();
        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);
        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }
    public Chaincode.Response saveContractInfo(ChaincodeStub stub, List<String> args) {
        ContractInfo enterpriseInfo = gson.fromJson(args.get(0), ContractInfo.class);
        _logger.info("conversion  ContractInfo is" + enterpriseInfo);
        String key = enterpriseInfo.getObjectType() + enterpriseInfo.getLoanNo();
        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);
        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }
    public Chaincode.Response saveCustAccountInfo(ChaincodeStub stub, List<String> args) {
        CustAccountInfo enterpriseInfo = gson.fromJson(args.get(0), CustAccountInfo.class);
        _logger.info("conversion  CustAccountInfo is" + enterpriseInfo);
        String key = enterpriseInfo.getObjectType() + enterpriseInfo.getTradeAccountId();
        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);
        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }
    public Chaincode.Response saveCustInfo(ChaincodeStub stub, List<String> args) {
        CustInfo enterpriseInfo = gson.fromJson(args.get(0), CustInfo.class);
        _logger.info("conversion  CustInfo is" + enterpriseInfo);
        String key = enterpriseInfo.getObjectType() + enterpriseInfo.getProdNo();
        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);
        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }
    public Chaincode.Response saveCustPayment(ChaincodeStub stub, List<String> args) {
        CustPayment enterpriseInfo = gson.fromJson(args.get(0), CustPayment.class);
        _logger.info("conversion  CustPayment is" + enterpriseInfo);
        String key = enterpriseInfo.getObjectType() + enterpriseInfo.getCustomerPaymentId();
        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);
        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }
    public Chaincode.Response saveDetailAsset(ChaincodeStub stub, List<String> args) {
        DetailAsset enterpriseInfo = gson.fromJson(args.get(0), DetailAsset.class);
        _logger.info("conversion  DetailAsset is" + enterpriseInfo);
        String key = enterpriseInfo.getObjectType() + enterpriseInfo.getLoanNo();
        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);
        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }
    public Chaincode.Response savePlatAccount(ChaincodeStub stub, List<String> args) {
        PlatAccount enterpriseInfo = gson.fromJson(args.get(0), PlatAccount.class);
        _logger.info("conversion  PlatAccount is" + enterpriseInfo);
        String key = enterpriseInfo.getObjectType() + enterpriseInfo.getId();
        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);
        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }
    public Chaincode.Response savePledgeNote(ChaincodeStub stub, List<String> args) {
        PledgeNote enterpriseInfo = gson.fromJson(args.get(0), PledgeNote.class);
        _logger.info("conversion  PledgeNote is" + enterpriseInfo);
        String key = enterpriseInfo.getObjectType() + enterpriseInfo.getLoanNo();
        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);
        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }
    public Chaincode.Response saveProductInfo(ChaincodeStub stub, List<String> args) {
        ProductInfo enterpriseInfo = gson.fromJson(args.get(0), ProductInfo.class);
        _logger.info("conversion  ProductInfo is" + enterpriseInfo);
        String key = enterpriseInfo.getObjectType() + enterpriseInfo.getAssetPackageId();
        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);
        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }
    public Chaincode.Response saveProjectBasic(ChaincodeStub stub, List<String> args) {
        ProjectBasic enterpriseInfo = gson.fromJson(args.get(0), ProjectBasic.class);
        _logger.info("conversion  ProjectBasic is" + enterpriseInfo);
        String key = enterpriseInfo.getObjectType() + enterpriseInfo.getProjectNo();
        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);
        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }
    public Chaincode.Response saveRepayInfo(ChaincodeStub stub, List<String> args) {
        RepayInfo enterpriseInfo = gson.fromJson(args.get(0), RepayInfo.class);
        _logger.info("conversion  RepayInfo is" + enterpriseInfo);
        String key = enterpriseInfo.getObjectType() + enterpriseInfo.getLoanNo();
        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);
        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }
    public Chaincode.Response saveRepayPlan(ChaincodeStub stub, List<String> args) {
        RepayPlan enterpriseInfo = gson.fromJson(args.get(0), RepayPlan.class);
        _logger.info("conversion  RepayPlan is" + enterpriseInfo);
        String key = enterpriseInfo.getObjectType() + enterpriseInfo.getLoanNo();
        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);
        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }
    public Chaincode.Response saveSelfProdChange(ChaincodeStub stub, List<String> args) {
        SelfProdChange enterpriseInfo = gson.fromJson(args.get(0), SelfProdChange.class);
        _logger.info("conversion  SelfProdChange is" + enterpriseInfo);
        String key = enterpriseInfo.getObjectType() + enterpriseInfo.getProdNo();
        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);
        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }
    public Chaincode.Response saveSelfProdPayment(ChaincodeStub stub, List<String> args) {
        SelfProdPayment enterpriseInfo = gson.fromJson(args.get(0), SelfProdPayment.class);
        _logger.info("conversion  SelfProdPayment is" + enterpriseInfo);
        String key = enterpriseInfo.getObjectType() + enterpriseInfo.getProductPaymentId();
        stub.putStringState(key, args.get(0));
        _logger.info("Transfer complete" + key);
        return newSuccessResponse("invoke finished successfully:", ByteString.copyFrom(key, UTF_8).toByteArray());
    }


}
