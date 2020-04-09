package hello.dao;

import hello.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Mapper
public interface UserDao {
    /**
     * 查詢用戶列表
     * @return
     */
    List<User> queryUserList();

}
