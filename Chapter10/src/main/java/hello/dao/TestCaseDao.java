package hello.dao;

import hello.model.AddUserCase;
import hello.model.LoginCase;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Service
//@Mapper
@Repository
public interface TestCaseDao {

    AddUserCase getUserInfo(Integer id);

    LoginCase getLoginCase(Integer id);
}
