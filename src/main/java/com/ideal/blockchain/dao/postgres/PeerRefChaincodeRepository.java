package com.ideal.blockchain.dao.postgres;

import com.ideal.blockchain.entity.postgres.PeerRefChaincode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeerRefChaincodeRepository extends JpaRepository<PeerRefChaincode,String> {
}
