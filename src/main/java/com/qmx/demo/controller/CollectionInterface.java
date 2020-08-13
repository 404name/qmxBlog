package com.qmx.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qmx.demo.entity.Collection;
import com.qmx.demo.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 404name
 * @since 2020-08-13
 */
@RestController
public class CollectionInterface {
    @Autowired
    public CollectionService collectionService;

    @RequestMapping("/collection")
    public Object collection(@RequestParam(value = "userid", required = true)Integer userid,
                             @RequestParam(value = "username", required = true)String username,
                             @RequestParam(value = "postingid", required = true)Integer postingid){
        HashMap<String,Object> map = new HashMap<>();
        QueryWrapper<Collection> wrapper = new QueryWrapper<>();
        wrapper.eq("userid",userid);
        wrapper.eq("postingid",postingid);
        Collection collection = collectionService.getOne(wrapper);
        if(collection == null){
            Collection collection0 = new Collection(userid,username,postingid);
            collectionService.save(collection0);
            map.put("msg","关注成功");
        }else{
            collectionService.remove(wrapper);
            map.put("msg","取消关注");
        }
        return map;
    }
}

