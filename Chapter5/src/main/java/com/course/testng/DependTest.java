package com.course.testng;

import org.testng.annotations.Test;

public class DependTest {
    @Test
    public void test1(){
        System.out.println("test1 方法执行了");
        throw new RuntimeException("test1 有错误出现了");
    }
    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2 方法执行了");
    }
}
