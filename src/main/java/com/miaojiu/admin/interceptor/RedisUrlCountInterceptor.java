package com.miaojiu.admin.interceptor;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @BelongsProject: boot-05-web-admin
 * @BelongsPackage: com.atguigu.admin.interceptor
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-04-13  13:15
 * @Description: TODO
 * @Version: 1.0
 */

//@Component
public class RedisUrlCountInterceptor implements HandlerInterceptor {
//    @Autowired
    StringRedisTemplate template;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        template.opsForValue().increment(uri);
        return true;
    }
}
