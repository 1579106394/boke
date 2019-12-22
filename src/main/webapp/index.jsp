<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/global.css">
    <script src="${pageContext.request.contextPath}/res/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
</head>
<body>
<div class="header">
    <div class="main">
        <a href="index.jsp" style="margin-left: 30px;line-height: 65px; color: white;font-size: 18px;">闲言博客后台管理</a>

        <div class="nav-user">
            <!-- 登入后的状态 -->

            <dev class="avatar">
                <a href="#" style="color: white;">${sessionScope.user.userNiko}</a>
                <a href="${pageContext.request.contextPath}/user/logOut.html" style="color: white;">退了</a>
            </dev>
            <div class="nav">
            </div>
        </div>
    </div>
</div>


<div class="main fly-user-main layui-clear">
    <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="user">

        <c:if test="${sessionScope.user.userRole == 2}">
            <li class="layui-nav-item layui-this"><a href="${pageContext.request.contextPath}/article/page.html"
                                                     target="right"> <i
                    class="layui-icon">&#xe705;</i> 文章管理</a></li>
            <li class="layui-nav-item "><a href="${pageContext.request.contextPath}/notice/page.html" target="right"> <i
                    class="layui-icon">&#xe667;</i> 公告管理</a></li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/user/page.html" target="right"> <i
                    class="layui-icon">&#xe66f;</i> 用户管理 </a></li>
            <li class="layui-nav-item "><a href="${pageContext.request.contextPath}/comment/page.html" target="right"> <i
                    class="layui-icon">&#xe63a;</i> 评论管理</a></li>
            <li class="layui-nav-item "><a href="${pageContext.request.contextPath}/message/page.html" target="right"> <i
                    class="layui-icon">&#xe66e;</i> 留言管理</a></li>
            <li class="layui-nav-item  "><a href="${pageContext.request.contextPath}/sendEmailNotice.jsp" target="right"> <i
                    class="layui-icon">&#xe609;</i> 邮件群发 </a></li>
            <li class="layui-nav-item  "><a href="${pageContext.request.contextPath}/jsoup/articleList.html?currentPage=1&search=闲言" target="right"> <i
                    class="layui-icon">&#xe635;</i> 文章爬取 </a></li>
            <li class="layui-nav-item "><a href="${pageContext.request.contextPath}/userDetail.jsp" target="right"> <i
                    class="layui-icon">&#xe60a;</i> 个人信息</a></li>
        </c:if>
        <c:if test="${sessionScope.user.userRole == 1}">

            <li class="layui-nav-item "><a href="${pageContext.request.contextPath}/userDetail.jsp" target="right"> <i
                    class="layui-icon">&#xe60a;</i> 个人信息</a></li>
        </c:if>
    </ul>

    <div class="site-tree-mobile layui-hide">
        <i class="layui-icon">&#xe602;</i>
    </div>
    <div class="site-mobile-shade"></div>

    <div class="fly-panel fly-panel-user">
        <div class="layui-tab layui-tab-brief" lay-filter="user">

            <div class="layui-tab-content" style="padding: 20px;padding-top: 0px;">

                <iframe src="${pageContext.request.contextPath}/article/page.html" width="88%" style="border: none;"
                        height="1300"
                        border="none"
                        name="right"></iframe>
            </div>
        </div>
    </div>
</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/myplugs/js/plugs.js"></script>--%>
<script>
    layui.use('element', function () {
        var element = layui.element();
    });
</script>
</body>
</html>
