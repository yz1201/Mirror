<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/16
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>login</title>
    <link rel="stylesheet" href="resource/css/bootstrap.min.css">
    <script src="resource/js/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="resource/js/bootstrap.min.js"></script>
    <style>
        .container {
            text-align: center;
        }

        .card-body {
            text-align: center;
            padding: 24px;
        }

        .err {
            height: 40px;
            text-align: center;
            size: 16px;
            margin-top: 24px;
        }

        .input_check {
            width: 200px;
            display: inline;
        }

        button {
            margin-top: 24px;
        }

        h1, h4 {
            text-align: center;
            color: red;
        }

        label {
            color: white;
        }

    </style>

    <script>
        window.onload = function () {
            document.getElementById("img_check").onclick = changeImg;
            document.getElementById("a_check").onclick = changeImg;
        };

        function changeImg() {
            const date = new Date().getTime();
            document.getElementById("img_check").setAttribute("src", "${pageContext.request.contextPath}/verificate?" + date);
        }
    </script>

</head>


<body class="bg-success">
<div class="container">
    <h1><span>Login</span></h1>
    <form method="post" action="${pageContext.request.contextPath}/login">
        <div class="card">
            <div class="card-body bg-success">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input class="form-control" id="username" name="username">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input class="form-control" id="password" name="password">
                </div>

                <div class="form-group">
                    <label>
                        <input class="form-control input_check check" name="verification_code">
                    </label>
                    <img src="${pageContext.request.contextPath}/verificate" alt="" id="img_check">
                    <a href="javascript:void(0)" id="a_check">看不清楚换一张？</a>
                </div>
                <button type="submit" class="btn btn-light">Login</button>

                <div class="form-group  err">
                    <h4>
                        <span>${pageContext.request.getAttribute("check_err")}</span>
                        <span>${pageContext.request.getAttribute("login_err")}</span>
                        <%--            <%= request.getAttribute("check_err") == null ? "" : request.getAttribute("check_err") %>--%>
                    </h4>
                </div>

            </div>
        </div>

    </form>




    <%--    <div class="row  err">--%>
    <%--        <h4>--%>
    <%--         --%>
    <%--            &lt;%&ndash;            ${pageContext.request.getAttribute("login_err")}&ndash;%&gt;--%>
    <%--            &lt;%&ndash;            <%= request.getAttribute("login_err") == null ? "" : request.getAttribute("login_err") %>&ndash;%&gt;--%>
    <%--        </h4>--%>
    <%--    </div>--%>

</div>
</body>
</html>
