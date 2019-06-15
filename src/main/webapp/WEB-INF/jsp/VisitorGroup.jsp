<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/14
  Time: 1:24
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <link rel="stylesheet" type="text/css" href="src/main/webapp/css/bootstrap.css"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial scale=1">
    <title>组会通知</title>

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
    <style>
        .float_left{
            float: left;
        }
        .float_right {
            float:right;
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
                <h2>组会通知</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="../index"><span class="nav-label">主页</span></a>
                    </li>
                    <li>
                        <strong>组会通知</strong>
                    </li>
                </ol>
            </div>
        </div>

        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>云计算与大数据研究组 <small>小组报告信息</small></h5>
                        </div>
                        <div class="ibox-content">

                            <table id="dataTables" class="table table-striped table-bordered table-hover ">
                                <thead>
                                <tr>
                                    <th>时间</th>
                                    <th>地点</th>
                                    <th>报告人</th>
                                    <th>主题</th>
                                    <th>资源下载</th>
                                    <td>参考文献</td>
                                </tr>
                                </thead>
                                <tbody>

                                <c:if test="${!empty groupList}">
                                <c:forEach var="group" items="${groupList}">
                                <tr>
                                    <td width="300px" style="word-wrap:break-word;"><fmt:formatDate pattern="yyyy-MM-dd"  value="${group.gdate}" /></td>
                                    <td width="200px" style="word-wrap:break-word;">${group.gspace}</td>
                                    <td width="200px" style="word-wrap:break-word;">${group.gspeaker}</td>
                                    <td width="600px" style="word-wrap:break-word;">${group.gtopic}</td>
                                    <td width="200px" style="word-wrap:break-word;">
                                        <a href="../group/fileDownload_ppt?Groupid=${group.id}">PPT</a>
                                        <a href="../group/fileDownload_pdf?Groupid=${group.id}">PDF</a>
                                    </td>
                                    <td width="300px" style="word-wrap: break-word;">
                                        <a href="../group/fileDownload_reference?Groupid=${group.id}">${group.conference}</a>
                                    </td>
                                </tr>
                                </c:forEach>
                                </c:if>

                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
        </div>




        <div class="footer">
            <div class="pull-right">
                <a style='color:grey' href="../group/getAll"><span class="glyphicon glyphicon-arrow-up"></span>回到顶部</a>
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
<script src="../js/jquery.dataTables.min.js"></script>

    <!-- Page-Level Scripts -->
    <script>
        $(function () {
            $("#dataTables").dataTable({
                'dom': '<"float_left"l>r<"float_right"f>t<"float_left"i><"float_right"p>',
                "bPaginate": true,  //是否显示分页
                "bLengthChange": true,  //是否启用每页显示的记录数
                "bFilter": true, //搜索栏
                "bSort": true, //是否支持排序功能
                stateSave: true,//保持翻页状态，
                "oLanguage": {
                    "sLengthMenu": "每页 _MENU_ 条记录",
                        "sZeroRecords": "对不起，查询不到任何相关数据",
                        "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
                        "sInfoEmtpy": "找不到相关数据",
                        "sInfoFiltered": "数据表中共为 _MAX_ 条记录)",
                        "sProcessing": "正在加载中...",
                        "sSearch": "查找：",
                        "sUrl": "", //多语言配置文件，可将oLanguage的设置放在一个txt文件中，例：Javascript/datatable/dtCH.txt
                        "oPaginate": {
                        "sFirst":    "第一页",
                            "sPrevious": " 上一页 ",
                            "sNext":     " 下一页 ",
                            "sLast":     " 最后一页 "
                    }
                }, //多语言配置
                "aLengthMenu": [[10, 20], ["10", "20"]]  //设置每页显示记录的下拉菜单
            });


        });

        <c:if  test= "${requestScope.error == '打开'}">
            window.open(requestScope.realPath);
        </c:if>
    </script>

</body>

</html>