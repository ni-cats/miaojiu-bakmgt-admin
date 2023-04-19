package com.miaojiu.admin.controller;

import com.miaojiu.admin.bean.Employee;
import com.miaojiu.admin.bean.User;
import com.miaojiu.admin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @BelongsProject: boot-05-web-admin
 * @BelongsPackage: com.atguigu.admin.controller
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-04-10  09:40
 * @Description: TODO
 * @Version: 1.0
 */
@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    EmployeeService employeeService;

//    @Autowired
//    StringRedisTemplate redisTemplate;

    @ResponseBody
    @RequestMapping("/acct")
    public Employee getById(Integer id) {

        return employeeService.getEmployeeById(1001);
    }

    /**
     * @param :
     * @return java.lang.String
     * @throws
     * @Description 登录页
     * @author Ni_cats
     * @email Ni_cats@163.com
     * @date 2023/4/10 9:43
     */

    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {

        if (StringUtils.hasLength(user.getUserName()) && StringUtils.hasLength(user.getPassword())) {
            //把登录成功的用户保存起来
            session.setAttribute("loginUser", user);

            //登录成功重定向到main页面，重定向，防止表单重复提交
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "账号密码错误！");
            //登录失败，回到登录页
            return "login";
        }


    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {

//        //首先判断是否登录
//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser != null){
//
//            return "main";
//        }else {
//            model.addAttribute("msg","未登录，请重新登录");
//            return "login";
//        }

//        ValueOperations<String, String> operations = redisTemplate.opsForValue();
//        String main = operations.get("/main.html");
//        String sql = operations.get("/sql");
//
//        model.addAttribute("mainCount",main);
//        model.addAttribute("sqlCount",sql);
        return "main";
    }

    @ResponseBody
    @RequestMapping("/sql")
    public String queryFromDB() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from employees", Long.class);
        return aLong.toString();
    }
}

