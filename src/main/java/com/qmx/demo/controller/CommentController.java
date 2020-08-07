package com.qmx.demo.controller;

import com.qmx.demo.entity.Comment;
import com.qmx.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String addComment(Comment comment){
        commentService.save(comment);
        String path = "redirect:/showPosting?postingid=" + comment.getTopostingid();
        System.out.println(path);
        return path;
    }
    @RequestMapping("/deleteComment")
    public String deleteComment(Comment comment){
        commentService.save(comment);
        return "/showPosting?postingid=" + comment.getTopostingid();
    }
}
