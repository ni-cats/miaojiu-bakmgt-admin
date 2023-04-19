package com.miaojiu.admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @BelongsProject: boot-05-web-admin
 * @BelongsPackage: com.atguigu.admin.config
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-04-12  11:00
 * @Description: TODO
 * @Version: 1.0
 */

//@Configuration
public class MyDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        //加入监控功能
        druidDataSource.setFilters("stat");
        return druidDataSource;

    }
    /**
     *
     * @Description TODO 监控页
     * @param null:
     * @return
     * @author Ni_cats
     * @email Ni_cats@163.com
     * @date 2023/4/12 11:14
     * @throws
     */

    @Bean
    public ServletRegistrationBean statViewServlet(){
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(statViewServlet,"/druid/*");
        return registrationBean;
    }
}
