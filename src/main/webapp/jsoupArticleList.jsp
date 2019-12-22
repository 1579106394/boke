<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/amazeui.min.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/admin.css"/>
    <script src="${pageContext.request.contextPath}/res/layui/layui.all.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/layui/css/layui.css"/>
</head>

<body>
<div class="admin-content-body">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">文章爬取</strong><small></small></div>
    </div>

    <hr>
    <form action="${pageContext.request.contextPath}/jsoup/articleList.html" method="post" id="pageForm">
        <input type="hidden" name="currentPage" value="${currentPage}" id="currentPage">
        <div class="am-g">
            <div class="am-u-sm-12 am-u-md-6">
            </div>
            <div class="am-u-sm-12 am-u-md-3">

            </div>
            <div class="am-u-sm-12 am-u-md-3">
                <div class="am-input-group am-input-group-sm">
                    <input type="text" value="${search}" placeholder="文章标题"
                           name="search" class="am-form-field">
                    <span class="am-input-group-btn">
            <button class="am-btn am-btn-default" type="submit">搜索</button>
          </span>
                </div>
            </div>
        </div>
        <div class="am-g">
            <div class="am-u-sm-12">
                <form class="am-form">
                    <table class="am-table am-table-striped am-table-hover table-main">
                        <thead>
                        <tr>
                            <th class="table-title">标题</th>
                            <th class="table-type">阅读量</th>
                            <th class="table-author am-hide-sm-only">作者</th>
                            <th class="table-author am-hide-sm-only">来源</th>
                            <th class="table-author am-hide-sm-only">发表时间</th>
                            <th class="table-set">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${articleList}" var="article">
                            <tr>
                                <td>${article.title}</td>
                                <td>${article.readNum}</td>
                                <td>${article.author}</td>
                                <td>${article.childUrl}</td>
                                <td>${article.date}</td>
                                <td>
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <a href="javascript:void(0);" onclick="readMessage('${article.childUrl}')"
                                               class="am-btn am-btn-default am-btn-xs am-text-secondary"><span
                                                    class="am-icon-pencil-square-o"></span> 查看
                                            </a>
                                            <a href="javascript:void(0);" onclick="saveArticle('${article.childUrl}')"
                                               class="am-btn am-btn-default am-btn-xs am-text-secondary"><span
                                                    class="am-icon-pencil-square-o"></span> 保存
                                            </a>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="am-cf">
                        <div class="am-fr">
                            <ul class="am-pagination">
                                <c:if test="${currentPage != 1}">
                                    <li>
                                        <a href="javascript:void(0)" onclick="submitForm(${currentPage-1})">«</a>
                                    </li>
                                </c:if>
                                <c:forEach begin="${currentPage}" end="${currentPage + 10}" var="p">
                                    <c:if test="${currentPage == p}">
                                        <li class="am-active">
                                            <a>${p}</a>
                                        </li>
                                    </c:if>
                                    <c:if test="${currentPage != p}">
                                        <li>
                                            <a href="javascript:void(0)" onclick="submitForm(${p})">${p}</a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                                <li>
                                    <a href="javascript:void(0)" onclick="submitForm(${currentPage+1})">»</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <hr>
                </form>
            </div>
        </div>
    </form>
</div>
<script>
    function submitForm(page) {
        $("#currentPage").val(page)
        $("#pageForm").submit()
    }

    function readMessage(url) {
        layer.open({
            type: 2
            , content: url
            , area: ['1400px', '1000px']
        })

    }

    function saveArticle(url) {

        $.ajax({
            url: "${pageContext.request.contextPath}/jsoup/save.action",
            data: "{\"url\": \"" + url + "\"}",
            contentType: "application/json;charset=UTF-8",
            type: "post",
            dataType: "json",
            success: function (dep) {
                if(dep.code == 200) {
                    layer.alert("保存成功！")
                }
                if(dep.code == 400) {
                    layer.alert("文章已存在！")
                }
            }
        });

    }
</script>
</body>
</html>
