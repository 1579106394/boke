package com.fzy.boke.interceptor;

import com.fzy.boke.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        String requestURI = request.getRequestURI();
        if (!requestURI.contains("/login") &&
                !requestURI.contains("/index") &&
                !requestURI.contains("/message/page") &&
                !requestURI.contains("/register") &&
                !requestURI.contains("/about")) {
            User user = (User) request.getSession().getAttribute("user");
            if (null == user) {
                response.sendRedirect(request.getContextPath() + "/login.jsp");
                return false;
            }
        }
        return true;
    }

}
