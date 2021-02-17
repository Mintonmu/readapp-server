package com.readapp.demo.yuedu;

import lombok.Data;

@Data
public class ContentRule {
    private String content;
    private String nextContentUrl;
    private String webJs;
    private String sourceRegex;
    private String replaceRegex;
    private String imageStyle;
}
