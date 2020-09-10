package com.qmx.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qmx.demo.entity.Homepage;
import com.qmx.demo.entity.Message;
import com.qmx.demo.entity.User;
import com.qmx.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 404name
 * @since 2020-09-05
 */
@RestController
@RequestMapping("/message")
public class MessageInterface {
    @Autowired
    private MessageService messageService;

    @RequestMapping("/selectAll")
    public Object selectAll(HttpSession session){
        HashMap<String,Object> map = new HashMap<>();
        User user = (User) session.getAttribute("loadUser");
        if(user != null){
            List<Message> messageList = messageService.selectByUserid(user.getId());
            map.put("messageList",messageList);
            return map;
        }
        return null;
    }
    @RequestMapping("/deleteById")
    public Object deletebyid(Integer id){
        Boolean bool = messageService.removeById(id);
        return null;
    }

    @RequestMapping("/deleteByUserId")
    public Object deletebyid(HttpSession session){
        User user = (User) session.getAttribute("loadUser");
        QueryWrapper<Message>  wrapper = new QueryWrapper<>();
        wrapper.eq("touserid",user.getId());
        Boolean bool = messageService.remove(wrapper);
        return null;
    }
}

