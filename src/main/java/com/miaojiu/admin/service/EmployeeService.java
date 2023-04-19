package com.miaojiu.admin.service;

import com.miaojiu.admin.bean.Employee;

/**
 * @BelongsProject: boot-05-web-admin
 * @BelongsPackage: com.atguigu.admin.service
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-04-12  20:42
 * @Description: TODO
 * @Version: 1.0
 */

public interface EmployeeService{

    public Employee getEmployeeById(Integer id);
}
