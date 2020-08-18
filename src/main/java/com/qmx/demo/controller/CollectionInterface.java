package com.qmx.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qmx.demo.entity.Collection;
import com.qmx.demo.entity.Posting;
import com.qmx.demo.service.CollectionService;
import com.qmx.demo.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 404name
 * @since 2020-08-13
 */
@RestController
public class CollectionInterface {
    @Autowired
    public CollectionService collectionService;
    @Autowired
    private PostingService postingService;
    @RequestMapping("/collection")
    public Object collection(Collection collection0) {
        HashMap<String, Object> map = new HashMap<>();
        QueryWrapper<Collection> wrapper = new QueryWrapper<>();
        wrapper.eq("userid", collection0.getUserid());
        wrapper.eq("postingid", collection0.getPostingid());
        Collection collection = collectionService.getOne(wrapper);
        if (collection == null) {
            collectionService.save(collection0);
            //增加收藏量
            QueryWrapper<Posting> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("postingid",collection0.getPostingid());
            Posting posting = postingService.getOne(wrapper1);
            posting.setCollectionnum(posting.getCollectionnum()+1);
            postingService.update(posting,wrapper1);
            map.put("msg", "关注成功");
        } else {
            collectionService.remove(wrapper);
            //减少收藏量
            QueryWrapper<Posting> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("postingid",collection0.getPostingid());
            Posting posting = postingService.getOne(wrapper1);
            posting.setCollectionnum(posting.getCollectionnum()-1);
            postingService.update(posting,wrapper1);
            map.put("msg", "取消关注");
        }
        return map;
    }

    @RequestMapping("/collectionornot")
    public Object collectedOrNot(Collection collection0) {
        HashMap<String, Object> map = new HashMap<>();
        QueryWrapper<Collection> wrapper = new QueryWrapper<>();
        wrapper.eq("userid", collection0.getUserid());
        wrapper.eq("postingid", collection0.getPostingid());
        Collection collection = collectionService.getOne(wrapper);
        if (collection == null) {
            map.put("msg", "未关注");
        } else {
            map.put("msg", "已关注");
        }
        return map;
    }
}

