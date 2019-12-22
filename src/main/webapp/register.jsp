<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" media="all"/>

    <!-- Jquery Js -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <!-- Layui Js -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/layui/layui.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/layui/css/layui.css" media="all"/>
    <!-- Jqarticle Js -->
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/assembly/jqarticle/jparticle.min.js"></script>
    <style>

        .body {
            background-image: url("${pageContext.request.contextPath}/img/carousel/01.jpg");
        }

        .layui-input, .layui-select, .layui-textarea {
            background-color: inherit;
            padding-left: 30px;
        }
        .zyl_lofo_main {
            height: 460px;
        }
    </style>
</head>
<body class="body">
<div class="zyl_lofo_main">
    <fieldset class="layui-elem-field layui-field-title zyl_mar_02">
        <legend>欢迎注册 - 闲言博客</legend>
    </fieldset>
    <div class="layui-row layui-col-space15">
        <form class="layui-form zyl_pad_01" action="${pageContext.request.contextPath}/user/register.html"
              method="post">
            <div class="layui-col-sm12 layui-col-md12">
                <div class="layui-form-item">
                    <input type="text" name="username" lay-verify="required|userName" autocomplete="off"
                           placeholder="账号" class="layui-input">
                    <i class="layui-icon layui-icon-username zyl_lofo_icon"></i>
                </div>
            </div>
            <div class="layui-col-sm12 layui-col-md12">
                <div class="layui-form-item">
                    <input type="password" name="password" lay-verify="required|pass" autocomplete="off"
                           placeholder="密码"
                           class="layui-input">
                    <i class="layui-icon layui-icon-password zyl_lofo_icon"></i>
                </div>
            </div>
            <div class="layui-col-sm12 layui-col-md12">
                <div class="layui-form-item">
                    <input type="text" name="userNiko" lay-verify="required" autocomplete="off"
                           placeholder="昵称" class="layui-input">
                    <i class="layui-icon layui-icon-username zyl_lofo_icon"></i>
                </div>
            </div>
            <div class="layui-col-sm12 layui-col-md12">
                <div class="layui-form-item">
                    <input type="text" name="userEmail" autocomplete="off"
                           placeholder="邮箱" class="layui-input">
                    <i class="layui-icon layui-icon-username zyl_lofo_icon"></i>
                </div>
            </div>
            <div class="layui-col-sm12 layui-col-md12">
                <div class="layui-form-item">
                    <input type="text" name="userPhone" lay-verify="required|userName" autocomplete="off"
                           placeholder="手机号" class="layui-input">
                    <i class="layui-icon layui-icon-username zyl_lofo_icon"></i>
                </div>
            </div>
            <div class="layui-col-sm12 layui-col-md12">
                <div class="layui-row">
                    <div class="layui-form-item">
                        <label class="layui-form-label" style="text-align: left">性别</label>
                        <div class="layui-input-block">
                            <input type="radio" name="userSex" value="1" title="男">
                            <input type="radio" name="userSex" value="2" title="女" checked>
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-col-sm12 layui-col-md12">
                <div class="layui-row" style="color: red;">
                    ${error}
                </div>
            </div>
            <div class="layui-col-sm12 layui-col-md12">
                <button class="layui-btn" lay-submit="" lay-filter="demo1">立即注册</button>
                <a class="layui-btn" href="${pageContext.request.contextPath}/login.jsp">前去登录</a>
            </div>
        </form>
    </div>
</div>
<!-- LoginForm End -->
<script>
    layui.use('form', function () {
        var form = layui.form;
    });
</script>
</body>
</html>
