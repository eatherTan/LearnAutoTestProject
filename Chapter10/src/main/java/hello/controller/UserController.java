package hello.controller;

import hello.model.User;
import hello.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
@Api(description = "这是我的一个版本的demo")
public class UserController {

    @RequestMapping("/test")
    public String test(){
        return "test";
    }


    @Autowired
    private UserService userService;

    @RequestMapping(value = "queryUserList",method = RequestMethod.GET)
    @ApiOperation(value = "查询用户列表",httpMethod = "GET")
    @ResponseBody
    public List<User> queryUserList(){
        List<User> list = userService.queryUserList();
        return list;
    }
}
