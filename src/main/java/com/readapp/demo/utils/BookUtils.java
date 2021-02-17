package com.readapp.demo.utils;

import com.github.pagehelper.util.StringUtil;
import com.readapp.demo.entity.Book;
import com.readapp.demo.entity.BookRule;
import com.readapp.demo.mapper.BookRuleMapper;
import okhttp3.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class BookUtils {

    @Autowired
    private BookRuleMapper bookRuleMapper;
    private static OkHttpClient client = new OkHttpClient();

    public List<Book> searchBooks(String keyword) {
        List<BookRule> bookRules = bookRuleMapper.selectList(null);

        return null;
    }

    public List<Book> searchBooks(BookRule rule, String keyword, Integer page) throws Exception {

        if (StringUtil.isEmpty(rule.searchAddress)) {
            throw new Exception("搜索地址规则为空");
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

        // 解析dom
        Elements items = doc.select("#hotcontent > table > tbody > tr");
        List<String> bookNames = items.select("td:nth-child(1) > a").eachText();
        List<String> links = items.select("td:nth-child(1) > a").eachAttr("href");
        List<String> newChapters = items.select("td:nth-child(2) > a").eachText();
        List<String> authors = items.select("td:nth-child(3)").eachText();
        List<String> times = items.select("td:nth-child(5)").eachText();

        for (int i = 0 ; i< bookNames.size(); i++){
            System.out.println(bookNames.get(i));
            System.out.println(links.get(i));
            System.out.println(newChapters.get(i));
            System.out.println(authors.get(i));
            System.out.println(times.get(i));
            System.out.println();
        }
        return null;
    }

    public Book extractContent(String url){
        return null;
    }
}
