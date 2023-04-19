package com.miaojiu.admin.controller;

import com.miaojiu.admin.bean.User;
import com.miaojiu.admin.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @BelongsProject: boot-05-web-admin
 * @BelongsPackage: com.atguigu.admin.controller
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-04-10  10:24
 * @Description: TODO
 * @Version: 1.0
 */

@Controller
public class TableController {

    @Autowired
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table() {
//        int i = 10 / 0;

        return "table/basic_table";
    }

    @GetMapping("user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                             RedirectAttributes  ra){

        userService.removeById(id);
        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }

    /**
     * @param :
     * @return java.lang.String
     * @throws
     * @Description TODO 动态页面，不在Data Tables 展示页面  表格的动态遍历
     * @author Ni_cats
     * @email Ni_cats@163.com
     * @date 2023/4/10 10:30
     */

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model) {
        //表格的动态遍历
//        List<User> users = Arrays.asList(new User("zhangsan", "1233"),
//                new User("lisi", "1234"),
//                new User("haha", "1235"),
//                new User("jiang", "1236"),
//                new User("wang", "1237"));
//
//        model.addAttribute("users",users);
        List<User> list = userService.list();

//        model.addAttribute("users", list);

        Page<User> userPage = new Page<User>(pn, 2);
        Page<User> page = userService.page(userPage, null);
        long current = page.getCurrent();
        long pages = page.getPages();
        long total = page.getTotal();
        List<User> records = page.getRecords();
        model.addAttribute("page",page);

        return "table/dynamic_table";
    }

    @GetMapping("/editable_table")
    public String editable_table() {

        return "table/editable_table";
    }

    @GetMapping("/pricing_table")
    public String pricing_table() {

        return "table/pricing_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table() {

        return "table/responsive_table";
    }


}
