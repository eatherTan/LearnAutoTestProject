package com.course.testng.group;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupOnClass1 {
    public void stu1(){
        System.out.println("Group1 de stu1方法执行啦");
    }
    public void stu2(){
        System.out.println("Group1 de stu2方法执行啦");
    }
}
