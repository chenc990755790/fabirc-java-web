package com.ideal.blockchain.dao.oracle;

import com.ideal.blockchain.entity.saas.Receivable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceivableRepository extends JpaRepository<Receivable,String> {
}
