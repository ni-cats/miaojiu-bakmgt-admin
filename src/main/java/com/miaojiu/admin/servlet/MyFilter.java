package com.miaojiu.admin.servlet;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @BelongsProject: boot-05-web-admin
 * @BelongsPackage: com.atguigu.admin.servlet
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-04-11  14:43
 * @Description: TODO
 * @Version: 1.0
 */

@Slf4j
@WebFilter(urlPatterns = {"/css/*","/images/*"})
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        log.info("doFilter...");
        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {
        log.info("destroy...");
    }
}

