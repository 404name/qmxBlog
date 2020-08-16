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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class UserInterface {
    @Autowired
    public UserService userService;

    @RequestMapping("/selectUser")
    public  Object showUser(@RequestParam(value = "id",required = false,defaultValue = "1")Integer id){
        HashMap<String,Object> map = new HashMap<>();
        User user = userService.selectById(id);
        map.put("user",user);
        return map;
    }

    @RequestMapping("ajaxCheck")
    public Object ajaxCheck(String username,String password){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        HashMap<String,String> map = new HashMap<>();
        wrapper.eq("email",username);
        User user = userService.getOne(wrapper);
        if(user == null) {
            map.put("Umsg","不存在该账户");
            map.put("Pmsg","");
        }else if(user.getPassword().equals(password)){
            map.put("Umsg","");
            map.put("Pmsg","登陆成功");
        }else{
            map.put("Umsg","");
            map.put("Pmsg","登陆失败");
        }
        if(password==""){
            map.put("Pmsg","密码不能为空");
        }
        return map;
    }
////    登陆验证，或许后期可以不要，未完成
//    @RequestMapping("loginCheck")
//    public Boolean loginCheck(String username,String password){
//        QueryWrapper<User> wrapper = new QueryWrapper<>();
////        无论用户输入姓名还是邮箱只要密码对了均可登录
//        wrapper.eq("email",username);
//        User getUserByEmail = userService.getOne(wrapper);
//        if(getUserByEmail!=null && getUserByEmail.getPassword().equals(password))
//            return true;
//        else {
//            wrapper.eq("email","");
//            wrapper.eq("username",username);
//            User getUserByName = userService.getOne(wrapper);
//            return getUserByName != null && getUserByName.getPassword().equals(password);
//        }
//
//    }

    @RequestMapping("/selectAllUser")
    public Object getuser(@RequestParam(value = "logic",required = false,defaultValue = "1")int logic){
        //if(loadController.loadclass != 5){
        //    return null;
        //}
        HashMap<String,Object> map = new HashMap<>();
        if(logic == 1){
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("deleted","0");
            List<User> users =  userService.list(queryWrapper);
            map.put("data",users);
            return map;
        }else{
            List<User> users =  userService.list();
            map.put("data",users);
            return map;
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

}

