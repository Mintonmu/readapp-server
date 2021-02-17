package com.readapp.demo.entity;

import lombok.Data;

import java.util.*;

/**
 * 章节查看缓存
 */
@Data
public class ChapterCache {

    /**
     * Default constructor
     */
    public ChapterCache() {
    }

    /**
     * 
     */
    public Long id;

    /**
     * 章节链接
     */
    public String chapterUrl;

    /**
     * 章节内容文件
     */
    public String chapterFile;

}