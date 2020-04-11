package hello.controller;

import hello.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/", description = "Post方法")
@RequestMapping("v2")
public class MyPostMethod {

    private static Cookie cookie;

    /**
     * 用户登录成功获取到cookie，然后再访问其他接口
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "用户登录成功获取到cookie", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(HttpServletResponse response, @RequestParam(value = "userName") String userName,
                        @RequestParam(value = "password") String password) {
        if (userName.equals("zhangsan") && password.equals("123456")) {
            cookie = new Cookie("login", "true");
            response.addCookie(cookie);
            return "恭喜你登录成功了";
        } else {
            return "用户名或密码错误";
        }
    }

    @RequestMapping(value = "getUserList", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表", httpMethod = "POST")
    public String getUserList(HttpServletRequest request, @RequestBody User user) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login1") && cookie.getValue().equals("true")) {
                if (user.getUserName().equals("zhangsan")) {
                    User u = new User();
                    u.setUserName("lisi");
                    return u.toString();
                } else {
                    return "名字错误";
                }
            } else {
                return "cookie错误";
            }

        }
        return"cookie 为空";
    }
}