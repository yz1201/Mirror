<!-- HTML5文档-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加用户</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="resource/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="resource/js/bootstrap.min.js"></script>
    <script>
        window.onload = function () {
            var back = document.getElementById("btn_back");
            back.onclick = function () {

            }
        }
    </script>
</head>
<body class="bg-success">
<div class="container">
    <div style="text-align: center;"><h3>添加联系人页面</h3></div>
    <form action="userAdd" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="username"
                   onkeyup="this.value=this.value.replace(/[, ]/g,'')" placeholder="请输入姓名">
        </div>

        <div class="form-group">
            <label>性别：</label>
            <label>
                <input type="radio" name="sex" value="男" checked="checked"/>
                男
            </label>
            <label>
                <input type="radio" name="sex" value="女"/>
                女
            </label>
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age"
                   onkeyup="this.value=this.value.replace(/[, ]/g,'')" placeholder="请输入年龄">
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control" id="address">
                <option value="广东" selected>广东</option>
                <option value="广西">广西</option>
                <option value="湖南">湖南</option>
                <option value="河南">河南</option>
                <option value="山西">山西</option>
                <option value="山东">山东</option>
                <option value="浙江">浙江</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" id="qq" name="qq_number"
                   onkeyup="this.value=this.value.replace(/[, ]/g,'')" placeholder="请输入QQ号码"/>
        </div>

        <!--  这里的邮箱格式改一下，好看一点  -->
        <div class="form-group">
            <label for="email">Email：</label>
            <input type="email" class="form-control" id="email" name="email"
                   onkeyup="this.value=this.value.replace(/[, ]/g,'')" placeholder="请输入邮箱地址"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-success" type="submit" value="提交"/>
            <input class="btn btn-danger" type="reset" value="重置"/>
            <input class="btn btn-dark" type="button" id="btn_back" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>