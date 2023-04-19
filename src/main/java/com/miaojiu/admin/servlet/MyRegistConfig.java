package com.miaojiu.admin.servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: boot-05-web-admin
 * @BelongsPackage: com.atguigu.admin.servlet
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-04-11  14:52
 * @Description: TODO
 * @Version: 1.0
 */

@Configuration
public class MyRegistConfig {

    @Bean
    public ServletRegistrationBean myServlet() {

        MyServlet myServlet = new MyServlet();

        return new ServletRegistrationBean(myServlet, "/my", "/my200");
    }

}
