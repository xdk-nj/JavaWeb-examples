<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
</head>
<body>
<h1>Ajax</h1>
<h2 id="h2"></h2>
<input type="text">
<input id="btn" type="button" value="提交">
</body>
<script type="text/javascript">
    $(function () {
        $("#btn").click(function () {
            $.ajax({
                url: "/test",
                type: "post",
                dataType: "text",
                success: function (data) {
                    $("#h2").html(data)
                }
            })
        })
    })
</script>
</html>
