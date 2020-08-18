package com.qmx.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qmx.demo.entity.Comment;
import com.qmx.demo.entity.Commenttocomment;
import com.qmx.demo.entity.Posting;
import com.qmx.demo.service.CommentService;
import com.qmx.demo.service.CommenttocommentService;
import com.qmx.demo.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
    @Autowired
    private PostingService postingService;
    @Autowired
    private CommentService commentService;
    @PostMapping("/addCommenttocomment")
    public String addPosting(Commenttocomment commenttocomment,
                             @RequestParam(value = "postingid",required = true)Integer postingid,
                             @RequestParam(value = "type",required = false,defaultValue = "1")int type){
            commenttocommentService.save(commenttocomment);
        //更新文章最后更新时间  文章评论+1
        QueryWrapper<Posting> wrapper = new QueryWrapper<>();
        wrapper.eq("postingid",postingid);
        Posting posting = postingService.getOne(wrapper);
        posting.setUpdatadate(new Date());
        posting.setCommentnum(posting.getCommentnum()+1);
        postingService.update(posting,wrapper);
        //更新评论楼层  评论+1
        QueryWrapper<Comment> wrapper0 = new QueryWrapper<>();
        wrapper0.eq("commentid",commenttocomment.getTocommentid());
        Comment comment = commentService.getOne(wrapper0);
        comment.setCommenttocommentnum(comment.getCommenttocommentnum()+1);
        commentService.update(comment,wrapper0);
        String path = "redirect:/showPosting?postingid=" + postingid;
            return path;
        }
    @RequestMapping("/deleteCommenttocomment")
    public String deleteCommenttocomment(@RequestParam(value = "commentid",required = true)Integer commentid,
                                @RequestParam(value = "postingid",required = true)Integer postingid,
                                @RequestParam(value = "type",required = false,defaultValue = "1")int type){
        QueryWrapper<Commenttocomment> wrapper = new QueryWrapper<>();
        wrapper.eq("commentid",commentid);
        Commenttocomment commenttocomment = commenttocommentService.getOne(wrapper);
        commenttocommentService.remove(wrapper);

        //更新文章最后更新时间  文章评论+1
        QueryWrapper<Posting> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("postingid",postingid);
        Posting posting = postingService.getOne(wrapper1);
        posting.setCommentnum(posting.getCommentnum()-1);
        postingService.update(posting,wrapper1);
        //更新评论楼层  评论+1
        QueryWrapper<Comment> wrapper0 = new QueryWrapper<>();
        wrapper0.eq("commentid",commenttocomment.getTocommentid());
        Comment comment = commentService.getOne(wrapper0);
        comment.setCommenttocommentnum(comment.getCommenttocommentnum()-1);
        commentService.update(comment,wrapper0);
        return "redirect:/showPosting?postingid=" + postingid;
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

