package hello.service;

import hello.model.User;
import hello.model.request.LoginRequest;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> queryUserList(Map<String,Object> param);

    User getUserInfo(Integer id) throws Exception;

    boolean addUser(User user);

    boolean updateUserInfo(User user) throws Exception;

    boolean login(LoginRequest user) throws Exception;
}
