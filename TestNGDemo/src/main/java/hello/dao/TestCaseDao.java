package hello.dao;

import hello.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Map;

//@Service
//@Mapper
@Repository
public interface TestCaseDao {

    AddUserCase getAddUserCase(Integer id);

    GetUserInfoCase getUserInfo(Integer id);

    LoginCase getLoginCase(Integer id);

    GetUserListCase getUserList(Map<String, Object> param);
    /**
     * 查询数据库中User表的数据
     * @param param
     * @return
     */
    User queryUser(Map<String, Object> param);
}
