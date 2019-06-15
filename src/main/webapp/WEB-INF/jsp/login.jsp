<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/4
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial scale=1">
    <title>云计算与大数据实验室 - 管理员登陆</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link href="../css/style.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:/ / -->
    <!--[if lt IE 9]>
    <script src="../js/html5shiv.min.js"></script>
    <script src="../js/respond.min.js "></script>
    <![endif]-->

    <style>
        body {
            background-image: url(../images/loginbg.jpg);
            background-repeat: no-repeat;
            background-size: cover
        }

        .bg {
            background-image: url(../images/loginbg.jpg);
            background-repeat: no-repeat;
            background-size: cover
        }

        .footer {
            position: absolute;
            bottom: 0;
            width: 100%;
            padding: 8px 20px 5px 20px;
            font-size: 12px;
        }

        .footer .footer-inner {
            float: left;
            display: inline-block;
        }

        .footer .footer-tools {
            float: right;
            display: inline-block;
        }

    </style>


</head>
<body>
<div class="middle-box text-center loginscreen">
    <div>
        <div>
            <h1 class="logo-name">Lab</h1>
        </div>

        <form class="m-t" role="form" action="../user/logincheck" method="post">
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                    <input type="text" class="form-control" placeholder="用户名" required="" name="ID">
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                    <input type="password" class="form-control" placeholder="密码" required="" name="PWD">
                </div>
            </div>

            <button type="submit" class="btn btn-default m-b" style="width: 90px">登 录</button>
            <button type="button" class="btn btn-default m-b" style="width: 90px; margin-left: 40px" data-toggle="modal" data-target="#Add">注册</button>
        </form>

    </div>
</div>

<!-- 用户名密码输入错误模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel"><span class="glyphicon glyphicon-warning-sign"></span></h4>
            </div>
            <div class="modal-body">用户名或密码输入错误</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 管理员登陆失效，请重新登录模态框（Modal） -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel2"><span class="glyphicon glyphicon-warning-sign"></span></h4>
            </div>
            <div class="modal-body">管理员登陆失效，请重新登录</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 新增模态框（Modal） -->
<div class="modal fade  text-center" id="Add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" style="display: inline-block; width: auto;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel1">注册</h4>
            </div>

            <form action="../user/insert" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-4 control-label">用户名：</label>
                        <div class="col-sm-8">
                            <input class="form-control" type="text" placeholder="username" required="" name="userid">
                        </div>
                    </div>
                    <div>&nbsp;</div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">密码：</label>
                        <div class="col-sm-8">
                            <input class="form-control" type="text" placeholder="password" required="" name="userpassword">
                        </div>
                    </div>
                    <div>&nbsp;</div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">邮箱：</label>
                        <div class="col-sm-8">
                            <input class="form-control" type="email" placeholder="email" required="" name="email">
                        </div>
                    </div>
                    <div>&nbsp;</div>
                </div>

                <div class="modal-footer">
                    <button type="submit" class="btn btn-default">保存</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>

            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<!-- jQuery 文件。务必在 bootstrap.min.js 之前引入 -->
<script src="../js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="../js/bootstrap.min.js"></script>
<!-- BEGIN CORE PLUGINS -->


<script>
    $(function () {
        <c:if  test= "${requestScope.error == 'err'}">
        $('#myModal').modal('show');
        </c:if>

        <c:if  test= "${requestScope.error == 'lose'}">
        $('#myModal2').modal('show');
        </c:if>
    });
</script>


</body>
</html>
