package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {
    @Test
    public void testCase1(){
        System.out.println("测试");
    }
    @Test
    public void testCase2(){
        System.out.println("测试2");
    }
    @BeforeMethod
    public void testBeforeMethod(){
        System.out.println("测试开始之前执行");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("测试方法之后执行");
    }
    @BeforeClass
    public void testBeforeClass(){
        System.out.println("测试类开始之前执行");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("测试类之后执行");
    }
    @BeforeSuite
    public void testBeforeSuit(){
        System.out.println("测试套件开始之前执行");
    }
    @AfterSuite
    public void afterSuit(){
        System.out.println("测试套件之后执行");
    }
}
