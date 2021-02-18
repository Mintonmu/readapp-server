package com.readapp.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.readapp.demo.common.Result;
import com.readapp.demo.entity.Book;
import com.readapp.demo.entity.BookRule;
import com.readapp.demo.entity.User;
import com.readapp.demo.mapper.BookRuleMapper;
import com.readapp.demo.utils.BookUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/book")
public class BookController {
    @Autowired
    private BookRuleMapper bookRuleMapper;

    @Autowired
    private BookUtils bookUtils;

    @GetMapping("/search")
    public Result<List<Book>> searchBooks(String keyword) {
        Result<List<Book>> result = new Result<>();
        List<Book> books;
        try {
            books = bookUtils.searchBooks(keyword);
            result.ok(books);
        } catch (Exception e) {
            e.printStackTrace();
            result.error2Msg(e.getMessage());
        }
        return result;
    }

    @GetMapping("/text")
    public Result<String> getContent(String url, Integer ruleId){
        LambdaQueryWrapper<BookRule> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(BookRule::getId, ruleId);
        BookRule rule = bookRuleMapper.selectOne(queryWrapper);

        Result<String> result = new Result<>();
        try {
            result.ok(bookUtils.getContent(url, rule));
        } catch (Exception e) {
            e.printStackTrace();
            result.error2Msg(e.getMessage());
        }
        return result;
    }
}
