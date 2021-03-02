package com.readapp.demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.readapp.demo.entity.BookRule;
import com.readapp.demo.mapper.BookRuleMapper;
import com.readapp.demo.yuedu.*;
import com.readapp.demo.yuedu.adapter.*;
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
    @javax.annotation.Resource
    private BookRuleMapper bookRuleMapper;

}
