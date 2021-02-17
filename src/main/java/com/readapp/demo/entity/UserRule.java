package com.readapp.demo.entity;

import lombok.Data;

import java.util.*;

/**
 * 用户提交规则
 */
@Data
public class UserRule {

    /**
     * Default constructor
     */
    public UserRule() {
    }

    /**
     * 
     */
    public Long id;

    /**
     * 用户
     */
    public User user;

    /**
     * 规则
     */
    public BookRule rule;

    /**
     * 是否启用
     */
    public boolean enable;

}