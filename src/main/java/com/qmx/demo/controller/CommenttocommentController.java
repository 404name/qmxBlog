package com.qmx.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qmx.demo.entity.Comment;
import com.qmx.demo.entity.Commenttocomment;
import com.qmx.demo.entity.Posting;
import com.qmx.demo.service.CommenttocommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 404name
 * @since 2020-08-13
 */
@Controller
public class CommenttocommentController {
    @Autowired
    private CommenttocommentService commenttocommentService;

    @PostMapping("/addCommenttocomment")
    public String addPosting(Commenttocomment commenttocomment,
                             @RequestParam(value = "postingid",required = true)Integer postingid,
                             @RequestParam(value = "type",required = false,defaultValue = "1")int type){
            commenttocommentService.save(commenttocomment);
            String path = null;
            System.out.println("---------------------------------------------");
        System.out.println(commenttocomment);
        System.out.println("---------------------------------------------");
            if(type == 0){
                path = "redirect:/showPosting?type=0&postingid=" + postingid;
            }
            else{
                path = "redirect:/showPosting?type=1&postingid=" + postingid;
            }
            return path;
        }
    @RequestMapping("/deleteCommenttocomment")
    public String deleteCommenttocomment(@RequestParam(value = "commentid",required = true)Integer commentid,
                                @RequestParam(value = "postingid",required = true)Integer postingid,
                                @RequestParam(value = "type",required = false,defaultValue = "1")int type){
        QueryWrapper<Commenttocomment> wrapper = new QueryWrapper<>();
        wrapper.eq("commentid",commentid);
        commenttocommentService.remove(wrapper);
        if(type == 0){
            return "redirect:/showPosting?type=0&postingid=" + postingid;
        }
        else{
            return "redirect:/showPosting?type=1&postingid=" + postingid;
        }
    }
    @RequestMapping("/updataCommenttocomment")
    public String updataCommenttocomment(Commenttocomment commenttocomment,
                                @RequestParam(value = "postingid",required = true)Integer postingid,
                                @RequestParam(value = "type",required = false,defaultValue = "1")int type){
        QueryWrapper<Commenttocomment> wrapper = new QueryWrapper<>();
        wrapper.eq("commentid",commenttocomment.getCommentid());
        commenttocommentService.update(commenttocomment,wrapper);
        if(type == 0){
            return "redirect:/showPosting?type=0&postingid=" + postingid;
        }
        else{
            return "redirect:/showPosting?type=1&postingid=" + postingid;
        }
    }
}

