package com.qmx.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qmx.demo.entity.Comment;
import com.qmx.demo.entity.Commenttocomment;
import com.qmx.demo.entity.Message;
import com.qmx.demo.entity.Posting;
import com.qmx.demo.service.CommentService;
import com.qmx.demo.service.CommenttocommentService;
import com.qmx.demo.service.MessageService;
import com.qmx.demo.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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
    @Autowired
    private MessageService messageService;
    @RequestMapping("/addComment")
    public String addComment( HttpServletRequest request,Comment comment,
                             @RequestParam(value = "type",required = false,defaultValue = "1")int type){
        //保存
        commentService.save(comment);
        //更新文章最后更新时间
        QueryWrapper<Posting> wrapper = new QueryWrapper<>();
        wrapper.eq("postingid",comment.getTopostingid());
        Posting posting = postingService.getOne(wrapper);
        posting.setCommentnum(posting.getCommentnum()+1);
        posting.setUpdatadate(new Date());
        postingService.update(posting,wrapper);
        //通知发帖人

        StringBuffer url1 = request.getRequestURL();
        String tempContextUrl1 = url1.delete(url1.length() - request.getRequestURI().length(), url1.length()).append("/").toString();

        String path0 = tempContextUrl1;
        Message message = new Message(posting.getId(),"文章有新的回复",path0+"showPosting?postingid=" + comment.getTopostingid() + "&commentid=" + comment.getCommentid(),0);
        messageService.save(message);
        String path = path = "redirect:/showPosting?postingid=" + comment.getTopostingid();
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

        //删除文章对应评论 以及楼中楼评论数量
        QueryWrapper<Posting> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("postingid",postingid);
        Posting posting = postingService.getOne(wrapper1);
        posting.setCommentnum(posting.getCommentnum()-1-comment.getCommenttocommentnum());
        postingService.update(posting,wrapper1);
        //删除楼中楼
        QueryWrapper<Commenttocomment> wrapper0 = new QueryWrapper<>();
        wrapper0.eq("tocommentid",commentid);
        commenttocommentService.remove(wrapper0);
        return "redirect:/showPosting?postingid=" + postingid;
    }
    @RequestMapping("/updataComment")
    public String updataComment(Comment comment,
                                @RequestParam(value = "type",required = false,defaultValue = "1")int type){
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("commentid",comment.getCommentid());
        Comment comment1 = commentService.getOne(wrapper);
        comment1.setCommentcontent(comment.getCommentcontent());
        commentService.update(comment1,wrapper);
        if(type == 0){
            return "redirect:/showPosting?type=0&postingid=" + comment1.getTopostingid();
        }
        else{
            return "redirect:/showPosting?type=1&postingid=" + comment1.getTopostingid();
        }
    }
}
