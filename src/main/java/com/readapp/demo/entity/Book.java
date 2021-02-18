package com.readapp.demo.entity;

import lombok.Data;

import java.util.List;

@Data
public class Book {
    private String name;// 书名
    private String cover;// 封面
    private String lastChapter;// 最新章节
    private String author;// 作者
    private String intro;// 简介
    private String category;// 分类
    private List<Chapter> chapters;

}


