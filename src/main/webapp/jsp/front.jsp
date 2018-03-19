<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>FeastCoding</title>
</head>
<body>
<h2>菜单</h2>
<c:forEach items="${menuList}" var="menu">
    <a href="${menu.url}" target="_blank">${menu.name}</a><br>
</c:forEach>

<br>
<br>
<br>
<h2>链接</h2>
<c:forEach items="${urlList}" var="url">
    <a href="${url.url}" target="_blank">${url.name}</a><br>
</c:forEach>

</body>
</html>