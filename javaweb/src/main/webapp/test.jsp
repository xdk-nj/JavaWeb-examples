<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name = (String)request.getAttribute("nameFromIndex");
    if (null == name) {
        name = "404";
    }
%>
<h2><%=name%></h2>
</body>
</html>
