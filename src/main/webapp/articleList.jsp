<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/amazeui.min.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/admin.css"/>
    <script src="${pageContext.request.contextPath}/res/layui/layui.all.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/layui/css/layui.css"/>
</head>

<body>
<div class="admin-content-body">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">文章管理</strong><small></small></div>
    </div>

    <hr>
    <form action="${pageContext.request.contextPath}/article/page.html" method="post" id="pageForm">
        <input type="hidden" name="currentPage" value="${page.currentPage}" id="currentPage">
        <div class="am-g">
            <div class="am-u-sm-12 am-u-md-6">
                <div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                        <a href="${pageContext.request.contextPath}/articleAdd.jsp" class="am-btn am-btn-default"><i
                                class="layui-icon">&#xe654</i> 新增
                        </a>
                    </div>
                </div>
            </div>
            <div class="am-u-sm-12 am-u-md-3">

            </div>
            <div class="am-u-sm-12 am-u-md-3">
                <div class="am-input-group am-input-group-sm">
                    <input type="text" value="${page.params.articleTitle}" placeholder="文章标题"
                           name="params[articleTitle]" class="am-form-field">
                    <span class="am-input-group-btn">
            <button class="am-btn am-btn-default" type="submit">搜索</button>
          </span>
                </div>
            </div>
        </div>
        <div class="am-g">
            <div class="am-u-sm-12">
                <form class="am-form">
                    <table class="am-table am-table-striped am-table-hover table-main">
                        <thead>
                        <tr>
                            <th class="table-title">标题</th>
                            <th class="table-type">阅读量</th>
                            <th class="table-author am-hide-sm-only">点赞量</th>
                            <th class="table-author am-hide-sm-only">来源</th>
                            <th class="table-author am-hide-sm-only">发表时间</th>
                            <th class="table-set">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${page.list}" var="article">
                            <tr>
                                <td>${article.articleTitle}</td>
                                <td>${article.artilceRead}</td>
                                <td>${article.articleGood}</td>
                                <td>${article.articleSource}</td>
                                <td>${article.articleTime}</td>
                                <td>
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <a href="javascript:void(0);" onclick="readMessage('${article.articleId}')"
                                               class="am-btn am-btn-default am-btn-xs am-text-secondary"><span
                                                    class="am-icon-pencil-square-o"></span> 查看
                                            </a>
                                            <a href="${pageContext.request.contextPath}/article/toEdit.html?id=${article.articleId}"
                                               class="am-btn am-btn-default am-btn-xs am-text-secondary"><span
                                                    class="am-icon-pencil-square-o"></span> 编辑
                                            </a>
                                            <a href="${pageContext.request.contextPath}/article/delete.html?id=${article.articleId}"
                                               class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span
                                                    class="am-icon-trash-o"></span> 删除
                                            </a>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="am-cf">
                        共 ${page.totalCount} 条记录
                        <div class="am-fr">
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
                    <hr>
                </form>
            </div>
        </div>
    </form>
</div>
<script>
    function submitForm(page) {
        $("#currentPage").val(page)
        $("#pageForm").submit()
    }

    function readMessage(id) {

        $.ajax({
            url: "${pageContext.request.contextPath}/article/getById.action",
            data: "{\"articleId\": \"" + id + "\"}",
            contentType: "application/json;charset=UTF-8",
            type: "post",
            dataType: "json",
            success: function (dep) {
                layer.alert(dep.articleContent)
            }
        });

    }
</script>
</body>
</html>
