package com.course.testng;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class IgnoreTest {
    @Test
    public  void ignore1(){
        System.out.println("ignore1 执行");
    }
//    @Ignore
    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore2 执行");
    }
}
