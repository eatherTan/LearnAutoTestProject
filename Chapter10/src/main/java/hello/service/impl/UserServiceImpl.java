package hello.service.impl;

import hello.dao.UserDao;
import hello.model.User;
import hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

//    @Autowired
    @Resource
    private UserDao userDao;

    /**
     * 查询用户列表
     * @return
     */

    @Override
    public List<User> queryUserList(Map<String, Object> param) {
        List<User> list = userDao.queryUserList(param);
        return list;
    }

    @Override
    public User getUserInfo(Integer id) throws Exception {
        User user = userDao.getUserInfo(id);
        if (user != null){
            return user;
        }else {
            throw new Exception("用户不存在");
        }
    }

    @Override
    public boolean addUser(User user) {
        int result = userDao.addUser(user);
        return result > 0;
    }

    @Override
    public boolean updateUserInfo(User user) throws Exception {
        if (user.getId() == null){
            throw new Exception("参数错误");
        }else {
            User u = userDao.getUserInfo(user.getId());
            if (u != null){
                int result = userDao.updateUserInfo(user);
                return result > 0;
            }else {
                throw new Exception("用户不存在");
            }
        }
    }

    @Override
    public boolean login(User user) throws Exception {
        if (user.getUserName() != null || user.getPassword() != null ){
            Map<String,Object> param = new HashMap<>();
            param.put("userName",user.getUserName());
            param.put("password",user.getPassword());
            List<User> userList = userDao.queryUserList(param);
            User realUser = userList.get(0);
            if (user.getUserName().equals(realUser.getUserName()) && user.getPassword().equals(realUser.getPassword())){
                return true;
            }else {
                throw new Exception("用户名或密码不正确");
            }
        }else {
            throw new Exception("用户名或密码不能为空");
        }
    }
}
