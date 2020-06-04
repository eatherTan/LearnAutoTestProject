package com.course.paramter;

import com.beust.jcommander.Parameter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamterTest {
    @Test
    @Parameters({"name","age"})
    public void paramterTest1(String name, int age){
        System.out.println("name:" + name + " ," + "age:" + age);
    }
}
