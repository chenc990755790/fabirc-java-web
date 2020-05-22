package com.ideal.blockchain.dao.oracle;

import com.ideal.blockchain.entity.saas.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,String> {
}
