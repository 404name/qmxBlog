package com.qmx.demo.controller;

/*------------------------
 *
 *@author 404name
 *@create 2020/8/4
 *------------------------*/

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qmx.demo.entity.User;
import com.qmx.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class loadController {
    @Autowired
    public UserService userService;
    //登录 及跳转
    @RequestMapping("/load")
    public String checkLoad(
            @RequestParam(value = "inputAccount", required = false, defaultValue = " ")String inputAccount,
            @RequestParam(value = "inputPassword",required = false,defaultValue = " ")String inputPassword,
            Model model){
        System.out.println(1);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email",inputAccount);
        queryWrapper.eq("password",inputPassword);
        User user = userService.getOne(queryWrapper);
        if(queryWrapper == null || user == null){
            model.addAttribute("msg","错误的密码");
            System.out.println(22);
            return "index";
        }else if(user.getUserclass() == 4){
            //管理员管理界面
            String name = user.getUsername();
            model.addAttribute("name",name);
            return "test";
        }
        else{
            //用户进入首页
            return "main";
        }
    }
}
