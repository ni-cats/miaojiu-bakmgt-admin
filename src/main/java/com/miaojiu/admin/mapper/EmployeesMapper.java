package com.miaojiu.admin.mapper;

import com.miaojiu.admin.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @BelongsProject: boot-05-web-admin
 * @BelongsPackage: com.atguigu.admin
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-04-12  17:20
 * @Description: TODO
 * @Version: 1.0
 */

@Mapper
public interface EmployeesMapper {

    public Employee getEmp(Integer id);


}
