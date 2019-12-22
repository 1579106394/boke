<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>评论-闲言博客</title>
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
    <div class="container container-message container-details container-comment">
        <div class="contar-wrap">
            <div class="item">
                <div class="item-box  layer-photos-demo1 layer-photos-demo">
                    <h3>
                        <a href="${pageContext.request.contextPath}/article/articleDetail.html?id=${article.articleId}">${article.articleTitle}</a>
                    </h3>
                    <h5>发布于：<span>${article.articleTime}</span></h5>
                    <p>
                        ${article.articleContent}
                    </p>
                    <div class="count layui-clear">
                        <span class="pull-left">阅读 <em>${article.artilceRead}</em></span>
                        <span class="pull-right like" id="good" onclick="good('${article.articleId}')"><i
                                class="layui-icon layui-icon-praise"></i><em
                                id="articleGood">${article.articleGood}</em></span>
                    </div>
                </div>
            </div>
            <a name="comment"> </a>
            <c:if test="${sessionScope.user.userActive == 1}">
                <form class="layui-form" action="${pageContext.request.contextPath}/comment/add.html" method="post">
                    <input type="hidden" name="commentUser" value="${sessionScope.user.userId}">
                    <input type="hidden" name="commentArticle" value="${article.articleId}">
                    <div class="layui-form-item layui-form-text">
                    <textarea class="layui-textarea" name="commentContent" style="resize:none"
                              placeholder="写点什么啊"></textarea>
                    </div>
                    <div class="btnbox">
                        <button type="submit" class="layui-btn layui-btn-normal">
                            确定
                        </button>
                    </div>
                </form>
            </c:if>
            <div id="LAY-msg-box">
                <c:forEach items="${commentList}" var="comment">
                    <div class="info-item">
                        <img class="info-img" src="${pageContext.request.contextPath}${comment.user.userImg}"
                             width="88px" height="68px"
                             alt="">
                        <div class="info-text">
                            <p class="title count">
                                <span class="name">哈哈</span>
                                <span class="info-img like" id="${comment.commentId}"
                                      onclick="goodComment('${comment.commentId}')"><i
                                        class="layui-icon layui-icon-praise"></i>
                                <em id="commentGood">${comment.commentGood}</em>
                                </span>
                            </p>
                            <p class="info-intr">${comment.commentContent}</p>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>

<script>

    function good(id) {
        $.ajax({
            url: "${pageContext.request.contextPath}/article/good.action",
            data: "{\"articleId\": \"" + id + "\"}",
            contentType: "application/json;charset=UTF-8",
            type: "post",
            dataType: "json",
            success: function (dep) {
                if (!($("#good").hasClass("layblog-this"))) {
                    $("#good").addClass('layblog-this');
                    $("#good").removeAttr("onclick");
                    var zan = parseInt($("#articleGood").text());
                    $("#articleGood").text(zan + 1);
                    layer.msg('点赞成功', {
                        icon: 6
                        , time: 1000
                    })
                }
            }
        });
    }

    function goodComment(id) {
        $.ajax({
            url: "${pageContext.request.contextPath}/comment/good.action",
            data: "{\"commentId\": \"" + id + "\"}",
            contentType: "application/json;charset=UTF-8",
            type: "post",
            dataType: "json",
            success: function (dep) {
                if (!($("#" + id).hasClass("layblog-this"))) {
                    $("#" + id).addClass('layblog-this');
                    $("#" + id).removeAttr("onclick");
                    var zan = parseInt($("#" + id + " #commentGood").text());
                    $("#" + id + " #commentGood").text(zan + 1);
                    layer.msg('点赞成功', {
                        icon: 6
                        , time: 1000
                    })
                }
            }
        });
    }
</script>
</body>
</html>
