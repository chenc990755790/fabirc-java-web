package com.ideal.blockchain.dao.postgres;

import com.ideal.blockchain.entity.postgres.Blocks;
import com.ideal.blockchain.entity.postgres.TransactionStatics;
import com.ideal.blockchain.entity.postgres.Transactions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, String> {

    @Query(value = "select to_char (createdt,'yyyy-MM-dd') as createdt,count (*) as count from transactions " +
            "GROUP BY to_char(createdt,'yyyy-MM-dd') order by to_char(createdt,'yyyy-MM-dd') asc limit 10",nativeQuery = true)
    List<String[]> queryTransactionsByCreatedt();

    @Query(nativeQuery = true, value = "select * from transactions where to_char(createdt,'yyyy-MM-dd') >= ?1  and to_char(createdt,'yyyy-MM-dd') <= ?2 ")
    Page<Transactions> queryByCreatedt(String startDate, String endDate, Pageable pageable);

    @Query(nativeQuery = true, value = "select count(*) from transactions where to_char(createdt,'yyyy-MM-dd') >= ?1  and to_char(createdt,'yyyy-MM-dd') <= ?2 ")
    int countByCreatedt(String startDate,String endDate);

}
