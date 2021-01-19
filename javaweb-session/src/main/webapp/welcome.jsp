<%@ page import="bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2><%= session.getAttribute("name")%></h2>
    <h3>${user.id}</h3>
    <h3>${user.name}</h3>
    <h3>${user.address}</h3>
    <!--true-->
    <h3>${10 > 9}</h3>
    <!--false-->
    <h3>${"1000" > "9"}</h3>
    <!--false-->
    <h3>${"1" > "2"}</h3>

    <h3>JSTL测试</h3>
    <%
        List<User> list = new ArrayList<>();
        list.add(new User(1, "aa", "bb"));
        list.add(new User(2, "aa", "bb"));
        list.add(new User(3, "aa", "bb"));
        request.setAttribute("list", list);
    %>
    <table>
    <c:forEach items="${list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.address}</td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
