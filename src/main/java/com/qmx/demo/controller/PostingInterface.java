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

//logic声明：    1表示逻辑查询   是用户的展示
//              0表示非逻辑  是管理员的，可查看用户删除的数据
@RestController
@RequestMapping("/posting")
public class PostingInterface {

    @Autowired
    public PostingService postingService;

    @Autowired
    public CommentService commentService;

    @RequestMapping("/selectAllPosting")
    public Object getAllPosting(@RequestParam(value = "logic",required = false,defaultValue = "1")int logic){
        HashMap<String,Object> map = new HashMap<>();
        //逻辑查询，  展示给用户
        if(logic == 1){
            QueryWrapper<Posting> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("deleted","0");
            List<Posting> postings = postingService.list(queryWrapper);
            map.put("data",postings);
            return map;
        }
        //非逻辑查询，  展示给管理员  所以包括被用户删除的数据
        else{
            List<Posting> postings = postingService.list();
            map.put("data",postings);
            return map;
        }
    }

    @RequestMapping("/selectPosting")
    public Object getPosting(@RequestParam(value = "logic",required = false,defaultValue = "1")int logic,
                             @RequestParam(value = "postingid",required = true)int postingid){
        HashMap<String,Object> map = new HashMap<>();
        if(logic == 1){
            //获取文章
            QueryWrapper<Posting> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("deleted","0");
            queryWrapper.eq("postingid",postingid);
            Posting posting =  postingService.getOne(queryWrapper);
            //获取评论
            QueryWrapper<Comment> queryWrapper0 = new QueryWrapper<>();
            queryWrapper0.eq("deleted","0");
            queryWrapper0.eq("topostingid",postingid);
            List<Comment> comments = commentService.list(queryWrapper0);
            map.put("posting",posting);
            map.put("data",comments);
        }else{
            QueryWrapper<Posting> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("deleted","1");
            queryWrapper.eq("postingid",postingid);
            Posting posting =  postingService.getOne(queryWrapper);
            //获取评论
            QueryWrapper<Comment> queryWrapper0 = new QueryWrapper<>();
            queryWrapper0.eq("deleted","1");
            queryWrapper0.eq("topostingid",postingid);
            List<Comment> comments = commentService.list(queryWrapper0);
            map.put("posting",posting);
            map.put("data",comments);
        }
        return map;
    }


    @RequestMapping("/selectPage")
    public Page<Posting> getpage(
            @RequestParam(value = "logic",required = false,defaultValue = "1")int logic,
            @RequestParam(value = "page", required = false, defaultValue = "1")int page,
            @RequestParam(value = "size",required = false,defaultValue = "5")int size){
        if(logic == 1){
            QueryWrapper<Posting> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("deleted","0");
            Page<Posting> pages = new Page<>(page,size);
            return postingService.page(pages,queryWrapper);
        }else{
            Page<Posting> pages = new Page<>(page,size);
            return postingService.page(pages);
        }
    }

    @RequestMapping("/delete")
    public Boolean deleteLogic(
            @RequestParam(value = "postingid", required = true)int postingid,
            @RequestParam(value = "logic",required = false,defaultValue = "1")int logic){
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("postingid",postingid);
        Posting posting = postingService.listByMap(hashMap).get(0);
        //逻辑删除
        if(logic == 1 && posting != null){
            if(posting.getDeleted() == 0){
                UpdateWrapper<Posting> updateWrapper = new UpdateWrapper<>();
                updateWrapper.eq("postingid",postingid);
                posting.setDeleted(1);
                postingService.update(posting,updateWrapper);
                return true;
            }
            else{
                return false;
            }
        }//物理删除
        else if(posting!=null){
            Boolean res = postingService.removeByMap(hashMap);
            return  res;
        }
        return false;
    }
}

