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
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.INPUT)
    private String userId;

    private String username;

    private String password;

    /**
     * 昵称
     */
    private String userNiko;

    /**
     * 用户头像
     */
    private String userImg;

    private String userEmail;

    /**
     * 1男2女
     */
    private Integer userSex;

    /**
     * 手机号
     */
    private Long userTelephone;

    /**
     * 1普通用户，2管理员
     */
    private Integer userRole;

    /**
     * 是否拉黑。1不拉黑，0拉黑
     */
    private Integer userActive;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserNiko() {
        return userNiko;
    }

    public void setUserNiko(String userNiko) {
        this.userNiko = userNiko;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public Long getUserTelephone() {
        return userTelephone;
    }

    public void setUserTelephone(Long userTelephone) {
        this.userTelephone = userTelephone;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public Integer getUserActive() {
        return userActive;
    }

    public void setUserActive(Integer userActive) {
        this.userActive = userActive;
    }

    @Override
    public String toString() {
        return "User{" +
        "userId=" + userId +
        ", username=" + username +
        ", password=" + password +
        ", userNiko=" + userNiko +
        ", userImg=" + userImg +
        ", userEmail=" + userEmail +
        ", userSex=" + userSex +
        ", userTelephone=" + userTelephone +
        ", userRole=" + userRole +
        ", userActive=" + userActive +
        "}";
    }
}
