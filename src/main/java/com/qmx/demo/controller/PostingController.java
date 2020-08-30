package com.qmx.demo.controller;

/*------------------------
 *
 *@author 404name
 *@create 2020/8/6
 *------------------------*/

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.qmx.demo.entity.*;
import com.qmx.demo.service.*;
import com.qmx.demo.service.impl.HomepageServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
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
    @Autowired
    public HomepageService homepageService;
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


        String pageclass = null;
        Integer type0 = 0;

        QueryWrapper<Posting> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("postingid",postingid);
        Posting posting = postingService.getOne(wrapper1);

        QueryWrapper<User> wrapper0 = new QueryWrapper<>();
        wrapper0.eq("id",posting.getId());
        User user0 = userService.getOne(wrapper0);
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("postingid",postingid);
        Boolean res = postingService.removeByMap(hashMap);
        if(res == true){
            if(posting.getPostingclass() == 1){
                if(user0.getUserclass() == 2){
                    pageclass = "开发组周任务";
                    type0 = 3;
                }else if(user0.getUserclass() == 3){
                    pageclass = "智能组周任务";
                    type0 = 4;
                }
            }
            //周总结
            else if(posting.getPostingclass() == 2){
                if(user0.getUserclass() == 2){
                    pageclass = "开发组周总结";
                    type0 = 1;
                }else if(user0.getUserclass() == 3){
                    pageclass = "智能组周总结";
                    type0 = 2;
                }
            }
            updataHomePage(pageclass,type0);
        }
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
        Posting tempposting = postingService.getOne(wrapper);
        postingService.update(posting,wrapper);
        posting = postingService.getOne(wrapper);
        if(tempposting.getPostingclass() == 1 || tempposting.getPostingclass() == 2){
            String pageclass = null;
            Integer type0 = 0;
            QueryWrapper<User> wrapper0 = new QueryWrapper<>();
            if(tempposting.getId()!=null){
                wrapper0.eq("id",tempposting.getId());
                User user0 = userService.getOne(wrapper0);
                if(tempposting.getPostingclass() == 1){
                    if(user0.getUserclass() == 2){
                        pageclass = "开发组周任务";
                        type0 = 3;
                    }else if(user0.getUserclass() == 3){
                        pageclass = "智能组周任务";
                        type0 = 4;
                    }
                    updataHomePage(pageclass,type0);
                    if(posting.getPostingclass() == 1 || posting.getPostingclass() == 2){
                        if(posting.getPostingclass() == 1){
                            if(user0.getUserclass() == 2){
                                pageclass = "开发组周任务";
                                type0 = 3;
                            }else if(user0.getUserclass() == 3){
                                pageclass = "智能组周任务";
                                type0 = 4;
                            }
                        }
                        else {
                            if(user0.getUserclass() == 2){
                                pageclass = "开发组周总结";
                                type0 = 1;
                            }else if(user0.getUserclass() == 3){
                                pageclass = "智能组周总结";
                                type0 = 2;
                            }
                        }
                        updataHomePage(pageclass,type0);
                    }
                }
                //周总结
                else if(tempposting.getPostingclass() == 2){
                    if(user0.getUserclass() == 2){
                        pageclass = "开发组周总结";
                        type0 = 1;
                    }else if(user0.getUserclass() == 3){
                        pageclass = "智能组周总结";
                        type0 = 2;
                    }
                    updataHomePage(pageclass,type0);
                    if(posting.getPostingclass() == 1 || posting.getPostingclass() == 2){
                        if(posting.getPostingclass() == 1){
                            if(user0.getUserclass() == 2){
                                pageclass = "开发组周任务";
                                type0 = 3;
                            }else if(user0.getUserclass() == 3){
                                pageclass = "智能组周任务";
                                type0 = 4;
                            }
                        }
                        else {
                            if(user0.getUserclass() == 2){
                                pageclass = "开发组周总结";
                                type0 = 1;
                            }else if(user0.getUserclass() == 3){
                                pageclass = "智能组周总结";
                                type0 = 2;
                            }
                        }
                        updataHomePage(pageclass,type0);
                    }
                }
            }
        }
        if(type == 0){
            return "admin/list/posting";
        }else{
            return "redirect:/showPosting?postingid=" + posting.getPostingid();
        }

    }
    public void updataHomePage(String pageclass, Integer type0){
        Posting posting = null;
        if(type0 == 0){
            return;
        }else if(type0 == 1){
            posting = postingService.select1();
        }
        else if(type0 == 2){
            posting = postingService.select2();
        }
        else if(type0 == 3){
            posting = postingService.select3();
        }
        else if(type0 == 4){
            posting = postingService.select4();
        }
        //周任务
        QueryWrapper<Homepage> wrapper = new QueryWrapper<>();
        wrapper.eq("pageclass",pageclass);
        Homepage homepage = homepageService.getOne(wrapper);
        if(posting == null){
            homepage.setTitle("暂无发帖,赶快去发帖吧");
            homepage.setHerf("/webGroupPostsPage");
        }else{
            homepage.setUpdatadate(posting.getPostingdate());
            homepage.setTitle(posting.getPostingtitle());
            homepage.setHerf("/showPosting?type=1&postingid="+posting.getPostingid());
        }
        homepageService.update(homepage,wrapper);
    }
    @PostMapping("/addPosting")
    public String addPosting(Posting posting,
                                 Model model,
                        @RequestParam(value = "type",required = false,defaultValue = "1")int type){
        String path = null;
        String pageclass = null;
        Integer type0 = 0;
        QueryWrapper<User> wrapper0 = new QueryWrapper<>();
        wrapper0.eq("id",posting.getId());
        User user0 = userService.getOne(wrapper0);
        if(posting.getPostingclass() == 1){
            if(user0.getUserclass() == 2){
                pageclass = "开发组周任务";
                type0 = 3;
            }else if(user0.getUserclass() == 3){
                pageclass = "智能组周任务";
                type0 = 4;
            }
        }
        //周总结
        else if(posting.getPostingclass() == 2){
            if(user0.getUserclass() == 2){
                pageclass = "开发组周总结";
                type0 = 1;
            }else if(user0.getUserclass() == 3){
                pageclass = "智能组周总结";
                type0 = 2;
            }
        }
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
            updataHomePage(pageclass,type0);
            return "admin/list/posting";
        }
        else{
            postingService.save(posting);
            updataHomePage(pageclass,type0);
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
