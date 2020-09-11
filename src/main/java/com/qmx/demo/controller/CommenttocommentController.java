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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    private MessageService messageService;

    @PostMapping("/addCommenttocomment")
    public String addPosting(HttpServletRequest request,
                            Commenttocomment commenttocomment,
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
        //通知回复人


        StringBuffer url1 = request.getRequestURL();
        String tempContextUrl1 = url1.delete(url1.length() - request.getRequestURI().length(), url1.length()).append("/").toString();

        String path0 = tempContextUrl1;
        Message message= new Message(commenttocomment.getTouserid(),commenttocomment.getUsername()+"回复了你",path0+"showPosting?postingid=" + postingid + "&commentid=l" + commenttocomment.getCommentid(),1);
        messageService.save(message);
        //通知发帖人
        message= new Message(comment.getId(),"文章有新的回复",path0+"showPosting?postingid=" + postingid + "&commentid=l" + commenttocomment.getCommentid(),0);
        messageService.save(message);
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
        Commenttocomment commenttocomment1 = commenttocommentService.getOne(wrapper);
        commenttocomment1.setCommentcontent(commenttocomment.getCommentcontent());
        commenttocommentService.update(commenttocomment1,wrapper);
        if(type == 0){
            return "redirect:/showPosting?type=0&postingid=" + postingid;
        }
        else{
            return "redirect:/showPosting?type=1&postingid=" + postingid;
        }
    }
}

