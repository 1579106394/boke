<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>留言-闲言博客</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/static/css/mian.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/amazeui.min.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/res/layui/layui.all.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/admin.css"/>
</head>
<body class="lay-blog">
<jsp:include page="header.jsp"/>
<div class="container-wrap">
    <div class="container container-message">
        <div class="contar-wrap" id="contar-wrap">
            <c:if test="${sessionScope.user.userActive == 1}">
                <form class="layui-form" action="${pageContext.request.contextPath}/message/add.html" method="post">
                    <div class="layui-form-item layui-form-text">
                    <textarea class="layui-textarea" id="LAY-msg-content" name="messageContent"
                              style="resize:none"></textarea>
                    </div>
                    <div class="item-btn">
                        <button class="layui-btn layui-btn-normal" type="submit" id="item-btn">提交</button>
                    </div>
                </form>
            </c:if>

            <form action="${pageContext.request.contextPath}/message/front/page.html" method="post" id="pageForm">
                <input type="hidden" name="currentPage" value="${page.currentPage}" id="currentPage">
            </form>

            <div id="LAY-msg-box">
                <div class="info-box">
                    <c:forEach items="${page.list}" var="message">
                        <div class="info-item">
                            <img class="info-img"
                                 src="${pageContext.request.contextPath}${message.user.userImg}" width="88px" height="68px" alt="">
                            <div class="info-text">
                                <p class="title count">
                                    <span class="name" style="display: inline-block">${message.user.userNiko}</span>
                                    <span class="info-img like" id="${message.messageId}"
                                          onclick="good('${message.messageId}')"><i
                                            class="layui-icon layui-icon-praise"></i><em
                                            id="messageGood">${message.messageGood}</em></span>
                                </p>
                                <p class="info-intr">
                                        ${message.messageContent}</p>
                            </div>
                        </div>
                    </c:forEach>
                </div>
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
</div>
<jsp:include page="footer.jsp"/>
</div>

<script id="LAY-msg-tpl" type="text/html">
    <div class="info-box">
        <div class="info-item">
            <img class="info-img" src="{{ d.avatar }}" alt="">
            <div class="info-text">
                <p class="title">
                    <span class="name">{{ d.username }}</span>
                    <span class="info-img">
					  	<i class="layui-icon layui-icon-praise"></i>
					  	{{ d.praise }}
					 	</span>
                </p>
                <p class="info-intr">
                    {{ d.content }}
                </p>
            </div>
        </div>
    </div>
</script>

<script>
    function submitForm(page) {
        $("#currentPage").val(page)
        $("#pageForm").submit()
    }

    function good(id) {
        $.ajax({
            url: "${pageContext.request.contextPath}/message/good.action",
            data: "{\"messageId\": \"" + id + "\"}",
            contentType: "application/json;charset=UTF-8",
            type: "post",
            dataType: "json",
            success: function (dep) {
                if (!($("#" + id).hasClass("layblog-this"))) {
                    $("#" + id).addClass('layblog-this');
                    $("#" + id).removeAttr("onclick");
                    var zan = parseInt($("#" + id + " #messageGood").text());
                    $("#" + id + " #messageGood").text(zan + 1);
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
