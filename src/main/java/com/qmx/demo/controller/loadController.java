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
    public static int loadclass;
    public static User user;
    static{
        loadclass = -1;
        user = null;
        //0 无查看权限
        //1  游客 可查看可评论，不可查看周任务等
        //2 3 组员
        //4 老师
        //5 管理员
    }
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
            loadclass = 0;
            return "login";
        }else{
            //管理员管理界面
            loadclass = user.getUserclass();
            loadController.user = user;
            String name = user.getUsername();
            model.addAttribute("power",loadclass);
            model.addAttribute("name",loadController.user.getUsername());
            model.addAttribute("user",loadController.user);
            return "index";
        }
    }
    @RequestMapping("/logout")
    public String logout(Model model){
        loadController.loadclass = 0;
        loadController.user = null;
        model.addAttribute("power",loadclass);
        model.addAttribute("name",loadController.user.getUsername());
        model.addAttribute("user",loadController.user);
        return "index";
    }
    @RequestMapping("/list/user")
    public String listuser(Model model){
        if(loadclass != 5){
            return "index";
        }
        model.addAttribute("power",loadclass);
        model.addAttribute("name",loadController.user.getUsername());
        model.addAttribute("user",loadController.user);
        return "list/user";
    }
    @RequestMapping("/list/posting")
    public String listposting(Model model){
        if(loadclass != 5){
            return "index";
        }
        model.addAttribute("power",loadclass);
        model.addAttribute("name",loadController.user.getUsername());
        model.addAttribute("user",loadController.user);
        return "list/posting";
    }
}
