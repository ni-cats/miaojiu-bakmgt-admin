package com.miaojiu.admin.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @BelongsProject: boot-05-web-admin
 * @BelongsPackage: com.atguigu.admin.servlet
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-04-11  14:48
 * @Description: TODO
 * @Version: 1.0
 */

@Slf4j
@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        log.info("contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        log.info("contextDestroyed");
    }
}
