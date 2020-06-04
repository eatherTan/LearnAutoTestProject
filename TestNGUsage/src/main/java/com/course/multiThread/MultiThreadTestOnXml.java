package com.course.multiThread;

import org.testng.annotations.Test;

public class MultiThreadTestOnXml {

    @Test
    public void test1(){
        System.out.println(1 + "\n");
        System.out.printf("Thread Id : %s%n" ,Thread.currentThread().getId());
    }
    @Test
    public void test2(){
        System.out.println(1  );
        System.out.printf("Thread Id : %s%n" ,Thread.currentThread().getId() + "\n");
    }
    @Test
    public void test3(){
        System.out.println(1 + "\n");
        System.out.printf("Thread Id : %s%n" ,Thread.currentThread().getId());
    }
}
