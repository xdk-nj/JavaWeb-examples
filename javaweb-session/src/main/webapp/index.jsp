<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Servlet Test</title>
</head>
<body>

<%
    String sessionId = session.getId();
    int maxInactiveInterval = session.getMaxInactiveInterval();
%>
<h1><%=sessionId%></h1>
<h1><%=maxInactiveInterval%></h1>

<form action="/login" method="post">
    用户名：<input type="text" name="username">
    密码：<input type="text" name="password">
    提交：<input type="submit">
</form>
</body>
</html>
