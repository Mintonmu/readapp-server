package com.readapp.demo.entity;

import lombok.Data;

import java.util.*;

/**
 * 规则使用次数记录
 */
@Data
public class RulePopulation {

    /**
     * Default constructor
     */
    public RulePopulation() {
    }

    /**
     * 
     */
    public Long id;

    /**
     * 规则
     */
    public BookRule rule;

    /**
     * 使用次数
     */
    public Integer population;

}