<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/9
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="${pageContext.request.contextPath}/user/login">
    用户名：<input type="text" name="name"/><br>
    密 码：<input type="text" name="pwd"/>
    <input type="submit" value="登录">
</form>
</body>
</html>
