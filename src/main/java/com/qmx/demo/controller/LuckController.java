package com.qmx.demo.controller;


import com.qmx.demo.entity.Luck;
import com.qmx.demo.service.LuckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 404name
 * @since 2020-09-16
 */
@Controller
public class LuckController {
    @Autowired
    LuckService luckService;
    @RequestMapping("/luck")
    public String luck(Model model){
        List<Luck> luckList = luckService.get2020Student();
        Integer num = luckList.size();
        System.out.println(luckList);
        model.addAttribute("studentList",luckList);
        model.addAttribute("studentNum",num);
        return "luckdraw";
    }
    @RequestMapping("/admin")
    public String luck1(Model model){
        List<Luck> luckList = luckService.get2020Student();
        Integer num = luckList.size();
        System.out.println(luckList);
        model.addAttribute("studentList",luckList);
        model.addAttribute("studentNum",num);
        return "luckdraw1";
    }
}

