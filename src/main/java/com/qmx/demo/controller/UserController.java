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

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //通过邮箱检测用户
    public boolean checkUser(String email){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("email",email);
        User user = userService.getOne(wrapper);
        if(user == null){
            return false;
        }else{
            return true;
        }
    }

    @RequestMapping("/toAllUser")
    public String listuser(Model model, HttpSession session){
        User user = (User)session.getAttribute("loadUser");
        if(user == null || user.getUserclass() != 5){
            session.setAttribute("msg","你没有权限访问");
            return "redirect:/index";
        }
        return "/admin/list/user";
    }
    @RequestMapping("/updataUser")
    public String updatauser(@RequestParam(value = "userid",required = true)int id,
                                Model model){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        User user =  userService.getOne(queryWrapper);
        model.addAttribute("user",user);
        return "redirect:/admin/detail/userUpdata";
    }
    @RequestMapping(value = "/showUser")
    public String showUser(@RequestParam(value = "id",required = true)int id,
                           Model model){
        User user = userService.getById(id);
        model.addAttribute("user",user);
        return "/user/profileDetail";
    }
    @PostMapping("/updataUser")
    public String updatauser1(User user,
                                 Model model){
        System.out.println(user);
        userService.updateById(user);
        return "redirect:/admin/list/user";
    }
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String adduser(User user,
                          Model model){
        System.out.println(user);
        userService.save(user);
        return "redirect:/admin/list/user";
    }
}
