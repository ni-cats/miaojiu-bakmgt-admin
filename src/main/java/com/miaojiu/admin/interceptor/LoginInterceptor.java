package com.miaojiu.admin.interceptor;

/**
 * @BelongsProject: boot-05-web-admin
 * @BelongsPackage: com.atguigu.admin.interceptor
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-04-10  14:32
 * @Description: TODO
 * @Version: 1.0
 */

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @param null:
 * @author Ni_cats
 * @Description TODO 登录检查
 * @return
 * @email Ni_cats@163.com
 * @date 2023/4/10 14:33
 * @throws
 */

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * @param request:
     * @param response:
     * @param handler:
     * @return boolean
     * @throws
     * @Description TODO 目标方法执行之前
     * @author Ni_cats
     * @email Ni_cats@163.com
     * @date 2023/4/10 14:34
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录检查逻辑
        HttpSession session = request.getSession();

        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {
            return true;
        } else {

            String requestURI = request.getRequestURI();
            log.info("拦截的路径：{}",requestURI);
            //未登录，跳转到登录页
            request.setAttribute("msg","请先登录！");
//            response.sendRedirect("/");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }


    }

    /**
     * @param request:
     * @param response:
     * @param handler:
     * @param modelAndView:
     * @return void
     * @throws
     * @Description TODO 目标方法执行以后
     * @author Ni_cats
     * @email Ni_cats@163.com
     * @date 2023/4/10 14:35
     */


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * @param request:
     * @param response:
     * @param handler:
     * @param ex:
     * @return void
     * @throws
     * @Description TODO 页面渲染以后
     * @author Ni_cats
     * @email Ni_cats@163.com
     * @date 2023/4/10 14:35
     */

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
