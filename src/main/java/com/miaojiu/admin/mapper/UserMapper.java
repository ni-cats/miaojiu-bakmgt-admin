package com.miaojiu.admin.mapper;

import com.miaojiu.admin.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @BelongsProject: boot-05-web-admin
 * @BelongsPackage: com.atguigu.admin.mapper
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-04-12  20:19
 * @Description: TODO
 * @Version: 1.0
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
