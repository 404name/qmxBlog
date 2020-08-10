package com.qmx.demo.controller;

/*------------------------
 *
 *@author 404name
 *@create 2020/8/4
 *------------------------*/

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qmx.demo.entity.User;
import com.qmx.demo.entity.Userclass;
import com.qmx.demo.service.CommentService;
import com.qmx.demo.service.UserService;
import com.qmx.demo.service.UserclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class loadController {
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserclassService userclassService;
    //注册 跳转
    @GetMapping("/register")
    public String toRegister(Model model){
        List<Userclass> userclasses = userclassService.list();
        model.addAttribute("userclasses",userclasses);
        return "/loginService/register";
    }
    //快速登录
    @RequestMapping(value = "/1")
    public String adminQuickLoad(HttpSession session){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email","111");
        User user = userService.getOne(queryWrapper);
        session.setAttribute("loadUser",user);
        session.setAttribute("msg","");
        return "redirect:/index";
    }
    @RequestMapping(value = "/2")
    public String userQuickLoad(HttpSession session){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email","666");
        User user = userService.getOne(queryWrapper);
        session.setAttribute("loadUser",user);
        session.setAttribute("msg","");
        return "redirect:/index";
    }
    //登录 及跳转
    @RequestMapping(value = "/load")
    public String checkLoad(
            @RequestParam(value = "inputAccount", required = false, defaultValue = " ")String inputAccount,
            @RequestParam(value = "inputPassword",required = false,defaultValue = " ")String inputPassword,
            Model model, HttpSession session){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email",inputAccount);
        queryWrapper.eq("password",inputPassword);
        User user = userService.getOne(queryWrapper);
        if(user == null){
            session.setAttribute("msg","密码错误,或查询不到该用户");
            return "redirect:/loginService/login";
        }else{
            //管理员管理界面
            session.setAttribute("loadUser",user);
            session.setAttribute("msg","");
            return "redirect:/index";
        }
    }
    @RequestMapping("/logout")
    public String logout(Model model,HttpSession session){
        System.out.println("????");
        User user = null;
        session.setAttribute("loadUser",user);
        session.setAttribute("msg","");
        return "redirect:/index";
    }
}
