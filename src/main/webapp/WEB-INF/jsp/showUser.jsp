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

    <title>管理员列表</title>

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
                <h2>子管理员管理</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="../user/AdminMain"><span class="nav-label">管理员主页</span></a>
                    </li>
                    <li>
                        <strong>子管理员管理</strong>
                    </li>
                </ol>
            </div>
        </div>

        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>云计算与大数据研究组 <small>子管理员列表</small></h5>
                            <div class="ibox-tools">
                                <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#Add"><span class="glyphicon glyphicon-plus"></span>新增管理员</button>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <table id="dataTables" class="table table-striped table-bordered table-hover ">
                                <thead>
                                <tr>
                                    <th>管理员ID</th>
                                    <th>密码</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:if test="${!empty userList}">
                                <c:forEach var="user" items="${userList}">
                                        <tr>
                                            <td>${user.userid}</td>
                                            <td>${user.userpassword}</td>
                                            <td>
                                                <button  type="button" class="btn btn-primary btn-sm"  onclick="deleteConfirm('${user.userid}')">
                                                    <span class="glyphicon glyphicon-minus"></span>删除
                                                </button>
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
                <a style='color:grey' href="../user/showUser"><span class="glyphicon glyphicon-arrow-up"></span>回到顶部</a>
            </div>
            <div>
                <strong>云计算与大数据研究组</strong> &copy; 2017
            </div>
        </div>
    </div>
</div>

<!-- 新增模态框（Modal） -->
<div class="modal fade  text-center" id="Add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="display: inline-block; width: auto;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">新增管理员</h4>
            </div>

            <form action="../user/insert" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">管理员ID：</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="text" placeholder="请输入文本" required="" name="userid">
                        </div>
                    </div>
                    <div>&nbsp;</div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">管理员密码：</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="text" placeholder="请输入文本" required="" name="userpassword">
                        </div>
                    </div>
                    <div>&nbsp;</div>
                </div>

                <div class="modal-footer">
                    <button type="submit" class="btn btn-default" >保存</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>

            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 上传成功模态框（Modal） -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel2"><span class="glyphicon glyphicon-warning-sign"></span></h4>
            </div>
            <div class="modal-body">添加成功</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
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
    $(function() {

        var $table = $("#dataTables").dataTable({
            'dom': '<"float_left"l>r<"float_right"f>t<"float_left"i><"float_right"p>',
            "bPaginate": true,  //是否显示分页
            "bLengthChange": 10,  //是否启用每页显示的记录数
            "bFilter": true, //搜索栏
            "bSort": false, //是否支持排序功能
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

        <c:if  test= "${requestScope.error == 'success'}">
        $('#myModal2').modal('show');
        </c:if>

    });


    function deleteConfirm(deleteID)
    {
        if (confirm('确实要删除此子管理员吗?'))
        {
            location.href="../user/delete?adminid="+deleteID;
        }
    }

</script>

</body>

</html>







