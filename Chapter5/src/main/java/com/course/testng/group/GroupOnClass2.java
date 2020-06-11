package com.course.testng.group;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupOnClass2 {
    public void stu1(){
        System.out.println("Group2 de stu1方法执行啦");
    }
    public void stu2(){
        System.out.println("Group2 de stu2方法执行啦");
    }
}
