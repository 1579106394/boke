package com.fzy.boke.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
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
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "comment_id", type = IdType.INPUT)
    private String commentId;

    /**
     * 评论者
     */
    private String commentUser;

    @TableField(exist = false)
    private User user;

    @TableField(exist = false)
    private Article article;
    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 评论时间
     */
    private String commentTime;

    /**
     * 评论帖子
     */
    private String commentArticle;

    /**
     * 点赞量
     */
    private Integer commentGood;

    /**
     * 预留字段，父级id
     */
    private String commentParent;

    public User getUser() {
        return user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(String commentUser) {
        this.commentUser = commentUser;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentArticle() {
        return commentArticle;
    }

    public void setCommentArticle(String commentArticle) {
        this.commentArticle = commentArticle;
    }

    public Integer getCommentGood() {
        return commentGood;
    }

    public void setCommentGood(Integer commentGood) {
        this.commentGood = commentGood;
    }

    public String getCommentParent() {
        return commentParent;
    }

    public void setCommentParent(String commentParent) {
        this.commentParent = commentParent;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentUser=" + commentUser +
                ", commentContent=" + commentContent +
                ", commentTime=" + commentTime +
                ", commentArticle=" + commentArticle +
                ", commentGood=" + commentGood +
                ", commentParent=" + commentParent +
                "}";
    }
}
