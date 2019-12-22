package com.fzy.boke.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author 方紫英
 * @since 2019-12-14
 */
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "article_id", type = IdType.INPUT)
    private String articleId;

    /**
     * 内容
     */
    private String articleContent;

    /**
     * 阅读量
     */
    private Integer artilceRead;

    /**
     * 发布时间
     */
    private String articleTime;

    /**
     * 来源。空不填。爬虫填写url
     */
    private String articleSource;

    /**
     * 预留字段。文章分类，暂时不用
     */
    private String articleType;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 点赞量
     */
    private Integer articleGood;


    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Integer getArtilceRead() {
        return artilceRead;
    }

    public void setArtilceRead(Integer artilceRead) {
        this.artilceRead = artilceRead;
    }

    public String getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(String articleTime) {
        this.articleTime = articleTime;
    }

    public String getArticleSource() {
        return articleSource;
    }

    public void setArticleSource(String articleSource) {
        this.articleSource = articleSource;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public Integer getArticleGood() {
        return articleGood;
    }

    public void setArticleGood(Integer articleGood) {
        this.articleGood = articleGood;
    }

    @Override
    public String toString() {
        return "Article{" +
        "articleId=" + articleId +
        ", articleContent=" + articleContent +
        ", artilceRead=" + artilceRead +
        ", articleTime=" + articleTime +
        ", articleSource=" + articleSource +
        ", articleType=" + articleType +
        ", articleTitle=" + articleTitle +
        ", articleGood=" + articleGood +
        "}";
    }
}
