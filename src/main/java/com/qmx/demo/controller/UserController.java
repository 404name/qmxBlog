package com.qmx.demo.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qmx.demo.entity.Comment;
import com.qmx.demo.entity.User;
import com.qmx.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 404name
 * @since 2020-08-03
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService userService;

    @RequestMapping("/selectAllUser")
    public List<User> getuser(@RequestParam(value = "logic",required = false,defaultValue = "1")int logic){
        if(logic == 1){
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("deleted","0");
            return userService.list(queryWrapper);
        }else{
            return userService.list();
        }
    }

    @RequestMapping("/selectPage")
    public Page<User> getpage(
            @RequestParam(value = "logic",required = false,defaultValue = "1")int logic,
            @RequestParam(value = "page", required = false, defaultValue = "1")int page,
            @RequestParam(value = "size",required = false,defaultValue = "5")int size
            ){
        if(logic == 1){
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("deleted","0");
            Page<User> pages = new Page<>(page,size);
            return userService.page(pages,queryWrapper);
        }else{
            Page<User> pages = new Page<>(page,size);
            return userService.page(pages);
        }
    }

    @RequestMapping("/delete")
    public Boolean deleteLogic(
            @RequestParam(value = "id", required = true)int id,
            @RequestParam(value = "logic",required = false,defaultValue = "1")int logic){
        User user = userService.getById(id);
        //逻辑删除
        if(logic == 1){
            if(user.getDeleted() == 0){
                user.setDeleted(1);
                QueryWrapper<User> wrapper = new QueryWrapper<>();
                wrapper.eq("id",id);
                userService.update(user,wrapper);
                return true;
            }
            else{
                return false;
            }
        }//物理删除
        else{
            Boolean res = userService.removeById(id);
            return  res;
        }
    }

    @RequestMapping("/register")
    public String registerNewUser(@RequestParam("username")String username,
                                  @RequestParam("schoolid")String schoolid,
                                  @RequestParam("email")String email,
                                  @RequestParam("gender")String gender,
                                  @RequestParam("password")String password,
                                  @RequestParam("userclass")String userclass,
                                  Model model) throws Exception{
        Integer intGender,intUserClass;
        if (gender.equals("male"))
            intGender=1;
        else    intGender=0;
        switch (userclass){
            case "游客": intUserClass = 0;break;
            case "开发组": intUserClass =1;break;
            case "硬件组": intUserClass =2;break;
            case "教师": intUserClass = 3;break;
            default:
                intUserClass = 0;break;
        }
        User user = new User(username,email,password,schoolid,intGender,intUserClass);
        //还没有完善mapper的接口，大致思路就是上面的了
        //邮箱/姓名重名问题，我想在前端用jQuery写，这里就不验证了
        return "";
    }
}

