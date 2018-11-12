package com.baizhi.interceptors;

import com.baizhi.entity.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object method) throws Exception {

        /*System.out.println("状态");*/
        String requestURL = request.getRequestURI();
        if (requestURL.indexOf("/findOne")>0) {
            return true;
        }
        Admin admin=(Admin)request.getSession().getAttribute("flag");
        if (admin!=null) {
            //System.out.println("1");
            return true;
        } else {
            response.sendRedirect(request.getContextPath()+"/back/admin/login.jsp");
            response.getWriter().print("error");
            return false;

        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object method, ModelAndView mv) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception e) throws Exception {

    }
}
