<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/16
  Time: 19:55
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
    <meta name="renderer" content="webkit">
    <title>管理员-新闻发布-新闻浏览</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/font-awesome.css" rel="stylesheet">
    <link href="../css/dataTables.bootstrap.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:/ / -->
    <!--[if lt IE 9]>
    <script src="../js/html5shiv.min.js"></script>
    <script src="../js/respond.min.js "></script>
    <![endif]-->


</head>
<body>
<!--页头-->
<div id="container">
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <c:if test= "${sessionScope.adminRole == '1'}">
                    <li class="nav-header">
                        <div class="dropdown profile-element">
                            <span><img alt="image" class="img-circle" src="../images/logo_small.jpg" /></span>
                            <a  data-toggle="dropdown" class="dropdown-toggle"  href="../index">
                                <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold"><c> ${adminname}</c></strong> </span></span>
                                </span>  <span class="text-muted text-xs block">超级管理员<b class="caret"></b></span> </span>
                                <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                    <li><a href="../user/showUser">子管理员管理</a>
                                    </li>
                                </ul>
                            </a>
                        </div>
                    </li>
                </c:if>

                <c:if test= "${sessionScope.adminRole == '2'}">
                    <li class="nav-header">
                        <div>
                            <span><img alt="image" class="img-circle" src="../images/logo_small.jpg" /></span>
                            <a>
                                <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold"><c> ${adminname}</c></strong> </span></span>
                                <span class="text-muted text-xs block">管理员</span>
                            </a>
                        </div>
                    </li>
                </c:if>

                <!-- 侧边栏-->
                <li><a href="../user/AdminMain"><i class="fa fa-th-large"></i><span class="nav-label">管理员主页</span></a></li>
                <li><a href="../news/admin"><i class="fa fa fa-globe"></i> <span class="nav-label">新闻发布</span></a></li>
                <li><a href="../group/admin"><i class="fa fa-comments"></i><span class="nav-label">组会通知</span></a></li>
                <li><a href="../paper/admin"><i class="fa fa-files-o"></i> <span class="nav-label"></span>论文上传</a></li>
                <li><a href="../room/admin"><i class="fa fa-calculator"></i> <span class="nav-label"></span>会议室租借</a></li>
            </ul>

        </div>
    </nav>

    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <span class="m-r-sm text-muted welcome-message"><a href="../user/AdminMain" title="返回首页"><i class="fa fa-home"></i></a>欢迎使用实验室平台</span>
                    </li>
                    <li>
                        <a  href="../index"><span class="glyphicon glyphicon-log-out"></span>退出</a>
                    </li>
                </ul>
            </nav>
        </div>


        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-sm-12">
                <h2>${news.title}</h2>
                发布时间：<fmt:formatDate pattern="yyyy-MM-dd"  value="${news.ndate}" />&nbsp;&nbsp;&nbsp;&nbsp;作者：${news.author}
                <br>
                <br>
                <ol class="breadcrumb">
                    <li>
                        <a href="../user/AdminMain"><span class="nav-label">管理员主页</span></a>
                    </li>
                    <li>
                        <a href="../news/admin"><span class="nav-label">新闻发布</span></a>
                    </li>
                    <li>
                        <strong>${news.title}</strong>
                    </li>
                </ol>
            </div>
        </div>

        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row" style="background-color: white">
                <div class="col-lg-12">
                    <div class="wrapper wrapper-content">
                        <div class="text-justify">
                            ${news.ncontent}
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="footer">
            <div class="pull-right">
                <a style='color:grey' href="../news/adminGetNews"><span class="glyphicon glyphicon-arrow-up"></span>回到顶部</a>
            </div>
            <div>
                <strong>云计算与大数据研究组</strong> &copy; 2017
            </div>
        </div>
    </div>
</div>


<!-- jQuery 文件。务必在 bootstrap.min.js 之前引入 -->
<script src="../js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="../js/bootstrap.min.js"></script>
<!-- BEGIN CORE PLUGINS -->

<script>
    $(function () {
        $('.col-md-4').height($('.col-md-8').height());
    });
</script>

</body>

</html>

