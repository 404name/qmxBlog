package com.qmx.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qmx.demo.entity.Comment;
import com.qmx.demo.entity.Posting;
import com.qmx.demo.entity.User;
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
@RequestMapping("/posting")
public class PostingController {

    @Autowired
    public PostingService postingService;

    @RequestMapping("/selectAllPosting")
    public List<Posting> getPosting(@RequestParam(value = "logic",required = false,defaultValue = "1")int logic){
        if(logic == 1){
            QueryWrapper<Posting> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("deleted","0");
            return postingService.list(queryWrapper);
        }else{
            return postingService.list();
        }
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
            @RequestParam(value = "id", required = true)int id,
            @RequestParam(value = "logic",required = false,defaultValue = "1")int logic){
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("postingid",id);
        Posting posting = postingService.listByMap(hashMap).get(0);
        //逻辑删除
        if(logic == 1 && posting != null){
            if(posting.getDeleted() == 0){
                UpdateWrapper<Posting> updateWrapper = new UpdateWrapper<>();
                updateWrapper.eq("postingid",id);
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

