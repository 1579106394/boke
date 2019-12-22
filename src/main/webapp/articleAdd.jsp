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
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/res/editor/dist/css/wangEditor.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>

    <style type="text/css">
        #div1 {
            width: 100%;
            height: 300px;
        }
    </style>

    <script type="text/javascript">
        function formSubmit() {
            var article = $("#div1").html();
            $(".article").val(article);
            $("#form").submit();
        }
    </script>


</head>

<body>
<div class="admin-content-body">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">发布文章</strong>
            <small></small>
        </div>
    </div>

    <hr>
    <div class="am-cf">
        <!-- content start -->
        <div class="">
            <div class="admin-content-body">
                <div class="am-g">
                    <form class="am-form am-form-horizontal" id="form"
                          action="${pageContext.request.contextPath}/article/add.html" method="post"
                          style="padding-top: 30px;">

                        <!-- 富文本编辑器内容 -->
                        <input type="hidden" name="articleContent" class="article"/>
                        <div class="am-form-group">
                            <label class="am-u-sm-2 am-form-label">
                                文章标题
                            </label>
                            <div class="am-u-sm-10">
                                <input id="roleName" required="" placeholder="请输入文章标题" value="" name="articleTitle"
                                       type="text">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label class="am-u-sm-2 am-form-label">
                                文章内容
                            </label>
                            <div class="am-u-sm-10">

                                <!-- 富文本编辑器 -->

                                <div id="div1">

                                </div>


                                <script type="text/javascript"
                                        src="${pageContext.request.contextPath }/res/editor/dist/js/wangEditor.js"></script>
                                <script type="text/javascript">
                                    $(function () {
                                        var editor = new wangEditor('div1');
                                        editor.create();
                                    });
                                </script>

                                <!-- 富文本编辑器 -->


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
