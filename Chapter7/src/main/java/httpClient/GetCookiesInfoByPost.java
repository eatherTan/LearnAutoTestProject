package httpClient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class GetCookiesInfoByPost {

    private String url;
    private ResourceBundle bundle;
    //存储cookie
    private CookieStore cookieStore;

    /**
     * 把URL使用配置文件方式的访问
     */
    @BeforeTest
    public void beforeTest(){
        Locale current = new Locale("zh","CN");
        bundle = ResourceBundle.getBundle("application");
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        String uri = bundle.getString("getCookies.uri");
        //RequestWithCookie.json 文件的mock请求
        String testUrl = this.url + uri;
        System.out.println("请求接口地址： " + testUrl);
        HttpGet get = new HttpGet(testUrl);
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //获取cookie信息
        cookieStore = ((DefaultHttpClient) client).getCookieStore();
        List<Cookie> cookies = cookieStore.getCookies();
        for (Cookie cookie : cookies){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name = " + name + " cookie value = " + value);
        }
    }
    //依赖获取cookie的测试方法
    @Test(dependsOnMethods = "testGetCookies")
    public void testUseCookies() throws IOException {
        String result;
        String uri = bundle.getString("postDemoWithCookies");
        String testUrl = this.url + uri;

        //声明Client对象，用来执行方法
        HttpClient client = new DefaultHttpClient();
        //声明HttpPost对象，即post方法
        HttpPost post = new HttpPost(testUrl);
        //设置请求头
        post.setHeader("content-type","application/json");
        //添加参数.参数是JSON格式的
        JSONObject object = new JSONObject();
        object.put("hi","1");
        //设置参数
        StringEntity entity = new StringEntity(object.toString(),"utf-8");
        post.setEntity(entity);
        //设置cookies信息
        ((DefaultHttpClient) client).setCookieStore(this.cookieStore);
        HttpResponse response = client.execute(post);
        //获取相应状态码
        int statusCode = response.getStatusLine().getStatusCode();
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        //将返回结果转为json对象
        JSONObject resultJson = new JSONObject(result);

        //获取返回结果的status 状态
        String message = (String) resultJson.get("message");
        String status = (String) resultJson.get("status");
        Assert.assertEquals(status,"1");
        Assert.assertEquals(message,"success");
    }
}
