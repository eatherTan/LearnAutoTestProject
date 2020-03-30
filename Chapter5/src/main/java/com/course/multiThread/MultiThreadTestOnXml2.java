package com.course.multiThread;

import org.testng.annotations.Test;

public class MultiThreadTestOnXml2 {

    @Test
    public void test1(){
        System.out.println(1 + "\n");
        System.out.printf("方法二： Thread Id : %s%n" ,Thread.currentThread().getId());
    }
    @Test
    public void test2(){
        System.out.println(1 + "\n");
        System.out.printf("方法二： Thread Id : %s%n" ,Thread.currentThread().getId());
    }
    @Test
    public void test3(){
        System.out.println(1 + "\n");
        System.out.printf("方法二： Thread Id : %s%n" ,Thread.currentThread().getId());
    }
}
