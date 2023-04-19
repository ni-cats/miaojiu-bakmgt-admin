package com.miaojiu.admin.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @BelongsProject: boot-05-web-admin
 * @BelongsPackage: com.atguigu.admin.servlet
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-04-11  14:36
 * @Description: TODO
 * @Version: 1.0
 */

@WebServlet(urlPatterns = "/my")
public class MyServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.getWriter().write("666");
    }
}
