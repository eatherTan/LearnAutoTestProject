package hello.cases;

import hello.config.TestConfig;
import hello.model.InterfaceNameEnum;
import hello.utils.ConfigFile;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
    @BeforeTest(groups = "loginTrue",description = "测试准备工作，测试URL 、HTTPClient")
    public void beforeTest(){
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceNameEnum.GetUserInfo);
        TestConfig.getUserListUrl = ConfigFile.getUrl(InterfaceNameEnum.GetUserList);
        TestConfig.addUserUrl = ConfigFile.getUrl(InterfaceNameEnum.AddUser);
        TestConfig.updateUserInfoUrl = ConfigFile.getUrl(InterfaceNameEnum.UpdateUserInfo);
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceNameEnum.Login);

        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }

    @Test
    public void testLogin(){
        Assert.assertEquals(1,2);
    }
}
