package com.readapp.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.readapp.demo.common.Result;
import com.readapp.demo.common.ZhuishuChapterResult;
import com.readapp.demo.entity.Book;
import com.readapp.demo.entity.BookRule;
import com.readapp.demo.entity.ZhuishuChapter;
import com.readapp.demo.mapper.BookRuleMapper;
import com.readapp.demo.utils.BookUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
    public ZhuishuChapterResult getContent(String url, String title,Integer ruleId){
        LambdaQueryWrapper<BookRule> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(BookRule::getId, ruleId);
        BookRule rule = bookRuleMapper.selectOne(queryWrapper);

        ZhuishuChapterResult chapter = new ZhuishuChapterResult();
        ZhuishuChapter c = new ZhuishuChapter();
        try {
            chapter.setOk(true);
            c.setBody(bookUtils.getContent(url, rule));
            c.setTitle(title);
            chapter.setChapter(c);
        } catch (Exception e) {
            e.printStackTrace();
            chapter.setOk(false);
        }
        return chapter;
    }
}
