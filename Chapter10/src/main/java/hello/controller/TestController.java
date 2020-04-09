package hello.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/hello")
    @ApiOperation(value = "测试路径",httpMethod = "GET")
    public String hello(){
        return "hello";
    }
}
