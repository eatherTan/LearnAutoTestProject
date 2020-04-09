package hello.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Api(value = "/",description = "Hi")

public class HelloController {

    @RequestMapping("/hi")
    @ApiOperation(value = "hello  接口", httpMethod = "GET")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}