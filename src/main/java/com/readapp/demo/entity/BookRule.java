package com.readapp.demo.entity;

import lombok.Data;

import java.util.*;

/**
 * 书籍采集规则
 */
@Data
public class BookRule {

    /**
     * Default constructor
     */
    public BookRule() {
    }

    /**
     * 
     */
    public Long id;

    /**
     * 搜索地址
     * http://domain/?key={{keyword}}&page={{page}}
     */
    public String searchAddress;

    /**
     * 搜索项规则
     */
    public String searchItemRule;

    /**
     * 书名规则
     */
    public String nameRule;

    /**
     * 作者规则
     */
    public String authorRule;

    /**
     * 分类规则
     */
    public String categoryRule;

    /**
     * 最新章节规则
     */
    public String newChapterRule;

    /**
     * 封面规则
     */
    public String coverRule;

    /**
     * 简介规则
     */
    public String introductionRule;

    /**
     * 目录规则
     */
    public String catalogRule;

    /**
     * 章节名规则
     */
    public String chapterNameRule;

    /**
     * 章节链接规则
     */
    public String chapterLinkRule;

    /**
     * 正文规则
     */
    public String textRule;

    /**
     * 请求头
     */
    public String header;

    /**
     * 从Map中加载配置
     * @param dict
     */
    public void loadFromDict(Map dict) {
        // TODO implement here
    }

}