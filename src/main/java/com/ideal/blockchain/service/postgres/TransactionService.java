package com.ideal.blockchain.service.postgres;

import com.ideal.blockchain.dao.postgres.TransactionsRepository;
import com.ideal.blockchain.entity.postgres.TransactionStatics;
import com.ideal.blockchain.entity.postgres.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionsRepository transactionsRepository;

    public List<TransactionStatics> convert() {
        List<String[]> transactionStatics = transactionsRepository.queryTransactionsByCreatedt();
        if (CollectionUtils.isEmpty(transactionStatics)) {
            return null;
        }
        List<TransactionStatics> transactionStaticsList = new ArrayList<>();
        for (Object[] strs : transactionStatics) {
            transactionStaticsList.add(new TransactionStatics((String) strs[0], (BigInteger) strs[1]));
        }
        return transactionStaticsList;
    }

    public long count() {
        return transactionsRepository.count();
    }

    public List<Transactions> findAll() {
        Sort sort = new Sort(Sort.Direction.DESC, "createdt");
        List<Transactions> transactionsList = transactionsRepository.findAll(sort).subList(0, 5);
        return transactionsList;
    }
}
