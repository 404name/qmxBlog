package com.qmx.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qmx.demo.entity.Collection;
import com.qmx.demo.entity.Comment;
import com.qmx.demo.entity.Commentlike;
import com.qmx.demo.entity.Posting;
import com.qmx.demo.service.CollectionService;
import com.qmx.demo.service.CommentService;
import com.qmx.demo.service.CommentlikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 404name
 * @since 2020-08-13
 */
@RestController
public class CommentlikeInterface {
    @Autowired
    public CommentlikeService commentlikeService;
    @Autowired
    private CommentService commentService;
    @RequestMapping("/commentlike")
    public Object collection(Commentlike commentlike0){
        HashMap<String,Object> map = new HashMap<>();
        QueryWrapper<Commentlike> wrapper = new QueryWrapper<>();
        wrapper.eq("userid",commentlike0.getUserid());
        wrapper.eq("commentid",commentlike0.getCommentid());
        Commentlike commentlike = commentlikeService.getOne(wrapper);
        if(commentlike == null){
            commentlikeService.save(commentlike0);
            //增加收藏量
            QueryWrapper<Comment> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("commentid",commentlike0.getCommentid());
            Comment comment = commentService.getOne(wrapper1);
            comment.setLikes(comment.getLikes()+1);
            commentService.update(comment,wrapper1);
            map.put("msg","点赞成功");
        }else{
           commentlikeService.remove(wrapper);
            //增加收藏量
            QueryWrapper<Comment> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("commentid",commentlike0.getCommentid());
            Comment comment = commentService.getOne(wrapper1);
            comment.setLikes(comment.getLikes()-1);
            commentService.update(comment,wrapper1);
            map.put("msg","取消点赞");
        }
        return map;
    }
}

