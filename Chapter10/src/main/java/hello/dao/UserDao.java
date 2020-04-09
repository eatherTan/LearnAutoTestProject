package hello.dao;

import hello.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    /**
     * 查詢用戶列表
     * @return
     */
    List<User> queryUserList();
}
