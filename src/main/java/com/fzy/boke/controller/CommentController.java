package com.fzy.boke.controller;

import com.fzy.boke.pojo.Comment;
import com.fzy.boke.service.CommentService;
import com.fzy.boke.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 发布评论
     *
     * @param comment
     * @param model
     * @return
     */
    @RequestMapping("/add.html")
    public String add(Comment comment, Model model) {
        comment.setCommentId(UUID.randomUUID().toString());
        comment.setCommentGood(0);
        comment.setCommentTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        commentService.insert(comment);
        return "redirect:/article/articleDetail.html?id=" + comment.getCommentArticle();
    }

    /**
     * 后台分页
     *
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("/page.html")
    public String page(Page<Comment> page, Model model) {
        page = commentService.selectByPage(page);
        model.addAttribute("page", page);
        return "commentList";
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete.html")
    public String delete(String id) {
        commentService.deleteById(id);
        return "redirect:/comment/page.html";
    }

    /**
     * 根据id查询
     * 返回json
     *
     * @param comment
     * @return
     */
    @RequestMapping("/getById.action")
    @ResponseBody
    public Comment getById(@RequestBody Comment comment) {
        return commentService.selectById(comment.getCommentId());
    }

    /**
     * 点赞
     */
    @RequestMapping("/good.action")
    @ResponseBody
    public Map<String, Object> good(@RequestBody Comment comment) {
        Comment a = commentService.selectById(comment.getCommentId());
        // 点赞数+1
        a.setCommentGood(a.getCommentGood() + 1);
        commentService.updateById(a);
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("code", "200");
        return retMap;
    }
}

