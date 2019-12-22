package com.fzy.boke.controller;

import com.fzy.boke.pojo.Article;
import com.fzy.boke.pojo.Comment;
import com.fzy.boke.service.ArticleService;
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
import java.util.List;
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
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    /**
     * 查询文章列表带搜索和分页
     *
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("/page.html")
    public String page(Page<Article> page, Model model) {
        page = articleService.selectByPage(page);
        model.addAttribute("page", page);
        return "articleList";
    }

    /**
     * 保存文章
     *
     * @param article
     * @return
     */
    @RequestMapping("/add.html")
    public String add(Article article) {
        article.setArticleId(UUID.randomUUID().toString());
        article.setArticleTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        article.setArticleGood(0);
        article.setArtilceRead(0);
        articleService.insert(article);
        return "redirect:/article/page.html";
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete.html")
    public String delete(String id) {
        articleService.deleteById(id);
        return "redirect:/article/page.html";
    }

    /**
     * 查询回显到修改
     */
    @RequestMapping("/toEdit.html")
    public String toEdit(String id, Model model) {
        Article article = articleService.selectById(id);
        model.addAttribute("article", article);
        return "articleEdit";
    }

    /**
     * 修改文章
     */
    @RequestMapping("/edit.html")
    public String edit(Article article) {
        articleService.updateById(article);
        return "redirect:/article/page.html";
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
    public Article getById(@RequestBody Article message) {
        return articleService.selectById(message.getArticleId());
    }

    /**
     * 查询文章跳转到详情页
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/articleDetail.html")
    public String detail(String id, Model model) {
        Article article = articleService.selectById(id);
        // 阅读数+1
        article.setArtilceRead(article.getArtilceRead() + 1);
        articleService.updateById(article);
        model.addAttribute("article", article);

        // 查询评论
        List<Comment> commentList = commentService.getListByArticle(id);
        model.addAttribute("commentList", commentList);
        return "front/details";
    }

    /**
     * 点赞
     */
    @RequestMapping("/good.action")
    @ResponseBody
    public Map<String, Object> good(@RequestBody Article article) {
        Article a = articleService.selectById(article.getArticleId());
        // 点赞数+1
        a.setArticleGood(a.getArticleGood() + 1);
        articleService.updateById(a);
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("code", "200");
        return retMap;
    }

}

