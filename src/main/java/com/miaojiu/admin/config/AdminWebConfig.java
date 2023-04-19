package com.miaojiu.admin.config;

import com.miaojiu.admin.interceptor.LoginInterceptor;
import com.miaojiu.admin.interceptor.RedisUrlCountInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @BelongsProject: boot-05-web-admin
 * @BelongsPackage: com.atguigu.admin.config
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-04-10  14:39
 * @Description: TODO
 * @Version: 1.0
 */

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

//    @Autowired
    RedisUrlCountInterceptor redisUrlCountInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/images/**", "/js/**");//放行的请求，注意放行静态资源
//
//        registry.addInterceptor(redisUrlCountInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/images/**", "/js/**");//放行的请求，注意放行静态资源
    }
}
