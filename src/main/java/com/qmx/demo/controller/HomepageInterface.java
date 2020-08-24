package com.qmx.demo.controller;


import com.qmx.demo.entity.Homepage;
import com.qmx.demo.entity.Postingclass;
import com.qmx.demo.service.HomepageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 404name
 * @since 2020-08-24
 */
@RestController
@RequestMapping("/homepage")
public class HomepageInterface {
    @Autowired
    private HomepageService homepageService;
    @RequestMapping("/selectAll")
    public Object selectAll(){
        HashMap<String,Object> map = new HashMap<>();
        List<Homepage> homepages = homepageService.selectAll();
        map.put("homepages",homepages);
        return map;
    }
}

