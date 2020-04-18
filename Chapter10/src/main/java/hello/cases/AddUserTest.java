package hello.cases;

import com.alibaba.fastjson.JSONObject;
import hello.Application;
import hello.config.TestConfig;
import hello.dao.TestCaseDao;
import hello.dao.UserDao;
import hello.model.AddUserCase;
import hello.model.User;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@SpringBootTest(classes = Application.class)
public class AddUserTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TestCaseDao testCaseDao;

    @Autowired
    private UserDao userDao;

//    @Test(dependsOnGroups = "loginTrue",description = "添加用户接口")
    @Test
    public void addUser() throws IOException {
        //测试数据放在数据库管理，数据库的是预期数据
        //AddUserCase 是从数据库中取出来的，把AddUserCase对象的数据作为新增呢
        AddUserCase addUserCase = testCaseDao.getAddUserCase(1);
        //1-发请求，获取接口
        //2-获得返回结果，验证返回结果
        String result = getResult(addUserCase);
        Assert.assertEquals(addUserCase.getExpected(),result,"新增用户失败");
        //3-这里直接查询数据库，user是否新增成功
        Map<String,Object> param = new HashMap<>();
        param.put("userName",addUserCase.getUserName());
        param.put("password",addUserCase.getPassword());
        param.put("age",addUserCase.getAge());
        param.put("sex",addUserCase.getSex());
        param.put("permission",addUserCase.getPermission());
        param.put("isDelete","");
        User user = testCaseDao.queryUser(param);
        //如果不为空，说明插入数据库成功
        Assert.assertNotEquals(user,null,"新增用户的数据与传入的参数不一致");
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
