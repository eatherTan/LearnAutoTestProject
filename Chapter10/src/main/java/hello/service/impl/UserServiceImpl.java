package hello.service.impl;

import hello.dao.UserDao;
import hello.model.User;
import hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserServiceImpl implements UserService {

    @Autowired(required=true)
    private UserDao userDao;

    /**
     * 查询用户列表
     * @return
     */
    @Override
    public List<User> queryUserList() {
        List<User> list = userDao.queryUserList();
        return list;
    }
}
