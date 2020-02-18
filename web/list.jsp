<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/16
  Time: 1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>UserList</title>
    <link rel="stylesheet" href="resource/css/bootstrap.min.css">
    <script src="resource/js/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.110.0/umd/popper.min.js"></script>
    <script src="resource/js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }

        .btn_query, label {
            color: purple;
        }

        .modal-title {
            color: whitesmoke;
        }

        .header {
            margin-top: 40px;
            padding: 12px;
        }

        .t1 {
            margin-left: 12px;
            margin-right: 12px;
        }

        .pre_block, .next_block {
            text-align: center;
        }

        .page_footer, span, .container, .row {
            text-align: center;
            width: 100%;
        }

        #form {
            width: 100%;
        }

    </style>
    <script>

        <%--function deleteUser(id){--%>
        <%--    //用户安全提示--%>
        <%--    if(confirm("您确定要删除吗？")){--%>
        <%--        //访问路径--%>
        <%--        location.href="${pageContext.request.contextPath}/delUserServlet?id="+id;--%>
        <%--    }--%>
        <%--}--%>
        window.onload = function () {
            //给删除选中按钮添加单击事件
            document.getElementById("delSelected").onclick = function () {
                if (confirm("您确定要删除选中条目吗？")) {
                    var flag = false;
                    //判断是否有选中条目
                    var cbs = document.getElementsByName("uid");
                    for (var i = 0; i < cbs.length; i++) {
                        if (cbs[i].checked) {
                            //有一个条目选中了
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {//有条目被选中
                        //表单提交
                        document.getElementById("form").submit();
                    }
                }
            };
            //1.获取第一个cb
            document.getElementById("firstCb").onclick = function () {
                //2.获取下边列表中所有的cb
                var cbs = document.getElementsByName("uid");
                //3.遍历
                for (var i = 0; i < cbs.length; i++) {
                    //4.设置这些cbs[i]的checked状态 = firstCb.checked
                    cbs[i].checked = this.checked;
                }
            }
        }
    </script>
</head>
<body class="bg-success">
<div class="container">
    <div class="row">
        <div class="header" style="float: left;">
            <form class="form-inline" action="${pageContext.request.contextPath}/findUserByPageServlet" method="post">
                <div class="form-group">
                    <label for="exampleInputName2">姓名</label>
                    <input type="text" name="username" value="${condition.username[0]}" class="form-control t1"
                           id="exampleInputName2">
                </div>
                <div class="form-group">
                    <label for="exampleInputName3">籍贯</label>
                    <input type="text" name="address" value="${condition.address[0]}" class="form-control t1"
                           id="exampleInputName3">
                </div>

                <div class="form-group">
                    <label for="exampleInputEmail2">邮箱</label>
                    <input type="text" name="email" value="${condition.email[0]}" class="form-control t1"
                           id="exampleInputEmail2">
                </div>
                <button type="submit" class="btn btn-warning btn_query">查询</button>
            </form>
        </div>

        <div class="header" style="float: right;">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
            <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>

        </div>
    </div>

    <div class="row">

        <form id="form" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">

            <table class="table table-bordered table-hover">
                <thead class="thead-dark">
                <tr>
                    <th><input type="checkbox" id="firstCb"></th>
                    <th>编号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>籍贯</th>
                    <th>QQ</th>
                    <th>邮箱</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>

                <c:forEach items="${pb.list}" var="user" varStatus="s">
                    <tr class="table-warning">
                        <td><input type="checkbox" name="uid" value="${user.id}"></td>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.sex}</td>
                        <td>${user.age}</td>
                        <td>${user.address}</td>
                        <td>${user.qq_number}</td>
                        <td>${user.email}</td>
                        <td>
                            <a class="btn btn-warning "
                               href="${pageContext.request.contextPath}/retrieveUser?id=${user.id}">修改</a>&nbsp;
                                <%--                    <a class="btn btn-danger" onclick="delfunc(this)"--%>
                                <%--                       href="${pageContext.request.contextPath}/userDelete">删除</a>--%>

                            <!-- 按钮：用于打开模态框 -->
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">删除
                            </button>
                            <!-- 模态框 -->
                            <div class="modal fade" id="myModal">
                                <div class="modal-dialog ">
                                    <div class="modal-content">

                                        <!-- 模态框头部 -->
                                        <div class="modal-header bg-warning">
                                            <h4 class="modal-title">确定删除？</h4>
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        </div>

                                        <!-- 模态框主体 -->
                                        <div class="modal-body bg-success">
                                            TEST-----MY-----CODE
                                        </div>

                                        <!-- 模态框底部 -->
                                        <div class="modal-footer bg-info">
                                            <a class="btn btn-danger"
                                               href="${pageContext.request.contextPath}/userDelete?id=${user.id}">
                                                确定
                                            </a>
                                                <%--                                    <button type="button" class="btn btn-danger" data-dismiss="modal">确定</button>--%>
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭
                                            </button>
                                        </div>

                                    </div>
                                </div>
                            </div>

                        </td>
                    </tr>
                </c:forEach>


                </tbody>
            </table>

        </form>

    </div>

    <%--    <ul class="pagination">--%>
    <%--        <li class="page-item"><a class="page-link" href="#">Previous</a></li>--%>
    <%--        <li class="page-item active"><a class="page-link" href="#">1</a></li>--%>
    <%--        <li class="page-item"><a class="page-link" href="#">2</a></li>--%>
    <%--        <li class="page-item"><a class="page-link" href="#">3</a></li>--%>
    <%--        <li class="page-item"><a class="page-link" href="#">Next</a></li>--%>
    <%--    </ul>--%>

    <div class="row">

        <ul class="pagination">
            <%--@elvariable id="pb" type="cn.dbdj1201.domain.PageBean"--%>
            <c:if test="${pb.currentPage == 1}">
            <li class="page-item disabled">
                </c:if>
                <c:if test="${pb.currentPage != 1}">
            <li class="page-item pre_block">
                </c:if>
                <a class="page-link"
                   href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage - 1}&rows=10&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}"
                   aria-label="Previous">
                    <span aria-hidden="true" style="color: blue" class="pre_block">Previous</span>
                </a>
            </li>


            <c:forEach begin="1" end="${pb.totalPage}" var="i">

                <c:if test="${pb.currentPage == i}">
                    <li class="page-item active">
                        <a class="page-link"
                           href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=10&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a>
                    </li>
                </c:if>
                <c:if test="${pb.currentPage != i}">
                    <li class="page-item">
                        <a class="page-link"
                           href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=10&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a>
                    </li>
                </c:if>

            </c:forEach>

            <c:if test="${pb.currentPage >= pb.totalPage}">
            <li class="page-item disabled">
                </c:if>
                <c:if test="${pb.currentPage < pb.totalPage}">
            <li class="page-item next_block">
                </c:if>

                <a class="page-link"
                   href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage + 1}&rows=10&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}"
                   aria-label="Next">
                    <span aria-hidden="true" style="color: blue" class="next_block">&nbsp;&nbsp;Next&nbsp;&nbsp;</span>
                </a>
            </li>
        </ul>

    </div>

    <div class="row page_footer">
        <span style="font-size: 25px;margin-left: 10px; color: white">
                    共${pb.totalCount}条记录，共${pb.totalPage}页
                </span>
    </div>
</div>


</body>
</html>
