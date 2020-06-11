package com.course.multiThread;

import org.testng.annotations.Test;

/**
 * 使用注解完成多线程
 */
public class MultiThreadTestOnAnnotation {
    /**
     * 在方法上可以指定线程池
     * invocationCount 线程数
     * threadPoolSize 线程池
     */
    @Test(invocationCount = 10, threadPoolSize = 3)
    public void test1(){
        System.out.println(1 );
        System.out.printf("Thread Id : %s%n" ,Thread.currentThread().getId() + "\n");
    }
}
