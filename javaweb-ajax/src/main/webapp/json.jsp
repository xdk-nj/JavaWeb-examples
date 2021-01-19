<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
</head>
<body>
<h3 id="h3">h3</h3>
<input id = "btn" type="button" value="获取json">
</body>
<script type="text/javascript">
    $(function () {
        $("#btn").click(function () {
            $.ajax({
                url: "/json",
                type: "post",
                dataType: "json",
                success: function (data) {
                    console.log(data)
                }
            })
        })
    })
</script>
</html>
