package com.readapp.demo.utils;

import com.readapp.demo.entity.Book;
import com.readapp.demo.entity.BookRule;
import com.readapp.demo.mapper.BookRuleMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookUtilsTest {

    @Autowired
    private BookRuleMapper bookRuleMapper;
    @Test
    void searchBooks() {
    }

    @Test
    void testSearchBooks() throws Exception {
        List<BookRule> bookRules = bookRuleMapper.selectList(null);
        BookUtils bookUtils = new BookUtils();
        
        List<Book> books = bookUtils.searchBooks(bookRules.get(0), "赘婿", 1);
    }
}