package com.ideal.blockchain.dao.oracle;

import com.ideal.blockchain.entity.saas.EnterpriseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseInfoRepository extends JpaRepository<EnterpriseInfo,String> {
}
