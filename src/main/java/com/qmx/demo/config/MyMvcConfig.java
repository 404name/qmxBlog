package com.qmx.demo.config;

/*------------------------
 *
 *@author 404name
 *@create 2020/8/3
 *------------------------*/

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("login").setViewName("loginService/login");
        registry.addViewController("login.html").setViewName("loginService/login");
        registry.addViewController("/ajax").setViewName("loginService/ajaxLoad");
//      管理员后台
        registry.addViewController("postDetail").setViewName("user/postDetail");
        registry.addViewController("/detail/updataPosting").setViewName("detail/updataPosting");
//        开发组论坛
        registry.addViewController("webGroupPostsPage").setViewName("softwareGroup/webGroupPostsPage");
//        额外界面
        registry.addViewController("/404").setViewName("error");
        registry.addViewController("/404").setViewName("404");
        registry.addViewController("aboutUs").setViewName("aboutUs");
        registry.addViewController("contactUs").setViewName("contactUs");
        registry.addViewController("problemFeedback").setViewName("loginService/problemFeedback");
//        用户界面的跳转部分
        registry.addViewController("profile").setViewName("user/profile");
        registry.addViewController("profileDetail").setViewName("user/profileDetail");
        registry.addViewController("privacy_setting").setViewName("user/privacy_setting");
        registry.addViewController("security_setting").setViewName("user/security_setting");

//        用户界面的跳转部分
        registry.addViewController("forgotPassword").setViewName("loginService/forgotPassword");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // classpath表示在resource目录下，/static/** 表示在URL路径中访问如
        // http://localhost:8080/static/ 即可访问到resource下的static目录
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }


    //开放权限地址
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandkerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/index","/login.html","/register","/register.html",
                        "/load","/logout","/registerCheck",
                        "/1","/2",
                        "/email/sendEmailCode","/email/checkCode","/homepage/selectAll",
                        "/static/**");
    }
}
