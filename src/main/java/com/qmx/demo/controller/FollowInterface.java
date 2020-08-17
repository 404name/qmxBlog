package com.qmx.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qmx.demo.entity.Collection;
import com.qmx.demo.entity.Follow;
import com.qmx.demo.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 404name
 * @since 2020-08-17
 */
@RestController
public class FollowInterface {
    @Autowired
    private FollowService followService;
    @RequestMapping("/follow")
    public Object collection(Follow follow0) {
        HashMap<String, Object> map = new HashMap<>();
        QueryWrapper<Follow> wrapper = new QueryWrapper<>();
        wrapper.eq("userid", follow0.getUserid());
        wrapper.eq("followid", follow0.getFollowid());
        Follow follow = followService.getOne(wrapper);
        if (follow == null) {
            followService.save(follow);
            map.put("msg", "关注成功");
        } else {
            followService.remove(wrapper);
            map.put("msg", "取消关注");
        }
        return map;
    }
}

