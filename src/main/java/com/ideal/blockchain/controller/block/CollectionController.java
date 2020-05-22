package com.ideal.blockchain.controller.block;

import com.ideal.blockchain.collection.CollectionParserService;
import com.ideal.blockchain.dao.model.CollectionEntity;
import com.ideal.blockchain.dto.response.ResultInfo;
import com.ideal.blockchain.enums.ResponseCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/collection")
public class CollectionController {
    @Autowired
    private CollectionParserService collectionParserService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo save(@RequestBody CollectionEntity entity) {
        if (StringUtils.isEmpty(entity.getCollectionName())) {
            return new ResultInfo(ResponseCodeEnum.FAILURE, "collectionName can not null");
        }
        String name = collectionParserService.addCollectionName(entity.getCollectionName());
        collectionParserService.insertCollectionConfig(entity);
        if (StringUtils.isEmpty(name)) {
            return new ResultInfo(ResponseCodeEnum.SUCCESS, "please upgrade chaincode next");
        } else {
            return new ResultInfo(ResponseCodeEnum.SUCCESS, "save success");
        }
    }

    @RequestMapping(value = "/queryCollection", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo queryCollection() {
        return new ResultInfo(ResponseCodeEnum.SUCCESS, collectionParserService.getCollectNameList());
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo modify(@RequestBody CollectionEntity entity) {
        if (StringUtils.isEmpty(entity.getCollectionName())) {
            return new ResultInfo(ResponseCodeEnum.FAILURE, "collectionName can not null");
        }
        collectionParserService.updateCollectionConfig(entity);
        return new ResultInfo(ResponseCodeEnum.SUCCESS, "modify success");
    }
}
