        <%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/14
  Time: 21:21
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
    <title>论文展示</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/dataTables.bootstrap.min.css">

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
                <h2>论文展示</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="../index"><span class="nav-label">主页</span></a>
                    </li>
                    <li>
                        <strong>论文展示</strong>
                    </li>
                </ol>
            </div>
        </div>

        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row ">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>云计算与大数据研究组 <small>会议文章列表</small></h5>
                        </div>
                        <div class="ibox-content">
                            <div>
                                <h3>
                                    <a style='color:grey; font-weight:normal' href="../paper/getAll">所有</a> &nbsp;&nbsp;
                                    <a style='color:grey; font-weight:normal' href="../paper/getYear?year=2017">2017</a>&nbsp;&nbsp;
                                 <a style='color:grey; font-weight:normal' href="../paper/getYear?year=2016">2016</a>&nbsp;&nbsp;
                                  <a style='color:grey; font-weight:normal' href="../paper/getYear?year=2015">2015</a>&nbsp;&nbsp;
                                  <a style='color:grey; font-weight:normal' href="../paper/getYear?year=2014">2014</a>&nbsp;&nbsp;
                                   <a style='color:grey; font-weight:normal' href="../paper/getYear?year=2013">2013</a>&nbsp;&nbsp;
                                   <a style='color:grey; font-weight:normal' href="../paper/getYear?year=2012">2012</a></h3>
                            </div>

                            <table id="dataTables" class="table table-striped table-bordered table-hover ">
                                <thead>
                                <tr>
                                    <th>时间</th>
                                    <th>论文标题</th>
                                    <th>作者</th>
                                    <th>期刊</th>
                                    <th>下载</th>
                                    <th>引用</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:if test="${!empty paperList}">
                                    <c:forEach var="paper" items="${paperList}">
                                        <tr>
                                            <td width="300px" style="word-wrap:break-word;"><fmt:formatDate  pattern="yyyy.MM.dd"  value="${paper.pdate}" /></td>
                                            <td width="800px" style="word-wrap:break-word;">${paper.title}</td>
                                            <td width="600px" style="word-wrap:break-word;">${paper.author}</td>
                                            <td width="200px" style="word-wrap:break-word;">${paper.pgroup}</td>
                                            <td width="400px" style="word-wrap:break-word;">
                                                PDF
                                                <a href="..${paper.pname}" target="_blank">[预览]</a>
                                                <a href="../paper/fileDownload_pdf?Paperid=${paper.id}">[下载]</a>
                                            </td>
                                            <td width="100px">
                                                <button type="button" class="bt btn-primary btn-sm"  onClick="ref(${paper.id})" >+</button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:if><% String ref = null; %>

                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="footer">
            <div class="pull-right">
                <a style='color:grey' href="../paper/getAll"><span class="glyphicon glyphicon-arrow-up"></span>回到顶部</a>
            </div>
            <div>
                <strong>云计算与大数据研究组</strong> &copy; 2017
            </div>
        </div>
    </div>
</div>

<!-- 引用模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">引用格式</h4>
            </div>
            <div class="modal-body">
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


<!-- Page-Level Scripts -->
<script>
    $(function () {
        $("#dataTables").dataTable({
            'dom': '<"float_right"f>',
            "bPaginate": true,  //是否显示分         "bLengthChange": false,  //是否启用每页显示的记录数
            "bFilter": true, //搜索栏
            "bSort": true, //是否支持排序功能
            stateSave: true,//保持翻页状态，
            "oLanguage": {
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
            "aLengthMenu": [[ 10, 20], [ "10", "20"]]  //设置每页显示记录的下拉菜单
        });




    });

    function ref(deleteID)
    {
        $.ajax({
            type: "post",//数据发送的方式（post 或者 get）
            url: "/paper/getReference",//要发送的后台地址
            data: {"adminPaperid":deleteID},//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
            dataType: "text",//后台处理后返回的数据格式
            async: false,
            success: function(data){
                console.log(data);
                    var modal = $('#myModal');
                    modal.find('.modal-body').text(data);
                    $('#myModal').modal('show');
            }
        });
        //location.href="/paper/getReference?adminPaperid="+deleteID;
    }


</script>

</body>

</html>
