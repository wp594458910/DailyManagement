<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <!-- 自动跳转到网站首页 -->
    <meta http-equiv="refresh" content="0;url=<%=path%>/index.do">
</head>
<body>
</body>
</html>