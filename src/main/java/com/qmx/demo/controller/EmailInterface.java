package com.qmx.demo.controller;

import com.qmx.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping("/email")
public class EmailInterface {
    public int makeAuthCode() {
        int authCodeNew = 0;
        authCodeNew = (int) Math.round(Math.random() * (9999 - 1000) + 1000);
        return authCodeNew;
    }

    @Autowired
    private  UserController userController;
    @Autowired
    private EmailService emailService;

    @RequestMapping("/checkCode")
    public Object sendEmail(HttpSession session,
                            @RequestParam(value = "email", required = true)String email,
                            @RequestParam(value = "code", required = true)int code){
        boolean flag = userController.checkUser(email);
        HashMap<String,Object> map = new HashMap<>();
        if(flag == true){
            map.put("msg","该邮箱已注册");
        }else{
            int sessionCode = (int)session.getAttribute("code");
            String sessionEmail = (String) session.getAttribute("email");
            if( session.getAttribute("code") == null || session.getAttribute("email") == null){
                map.put("msg","未发送验证码");
            }
            else if(email.equals(sessionEmail) && code == sessionCode){
                map.put("msg","校验成功");
                map.put("matching","1");
            }else{
                map.put("msg","邮箱与验证码不匹配");
            }
        }
        return map;
    }


    @RequestMapping("/sendEmailCode")
    public Object sendEmail(HttpSession session,
                             @RequestParam(value = "email", required = true)String email){
        boolean flag = userController.checkUser(email);
        HashMap<String,Object> map = new HashMap<>();
        if(flag == true){
            map.put("msg","该邮箱已注册");
        }else {
            int code = makeAuthCode();
            String to = email;
            String title = "启明星注册验证码";
            String content = "验证码如下:"+code;
            session.setAttribute("email",email);
            session.setAttribute("code",code);
            boolean flag1 = emailService.sendAttachmentMail(to,title,content);
            System.out.println(content);
            if(flag1){
                map.put("msg","发送成功");
            }else{
                map.put("msg","发送失败");
            }
        }
        return map;
    }
}
