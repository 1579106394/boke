<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>闲言博客</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/res/layui/layui.all.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/static/css/mian.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/amazeui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/admin.css"/>

</head>
<body class="lay-blog">

<jsp:include page="header.jsp"/>
<div class="container-wrap">
    <div class="container">
        <div class="contar-wrap">
            <h4 class="item-title">
                <p><a href="javascript:void(0);" onclick="readMessage('${notice.noticeId}')"><i
                        class="layui-icon layui-icon-speaker"></i>公告：<span>${notice.noticeTitle}</span></a></p>
            </h4>
            <c:forEach items="${page.list}" var="article">
                <div class="item">
                    <div class="item-box  layer-photos-demo1 layer-photos-demo">
                        <h3>
                            <a href="${pageContext.request.contextPath}/article/articleDetail.html?id=${article.articleId}">${article.articleTitle}</a>
                        </h3>
                        <h5>发布于：<span>${article.articleTime}</span></h5>
                        <div style="max-height: 300px; overflow: hidden;">
                                ${article.articleContent}
                        </div>
                    </div>
                    <div class="comment count">
                        <a href="${pageContext.request.contextPath}/article/articleDetail.html?id=${article.articleId}#comment">评论</a>
                        <a href="javascript:;" id="good" onclick="good('${article.articleId}')">点赞</a>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="am-fr" style="float: inherit">
            <ul class="am-pagination">
                <c:if test="${page.currentPage != 1}">
                    <li>
                        <a href="javascript:void(0)" onclick="submitForm(${page.currentPage-1})">«</a>
                    </li>
                </c:if>
                <c:forEach begin="1" end="${page.totalPage}" var="p">
                    <c:if test="${page.currentPage == p}">
                        <li class="am-active">
                            <a>${p}</a>
                        </li>
                    </c:if>
                    <c:if test="${page.currentPage != p}">
                        <li>
                            <a href="javascript:void(0)" onclick="submitForm(${p})">${p}</a>
                        </li>
                    </c:if>
                </c:forEach>
                <c:if test="${page.currentPage != page.totalPage}">
                    <li>
                        <a href="javascript:void(0)" onclick="submitForm(${page.currentPage+1})">»</a>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
<script>
    layui.config({
        base: '../res/static/js/'
    }).use('blog');

    function readMessage(id) {

        $.ajax({
            url: "${pageContext.request.contextPath}/notice/getById.action",
            data: "{\"noticeId\": \"" + id + "\"}",
            contentType: "application/json;charset=UTF-8",
            type: "post",
            dataType: "json",
            success: function (dep) {
                layer.alert(dep.noticeContent)
            }
        });

    }

    function good(id) {
        $.ajax({
            url: "${pageContext.request.contextPath}/article/good.action",
            data: "{\"articleId\": \"" + id + "\"}",
            contentType: "application/json;charset=UTF-8",
            type: "post",
            dataType: "json",
            success: function (dep) {
                if (!($("#good").hasClass("layblog-this"))) {
                    $("#good").text('已赞');
                    $("#good").addClass('layblog-this');
                    $("#good").removeAttr("onclick");
                    layer.msg('点赞成功', {
                        icon: 6
                        , time: 1000
                    })
                }
            }
        });
    }
</script>
<script>
    function submitForm(page) {
        $("#currentPage").val(page)
        $("#pageForm").submit()
    }
</script>
</body>
</html>
