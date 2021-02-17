package com.readapp.demo;

import com.readapp.demo.entity.User;
import com.readapp.demo.entity.UserRule;
import com.readapp.demo.mapper.UserMapper;
import com.readapp.demo.mapper.UserRuleMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRuleTest {
    @Resource
    private UserRuleMapper userRuleMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<UserRule> userList = userRuleMapper.selectList(null);
        assert 0 == userList.size();
        userList.forEach(System.out::println);
    }
}
