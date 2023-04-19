package com.miaojiu.admin.service.impl;

import com.miaojiu.admin.bean.User;
import com.miaojiu.admin.mapper.UserMapper;
import com.miaojiu.admin.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: boot-05-web-admin
 * @BelongsPackage: com.atguigu.admin.service.impl
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-04-12  20:41
 * @Description: TODO
 * @Version: 1.0
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
