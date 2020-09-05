package com.qmx.demo.controller;

/*------------------------
 *
 *@author 404name
 *@create 2020/8/7
 *------------------------*/

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qmx.demo.entity.Follow;
import com.qmx.demo.entity.User;
import com.qmx.demo.service.FollowService;
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
    @Autowired
    private FollowService followService;
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
        return "admin/list/user";
    }
    @RequestMapping("/updataUser")
    public String updatauser(User user,
                                Model model){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",user.getId());
        userService.update(user,queryWrapper);
        return "redirect:/showUser?id="+user.getId();
    }
    @RequestMapping("/deleteUser")
    public String deleteuser(Integer id,
                             Model model){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        userService.remove(queryWrapper);
        return "admin/list/user";
    }
    @RequestMapping(value = "/showUser")
    public String showUser(@RequestParam(value = "id",required = true)int id,
                           HttpSession session,
                           Model model){
        User user = userService.getById(id);
        model.addAttribute("user",user);
        //判断是否关注
        User user1 = (User)session.getAttribute("loadUser");
        Integer id1 = user1.getId();
        QueryWrapper<Follow> wrapper = new QueryWrapper<>();
        wrapper.eq("userid",id1);
        wrapper.eq("followid",id);
        Follow follow = followService.getOne(wrapper);
        if(follow == null){
            String msg = "未关注";
            model.addAttribute("followMsg",msg);
        }else{
            String msg = "已关注";
            model.addAttribute("followMsg",msg);
        }
        return "user/profileDetail";
    }
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String adduser(User user,
                          Model model){
        System.out.println(user);
        userService.save(user);
        return "admin/list/user";
    }
    @RequestMapping("/changePassword")
    public String changePassword(Integer userid,String password,String repassword,Model model){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id",userid);
        User user = userService.getOne(wrapper);
        if (user.getPassword().equals(password)){
            user.setPassword(repassword);
            userService.update(user,wrapper);
            return "loginService/login";
        }
        else {
            return "user/security_setting";
        }
    }
}
