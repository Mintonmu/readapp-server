package com.readapp.demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.readapp.demo.entity.BookRule;
import com.readapp.demo.mapper.BookRuleMapper;
import com.readapp.demo.yuedu.*;
import com.readapp.demo.yuedu.adapter.BookInfoRuleAdapter;
import com.readapp.demo.yuedu.adapter.SearchAdapter;
import com.readapp.demo.yuedu.adapter.TocRuleAdapter;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRuleTest {
    @Autowired
    private BookRuleMapper bookRuleMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<BookRule> bookRules = bookRuleMapper.selectList(null);
        assert 0 == bookRules.size();
        bookRules.forEach(System.out::println);
    }

    /**
     * 从阅读app的json中加载规则
     */
    @Test
    public void loadFromYueDuJsonArray() throws IOException {
        String file = "test/exportBookSource.json";
        Resource resource = new ClassPathResource(file);

        FileInputStream fileInputStream = new FileInputStream(resource.getFile().getPath());
        byte[] bytes = fileInputStream.readAllBytes();


        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(BookInfoRule.class, new BookInfoRuleAdapter())
                .registerTypeAdapter(ContentRule.class, new ContentRule())
                .registerTypeAdapter(ExploreRule.class, new ExploreRule())
                .registerTypeAdapter(TocRule.class, new TocRuleAdapter())
                .registerTypeAdapter(SearchRule.class, new SearchAdapter());

        builder.setPrettyPrinting();
        Gson gson = builder.create();

        Type userListType = new TypeToken<ArrayList<YueDuBookSource>>() {
        }.getType();

        List<YueDuBookSource> yueDuBookSources = gson.fromJson(new String(bytes), userListType);
        yueDuBookSources.forEach(System.out::println);
    }
}
