package com.readapp.demo.controller;

import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.readapp.demo.entity.Book;
import com.readapp.demo.entity.BookRule;
import com.readapp.demo.entity.User;
import com.readapp.demo.mapper.BookRuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookRuleMapper bookRuleMapper;
    @GetMapping("/search")
    public List<Book> searchBooks(User user, String keyword){
        List<BookRule> bookRules = bookRuleMapper.selectList(null);
        return null;
    }
}
