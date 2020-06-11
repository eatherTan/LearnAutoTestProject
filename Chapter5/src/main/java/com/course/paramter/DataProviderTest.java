package com.course.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "data")
    public void testDataProvider(String name, int age){
        System.out.println("name:" + name + " ," + "age:" + age);
    }
    @DataProvider(name = "data")
    public Object[][] providerData(){
        Object[][] objects = new Object[][]{
                {"张三",10},
                {"李四",20},
                {"王五",14}
        };
        return objects;
    }
    @Test(dataProvider = "methodData")
    public void test1(String name, int age){
        System.out.println("Test1 方法的 name:" + name + " ," + "age:" + age);
    }
    @Test(dataProvider = "methodData")
    public void test2(String name, int age){
        System.out.println("Test2 方法的 name:" + name + " ," + "age:" + age);
    }

    /**
     * 根据不同方法来传递不同的参数
     * @param method
     * @return
     */
    @DataProvider(name = "methodData")
    public Object[][] methodData(Method method){
        Object[][] objects = null;
        if (method.getName().equals("test1")){
            objects = new Object[][]{
                    {"张三", 12},
                    {"李四",42},
                    {"王五",22}
            };
        }else if (method.getName().equals("test2")){
            objects = new Object[][]{
                    {"tan", 12},
                    {"xiao",42},
                    {"lian",22}
            };
        }
        return objects;
    }
}
