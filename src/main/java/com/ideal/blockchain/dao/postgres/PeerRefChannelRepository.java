package com.ideal.blockchain.dao.postgres;

import com.ideal.blockchain.entity.postgres.PeerRefChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeerRefChannelRepository extends JpaRepository<PeerRefChannel,String> {
}
