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
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/ajax").setViewName("ajaxLoad");
        registry.addViewController("/ajax.html").setViewName("ajaxLoad");
        registry.addViewController("/postDetail.html").setViewName("postDetail");
        registry.addViewController("/profile.html").setViewName("profile");
        registry.addViewController("/detail/updataPosting").setViewName("detail/updataPosting");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // classpath表示在resource目录下，/static/** 表示在URL路径中访问如
        // http://localhost:8080/static/ 即可访问到resource下的static目录
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandkerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/index","/login.html",
                        "/load","/logout","/addUser",
                        "/register.html","/static/**");
    }
}
