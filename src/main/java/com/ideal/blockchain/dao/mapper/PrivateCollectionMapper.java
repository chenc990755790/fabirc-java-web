package com.ideal.blockchain.dao.mapper;

import com.ideal.blockchain.dao.base.BaseMapper;
import com.ideal.blockchain.dao.model.CollectionEntity;

import java.util.Set;

public interface PrivateCollectionMapper extends BaseMapper<CollectionEntity> {
    void updateByCollectionName(CollectionEntity entity);
    Set<String> getCollectionNameList(String companyId);
}
