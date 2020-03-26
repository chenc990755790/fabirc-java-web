package com.ideal.blockchain.dao.mapper;

import com.ideal.blockchain.dao.base.BaseMapper;
import com.ideal.blockchain.dao.model.CollectionEntity;

import java.util.List;

public interface PrivateCollectionMapper extends BaseMapper<CollectionEntity> {
    void updateByCollectionName(CollectionEntity entity);
    List<String> getCollectionNameList(String companyId);
}
