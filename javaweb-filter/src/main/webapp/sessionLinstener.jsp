<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>当前在线人数：<%= session.getServletContext().getAttribute("count")%></h2>
</body>
</html>
