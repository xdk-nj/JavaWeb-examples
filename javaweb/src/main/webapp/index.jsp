<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Servlet Test</title>
</head>
<body>
<form action="/hello" method="post">
    用户名：<input type="text" name="username">
    密码：<input type="text" name="password">
    提交：<input type="submit">
</form>

<%
    String name = null;
    String key = request.getParameter("name");
    if (null == key || "".equals(key)) {
        name = "hello";
    } else name = key;

    //在index.jsp  test.jsp中通过setAttribute  和  getAttribute来取值
    //request.setAttribute("nameFromIndex", name);
    //request.getRequestDispatcher("test.jsp").forward(request, response);
%>
<h1><%=name%></h1>
</body>
</html>
