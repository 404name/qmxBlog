package com.qmx.demo.controller;

/*------------------------
 *
 *@author 404name
 *@create 2020/8/6
 *------------------------*/

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qmx.demo.entity.Comment;
import com.qmx.demo.entity.Posting;
import com.qmx.demo.entity.Postingclass;
import com.qmx.demo.entity.User;
import com.qmx.demo.service.CommentService;
import com.qmx.demo.service.PostingService;
import com.qmx.demo.service.PostingclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
public class PostingController {
    @Autowired
    public PostingService postingService;

    @Autowired
    public CommentService commentService;

    @Autowired
    public PostingclassService postingclassService;

    @GetMapping("/updataPosting")
    public String updataPosting(@RequestParam(value = "postingid",required = true)int postingid,
                                HttpSession session,Model model){
        QueryWrapper<Posting> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("postingid",postingid);
        Posting posting =  postingService.getOne(queryWrapper);
        session.setAttribute("posting",posting);
        System.out.println(posting);
        List<Postingclass> postingclasses = postingclassService.list();
        model.addAttribute("postingclasses",postingclasses);
        return "detail/updataPosting";
    }
    @PostMapping("/updataPosting")
    public String updataPosting1(Posting posting,
                                Model model){
        System.out.println(posting);
        postingService.updateById(posting);
        return "redirect:/list/posting";
    }

    @PostMapping("/addPosting")
    public String addPosting(Posting posting,
                                 Model model){
        System.out.println(posting);
        postingService.save(posting);
        return "redirect:/list/posting";
    }

    @RequestMapping("/showPosting")
    public String showPosting(@RequestParam(value = "logic",required = false,defaultValue = "1")int logic,
                              @RequestParam(value = "postingid",required = true)int postingid,
                              Model model){
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
            model.addAttribute("posting",posting);
            model.addAttribute("comments",comments);
        }else{
            QueryWrapper<Posting> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("postingid",postingid);
            Posting posting =  postingService.getOne(queryWrapper);
            //获取评论
            QueryWrapper<Comment> queryWrapper0 = new QueryWrapper<>();
            queryWrapper0.eq("deleted","1");
            queryWrapper0.eq("topostingid",postingid);
            List<Comment> comments = commentService.list(queryWrapper0);
            model.addAttribute("posting",posting);
            model.addAttribute("comments",comments);
        }
        return "/detail/postDetail";
    }
}
