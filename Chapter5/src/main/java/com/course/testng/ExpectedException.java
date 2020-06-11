package com.course.testng;

import org.testng.annotations.Test;

public class ExpectedException {
    /**
     * 在什么时候用到异常测试
     * 在我们期望结果为某一个异常的时候
     * 比如：我们传入了一些不合法的参数，程序抛出了异常
     * 也就是说我们的预期结果就是这个异常
     */
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed(){
        System.out.println("11");
        throw new RuntimeException("错误出现");
    }
}
