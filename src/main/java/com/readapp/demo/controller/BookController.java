package com.readapp.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.readapp.demo.common.Result;
import com.readapp.demo.common.ZhuishuChapterResult;
import com.readapp.demo.entity.Book;
import com.readapp.demo.entity.BookRule;
import com.readapp.demo.entity.ZhuishuChapter;
import com.readapp.demo.mapper.BookRuleMapper;
import com.readapp.demo.utils.BookUtils;
import org.apache.ibatis.annotations.Param;
import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController("/book")
public class BookController {
    @Resource
    private BookRuleMapper bookRuleMapper;

    @Resource
    private BookUtils bookUtils;

//    @GetMapping("/search")
//    public Result<List<Book>> searchBooks(@RequestParam("keyword") String keyword) {
//        Result<List<Book>> result = new Result<>();
//        List<Book> books;
//        try {
//            books = bookUtils.searchBooks(keyword);
//            result.ok(books);
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.error2Msg(e.getMessage());
//        }
//        return result;
//    }

    /**
     * 获取前10个优先级最高的规则
     *
     * @return 规则书籍
     */
    @GetMapping("/get_top{num}_rules")
    public List<BookRule> getTop10BookRules(@PathVariable(value = "num") String num) {

        int limit = 10;
        try {
            limit = Integer.parseInt(num);
        } catch (NumberFormatException ignored) {
        }

        LambdaQueryWrapper<BookRule> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(BookRule::getPriority).last("limit " + limit);

        return bookRuleMapper.selectList(queryWrapper);
    }

    /**
     * 搜索书籍
     *
     * @param ruleId  规则id
     * @param keyword 关键词
     * @return 书籍信息
     */
    @GetMapping("/search")
    public Result<List<Book>> searchBooks(@RequestParam("rule") Integer ruleId, @RequestParam("keyword") String keyword) {
        Result<List<Book>> result = new Result<>();
        List<Book> books;
        BookRule bookRule = bookRuleMapper.selectById(ruleId);
        try {
            books = bookUtils.searchBooks(bookRule, keyword);
            result.ok(books);
        } catch (Exception e) {
            e.printStackTrace();
            result.error2Msg(e.getMessage());
        }
        return result;
    }

    /**
     * 获取正文内容
     *
     * @param url    正文链接
     * @param title  书名
     * @param ruleId 规则id
     * @return 追书神器返回结果
     */
    @GetMapping("/text")
    public ZhuishuChapterResult getContent(String url, String title, Integer ruleId) {
        BookRule rule = bookRuleMapper.selectById(ruleId);

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
