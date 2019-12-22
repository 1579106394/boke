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
    <script>
        /**
         * 初始化  serializeObject
         */
        function initSerializeObject() {
            $.fn.serializeObject = function () {
                var o = {};
                var a = this.serializeArray();
                $.each(a, function () {
                    if (o[this.name]) {
                        if (!o[this.name].push) {
                            o[this.name] = [o[this.name]];
                        }
                        o[this.name].push(this.value || '');
                    } else {
                        o[this.name] = this.value || '';
                    }
                });
                return o;
            };
        }

        function formSubmit() {
            initSerializeObject()
            var param = $("#form").serializeObject();
            $.ajax({
                url: "${pageContext.request.contextPath}/email/sendEmail.action",
                data: JSON.stringify(param),
                contentType: "application/json;charset=UTF-8",
                type: "post",
                dataType: "json",
                success: function (dep) {
                    layer.alert(dep.msg)
                }
            });
        }
    </script>

</head>

<body>
<div class="admin-content-body">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">发送邮件</strong>
            <small></small>
        </div>
    </div>

    <hr>
    <div class="am-cf">
        <!-- content start -->
        <div class="">
            <div class="admin-content-body">
                <div class="am-g">
                    <form class="am-form am-form-horizontal" id="form" method="post"
                          style="padding-top: 30px;">
                        <div class="am-form-group">
                            <label class="am-u-sm-2 am-form-label">
                                邮件标题
                            </label>
                            <div class="am-u-sm-10">
                                <input id="roleName" required="" placeholder="请输入邮件标题" value="" name="title"
                                       type="text">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label class="am-u-sm-2 am-form-label">
                                邮件内容
                            </label>
                            <div class="am-u-sm-10">
                                <textarea name="content"></textarea>
                            </div>
                        </div>

                        <div class="am-form-group">
                            <div class="am-u-sm-9 am-u-sm-push-2">
                                <input class="am-btn am-btn-success" value="发布" type="button" onclick="formSubmit();">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>


</div>

</body>

</html>
