package httpClient;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class HttpClientDemo1 {
    @Test
    public void test1() throws IOException {
        //存放结果
        String result;
        HttpGet get = new HttpGet("http://www.baidu.com");
        HttpClient clien = new DefaultHttpClient();
        //执行方法
        HttpResponse response = clien.execute(get);
        System.out.println(response);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
//        System.out.println(EntityUtils.toString(response.getEntity(),"utf-8"));
    }
}
