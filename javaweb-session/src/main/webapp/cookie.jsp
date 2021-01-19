<%@ page import="java.text.CollationKey" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cookie cookie = new Cookie("name", "xdk");
    response.addCookie(cookie);

    Cookie[] cookies = request.getCookies();
    for (Cookie c : cookies) {
        out.write(c.getName() + ":" + c.getValue() + "<br/>");
    }
%>
</body>
</html>
