package com.readapp.demo.entity;

import lombok.Data;

import java.util.*;

/**
 * 用户信息
 */
@Data
public class User {

    /**
     * Default constructor
     */
    public User() {
    }

    /**
     * 
     */
    public String userId;

    /**
     * 
     */
    public String nickname;

    /**
     * 
     */
    public String bookshelf;

    /**
     * 
     */
    public Integer setting;

}