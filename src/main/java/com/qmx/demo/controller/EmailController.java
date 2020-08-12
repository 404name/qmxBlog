package com.qmx.demo.controller;

import com.qmx.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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

    @RequestMapping("/sendEmail")
    @ResponseBody
    public boolean sendEmail(String to, String subject, String contentText){
        return  emailService.sendAttachmentMail(to,subject,contentText);
    }

}
