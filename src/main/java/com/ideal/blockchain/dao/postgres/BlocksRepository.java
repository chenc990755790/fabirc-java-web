package com.ideal.blockchain.dao.postgres;

import com.ideal.blockchain.entity.postgres.Blocks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Max;
import java.util.Date;
import java.util.List;

@Repository
public interface BlocksRepository extends JpaRepository<Blocks,String> {



    @Query(nativeQuery = true, value = "select * from blocks where to_char(createdt,'yyyy-MM-dd') >= ?1  and to_char(createdt,'yyyy-MM-dd') <= ?2 ")
    Page<Blocks> queryByCreatedt(String startDate,String endDate,Pageable pageable);

    @Query(nativeQuery = true, value = "select count(*) from blocks where to_char(createdt,'yyyy-MM-dd') >= ?1  and to_char(createdt,'yyyy-MM-dd') <= ?2 ")
    int countByCreatedt(String startDate,String endDate);
}
