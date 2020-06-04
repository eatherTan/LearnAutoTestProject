package com.test.report;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestReport {
    @Test
    public void test1(){
        Assert.assertEquals(1,2);
    }
    @Test
    public void test2(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void test3(){
        Assert.assertEquals("aaa","aaa");
    }
    /**
     * 记录日志
     */
    @Test
    public void logDemo() throws Exception {
        Reporter.log("这是我们自己写的日志");
        throw new Exception("错误抛出： 错误方法日志");
    }
}
