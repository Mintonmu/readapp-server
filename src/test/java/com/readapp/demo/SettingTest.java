package com.readapp.demo;

import com.readapp.demo.entity.BookRule;
import com.readapp.demo.entity.Setting;
import com.readapp.demo.mapper.BookRuleMapper;
import com.readapp.demo.mapper.SettingMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SettingTest {
    @Resource
    private SettingMapper settingMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<Setting> bookRules = settingMapper.selectList(null);
        assert 0 == bookRules.size();
        bookRules.forEach(System.out::println);
    }
}
