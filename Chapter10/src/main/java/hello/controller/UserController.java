package hello.controller;

import hello.model.User;
import hello.model.request.GetUserInfoRequest;
import hello.model.request.LoginRequest;
import hello.model.request.QueryUserListRequest;
import hello.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/v1")
@Api(value = "v1", description = "用户管理")
public class UserController {

//    @Autowired
    @Resource
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "用户登录",httpMethod = "POST")
    @ResponseBody
    public Boolean login(HttpServletResponse response, @RequestBody LoginRequest user) throws Exception {

        Boolean login = userService.login(user);
        if (login == true){
            Cookie cookie = new Cookie("login","true");
            response.addCookie(cookie);
        }
        return login;
    }

    @RequestMapping(value = "/queryUserList",method = RequestMethod.POST)
    @ApiOperation(value = "查询用户列表",httpMethod = "POST")
    @ResponseBody
    public List<User> queryUserList(@RequestBody QueryUserListRequest request){
        Map<String,Object> param = new HashMap<>();
        List<User> list = userService.queryUserList(param);
        return list;
    }

    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户信息",httpMethod = "POST")
    @ResponseBody
    public User getUserInfo(HttpServletRequest httpServletRequest, @RequestBody GetUserInfoRequest request) throws Exception {
        Boolean verifyCookie = verifyCookies(httpServletRequest);
        User user = userService.getUserInfo(request.getId());
        return user;
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ApiOperation(value = "新增用户",httpMethod = "POST")
    @ResponseBody
    public Boolean addUser(HttpServletRequest httpServletRequest, @RequestBody QueryUserListRequest request){
        Boolean verifyCookie = verifyCookies(httpServletRequest);
        User user = new User();
        BeanUtils.copyProperties(request,user);
        Boolean bool = userService.addUser(user);
        return bool;
    }

    @RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
    @ApiOperation(value = "编辑用户",httpMethod = "POST")
    @ResponseBody
    public Boolean updateUserInfo(HttpServletRequest httpServletRequest, @RequestBody QueryUserListRequest request) throws Exception {
        Boolean verifyCookie = verifyCookies(httpServletRequest);
        User user = new User();
        BeanUtils.copyProperties(request,user);
        Boolean bool = userService.updateUserInfo(user);
        return bool;
    }
    /**
     * 校验cookie 是否正确
     * @param httpServletRequest
     * @return
     */
    private Boolean verifyCookies(HttpServletRequest httpServletRequest){
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies == null || cookies.length == 0){
            return false;
        }
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return true;
            }
        }
        return false;
    }
}
