<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/19
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String date= format.format(new Date());
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial scale=1">
    <meta name="renderer" content="webkit">

    <title>管理员-新闻发布</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/font-awesome.css" rel="stylesheet">
    <link href="../css/animate.css" rel="stylesheet">
    <link href="../css/dataTables.bootstrap.css" rel="stylesheet">
    <link href="../css/summernote.css" rel="stylesheet">
    <link href="../css/summernote-bs3.css" rel="stylesheet">
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
<div id="wrapper">
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div>
                        <span><img alt="image" class="img-circle" src="../images/logo_small.jpg" /></span>
                        <a>
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold"><c> ${adminname}</c></strong> </span></span>
                            <span class="text-muted text-xs block">管理员</span>
                        </a>
                    </div>
                </li>

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
                <h2>新闻发布</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="../user/AdminMain"><span class="nav-label">管理员主页</span></a>
                    </li>
                    <li>
                        <strong>新增发布</strong>
                    </li>
                </ol>
            </div>

        </div>

        <div>&nbsp;</div>



        <div class="wrapper wrapper-content">

            <form id = "form1" >

            <div class="row ">
                <div class="form-group">
                    <div class="col-sm-1 text-center"><h3>标题：</h3></div>
                    <div class="col-sm-7">
                        <input class="form-control" type="text" placeholder="" required="" id="title">
                    </div>

                    <div class="col-sm-1 text-center"><h3>时间：</h3></div>
                    <div class="col-sm-3">
                        <input class="form-control" type="text"  required="" value="<%=date%>" id="time" readonly>
                    </div>
                </div>


            </div>
            <div>&nbsp;</div>

                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox float-e-margins">
                                <div id="summernote">
                                    <p>
                                        输入正文
                                    </p>

                                </div>
                        </div>
                    </div>
                </div>

            </form>

                <div class="row">
                    <div class="pull-right">
                        <button id = "btnSave" type="button" class="btn btn-default" >发布</button>
                        <!--  <input type="submit" class="btn btn-default" value="发布" >-->
                     </div>
                 </div>


         </div>


         <div class="footer">
             <div class="pull-right">
                 <a style='color:grey' href="add"><span class="glyphicon glyphicon-arrow-up"></span>回到顶部</a>
             </div>
             <div>
                 <strong>云计算与大数据研究组</strong> &copy; 2017
             </div>
         </div>
     </div>


 </div>

 <!-- 上传成功模态框（Modal） -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel2"><span class="glyphicon glyphicon-warning-sign"></span></h4>
            </div>
            <div class="modal-body">发布成功</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" onclick="location.href='../news/admin'">确定</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<!-- jQuery 文件。务必在 bootstrap.min.js 之前引入 -->
<script src="../js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="../js/bootstrap.min.js"></script>
<!-- BEGIN CORE PLUGINS -->
<script src="../js/jquery.dataTables.min.js"></script>

<!-- SUMMERNOTE -->
<script src="../js/summernote.min.js"></script>
<script src="../js/summernote-zh-CN.js"></script>

<script>
    $(document).ready(function () {
        $('#summernote').summernote({
            lang: 'zh-CN',
            height: 224,                 // set editor height
            });

        $("#btnSave").click(function () {
            var content = $('#summernote').code();
            alert(content);
            //location.href="/news/insert?newsContent="+content;
            // return true;
            $.ajax({
                type: "post",//数据发送的方式（post 或者 get）
                url: "insert",//要发送的后台地址
                data: {"newsContent":content,"title":$('#title').val(),"time":$('#time').val()},//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
                dataType: "json",//后台处理后返回的数据格式
                success: function(data){
                    if(!data.success){
                        alert("操作失败，请与管理员联系");
                    }
                    else{
                        alert("发布成功");
                        location.href="../news/admin";
                    }
                }
            });
            //$("#form1").submit();
        });


        <c:if  test= "${requestScope.error == 'success'}">
            $('#myModal2').modal('show')
        </c:if>

    });


</script>

</body>

</html>