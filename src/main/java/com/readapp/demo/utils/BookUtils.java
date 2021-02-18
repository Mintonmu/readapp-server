package com.readapp.demo.utils;

import com.github.pagehelper.util.StringUtil;
import com.readapp.demo.entity.Book;
import com.readapp.demo.entity.BookRule;
import com.readapp.demo.entity.Chapter;
import com.readapp.demo.mapper.BookRuleMapper;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookUtils {

    @Resource
    private BookRuleMapper bookRuleMapper;

    public List<Book> searchBooks(String keyword) throws Exception {
        List<BookRule> bookRules = bookRuleMapper.selectList(null);
        List<Book> books = new ArrayList<>();
        for (BookRule rule: bookRules){
            books.addAll(searchBooks(rule, keyword, 1));
        }
        return books;
    }

    public List<Book> searchBooks(BookRule rule, String keyword, Integer page) throws Exception {

        if (StringUtil.isEmpty(rule.getSearchAddress())) {
            throw new Exception("搜索地址规则为空");
        }
        if (StringUtil.isEmpty(rule.getSearchItemLinkRule())) {
            throw new Exception("数据链接规则为空");
        }


        // http://domain/?key={{keyword}}&page={{page}}
        // 替换占位符
        String request_url = rule.searchAddress
                .replace("{{keyword}}", keyword)
                .replace("{{page}}", String.valueOf(page));

        // 发起请求返回html源码
        //字符串解析
        Document doc = Jsoup.connect(request_url)
                .userAgent(rule.getHeader())
                .timeout(3000)
                .get();

        // 获取书籍链接
        List<String> links = parseRule(doc, rule.getSearchItemLinkRule());

        //获取书籍内容
        List<Book> books = new ArrayList<>();
        for (String link : links.subList(0, 3)) {
            Book book = extractContent(rule, link);
            books.add(book);
        }

        return books;
    }

    private Book extractContent(BookRule rule, String url) throws Exception {
        Book book = new Book();

        // 发起请求返回html源码
        //字符串解析
        Document doc = Jsoup.connect(url)
                .userAgent(rule.getHeader())
                .timeout(3000)
                .get();

        //解析作者名
        if (!StringUtil.isEmpty(rule.getAuthorRule())) {
            List<String> authors = parseRule(doc, rule.getAuthorRule());
            //获取到作者
            book.setAuthor(authors.get(0));
        }

        //解析作者名
        if (!StringUtil.isEmpty(rule.getAuthorRule())) {
            List<String> authors = parseRule(doc, rule.getAuthorRule());
            //获取到作者
            book.setAuthor(authors.get(0));
        }

        //解析书名
        if (!StringUtil.isEmpty(rule.getNameRule())) {
            List<String> names = parseRule(doc, rule.getNameRule());
            //获取到书名
            book.setName(names.get(0));
        }

        //解析最新章节
        if (!StringUtil.isEmpty(rule.getNewChapterRule())) {
            List<String> news = parseRule(doc, rule.getNewChapterRule());
            //获取到书名
            book.setLastChapter(news.get(0));
        }

        //解析封面
        if (!StringUtil.isEmpty(rule.getCoverRule())) {
            List<String> covers = parseRule(doc, rule.getCoverRule());
            //获取到封面
            book.setCover(covers.get(0));
        }

        //解析简介
        if (!StringUtil.isEmpty(rule.getIntroductionRule())) {
            List<String> intro = parseRule(doc, rule.getIntroductionRule());
            //获取到封面
            book.setIntro(intro.get(0));
        }

        //解析章节名
        if (!StringUtil.isEmpty(rule.getChapterNameRule()) && !StringUtil.isEmpty(rule.getChapterLinkRule())) {
            List<String> cnames = parseRule(doc, rule.getChapterNameRule());
            List<String> clinks = parseRule(doc, rule.getChapterLinkRule());

            if (cnames.size() != clinks.size()) {
                throw new Exception("章节名和链接无法对应");
            }
            List<Chapter> chapters = new ArrayList<>();
            for (int i = 0; i < clinks.size(); i++) {
                Chapter c = new Chapter();
                c.setUrl(clinks.get(i));
                c.setName(cnames.get(i));
                chapters.add(c);
            }
            //获取到封面
            book.setChapters(chapters);
        }
        return book;
    }

    /*
    解析规则
     */
    private static List<String> parseRule(Document doc, String textRule) throws Exception {
        // 三段式
        // 第一段 标签 第二段 属性 第三段 从第几个开始（0开始）
        String[] rule = textRule.split("@");

        if (rule.length != 3) {
            throw new Exception("规则必须为css@attr@pos格式");
        }
        List<String> result;
        if ("text".equals(rule[1])) {
            result = doc.select(rule[0]).eachText();
        } else {
            result = doc.select(rule[0]).eachAttr(rule[1]);
        }
        //列表切片
        return result.subList(Integer.parseInt(rule[2]), result.size());
    }

    /*
    获取正文内容
     */
    public static String getContent(String out_web_url, BookRule rule) throws Exception {
        Document doc = Jsoup.connect(out_web_url)
                .userAgent(rule.getHeader())
                .timeout(3000)
                .get();
        List<String> content = parseRule(doc, rule.getTextRule());
        return content.size() == 0 ? "无内容" : content.get(0);
    }
}
