package com.fzy.boke.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.fzy.boke.pojo.User;
import com.fzy.boke.service.UserService;
import com.fzy.boke.utils.MailUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author:
 * @Date: 2019/12/17 22:27
 * @Version 1.0
 */
@Controller
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private UserService userService;

    /**
     * 查询用户，跳转到发送邮件页面
     *
     * @return
     */
    @RequestMapping("/toSend.html")
    public String toSend(String id, Model model) {
        model.addAttribute("userId", id);
        return "sendEmail";
    }

    /**
     * 发送邮件
     *
     * @param map
     * @return
     */
    @RequestMapping("/sendEmail.action")
    @ResponseBody
    public Map<String, Object> sendEmail(@RequestBody Map<String, Object> map) throws MessagingException {
        Map<String, Object> retMap = new HashMap<>();
        String title = MapUtils.getString(map, "title");
        String content = MapUtils.getString(map, "content");
        String userId = MapUtils.getString(map, "userId");
        User user = userService.selectById(userId);
        if (user == null) {
            retMap.put("code", 400);
            retMap.put("msg", "用户不存在！");
            return retMap;
        }
        String userEmail = user.getUserEmail();
        String emailReg = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p = Pattern.compile(emailReg);
        Matcher m = p.matcher(userEmail);
        if (!m.matches()) {
            retMap.put("code", 400);
            retMap.put("msg", "当前用户邮箱不正确！");
            return retMap;
        }
        MailUtils.sendMail(userEmail, content, title);
        retMap.put("code", 200);
        retMap.put("msg", "发送完毕！");
        return retMap;
    }

    /**
     * 通知邮件
     * 发送给所有人
     *
     * @param map
     * @return
     */
    @RequestMapping("/noticeEmail.action")
    @ResponseBody
    public Map<String, Object> noticeEmail(@RequestBody Map<String, Object> map) {
        Map<String, Object> retMap = new HashMap<>();
        String title = MapUtils.getString(map, "title");
        String content = MapUtils.getString(map, "content");
        List<User> userList = userService.selectList(new EntityWrapper<>());
        for (User user : userList) {
            String userEmail = user.getUserEmail();
            String emailReg = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern p = Pattern.compile(emailReg);
            Matcher m = p.matcher(userEmail);
            if (m.matches()) {
                try {
                    MailUtils.sendMail(userEmail, content, title);
                }catch (Exception ignored) {

                }
            }
        }
        retMap.put("code", 200);
        retMap.put("msg", "发送完毕！");
        return retMap;
    }

}
