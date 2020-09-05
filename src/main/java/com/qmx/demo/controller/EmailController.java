package com.qmx.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qmx.demo.entity.User;
import com.qmx.demo.service.EmailService;
import com.qmx.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailController {
    public int makeAuthCode() {
        int authCodeNew = 0;
        authCodeNew = (int) Math.round(Math.random() * (9999 - 1000) + 1000);
        return authCodeNew;
    }

    @Autowired
    private EmailService emailService;
    @Autowired
    private UserService userService;
    @RequestMapping("/sendEmail")
    @ResponseBody
    public boolean sendEmail(String to, String subject, String contentText, HttpSession session){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("email",to);
        User user  = userService.getOne(wrapper);
        contentText = "你的密码如下:"+user.getPassword() + "，请勿泄露给他人。";
        return  emailService.sendAttachmentMail(to,subject,contentText);
    }
}
