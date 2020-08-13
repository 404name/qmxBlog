package com.qmx.demo.controller;


import com.qmx.demo.entity.Userclass;
import com.qmx.demo.service.UserService;
import com.qmx.demo.service.UserclassService;
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
 * @since 2020-08-07
 */

//用户信息控制器
@RestController
public class UserclassInterface {
    @Autowired
    private UserclassService userclassService;
    @Autowired
    private UserService userService;
    @RequestMapping("/usermessage")
    public Object userclass(){
        HashMap<String,Object> map = new HashMap<>();
        List<Userclass> userclasses = userclassService.selectAll();
        Integer usernum = userService.getUserNum();
        map.put("userclasses",userclasses);
        map.put("usernum",usernum);
        return map;
    }
}

