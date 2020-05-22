package com.ideal.blockchain.dao.oracle;

import com.ideal.blockchain.entity.saas.InvoiceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceInfo,String> {
}
