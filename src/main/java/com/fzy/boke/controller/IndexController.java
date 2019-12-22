package com.fzy.boke.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.fzy.boke.pojo.Article;
import com.fzy.boke.pojo.Notice;
import com.fzy.boke.service.ArticleService;
import com.fzy.boke.service.NoticeService;
import com.fzy.boke.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 方紫英
 * @Date: 2019/12/14 22:53
 * @Version 1.0
 */
@Controller
public class IndexController {

    @Autowired
    private NoticeService noticeService;
    @Autowired
    private ArticleService articleService;

    /**
     * 重定向到首页
     * @return
     */
    @RequestMapping("/")
    public String redirect() {
        return "redirect:/index/front.html";
    }

    /**
     * 前台首页
     *
     * @return
     */
    @RequestMapping("/index/front.html")
    public String frontIndex(Model model, Page<Article> page) {
        // 查询最新公告
        Notice notice = noticeService.selectOne(new EntityWrapper<Notice>().orderBy("notice_time", false));
        model.addAttribute("notice", notice);
        page = articleService.selectByPage(page);
        model.addAttribute("page", page);
        return "front/index";
    }

    /**
     * 后台首页
     *
     * @return
     */
    @RequestMapping("/index/back.html")
    public String backIndex() {

        return "index";
    }

}
