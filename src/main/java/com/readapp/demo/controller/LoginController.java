package com.readapp.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.readapp.demo.WeXin.WxMiniApi;
import com.readapp.demo.WeXin.WxMiniApiImpl;
import com.readapp.demo.common.Result;
import com.readapp.demo.entity.Book;
import com.readapp.demo.entity.BookRule;
import com.readapp.demo.entity.BookShelf;
import com.readapp.demo.entity.User;
import com.readapp.demo.mapper.BookShelfMapper;
import com.readapp.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class LoginController {

    private final WxMiniApi wxMiniApi = new WxMiniApiImpl();
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BookShelfMapper bookShelfMapper;

    @GetMapping("/login")
    public Result<User> login(String jsCode, String nickname) throws IOException {
        JSONObject jsonObject = wxMiniApi.authCode2Session("wx1968857a81585552", "3e36011c589c25d7742d5ca8b7a7d614", jsCode);
        Result<User> result = new Result<>();

        //获取openid错误
        if (jsonObject.containsKey("errcode")) {
            Integer errcode = jsonObject.getInteger("errcode");
            if (errcode != 0) {
                result.error((String) jsonObject.get("errcode"), (String) jsonObject.get("errmsg"));
                return result;
            }
        }

        // 查找该用户是否存在
        String openid = jsonObject.getString("openid");
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserId, openid);
        User user = userMapper.selectOne(queryWrapper);
        // 用户不存在则创建
        if (user == null) {
            user = new User();
            user.setUserId(openid);
            user.setNickname(nickname);
            userMapper.insert(user);
        }
        result.ok(user);
        return result;
    }

    @GetMapping("/getShelf")
    public Result<List<BookShelf>> getShelf(String openid) {
        Result<List<BookShelf>> result = new Result<>();

        //根据用户id查找书架
        LambdaQueryWrapper<BookShelf> queryWrapper2 = new LambdaQueryWrapper<>();
        queryWrapper2.eq(BookShelf::getBookshelfId, openid);
        List<BookShelf> bookShelfs = bookShelfMapper.selectList(queryWrapper2);

        if (bookShelfs == null || bookShelfs.size() == 0) {
            result.error2Msg("没有收藏过书籍");//没有找到书架
        } else
            result.ok(bookShelfs); //找到书架

        return result;
    }

    @GetMapping("/addShelf")
    public Result<String> addShelf(String openid, BookShelf newBookShelf) {
        Result<String> result = new Result<>();

        LambdaQueryWrapper<BookShelf> queryWrapper2 = new LambdaQueryWrapper<>();
        queryWrapper2.eq(BookShelf::getBookshelfId, openid);
        List<BookShelf> bookShelfs = bookShelfMapper.selectList(queryWrapper2);

        boolean contains = bookShelfs.contains(newBookShelf);
        if (!contains) {
            bookShelfMapper.insert(newBookShelf);
            result.ok("加入书架成功");
        } else {
            result.error2Msg("已经加入书架");
        }

        return result;
    }
}
