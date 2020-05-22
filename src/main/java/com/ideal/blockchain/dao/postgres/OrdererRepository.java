package com.ideal.blockchain.dao.postgres;

import com.ideal.blockchain.entity.postgres.Orderer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdererRepository extends JpaRepository<Orderer,String> {
}
