package com.qmx.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qmx.demo.entity.Comment;
import com.qmx.demo.entity.Posting;
import com.qmx.demo.entity.User;
import com.qmx.demo.service.CommentService;
import com.qmx.demo.service.PostingService;
import com.qmx.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    public CommentService commentService;

    @RequestMapping("/selectAllComment")
    public List<Comment> getcomment(@RequestParam(value = "logic",required = false,defaultValue = "1")int logic){
        if(logic == 1){
            QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("deleted","0");
            return commentService.list(queryWrapper);
        }else{
            return commentService.list();
        }
    }

    @RequestMapping("/selectPage")
    public Page<Comment> getpage(
            @RequestParam(value = "logic",required = false,defaultValue = "1")int logic,
            @RequestParam(value = "page", required = false, defaultValue = "1")int page,
            @RequestParam(value = "size",required = false,defaultValue = "5")int size){
        if(logic == 1){
            QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("deleted","0");
            Page<Comment> pages = new Page<>(page,size);
            return commentService.page(pages,queryWrapper);
        }else{
            Page<Comment> pages = new Page<>(page,size);
            return commentService.page(pages);
        }
    }

    @RequestMapping("/delete")
    public Boolean deleteLogic(
            @RequestParam(value = "id", required = true)int id,
            @RequestParam(value = "logic",required = false,defaultValue = "1")int logic){
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("commentid",id);
        Comment comment = commentService.listByMap(hashMap).get(0);
        //逻辑删除
        if(logic == 1 && comment != null){
            if(comment.getDeleted() == 0){
                UpdateWrapper<Comment> updateWrapper = new UpdateWrapper<>();
                updateWrapper.eq("postingid",id);
                comment.setDeleted(1);
                commentService.update(comment,updateWrapper);
                return true;
            }
            else{
                return false;
            }
        }//物理删除
        else if(comment!=null){
            Boolean res = commentService.removeByMap(hashMap);
            return  res;
        }
        return false;
    }
}

