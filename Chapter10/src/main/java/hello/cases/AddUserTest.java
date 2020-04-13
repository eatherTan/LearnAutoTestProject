package hello.cases;

import com.alibaba.fastjson.JSONObject;
import hello.config.TestConfig;
import hello.dao.TestCaseDao;
import hello.dao.UserDao;
import hello.model.AddUserCase;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddUserTest {

    @Autowired
    private TestCaseDao testCaseDao;

    @Autowired
    private UserDao userDao;

    @Test(dependsOnGroups = "loginTrue",description = "添加用户接口")
    public void addUser() throws IOException {
        //测试数据放在数据库管理，数据库的是预期数据
        //AddUserCase 是从数据库中取出来的，把AddUserCase对象的数据作为新增呢
        AddUserCase addUserCase = testCaseDao.getUserInfo(1);
        //1-发请求，获取接口

        String result = getResult(addUserCase);
        //2-验证返回结果
//        User user = userDao.addUser();
//        System.out.println(user);
        Assert.assertEquals(addUserCase.getExpected(),result);
//        User user
    }

    private String getResult(AddUserCase addUser) throws IOException {
        //TestConfig.addUserUrl 是接口请求地址
        HttpPost post = new HttpPost(TestConfig.addUserUrl);
        JSONObject param = new JSONObject();
        param.put("userName",addUser.getUserName());
        param.put("password",addUser.getPassword());
        param.put("sex",addUser.getSex());
        param.put("age",addUser.getAge());
        param.put("permission",addUser.getPermission());
        //设置头信息
        post.setHeader("content-type","application/json");

        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);

        //设置cookie
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.cookieStore);

        String result; // 结果
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        return result;

    }
}
