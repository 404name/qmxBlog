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

}

