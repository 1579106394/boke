<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>404 - 闲言博客</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/static/css/mian.css">
</head>
<body class="lay-blog">

<jsp:include page="header.jsp"/>
<div class="container-wrap">
    <div class="container">
        <div class="contar-wrap">
            <div style="padding: 150px 0 50px; text-align: center; font-size: 30px; color: #ccc; font-weight: 300;">
                心姐抛出了个 404
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
<script src="${pageContext.request.contextPath}/res/layui/layui.js"></script>
<script>
    layui.config({
        base: '${pageContext.request.contextPath}/res/static/js/'
    }).use('blog');
</script>
</body>
</html>
