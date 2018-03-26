<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>FeastCoding</title>
    <link href="<%=path%>/static/css/bootstrap.css" rel="stylesheet"/>
    <link href="<%=path%>/static/css/base.css" rel="stylesheet"/>
</head>
<body style="min-height:800px; height: auto">
<div class="container-fluid">

    <nav class="navbar navbar-default row no-yj  navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#nav-list-left" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">FeastCoding后台管理</a>
            </div>

            <div class="collapse navbar-collapse pull-right" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a class="dropdown-toggle" data-toggle="dropdown" href="#" style="height: 50px">
                        <img class="img-circle pull-left img-responsive nav-user-img" src="<%=path%>/static/img/user.jpg"/><span
                            class="pull-left nav-username">${sessionScope.user.name }</span></a>
                    </li>
                    <li><a class="dropdown-toggle" data-toggle="dropdown" href="<%=path%>/jsp/login.jsp"
                           style="height: 50px">
                        <span class="pull-left">退出</span></a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>


    <div class="row" style="margin-top:70px">
        <div class="  nav-left col-md-2 no-padding" id="nav-list-left">
            <div class="user-panel">
                <img src="<%=path%>/static/img/user.jpg" class="img-circle center-block"/>
            </div>

            <div class="nav-list">
                <ul>
                    <li>
                        <a href="<%=path%>/jsp/index.jsp">首页</a>
                    </li>
                    <li class="nav-left-dropdown">
                        <a href="<%=path %>/queryUrlBypage.do">链接管理</a>
                    </li>
                </ul>
            </div>
        </div>

        <div class="main-right  col-md-10 col-md-offset-2">
            <div class="panel-body">
                <ol class="breadcrumb">
                    <li><a href="#">首页</a></li>
                    <li><a href="#">链接管理</a></li>
                </ol>
            </div>

            <div class="col-md-12">

                <div class="panel panel-default ">
                    <div class="panel-heading">链接列表</div>

                    <div class="panel-body">
                        <div class="main-right  col-xs-12">
                            <div class="pull-right">
                                <a class="btn btn-success" href="<%=path%>/jsp/url_add.jsp"><font
                                        color="#FFFFFF">新增链接</font></a>
                            </div>
                        </div>
                        <table class="table table-bordered tb-hover">
                            <thead>
                            <tr>
                                <td width="10%">
                                    名称
                                </td>
                                <td width="20%">
                                    url
                                </td>
                                <td width="30%">
                                    描述
                                </td>
                                <td width="10%">
                                    点击次数
                                </td>
                                <td width="10%">
                                    类型
                                </td>
                                <td width="20%" class="text-center">操作</td>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${urlList}" var="item">
                                <tr>
                                    <td>
                                            ${item.name}
                                    </td>
                                    <td>
                                            ${item.url}
                                    </td>
                                    <td>
                                            ${item.description}
                                    </td>
                                    <td>
                                            ${item.times}
                                    </td>
                                    <td>
                                        <c:if test="${item.typeid == 1}">
                                            菜单链接
                                        </c:if>
                                        <c:if test="${item.typeid == 2}">
                                            收藏连接
                                        </c:if>
                                    </td>
                                    <td class=" text-center">
                                        <a href="<%=path %>/editUrl.do?id=${item.id}" }"><i
                                            class="glyphicon glyphicon-edit"></i></a>
                                        <a href="<%=path %>/deleteUrlByid.do?id=${item.id}"
                                           onclick="return confirm('确定删除吗?')"><i class="glyphicon glyphicon-remove"></i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                        <div class="pull-right">
                            <nav>
                                <ul class="pagination">
                                    <c:if test="${page.pageNumber==1 || page.totalPage==0 }">
                                        <li><a>首页</a></li>
                                        <li><a>上一页 </a></li>
                                    </c:if>
                                    <c:if test="${page.pageNumber!=1 && page.totalPage!=0 }">
                                        <li><a href="<%=path %>/queryUrlBypage.do?pageNumber=1">首页</a></li>
                                        <li>
                                            <a href="<%=path %>/queryUrlBypage.do?pageNumber=${page.pageNumber-1 }">上一页 </a>
                                        </li>
                                    </c:if>
                                    <c:if test="${page.pageNumber==page.totalPage || page.totalPage==0 }">
                                        <li><a>下一页 </a></li>
                                        <li><a>尾页 </a></li>
                                    </c:if>
                                    <c:if test="${page.pageNumber!=page.totalPage && page.totalPage!=0 }">
                                        <li>
                                            <a href="<%=path %>/queryUrlBypage.do?pageNumber=${page.pageNumber+1 }">下一页 </a>
                                        </li>
                                        <li><a href="<%=path %>/queryUrlBypage.do?pageNumber=${page.totalPage }">尾页</a>
                                        </li>
                                    </c:if>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    if ('${mes}' != '') {
        alert('${mes}');
    }
</script>
</body>
<script src="<%=path%>/static/js/jquery.min.js"></script>
</html>