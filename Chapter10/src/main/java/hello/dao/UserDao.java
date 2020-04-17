package hello.dao;

import hello.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;


//@Service
//@Mapper

@Repository
public interface UserDao {
    /**
     * 查詢用戶列表
     * @return
     */
    List<User> queryUserList(Map<String,Object> param);

    User getUserInfo(Integer id);

    int addUser(User user);

    int updateUserInfo(User user);

//    boolean login(User user);
}
