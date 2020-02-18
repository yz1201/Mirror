<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="resource/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="resource/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="userEdit" method="post">
        <input type="hidden" class="form-control" name="id" value="${select_user.id}">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="username" readonly="readonly"
                   value="${select_user.username}"/>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <%--@elvariable id="select_user" type="cn.tyz.mirror.domain.UserModel"--%>
            <c:if test="${select_user.sex == '男'}">
                <input type="radio" name="sex" value="男" checked="checked"/>男
                <input type="radio" name="sex" value="女"/>女
            </c:if>

            <c:if test="${select_user.sex == '女'}">
                <input type="radio" name="sex" value="男"/>男
                <input type="radio" name="sex" value="女" checked="checked"/>女
            </c:if>
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" value="${select_user.age}"/>
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" id="address" class="form-control">
                <c:if test="${select_user.address == '广东'}">
                    <option value="广东" selected>广东</option>
                    <option value="广西">广西</option>
                    <option value="湖南">湖南</option>
                    <option value="河南">河南</option>
                    <option value="山西">山西</option>
                    <option value="山东">山东</option>
                    <option value="浙江">浙江</option>
                </c:if>

                <c:if test="${select_user.address == '广西'}">
                    <option value="广东">广东</option>
                    <option value="广西" selected>广西</option>
                    <option value="湖南">湖南</option>
                    <option value="河南">河南</option>
                    <option value="山西">山西</option>
                    <option value="山东">山东</option>
                    <option value="浙江">浙江</option>
                </c:if>
                <c:if test="${select_user.address == '湖南'}">
                    <option value="广东">广东</option>
                    <option value="广西">广西</option>
                    <option value="湖南" selected>湖南</option>
                    <option value="河南">河南</option>
                    <option value="山西">山西</option>
                    <option value="山东">山东</option>
                    <option value="浙江">浙江</option>
                </c:if>
                <c:if test="${select_user.address == '河南'}">
                    <option value="广东">广东</option>
                    <option value="广西">广西</option>
                    <option value="湖南">湖南</option>
                    <option value="河南" selected>河南</option>
                    <option value="山西">山西</option>
                    <option value="山东">山东</option>
                    <option value="浙江">浙江</option>
                </c:if>
                <c:if test="${select_user.address == '山西'}">
                    <option value="广东">广东</option>
                    <option value="广西">广西</option>
                    <option value="湖南">湖南</option>
                    <option value="河南">河南</option>
                    <option value="山西" selected>山西</option>
                    <option value="山东">山东</option>
                    <option value="浙江">浙江</option>
                </c:if>
                <c:if test="${select_user.address == '山东'}">
                    <option value="广东">广东</option>
                    <option value="广西">广西</option>
                    <option value="湖南">湖南</option>
                    <option value="河南">河南</option>
                    <option value="山西">山西</option>
                    <option value="山东" selected>山东</option>
                    <option value="浙江">浙江</option>
                </c:if>
                <c:if test="${select_user.address == '浙江'}">
                    <option value="广东">广东</option>
                    <option value="广西">广西</option>
                    <option value="湖南">湖南</option>
                    <option value="河南">河南</option>
                    <option value="山西">山西</option>
                    <option value="山东">山东</option>
                    <option value="浙江" selected>浙江</option>
                </c:if>


            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" name="qq_number" id="qq" value="${select_user.qq_number}"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" name="email" id="email" value="${select_user.email}"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>