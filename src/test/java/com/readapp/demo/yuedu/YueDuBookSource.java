package com.readapp.demo.yuedu;


public class YueDuBookSource {
    private String bookSourceName;
    private String bookSourceGroup;
    private String bookSourceUrl;
    private int bookSourceType;
    private String bookUrlPattern;
    private int customOrder;
    private boolean enabled;
    private boolean enabledExplore;
    private String header;
    private String loginUrl;
    private String bookSourceComment;
    private long lastUpdateTime;
    private int weight;
    private String exploreUrl;
    private ExploreRule ruleExplore;
    private String searchUrl;
    private SearchRule ruleSearch;
    private BookInfoRule ruleBookInfo;
    private TocRule ruleToc;
    private ContentRule ruleContent;

    @Override
    public String toString() {
        return "YueDuBookSource{" +
                "bookSourceName='" + bookSourceName + '\'' +
                ", bookSourceGroup='" + bookSourceGroup + '\'' +
                ", bookSourceUrl='" + bookSourceUrl + '\'' +
                ", bookSourceType=" + bookSourceType +
                ", bookUrlPattern='" + bookUrlPattern + '\'' +
                ", customOrder=" + customOrder +
                ", enabled=" + enabled +
                ", enabledExplore=" + enabledExplore +
                ", header='" + header + '\'' +
                ", loginUrl='" + loginUrl + '\'' +
                ", bookSourceComment='" + bookSourceComment + '\'' +
                ", lastUpdateTime=" + lastUpdateTime +
                ", weight=" + weight +
                ", exploreUrl='" + exploreUrl + '\'' +
                ", ruleExplore='" + ruleExplore + '\'' +
                ", searchUrl='" + searchUrl + '\'' +
                ", ruleSearch='" + ruleSearch + '\'' +
                ", ruleBookInfo='" + ruleBookInfo + '\'' +
                ", ruleToc='" + ruleToc + '\'' +
                ", ruleContent='" + ruleContent + '\'' +
                '}';
    }
}
