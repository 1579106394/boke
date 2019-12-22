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
public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "notice_id", type = IdType.INPUT)
    private String noticeId;

    /**
     * 公告内容
     */
    private String noticeContent;

    /**
     * 公告时间
     */
    private String noticeTime;

    /**
     * 公告标题
     */
    private String noticeTitle;

    /**
     * 阅读
     */
    private Integer noticeRead;


    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(String noticeTime) {
        this.noticeTime = noticeTime;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public Integer getNoticeRead() {
        return noticeRead;
    }

    public void setNoticeRead(Integer noticeRead) {
        this.noticeRead = noticeRead;
    }

    @Override
    public String toString() {
        return "Notice{" +
        "noticeId=" + noticeId +
        ", noticeContent=" + noticeContent +
        ", noticeTime=" + noticeTime +
        ", noticeTitle=" + noticeTitle +
        ", noticeRead=" + noticeRead +
        "}";
    }
}
