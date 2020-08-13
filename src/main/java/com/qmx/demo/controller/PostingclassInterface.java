package com.qmx.demo.controller;


import com.qmx.demo.entity.Postingclass;
import com.qmx.demo.entity.Userclass;
import com.qmx.demo.service.PostingService;
import com.qmx.demo.service.PostingclassService;
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
@RestController
public class PostingclassInterface {
    @Autowired
    private PostingclassService postingclassService;
    @Autowired
    private PostingService postingService;
    @RequestMapping("/postingmessage")
    public Object postingclass(){
        HashMap<String,Object> map = new HashMap<>();
        List<Postingclass> postingclasses = postingclassService.selectAll();
        Integer postingnum = postingService.getPostingNum();
        map.put("postingclasses",postingclasses);
        map.put("postingnum",postingnum);
        return map;
    }
}

