package hello.dao;

import hello.model.AddUserCase;
import hello.model.LoginCase;

public interface TestCaseDao {

    AddUserCase getUserInfo(Integer id);

    LoginCase getLoginCase(Integer id);
}
