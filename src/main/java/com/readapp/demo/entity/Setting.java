package com.readapp.demo.entity;

import java.util.*;

/**
 * 个人用户设置
 */
public class Setting {

    /**
     * Default constructor
     */
    public Setting() {
    }

    /**
     * 
     */
    public int id;

    /**
     * 字体大小
     */
    public int fontSize;

    /**
     * 字体风格
     */
    public String fontStyle;

    /**
     * 背景风格
     */
    public String backgroundStyle;

    /**
     * 自动滚屏
     */
    public boolean autoScroll;

    /**
     * 滚动间隔
     */
    public int scrollInterval;

}