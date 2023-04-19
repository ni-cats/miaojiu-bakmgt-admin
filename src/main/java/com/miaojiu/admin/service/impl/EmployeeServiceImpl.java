package com.miaojiu.admin.service.impl;

import com.miaojiu.admin.mapper.EmployeesMapper;
import com.miaojiu.admin.bean.Employee;
import com.miaojiu.admin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: boot-05-web-admin
 * @BelongsPackage: com.atguigu.admin.service
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-04-12  17:38
 * @Description: TODO
 * @Version: 1.0
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeesMapper employeesMapper;

    public Employee getEmployeeById(Integer id){
        return employeesMapper.getEmp(id);
    }
}
