package com.qmx.demo.controller;

/*------------------------
 *
 *@author 404name
 *@create 2020/8/4
 *------------------------*/

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mysql.cj.Session;
import com.qmx.demo.entity.Comment;
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
        return "/register";
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
            return "redirect:login";
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
    @RequestMapping("/list/user")
    public String listuser(Model model,HttpSession session){
        User user = (User)session.getAttribute("loadUser");
        if(user == null || user.getUserclass() != 5){
            session.setAttribute("msg","你没有权限访问");
            return "redirect:/index";
        }
////        model.addAttribute("power",loadclass);
////        model.addAttribute("name",loadController.user.getUsername());
//        model.addAttribute("user",loadController.user);
////        测试插件而获取的所有数据，目前已知table插件和ajax获取后台代码再修改前端有冲突，所以搞了这里的代码
////        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
////        queryWrapper.eq("deleted","0");
////        List<Comment> users = commentService.list(queryWrapper);
        return "list/user";
    }
    @RequestMapping("/list/posting")
    public String listposting(Model model,HttpSession session){
        User user = (User)session.getAttribute("loadUser");
        if(user == null || user.getUserclass() != 5){
            session.setAttribute("msg","你没有权限访问");
            return "redirect:/index";
        }
//        model.addAttribute("power",loadclass);
//        model.addAttribute("name",loadController.user.getUsername());
        return "list/posting";
    }
}
