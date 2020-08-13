package com.qmx.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qmx.demo.entity.Comment;
import com.qmx.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*------------------------
 *
 *@author 404name
 *@create 2020/8/7
 *------------------------*/
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/addComment")
    public String addComment(Comment comment,
                             @RequestParam(value = "type",required = false,defaultValue = "1")int type){
        commentService.save(comment);
        String path = null;
        if(type == 0){
            path = "redirect:/showPosting?type=0&postingid=" + comment.getTopostingid();
        }
        else{
            path = "redirect:/showPosting?type=1&postingid=" + comment.getTopostingid();
        }
        return path;
    }
    @RequestMapping("/deleteComment")
    public String deleteComment(@RequestParam(value = "commentid",required = true)Integer commentid,
                                @RequestParam(value = "logic",required = false,defaultValue = "1")int logic,
                                @RequestParam(value = "type",required = false,defaultValue = "1")int type){
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("commentid",commentid);
        Comment comment = commentService.getOne(wrapper);
        comment.setDeleted(1);
        commentService.update(comment,wrapper);
        if(type == 0){
            return "redirect:/showPosting?type=0&postingid=" + comment.getTopostingid();
        }
        else{
            return "redirect:/showPosting?type=1&postingid=" + comment.getTopostingid();
        }
    }
    @RequestMapping("/updataComment")
    public String deleteComment(Comment comment,
                                @RequestParam(value = "type",required = false,defaultValue = "1")int type){
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("commentid",comment.getCommentid());
        commentService.update(comment,wrapper);
        if(type == 0){
            return "redirect:/showPosting?type=0&postingid=" + comment.getTopostingid();
        }
        else{
            return "redirect:/showPosting?type=1&postingid=" + comment.getTopostingid();
        }
    }
}
