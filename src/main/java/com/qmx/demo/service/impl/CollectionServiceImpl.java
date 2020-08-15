package com.qmx.demo.service.impl;

import com.qmx.demo.entity.Collection;
import com.qmx.demo.entity.Posting;
import com.qmx.demo.mapper.CollectionMapper;
import com.qmx.demo.service.CollectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 404name
 * @since 2020-08-13
 */
@Service
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, Collection> implements CollectionService {
    @Autowired
    public CollectionMapper collectionMapper;
    @Override
    public List<Integer> getCollectionUserByPostingid(Integer postingid) {
        return collectionMapper.getCollectionUserByPostingid(postingid);
    }

    @Override
    public Integer getCollectionnumByPostingid(Integer postingid) {
        return collectionMapper.getCollectionnumByPostingid(postingid);
    }

    @Override
    public List<Posting> getCollectionByUserid(Integer userid) {
        return collectionMapper.getCollectionByUserid(userid);
    }

    @Override
    public Integer getCollectionnumByUserid(Integer userid) {
        return collectionMapper.getCollectionnumByUserid(userid);
    }
}
