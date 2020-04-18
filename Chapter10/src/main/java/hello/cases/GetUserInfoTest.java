package hello.cases;

import com.alibaba.fastjson.JSONObject;
import hello.dao.TestCaseDao;
import hello.model.GetUserInfoCase;
import hello.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class GetUserInfoTest {

    @Autowired
    private TestCaseDao testCaseDao;

    public void testGetUserInfoTest(){
        //这里该怎么解决，不用手动传入参数
        GetUserInfoCase getUserInfoCase = testCaseDao.getUserInfo(1);


        JSONObject result = getResult();

        //验证数据的正确性
        Map<String,Object> param = new HashMap<>();
        param.put("id",getUserInfoCase.getUserId());
        User userInfo = testCaseDao.queryUser(param);
    }

    /**
     * 获取结果
     * @return
     */
    private JSONObject getResult() {
        return null;
    }
}
