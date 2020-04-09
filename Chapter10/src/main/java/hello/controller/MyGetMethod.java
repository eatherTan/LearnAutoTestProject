package hello.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Api(description = "获取cookie")
@RestController
@ComponentScan
public class MyGetMethod {

    /**
     * 实现了接口返回Cookie信息
     * @param response
     * @return
     */
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "实现了接口返回Cookie信息",httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCookies(HttpServletResponse response){
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "获得Cookie";
    }
    /**
     * 要求客户端携带cookie访问
     */

    @RequestMapping(value = "/getWithCookies",method = RequestMethod.GET)
    @ApiOperation(value = "要求客户端携带cookie访问",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            return "cookies 必传";
        }else {
            for (Cookie cookie : cookies){
                if (cookie.getName().equals("login") && cookie.getValue().equals("true")){
                    return "cookie 信息正确";
                }
            }
        }
        return "cookies 必传";
    }
    /**
     * 开发：需要携带参数的Get请求
     * http://localhost:8080/getProductList?start=1&end=12
     */
    @RequestMapping(value = "/getProductList")
    @ApiOperation(value = "需要携带参数的Get请求",httpMethod = "GET")
    public Map<String,Integer> getList(@RequestParam Integer start, @RequestParam Integer end){
        Map<String,Integer> productList = new HashMap<>();
        productList.put("鞋子",10);
        productList.put("上衣",30);
        productList.put("裤子",40);
        return productList;
    }
    /**
     * 开发：需要携带参数的Get请求
     * http://localhost:8080/getProductList?start=1&end=12
     */
    @RequestMapping(value = "/getProductList1/{start}/{end}")
    @ApiOperation(value = "需要携带参数的Get请求方式2",httpMethod = "GET")
    public Map<String,Integer> getList1(@PathVariable Integer start, @PathVariable Integer end){
        Map<String,Integer> productList = new HashMap<>();
        productList.put("鞋子",10);
        productList.put("上衣",30);
        productList.put("裤子",40);
        return productList;
    }
}
