package com.fzy.boke.utils;

import com.fzy.boke.pojo.Article;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

/**
 * Jsoup相关工具类
 *
 * @Date: 2019/5/8 0008 下午 5:56
 * @Version 1.0
 */
public class JsoupUtils {

    private JsoupUtils() {
    }

    /**
     * 获取爬取的CSDN文档
     */
    public static Document getCSDNDocument(int page, String lang) throws Exception {
        String url = "https://so.csdn.net/so/search/s.do?p=" + page + "&q=" + lang + "&t=&domain=&o=&s=&u=&l=";
        return getDocument(url);
    }

    /**
     * 获取爬取的CSDN文档
     */
    public static Document getYeziDocument(int page, String lang) throws Exception {
        String url = "http://search.sina.com.cn/?c=blog&q=" + lang + "&by=article&sort=time&col=&range=&source=&from=&country=&size=&time=&a=&page=" + page + "&dpc=1";
        return getDocument(url);
    }

    /**
     * 获取爬取的文档
     */
    public static Document getDocument(String url) throws Exception {
        Connection conn = Jsoup.connect(url);
        conn.header("Accept", "application/json, text/plain, */*; q=0.01").header("Accept-Encoding",
                "gzip, deflate");
        conn.header("Accept-Language", "zh-CN,zh;q=0.9").header("Connection", "keep-alive");
        conn.header("Content-Length", "30");
        conn.header("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:71.0) Gecko/20100101 Firefox/71.0")
                .header("X-Requested-With", "XMLHttpRequest");
        conn.ignoreHttpErrors(true);
        return conn.get();
    }

    @Test
    public void getTitleList() throws Exception {
        Document java = getCSDNDocument(1, "java");
        Elements elements = java.select(".search-list.J_search");
        for (Element element : elements) {
            // 标题
            Elements titleElement = element.select(".limit_width a:first-child");
            String title = titleElement.text();
            String childUrl = titleElement.attr("href");
            System.out.println(title + ":" + childUrl);

            Elements authorElement = element.select(".author");
            System.out.println("作者：" + authorElement.text().replace("作者： ", ""));

            Elements dateElement = element.select(".date");
            System.out.println("时间：" + dateElement.text().replace("日期：", ""));

            Elements readElement = element.select(".down");
            System.out.println("阅读数：" + readElement.text().replace("次阅读", ""));
            // 每次歇10毫秒，防止内存溢出或者被爬取对象检测到爬虫
            Thread.sleep(10);

        }
    }

    @Test
    public void getJianShuTitleList() throws Exception {
        Document java = getYeziDocument(1, "java");
        Elements elements = java.select("div.box-result");
        for (Element element : elements) {
            // 标题
            Elements titleElement = element.select(".r-info-blog-tit a");
            String title = titleElement.text();
            String childUrl = titleElement.attr("href");
            System.out.println(title + ":" + childUrl);

            Elements authorElement = element.select(".rib-author");
            System.out.println("作者：" + authorElement.text());

            Elements dateElement = element.select(".fgray_time");
            System.out.println("时间：" + dateElement.text());
            // 每次歇10毫秒，防止内存溢出或者被爬取对象检测到爬虫
            Thread.sleep(10);

        }
    }

    @Test
    public void getContent() throws Exception {
        Article article = new Article();

        Document childDocument = JsoupUtils.getDocument("http://blog.sina.com.cn/s/blog_e5284d3c0102yfc1.html");

        // 获取标题
        Elements titleElement = childDocument.select(".titName");
        String articleTitle = titleElement.html();

        // 获取发布时间
        Elements timeElement = childDocument.select(".time.SG_txtc");
        String time = timeElement.text().replaceAll("\\(", "").replaceAll("\\)", "");

        // 获取文章内容
        Elements contentElement = childDocument.select(".articalContent");
        String content = contentElement.html();
        System.out.println(articleTitle);
        System.out.println(time);
        System.out.println(content);
        // 每次歇10毫秒，防止内存溢出或者被爬取对象检测到爬虫
        Thread.sleep(10);

    }

    @Test
    public void getSinaContent() throws Exception {
        Article article = new Article();

        Document childDocument = JsoupUtils.getDocument("http://blog.sina.com.cn/s/blog_e5284d3c0102yfc1.html");

        // 获取标题
        Elements titleElement = childDocument.select(".title-article");
        String articleTitle = titleElement.html();

        // 获取发布时间
        Elements timeElement = childDocument.select(".time");
        String time = timeElement.text().replaceAll("年", "-").replaceAll("月", "-").replaceAll("日", "");

        // 获取文章内容
        Elements contentElement = childDocument.select(".baidu_pl");
        String content = contentElement.html();
        System.out.println(articleTitle);
        System.out.println(time);
        System.out.println(content);
        // 每次歇10毫秒，防止内存溢出或者被爬取对象检测到爬虫
        Thread.sleep(10);

    }

    @Test
    public void getAll() throws Exception {
        Document java = getCSDNDocument(1, "java");
        Elements elements = java.select(".search-list.J_search");
        for (Element element : elements) {
            // 标题
            Elements childElement = element.select(".limit_width a:first-child");
            String childUrl = childElement.attr("href");
            Document childDocument = JsoupUtils.getDocument(childUrl);

            // 获取标题
            Elements titleElement = childDocument.select(".title-article");
            String articleTitle = titleElement.text();

            // 获取发布时间
            Elements timeElement = childDocument.select(".time");
            String time = timeElement.text().replaceAll("年", "-").replaceAll("月", "-").replaceAll("日", "");

            // 获取文章内容
            Elements contentElement = childDocument.select(".baidu_pl");
            String content = contentElement.html();
            System.out.println(articleTitle);
            System.out.println(time);
            System.out.println(content);
            // 每次歇10毫秒，防止内存溢出或者被爬取对象检测到爬虫
            Thread.sleep(10);

        }
    }
}
