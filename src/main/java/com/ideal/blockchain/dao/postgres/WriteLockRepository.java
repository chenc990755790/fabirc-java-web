package com.ideal.blockchain.dao.postgres;

import com.ideal.blockchain.entity.postgres.WriteLock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WriteLockRepository extends JpaRepository<WriteLock,String> {
}
