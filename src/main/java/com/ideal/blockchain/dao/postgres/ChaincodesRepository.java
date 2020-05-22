package com.ideal.blockchain.dao.postgres;

import com.ideal.blockchain.entity.postgres.Chaincodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChaincodesRepository extends JpaRepository<Chaincodes,String> {
}
