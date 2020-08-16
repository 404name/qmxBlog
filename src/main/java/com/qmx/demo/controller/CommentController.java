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
    private PostingService postingService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommenttocommentService commenttocommentService;

    @RequestMapping("/addComment")
    public String addComment(Comment comment,
                             @RequestParam(value = "type",required = false,defaultValue = "1")int type){
        //保存
        commentService.save(comment);

        //更新文章最后更新时间
        QueryWrapper<Posting> wrapper = new QueryWrapper<>();
        wrapper.eq("postingid",comment.getTopostingid());
        Posting posting = postingService.getOne(wrapper);
        postingService.updateById(posting);
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
                                @RequestParam(value = "type",required = false,defaultValue = "1")int type){
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("commentid",commentid);
        Comment comment = commentService.getOne(wrapper);
        Integer postingid = comment.getTopostingid();
        commentService.remove(wrapper);
        //删除楼中楼
        QueryWrapper<Commenttocomment> wrapper0 = new QueryWrapper<>();
        wrapper0.eq("tocommentid",commentid);
        commenttocommentService.remove(wrapper0);
        if(type == 0){
            return "redirect:/showPosting?type=0&postingid=" + postingid;
        }
        else{
            return "redirect:/showPosting?type=1&postingid=" + postingid;
        }
    }
    @RequestMapping("/updataComment")
    public String updataComment(Comment comment,
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
