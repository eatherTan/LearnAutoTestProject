package hello.service;

import hello.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface UserService {
    List<User> queryUserList();
}
