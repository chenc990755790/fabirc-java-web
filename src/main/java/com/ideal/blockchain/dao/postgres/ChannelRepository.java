package com.ideal.blockchain.dao.postgres;

import com.ideal.blockchain.entity.postgres.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<Channel,String> {
}
