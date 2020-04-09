package hello.service.impl;

import hello.dao.UserDao;
import hello.model.User;
import hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
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
