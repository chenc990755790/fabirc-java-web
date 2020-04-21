package org.hyperledger.fabric.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hyperledger.fabric.shim.ChaincodeStub;
import org.hyperledger.fabric.shim.ledger.KeyValue;
import org.hyperledger.fabric.shim.ledger.QueryResultsIterator;

import java.util.Iterator;
import java.util.List;

public class QueryUtil {

    public static final Log _logger = LogFactory.getLog(QueryUtil.class);

    public static String getQueryForResult(ChaincodeStub stub,String richQueryString) {
        String queryString = String.format("{\"selector\":{%s}}", richQueryString);
        _logger.info("rich query string is :" + queryString);
        QueryResultsIterator<KeyValue> values = stub.getQueryResult(queryString);
        if (values == null) {
            return "";
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
        _logger.info(String.format("Query Response:\nKey: %s, Value: %s\n", richQueryString, sb));
        return sb.toString();
    }

    public static String getRichQueryString(List<String> args, boolean isReges) {
        StringBuilder sb = new StringBuilder();
        int k = args.size() / 2;
        for (int i = 0; i < k; i++) {
            if (isReges) {
                sb.append(String.format("\"%s\":%s", args.get(i * 2), args.get(i * 2 + 1))).append(",");
            } else {
                sb.append(String.format("\"%s\":\"%s\"", args.get(i * 2), args.get(i * 2 + 1))).append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }


}
