package com.readapp.demo.utils;

import com.readapp.demo.entity.Book;
import com.readapp.demo.entity.BookRule;
import com.readapp.demo.mapper.BookRuleMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookUtilsTest {

    @Resource
    private BookRuleMapper bookRuleMapper;

    @Autowired
    private BookUtils bookUtils;

    @Test
    void searchBooks() {
    }

    @Test
    void testSearchBooks() throws Exception {
        BookRule rule = bookRuleMapper.selectById(5);

        List<Book> books = bookUtils.searchBooks(rule, "赘婿");
        System.out.println("----------------------------------");
        books.forEach(System.out::println);
        System.out.println("----------------------------------");
    }
}