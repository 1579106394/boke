package com.fzy.boke.controller;

import com.fzy.boke.pojo.Message;
import com.fzy.boke.pojo.User;
import com.fzy.boke.service.MessageService;
import com.fzy.boke.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 方紫英
 * @since 2019-12-14
 */
@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 发布留言
     *
     * @param message
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/add.html")
    public String add(Message message, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageGood(0);
        message.setMessageTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        message.setMessageUser(user.getUserId());
        messageService.insert(message);
        return "redirect:/message/front/page.html";
    }

    /**
     * 前台分页查询
     *
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("/front/page.html")
    public String frontPage(Page<Message> page, Model model) {
        page = messageService.selectByPage(page);
        model.addAttribute("page", page);
        return "front/message";
    }

    /**
     * 后台分页
     *
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("/page.html")
    public String page(Page<Message> page, Model model) {
        page = messageService.selectByPage(page);
        model.addAttribute("page", page);
        return "messageList";
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete.html")
    public String delete(String id) {
        messageService.deleteById(id);
        return "redirect:/message/page.html";
    }

    /**
     * 根据id查询
     * 返回json
     *
     * @param message
     * @return
     */
    @RequestMapping("/getById.action")
    @ResponseBody
    public Message getById(@RequestBody Message message) {
        return messageService.selectById(message.getMessageId());
    }

    /**
     * 点赞
     */
    @RequestMapping("/good.action")
    @ResponseBody
    public Map<String, Object> good(@RequestBody Message message) {
        Message a = messageService.selectById(message.getMessageId());
        // 点赞数+1
        a.setMessageGood(a.getMessageGood() + 1);
        messageService.updateById(a);
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("code", "200");
        return retMap;
    }
}

