package hello.controller;

import com.alibaba.fastjson.JSONObject;
import hello.Application;
import hello.config.TestConfig;
import hello.dao.TestCaseDao;
import hello.model.InterfaceNameEnum;
import hello.model.LoginCase;
import hello.utils.ConfigFile;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.io.IOException;

import static org.testng.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class UserControllerTest {

    @Resource
    private TestCaseDao testCaseDao;

    @BeforeTest(groups = "loginTrue",description = "测试准备工作，测试URL 、HTTPClient")
    public void beforeTest(){
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceNameEnum.GetUserInfo);
        TestConfig.getUserListUrl = ConfigFile.getUrl(InterfaceNameEnum.GetUserList);
        TestConfig.addUserUrl = ConfigFile.getUrl(InterfaceNameEnum.AddUser);
        TestConfig.updateUserInfoUrl = ConfigFile.getUrl(InterfaceNameEnum.UpdateUserInfo);
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceNameEnum.Login);

        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }

    @Test(groups = "loginTrue",description = "用户登录成功接口测试")
    public void testLogin() throws IOException {

        System.out.println(testCaseDao.toString());
        //获取数据库中的测试用例
        LoginCase loginCase = testCaseDao.getLoginCase(1);
        System.out.println(TestConfig.loginUrl);
        //1-发送请求
        String result = getReult(loginCase);

        //2-验证结果
        Assert.assertEquals(loginCase.getExpected(),result);
    }

    @Test(groups = "loginFlase",description = "用户登录失败接口测试")
    public void loginFlase() throws IOException {

        //获取数据库中的测试用例
        LoginCase loginCase = testCaseDao.getLoginCase(1);
        System.out.println(TestConfig.loginUrl);
        //1-发送请求
        String result = getReult(loginCase);

        //2-验证结果
        Assert.assertEquals(loginCase.getExpected(),result);
    }

    private String getReult(LoginCase loginCase) throws IOException {
        //TestConfig.addUserUrl 是接口请求地址
        HttpPost post = new HttpPost(TestConfig.addUserUrl);
        JSONObject param = new JSONObject();
        param.put("userName",loginCase.getUserName());
        param.put("password",loginCase.getPassword());

        //设置头信息
        post.setHeader("content-type","application/json");

        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);

        //赋值cookie
        TestConfig.cookieStore = TestConfig.defaultHttpClient.getCookieStore();

        String result; // 结果
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        return result;
    }
}