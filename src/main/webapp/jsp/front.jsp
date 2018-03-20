<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>FeastCoding</title>
    <link href="https://cdn.bootcss.com/semantic-ui/2.3.0/semantic.min.css" rel="stylesheet">
</head>
<body>
<div class="ui inverted segment">
    <div class="ui inverted secondary menu">
        <a class="item" href="#">FeastCoding</a>
        <c:forEach items="${menuList}" var="menu">
            <a class="item" href="javascript:void(0)" onclick="view('${menu.id}','${menu.url}')">${menu.name}</a>
        </c:forEach>

        <div class="right menu">
            <div class="item">
                <a class="ui secondary button" href="<%=path%>/admin.do">后台管理</a>
            </div>
        </div>
    </div>
</div>
<div class="ui grid">
    <div class="eleven wide centered column">
        <div class="ui raised segment">
            <a class="ui blue ribbon label">Normal </a> <span>常用 </span>
            <p></p>
        </div>
        <div class="ui cards">
            <c:forEach items="${normalList}" var="normal">
                <div class="card">
                    <div class="content">
                        <div class="header">${normal.name} </div>
                        <div class="description">
                            <c:if test="${empty normal.description}">
                                太懒了，没有添加描述
                            </c:if>
                            <c:if test="${!empty normal.description}">
                                ${normal.description}
                            </c:if>
                        </div>
                    </div>
                    <div class="ui bottom attached button" onclick="view('${normal.id}','${normal.url}')"><i
                            class="send icon"></i> Enter Site
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<div class="ui grid">
    <div class="eleven wide centered column">
        <div class="ui raised segment">
            <a class="ui teal ribbon label">All </a> <span>全部 </span>
            <p></p>
        </div>
        <div class="ui search">
            <form action="<%=path%>/index.do" method="post" id="searchForm">
                <div class="ui icon input">
                    <input class="prompt" type="text" name="name" value="${url.name}" placeholder="搜索">
                    <i id="submitButton" class="search icon"></i>
                </div>
                <a href="<%=path%>/index.do"><i class="refresh icon"></i></a>
            </form>
            <div class="results"></div>
        </div>
    </div>
    <div class="seleven wide centered column">
        <div class="ui cards">
            <c:forEach items="${urlList}" var="all">
                <div class="card">
                    <div class="content">
                        <div class="header">${all.name} </div>
                        <div class="description">
                            <c:if test="${empty all.description}">
                                太懒了，没有添加描述
                            </c:if>
                            <c:if test="${!empty all.description}">
                                ${all.description}
                            </c:if>
                        </div>
                    </div>
                    <div class="ui bottom attached button" onclick="view('${all.id}','${all.url}')"><i
                            class="send icon"></i> Enter Site
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="right floated center aligned one wide column">
            <div class="ui right floated pagination menu">
                <c:if test="${page.pageNumber==1 || page.totalPage==0 }">
                    <a class="icon item"><i class="left chevron icon"></i></a>
                </c:if>
                <c:if test="${page.pageNumber!=1 && page.totalPage!=0 }">
                    <a class="icon item"
                       href="<%=path %>/queryUrlBypage.do?pageNumber=${page.pageNumber-1 }&name=${url.name}">
                        <i class="left chevron icon"></i>
                    </a>
                </c:if>
                <c:if test="${page.pageNumber==page.totalPage || page.totalPage==0 }">
                    <a class="icon item"><i class="right chevron icon"></i></a>
                </c:if>
                <c:if test="${page.pageNumber!=page.totalPage && page.totalPage!=0 }">
                    <a class="icon item"
                       href="<%=path %>/queryUrlBypage.do?pageNumber=${page.pageNumber+1 }&name=${url.name}">
                        <i class="right chevron icon"></i>
                    </a>
                </c:if>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js "></script>
<script src="https://cdn.bootcss.com/semantic-ui/2.3.0/semantic.min.js "></script>
<script>
    function view(id, url) {
        $.ajax({
            type: "POST",
            url: "<%=path%>/enterSite.do",
            data: {
                id: id
            },
            dataType: "json",
            async: true,
            success: function (data) {
            }
        });
        window.open(url);
    }

    $("#submitButton").click(function () {
        $("#searchForm").submit();
    })
</script>
</body>
</html>
