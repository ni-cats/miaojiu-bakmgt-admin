package com.miaojiu.admin;

import com.miaojiu.admin.bean.User;
import com.miaojiu.admin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
//        jdbcTemplate.queryForList("select * from dbtest1",);
        Long aLong = jdbcTemplate.queryForObject("select count(*) from employees", Long.class);
        System.out.println(aLong);
        log.info("记录数：{}",aLong);

        log.info("数据源类型：{}",dataSource.getClass());
    }

    @Test
    void TestUserMapper(){
        User user = userMapper.selectById(1L);
        log.info("用户信息：{}",user);
    }

    @Test
    void testRedis(){
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set("hello","world");
        String hello = operations.get("hello");
        System.out.println(hello);
    }
}
