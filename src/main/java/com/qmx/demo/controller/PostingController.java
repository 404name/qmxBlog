package com.qmx.demo.controller;

/*------------------------
 *
 *@author 404name
 *@create 2020/8/6
 *------------------------*/

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.qmx.demo.entity.Comment;
import com.qmx.demo.entity.Posting;
import com.qmx.demo.entity.Postingclass;
import com.qmx.demo.entity.User;
import com.qmx.demo.service.CommentService;
import com.qmx.demo.service.PostingService;
import com.qmx.demo.service.PostingclassService;
import com.qmx.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
@Controller
public class PostingController {
    @Autowired
    public PostingService postingService;

    @Autowired
    public CommentService commentService;
    @Autowired
    public UserService userService;

    @Autowired
    public PostingclassService postingclassService;

    //不返回数据仅仅跳转
    @RequestMapping("/toAllPosting")
    public String listposting(Model model,HttpSession session){
        User user = (User)session.getAttribute("loadUser");
        if(user == null || user.getUserclass() != 5){
            session.setAttribute("msg","你没有权限访问");
            return "redirect:/index";
        }
        return "admin/list/posting";
    }
    @RequestMapping("/deletePosting")
    public String deleteposting(@RequestParam(value = "postingid", required = true)int postingid,
                            @RequestParam(value = "type",required = false,defaultValue = "1")int type){
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("postingid",postingid);
        Boolean res = postingService.removeByMap(hashMap);
        if(type==0){
            //管理员
            return "admin/list/posting";
        }else{
            //用户 （还未设置）
            return "admin/list/posting";
        }
    }
    @RequestMapping("/toupdataPosting")
    public String toupdataPosting(@RequestParam(value = "postingid",required = true)int postingid,
                                Model model){
        QueryWrapper<Posting> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("postingid",postingid);
        Posting posting =  postingService.getOne(queryWrapper);
        model.addAttribute("posting",posting);
        System.out.println(posting);
        List<Postingclass> postingclasses = postingclassService.list();
        model.addAttribute("postingclasses",postingclasses);
        return "admin/detail/updataPosting";
    }
    @PostMapping("/updataPosting")
    public String updataPosting1(Posting posting,
                                 @RequestParam(value = "type",required = false,defaultValue = "1")int type,
                                Model model){
        QueryWrapper<Posting> wrapper = new QueryWrapper<>();
        wrapper.eq("postingid",posting.getPostingid());
        postingService.update(posting,wrapper);
        if(type == 0){
            return "admin/list/posting";
        }else{
            return "redirect:/showPosting?postingid=" + posting.getPostingid();
        }

    }

    @PostMapping("/addPosting")
    public String addPosting(Posting posting,
                                 Model model,
                        @RequestParam(value = "type",required = false,defaultValue = "1")int type){

        String path = null;
        if(type == 0){
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("username",posting.getUsername());
            User user = userService.getOne(wrapper);
            if(user == null){
                model.addAttribute("msg","该用户不存在");
                return "admin/list/posting";
            }
            posting.setId(user.getId());
            postingService.save(posting);
            return "admin/list/posting";
        }
        else{
            postingService.save(posting);
            return "redirect:/webGroupPostsPage";
        }
    }
    @PostMapping("/addSoftwarePostingByUser")
    public String addPostingByUser(Posting posting,
                                   Model model,
                                   @RequestParam(value = "type",required = false,defaultValue = "1")int type){

        String path = null;
        if(type == 0){
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("username",posting.getUsername());
            User user = userService.getOne(wrapper);
            if(user == null){
                model.addAttribute("msg","该用户不存在");
                return "admin/list/posting";
            }
            posting.setId(user.getId());
            postingService.save(posting);
            return "admin/list/posting";
        }
        else{
            postingService.save(posting);
            return "redirect:/webGroupPostsPage";
        }
    }

    @RequestMapping("/showPosting")
    public String showPosting(@RequestParam(value = "logic",required = false,defaultValue = "1")int logic,
                              @RequestParam(value = "postingid",required = true)int postingid,
                              Model model){
        Posting posting = postingService.selectByPositngId(postingid);
        model.addAttribute("posting",posting);
        return "softwareGroup/postDetail";
    }
}
