package com.miaojiu.admin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @BelongsProject: boot-05-web-admin
 * @BelongsPackage: com.atguigu.admin
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-04-13  13:46
 * @Description: TODO
 * @Version: 1.0
 */

@DisplayName("Junit5Test")

public class Junit5Test {


    @Test
    @DisplayName("测试DisplayName")
    void testDisplayName(){
        System.out.println(1);
    }

    @BeforeEach
    void testBeforeEach(){
        System.out.println("test begin ...");
    }

    // TODO 断言机制

    @Test
    @DisplayName("断言机制")
    void testAssertions(){
        int cal = cal(2, 3);
        assertEquals(6,cal,"计算失败");

    }

    int cal(int i,int j){
        return i + j;
    }


}
