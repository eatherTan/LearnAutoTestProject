package hello.cases;

import hello.model.AddUserCase;
import hello.model.User;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

public class AddUserTest {

    @Test(dependsOnGroups = "loginTrue",description = "添加用户接口")
    public void addUser(){
        //测试数据放在数据库管理，数据库的是预期数据
        //AddUserCase 是从数据库中取出来的，把AddUserCase对象的数据作为新增呢
        //1-发请求，获取接口
        AddUserCase addUser = new AddUserCase();
        String result = getResult(addUser);
        //2-验证返回结果
//        User user
    }

    private String getResult(AddUserCase addUser){
        return null;
    }
}
