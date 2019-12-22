<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/static/css/mian.css">
</head>
<div class="header">
    <div class="header-wrap">
        <h1 class="logo pull-left">
            <a href="${pageContext.request.contextPath}/index/front.html">
                <img src="${pageContext.request.contextPath}/res/static/images/logo.png" alt="" class="logo-img">
                <img src="${pageContext.request.contextPath}/res/static/images/logo-text.png" alt="" class="logo-text">
            </a>
        </h1>
        <form class="layui-form blog-seach pull-left" action="${pageContext.request.contextPath}/index/front.html"
              method="post" id="pageForm">
            <div class="layui-form-item blog-sewrap">
                <div class="layui-input-block blog-sebox">
                    <i class="layui-icon layui-icon-search"></i>
                    <input type="text" name="params[articleTitle]" lay-verify="title" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
        </form>
        <div class="blog-nav pull-right">
            <ul class="layui-nav pull-left">
                <li class="layui-nav-item layui-this"><a
                        href="${pageContext.request.contextPath}/index/front.html">首页</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/message/front/page.html">留言</a>
                </li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/front/about.jsp">关于</a></li>
            </ul>
            <a href="${pageContext.request.contextPath}/userDetail.jsp" class="personal pull-left">
                <i class="layui-icon layui-icon-username"></i>
            </a>
        </div>
        <div class="mobile-nav pull-right" id="mobile-nav">
            <a href="javascript:;">
                <i class="layui-icon layui-icon-more"></i>
            </a>
        </div>
    </div>
    <ul class="pop-nav" id="pop-nav">
        <li><a href="${pageContext.request.contextPath}/index/front.html">首页</a></li>
        <li><a href="${pageContext.request.contextPath}/message/front/page.html">留言</a></li>
        <li><a href="${pageContext.request.contextPath}/front/about.jsp">关于</a></li>
    </ul>
</div>
