package com.qmx.demo.config;

/*------------------------
 *
 *@author 404name
 *@create 2020/8/7
 *------------------------*/

import com.qmx.demo.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginHandkerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取用户是否登录
        User user = (User) request.getSession().getAttribute("user");

        if( user == null){
            request.setAttribute("msg","没有权限请先登录");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }else{
            request.removeAttribute("msg");
            return true;
        }
    }
}
