<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>FeastCoding</title>
    <link href="https://cdn.bootcss.com/semantic-ui/2.3.0/semantic.min.css" rel="stylesheet">
</head>
<body>
<div class="ui inverted segment">
    <div class="ui inverted secondary menu">
        <a class="item" href="#">FeastCoding</a>
        <c:forEach items="${menuList}" var="menu">
            <a class="item" href="${menu.url}" target="_blank">${menu.name}</a>
        </c:forEach>

        <div class="right menu">
            <div class="item">
                <a class="ui secondary button" href="<%=path%>/admin.do">后台管理</a>
            </div>
        </div>
    </div>
</div>
<div class="ui cards">
    <c:forEach items="${urlList}" var="url">
        <div class="card">
            <div class="content">
                <div class="header">${url.name} </div>
                <div class="description">
                    <c:if test="${empty url.description}">
                        太懒了，没有添加描述
                    </c:if>
                    <c:if test="${!empty url.description}">
                        ${url.description}
                    </c:if>
                </div>
            </div>
            <div class="ui bottom attached button" onclick="view('${url.url}')"><i class="add icon"></i> Enter Site </div>
        </div>
    </c:forEach>
</div>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js "></script>
<script src="https://cdn.bootcss.com/semantic-ui/2.3.0/semantic.min.js "></script>
<script>
    function view(url) {
        window.open(url);
    }
</script>
</body>
</html>
