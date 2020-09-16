package com.qmx.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qmx.demo.entity.Luck;
import com.qmx.demo.entity.Message;
import com.qmx.demo.entity.User;
import com.qmx.demo.service.LuckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/*------------------------
 *
 *@author 404name
 *@create 9/16/2020
 *------------------------*/
@RestController
@RequestMapping("/luck")
public class LuckInterface {
    @Autowired
    LuckService luckService;
    @RequestMapping("/add")
    public Object selectAll(Luck luck){
        HashMap<String,Object> map  = new HashMap<>();
        String name = luck.getName();
        QueryWrapper<Luck> wrapper = new QueryWrapper<>();
        wrapper.eq("name",name);
        Luck luck1 = null;
        luck1 = luckService.getOne(wrapper);
        if(luck1 == null){
            luckService.save(luck);
            map.put("msg","成功签到");
            return map;
        }else{
            map.put("msg","请勿重复签到");
            return map;
        }
    }
}
