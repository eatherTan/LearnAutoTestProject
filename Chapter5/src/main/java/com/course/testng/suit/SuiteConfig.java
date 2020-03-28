package com.course.testng.suit;


import org.testng.annotations.*;

public class SuiteConfig {
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("before suit 运行啦！");
    }
    @AfterSuite
    public void afterSuit(){
        System.out.println("after suit 运行啦！");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("before test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("after test");
    }
}
