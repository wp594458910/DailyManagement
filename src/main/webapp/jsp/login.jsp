<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <title>FeastCoding</title>
    <link href="<%=path%>/jsp/css/login.css" type="text/css" rel="stylesheet">
</head>
<body>

<div class="login">
    <div class="message">FeastCoding后台管理</div>
    <div id="darkbannerwrap"></div>

    <form method="post" action="<%=path%>/login.do">
        <input name="action" value="login" type="hidden">
        <input name="username" placeholder="用户名" required="" type="text">
        <hr class="hr15">
        <input name="password" placeholder="密码" required="" type="password">
        <hr class="hr15">
        <input value="登录" style="width:100%;" type="submit">
        <hr class="hr20">
    </form>


</div>

<div class="copyright">© FeastCoding by<a href="http://www.feastcoding.cn/" target="_blank">FeastCoding</a></div>
<script type="text/javascript">
    if('${mes}'!=''){
        alert('${mes}');
    }
</script>
</body>
</html>
