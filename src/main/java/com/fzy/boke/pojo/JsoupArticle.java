package com.fzy.boke.pojo;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author 方紫英
 * @since 2019-12-14
 */
public class JsoupArticle implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 阅读量
     */
    private String readNum;

    /**
     * 发布时间
     */
    private String date;

    /**
     * 来源。空不填。爬虫填写url
     */
    private String childUrl;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 作者
     */
    private String author;

    public String getReadNum() {
        return readNum;
    }

    public void setReadNum(String readNum) {
        this.readNum = readNum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getChildUrl() {
        return childUrl;
    }

    public void setChildUrl(String childUrl) {
        this.childUrl = childUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
