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
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "message_id", type = IdType.INPUT)
    private String messageId;

    /**
     * 留言者
     */
    private String messageUser;

    @TableField(exist = false)
    private User user;

    /**
     * 留言内容
     */
    private String messageContent;

    /**
     * 留言时间
     */
    private String messageTime;

    /**
     * 点赞量
     */
    private Integer messageGood;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

    public Integer getMessageGood() {
        return messageGood;
    }

    public void setMessageGood(Integer messageGood) {
        this.messageGood = messageGood;
    }

    @Override
    public String toString() {
        return "Message{" +
        "messageId=" + messageId +
        ", messageUser=" + messageUser +
        ", messageContent=" + messageContent +
        ", messageTime=" + messageTime +
        ", messageGood=" + messageGood +
        "}";
    }
}
