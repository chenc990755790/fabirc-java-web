package com.ideal.blockchain.dao.postgres;

import com.ideal.blockchain.entity.postgres.Peer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeerRepository extends JpaRepository<Peer,String> {
}
