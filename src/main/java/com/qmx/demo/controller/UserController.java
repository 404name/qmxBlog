package com.qmx.demo.controller;

/*------------------------
 *
 *@author 404name
 *@create 2020/8/7
 *------------------------*/

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qmx.demo.entity.Posting;
import com.qmx.demo.entity.User;
import com.qmx.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/updataUser")
    public String updatauser(@RequestParam(value = "userid",required = true)int id,
                                Model model){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        User user =  userService.getOne(queryWrapper);
        model.addAttribute("user",user);
        return "redirect:/detail/userUpdata";
    }
    @PostMapping("/updataUser")
    public String updatauser1(User user,
                                 Model model){
        System.out.println(user);
        userService.updateById(user);
        return "redirect:/list/user";
    }
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String adduser(User user,
                          Model model){
        System.out.println(user);
        userService.save(user);
        return "redirect:/list/user";
    }
}
