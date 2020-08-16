package com.qmx.demo.service;

import com.qmx.demo.entity.Collection;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qmx.demo.entity.Posting;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 404name
 * @since 2020-08-13
 */
public interface CollectionService extends IService<Collection> {
    List<Integer> getCollectionUserByPostingid(Integer postingid);
    Integer getCollectionnumByPostingid(Integer postingid);

    List<Posting> getCollectionByUserid(Integer id);
    Integer getCollectionnumByUserid(Integer id);
}
