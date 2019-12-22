<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/amazeui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/admin.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/res/layui/layui.all.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/layui/css/layui.css"/>

    <style type="text/css">
        #div1 {
            width: 100%;
            height: 300px;
        }
    </style>

    <script type="text/javascript">
        function formSubmit() {
            $("#userForm").submit();
        }
    </script>

</head>

<body>
<div class="admin-content-body">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">个人信息</strong>
            <small></small>
        </div>
    </div>

    <hr>
    <div class="am-cf">
        <!-- content start -->
        <div class="">
            <div class="admin-content-body">
                <div class="am-g">
                    <form class="am-form am-form-horizontal" id="userForm"
                          action="${pageContext.request.contextPath}/user/updateDetail.html" method="post"
                          style="padding-top: 30px;">
                        <input type="hidden" name="userId" value="${sessionScope.user.userId}">
                        <input type="hidden" name="userActive" value="${sessionScope.user.userActive}">
                        <input type="hidden" name="userRole" value="${sessionScope.user.userRole}">
                        <input type="hidden" name="username" value="${sessionScope.user.username}">
                        <input type="hidden" name="userSex" value="${sessionScope.user.userSex}">
                        <input type="hidden" id="userImg" name="userImg" value="${sessionScope.user.userImg}">
                        <div class="am-form-group">
                            <label class="am-u-sm-2 am-form-label">
                                昵称
                            </label>
                            <div class="am-u-sm-10">
                                <input id="userNiko" required="" placeholder="" value="${sessionScope.user.userNiko}"
                                       name="userNiko"
                                       type="text">
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label class="am-u-sm-2 am-form-label">
                                密码
                            </label>
                            <div class="am-u-sm-10">
                                <input id="password" required="" placeholder="" value="${sessionScope.user.password}"
                                       name="password"
                                       type="text">
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label class="am-u-sm-2 am-form-label">
                                手机
                            </label>
                            <div class="am-u-sm-10">
                                <input id="userTelephone" required="" placeholder=""
                                       value="${sessionScope.user.userTelephone}"
                                       name="userTelephone"
                                       type="text">
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label class="am-u-sm-2 am-form-label">
                                邮箱
                            </label>
                            <div class="am-u-sm-10">
                                <input id="userEmail" required="" placeholder="" value="${sessionScope.user.userEmail}"
                                       name="userEmail"
                                       type="text">
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label class="am-u-sm-2 am-form-label">
                                头像
                            </label>
                            <div class="am-u-sm-10">
                                <img id="header" src="${pageContext.request.contextPath}${sessionScope.user.userImg}"
                                     alt="" height="100px" width="100px">
                            </div>
                        </div>

                    </form>

                    <div class="am-form-group">
                        <div class="am-u-sm-9 am-u-sm-push-2">
                            <button type="button" class="layui-btn" id="uploadImg">
                                <i class="layui-icon">&#xe67c;</i>上传图片
                            </button>
                        </div>
                    </div>
                    <div class="am-form-group">
                        <div class="am-u-sm-9 am-u-sm-push-2">
                            <div style="height: 20px;"></div>
                        </div>
                    </div>
                    <div class="am-form-group">
                        <div class="am-u-sm-9 am-u-sm-push-2">
                            <input class="am-btn am-btn-success" value="发布" type="button" onclick="formSubmit();">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <script>
        layui.use('upload', function () {
            var upload = layui.upload;

            //执行实例
            var uploadInst = upload.render({
                elem: '#uploadImg' //绑定元素
                , url: '${pageContext.request.contextPath}/uploadImg.action' //上传接口
                , done: function (res) {
                    //上传完毕回调
                    $("#userImg").val(res.url)
                    var url = '${pageContext.request.contextPath}' + res.url;
                    console.log(url)
                    $("#header").attr('src', url)
                }
            });
        });
    </script>


</div>

</body>

</html>
