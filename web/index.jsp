<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>HomePage</title>
    <link rel="stylesheet" href="resource/css/bootstrap.min.css">
    <script src="resource/js/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="resource/js/bootstrap.min.js"></script>
    <style>
        .card-body {
            margin-top: 120px;
            padding: 120px;
            text-align: center;
        }

        a {
            color: #28a745;
        }
    </style>
</head>
<body class="bg-warning">
<div class="container">
    <div class="card-body">
<%--        <a href="${pageContext.request.contextPath}/findUserByPageServlet"><h1 class="h1">USER INFO</h1></a>--%>
        <a href="${pageContext.request.contextPath}/login.jsp"><h1 class="h1">Login</h1></a>
        <a href="${pageContext.request.contextPath}/register.jsp"><h1 class="h1">Register</h1></a>
    </div>
</div>


</body>
</html>
