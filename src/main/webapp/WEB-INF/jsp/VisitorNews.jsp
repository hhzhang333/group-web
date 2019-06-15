<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/6
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial scale=1">
    <title>新闻动态</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/font-awesome.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:/ / -->
    <!--[if lt IE 9]>
    <script src="../js/html5shiv.min.js"></script>
    <script src="../js/respond.min.js "></script>
    <![endif]-->

    <style>
        .line{
            height:1px;
            width:100%;
            background:#38283c;
            overflow:hidden;
        }
        .line2{
            height:1px;
            width:100%;
            background:grey;
            overflow:hidden;
        }

    </style>
</head>
<body>
<!--页头-->
<div id="container">
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <span><img alt="image" class="img-circle" src="../images/logo_small.jpg" /></span>
                        <a  data-toggle="dropdown" class="dropdown-toggle"  href="../index">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">云计算与大数据实验室</strong> </span></span>
                        </a>
                    </div>
                </li>

                <!-- 侧边栏-->
                <li><a href="../index"><i class="fa fa-th-large"></i><span class="nav-label">主页</span></a></li>
                <li><a href="../news/getAll"><i class="fa fa fa-globe"></i> <span class="nav-label">新闻动态</span></a></li>
                <li><a href="../group/getAll"><i class="fa fa-comments"></i><span class="nav-label">组会通知</span></a></li>
                <li><a href="../paper/getAll"><i class="fa fa-files-o"></i> <span class="nav-label"></span>论文展示</a></li>
                <li><a href="../room/get"><i class="fa fa-calculator"></i> <span class="nav-label"></span>会议室租借情况</a></li>
            </ul>

        </div>
    </nav>

    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <span class="m-r-sm text-muted welcome-message"><a href="../index" title="返回首页"><i class="fa fa-home"></i></a>欢迎使用实验室平台</span>
                    </li>
                    <li>
                        <a  href="../user/login"><i class="fa fa-sign-out"></i>管理员登陆</a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="clearfix visible-xs-block"></div>

        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-sm-12">
                <h2>新闻动态</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="../index"><span class="nav-label">主页</span></a>
                    </li>
                    <li>
                        <strong>新闻动态</strong>
                    </li>
                </ol>
            </div>

        </div>

        <!-- Add the extra clearfix for only the required viewport -->
        <div class="clearfix visible-xs-block"></div>
        <!-- 空出一行-->
        <div class="row">
            &nbsp;
        </div>
        <div class="clearfix visible-xs-block"></div>

        <div class="wrapper wrapper-content" style="background:#FFFFFF ">
            <div style="margin-left: 33px">
            <div class="row">
            <div class="col-md-10">
                <c:forEach var="news" items="${newsList}">
                    <div class="row">
                        <div class="col-md-12">
                    <h3><i class="fa fa fa-globe" style='color:#1cc09f'></i>
                        &nbsp;<a style='color:grey; font-weight:normal' href="../news/getNews?newsid=${news.id} ">${news.title}</a>
                    </h3>
                        </div>
                        <hr style="height:10%; width:100%; margin-top: 34px"/>
                    </div>

                </c:forEach>
            </div>

            <div class="col-md-2" >
                <c:forEach var="news" items="${newsList}">
                    <div class="row">
                        <div class="col-md-12">
                            <h3  style='color:grey; font-weight:normal'><fmt:formatDate pattern="yyyy-MM-dd"  value="${news.ndate}" />
                            </h3>
                        </div>
                        <hr style="height:10%; width:100%; margin-top: 34px" />
                    </div>
                </c:forEach>
            </div>
        </div>
            </div>
        </div>

        <div class="footer">
            <div class="pull-right">
                <a style='color:grey' href="../news/getAll"><span class="glyphicon glyphicon-arrow-up"></span>回到顶部</a>
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

<script>
$(function () {
$('.col-md-4').height($('.col-md-8').height());
});
</script>

</body>

</html>
