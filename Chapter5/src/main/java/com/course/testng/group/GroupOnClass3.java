package com.course.testng.group;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupOnClass3 {
    public void teacher1(){
        System.out.println("Group3 de teacher1执行啦");
    }
    public void teacher2(){
        System.out.println("Group3 de teacher1执行啦");
    }
}
