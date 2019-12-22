package com.fzy.boke.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.fzy.boke.pojo.Article;
import com.fzy.boke.pojo.JsoupArticle;
import com.fzy.boke.service.ArticleService;
import com.fzy.boke.utils.JsoupUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author:
 * @Date: 2019/12/18 22:26
 * @Version 1.0
 */
@Controller
@RequestMapping("/jsoup")
public class JsoupController {

    @Autowired
    private ArticleService articleService;

    /**
     * 爬取文章列表
     *
     * @param search
     * @param currentPage
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/articleList.html")
    public String articleList(String search, Integer currentPage, Model model) throws Exception {
        if (search == null) {
            search = " ";
        }
        if (currentPage == null) {
            currentPage = 1;
        }
        String searchName = URLEncoder.encode(search, "GBK");
        Document java = JsoupUtils.getYeziDocument(currentPage, searchName);
        List<JsoupArticle> articleList = new ArrayList<>();
        Elements elements = java.select("div.box-result");
        for (Element element : elements) {
            JsoupArticle article = new JsoupArticle();
            // 标题
            Elements titleElement = element.select(".r-info-blog-tit a");
            String title = titleElement.text();
            String childUrl = titleElement.attr("href");
            System.out.println(title + ":" + childUrl);

            Elements authorElement = element.select(".rib-author");
            System.out.println("作者：" + authorElement.text());

            Elements dateElement = element.select(".fgray_time");
            System.out.println("时间：" + dateElement.text());
            // 标题
            String author = authorElement.text();
            String date = dateElement.text();
            article.setTitle(title);
            article.setChildUrl(childUrl);
            article.setAuthor(author);
            article.setDate(date);
            article.setReadNum("0");
            articleList.add(article);
            Thread.sleep(10);
        }
        model.addAttribute("search", search);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("articleList", articleList);
        return "jsoupArticleList";
    }

    @RequestMapping("/save.action")
    @ResponseBody
    public Map<String, Object> save(@RequestBody Map<String, Object> dataMap) throws Exception {
        String url = (String) dataMap.get("url");
        Map<String, Object> retMap = new HashMap<>();
        Document childDocument = JsoupUtils.getDocument(url);

        // 获取标题
        Elements titleElement = childDocument.select(".titName");
        String articleTitle = titleElement.text();

        Article article1 = articleService.selectOne(new EntityWrapper<Article>().eq("article_title", articleTitle));
        if (article1 != null) {
            retMap.put("code", 400);
            return retMap;
        }

        // 获取发布时间
        Elements timeElement = childDocument.select(".time.SG_txtc");
        String time = timeElement.text().replaceAll("\\(", "").replaceAll("\\)", "");

        // 获取文章内容
        Elements contentElement = childDocument.select(".articalContent");
        String content = contentElement.html();
        System.out.println(articleTitle);
        System.out.println(time);
        System.out.println(content);

        Article article = new Article();
        article.setArticleId(UUID.randomUUID().toString());
        article.setArticleSource(url);
        article.setArticleTitle(articleTitle);
        article.setArticleContent(content);
        article.setArticleGood(0);
        article.setArtilceRead(0);
        article.setArticleTime(time);
        articleService.insert(article);
        retMap.put("code", 200);
        return retMap;
    }

}
