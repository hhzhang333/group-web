<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/23
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd EEE");
    String date= format.format(new Date());
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial scale=1">
    <meta name="renderer" content="webkit">

    <title>会议室租借</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/font-awesome.css" rel="stylesheet">
    <link href="../css/dataTables.bootstrap.css" rel="stylesheet">
    <link href="../css/bootstrap-datepicker3.css" rel="stylesheet">
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
        .table th, .table td {
            text-align: center;
            vertical-align: middle!important;
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
                <c:if test= "${sessionScope.get('adminRole') == '1'}">
                    <li><a href="../user/AdminMain"><i class="fa fa-th-large"></i><span class="nav-label">管理员主页</span></a></li>
                    <li><a href="../news/admin"><i class="fa fa fa-globe"></i> <span class="nav-label">新闻发布</span></a></li>
                    <li><a href="../group/admin"><i class="fa fa-comments"></i><span class="nav-label">组会通知</span></a></li>
                    <li><a href="../paper/admin"><i class="fa fa-files-o"></i> <span class="nav-label"></span>论文上传</a></li>
                </c:if>
                <!-- 侧边栏-->
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
                <h2>会议室租借</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="../user/AdminMain"><span class="nav-label">管理员主页</span></a>
                    </li>
                    <li>
                        <strong>会议室租借</strong>
                    </li>
                </ol>
            </div>
            <div class="col-sm-12">
                &nbsp;
            </div>
            <div class="col-sm-12">
                今天：<%=date%>
            </div>
        </div>

        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <div class="col-lg-4">
                            <h5>会议室预约情况 <small>(1（大会议室）会议室为370,2（小会议室）会议室为364)</small></h5>
                            </div>
                            <div class="col-lg-4">
                                <div class="form-group" id="data_1">
                                    <label class="col-sm-4 control-label">日期选择：</label>
                                    <div class="col-sm-8">
                                        <div class="input-group date">
                                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                            <input id="datetimepicker" value="<%=request.getAttribute("selectDateid").toString()%>" type="text" data-format="yyyy-MM-dd"  class="form-control"  required="" name="time">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <label class="col-sm-5 control-label text-center">会议室选择：</label>
                                <div class="col-sm-7">
                                    <form name = "form1" >
                                    <select id = "select" name="selectRoom" onchange="document.form1.submit();" class="form-control">
                                        <option value="1">大会议室</option>
                                        <option value="2">小会议室</option>
                                        </select>
                                    </form>
                                </div>
                            </div>
                        </div>

                        <div class="ibox-content">
                            <table id="myTable" class="table">
                               <thead >
                                <tr>
                                    <th>时间</th>
                                    <th>周一</th>
                                    <th>周二</th>
                                    <th>周三</th>
                                    <th>周四</th>
                                    <th>周五</th>
                                    <th>周六</th>
                                    <th>周日</th>
                                </tr>
                                </thead>
                                <tbody>

                                <tr>
                                    <td>8:00-9:00</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>9:00-10:00</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>10:00-11:00</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>11:00-12:00</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>12:00-13:00</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>13:00-14:00</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>14:00-15:00</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>15:00-16:00</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>16:00-17:00</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>17:00-18:00</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>18:00-19:00</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>19:00-20:00</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>20:00-21:00</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>21:00-22:00</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>


    <div class="row">
                <div class="col-lg-6">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>我的预约<small>未完成预约</small></h5>
                            <div class="ibox-tools">
                                <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#Add"><span class="glyphicon glyphicon-plus"></span>新增预约</button>
                            </div>
                        </div>
                        <div class="ibox-content">

                            <table id="after" class="table table-striped table-bordered table-hover ">
                                <thead>
                                <tr>
                                    <th>日期</th>
                                    <th>地点</th>
                                    <th>开始时间</th>
                                    <th>结束时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:if test="${!empty after}">
                                    <c:forEach var="room2" items="${after}">
                                        <tr>
                                            <td><fmt:formatDate pattern="yyyy-MM-dd"  value="${room2.rdate}" /></td>
                                            <td>${room2.room}</td>
                                            <td><fmt:formatDate pattern="HH:mm"  value="${room2.begintime}" /></td>
                                            <td><fmt:formatDate pattern="HH:mm"  value="${room2.endtime}" /></td>
                                            <td>
                                                <button  type="button" class="btn btn-primary btn-sm"  onclick="deleteConfirm(${room2.id})">
                                                    <span class="glyphicon glyphicon-minus"></span>删除预约
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


                <div class="col-lg-6">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>我的预约<small>已完成预约</small></h5>
                        </div>
                        <div class="ibox-content">

                            <table id="bofore" class="table table-striped table-bordered table-hover ">
                                <thead>
                                <tr>
                                    <th>日期</th>
                                    <th>地点</th>
                                    <th>开始时间</th>
                                    <th>结束时间</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${!empty before}">
                                    <c:forEach var="room2" items="${before}">
                                        <tr>
                                            <td><fmt:formatDate pattern="yyyy-MM-dd"  value="${room2.rdate}" /></td>
                                            <td>${room2.room}</td>
                                            <td><fmt:formatDate pattern="HH:mm"  value="${room2.begintime}" /></td>
                                            <td><fmt:formatDate pattern="HH:mm"  value="${room2.endtime}" /></td>
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
                <a style='color:grey' href="../room/admin"><span class="glyphicon glyphicon-arrow-up"></span>回到顶部</a>
            </div>
            <div>
                <strong>云计算与大数据研究组</strong> &copy; 2017
            </div>
        </div>
    </div>
</div>


<!--预约模态框（Modal） -->
<div class="modal fade  text-center" id="Add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="display: inline-block; width: auto;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">新增预约</h4>
            </div>

            <form action="../room/insert" method="post" enctype="multipart/form-data">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">日期：</label>
                        <div class="col-sm-9">
                            <div class="input-group date">
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                <input id="datetimepicker1" type="Date" class="form-control"  required="" name="time">
                            </div>
                        </div>
                    </div>

                    <div>&nbsp;</div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label text-center">会议室选择：</label>
                        <div class="col-sm-9">
                                <select id = "select2" name="selectRoom2" class="form-control">
                                    <option value="1">大会议室</option>
                                    <option value="2">小会议室</option>
                                </select>
                        </div>
                    </div>

                    <div>&nbsp;</div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label text-center">开始时间：</label>
                        <div class="col-sm-3">
                                    <select id = "select3" name="select3" class="form-control">
                                        <option value="8:00:00">8:00</option>
                                        <option value="9:00:00">9:00</option>
                                        <option value="10:00:00">10:00</option>
                                        <option value="11:00:00">11:00</option>
                                        <option value="12:00:00">12:00</option>
                                        <option value="13:00:00">13:00</option>
                                        <option value="14:00:00">14:00</option>
                                        <option value="15:00:00">15:00</option>
                                        <option value="16:00:00">16:00</option>
                                        <option value="17:00:00">17:00</option>
                                        <option value="18:00:00">18:00</option>
                                        <option value="19:00:00">19:00</option>
                                        <option value="20:00:00">20:00</option>
                                        <option value="21:00:00">21:00</option>
                                    </select>
                        </div>

                        <label class="col-sm-3 control-label text-center">结束时间：</label>
                        <div class="col-sm-3">
                                    <select id = "select4" name="select4" class="form-control">
                                        <option value="9:00:00">9:00</option>
                                        <option value="10:00:00">10:00</option>
                                        <option value="11:00:00">11:00</option>
                                        <option value="12:00:00">12:00</option>
                                        <option value="13:00:00">13:00</option>
                                        <option value="14:00:00">14:00</option>
                                        <option value="15:00:00">15:00</option>
                                        <option value="16:00:00">16:00</option>
                                        <option value="17:00:00">17:00</option>
                                        <option value="18:00:00">18:00</option>
                                        <option value="19:00:00">19:00</option>
                                        <option value="20:00:00">20:00</option>
                                        <option value="21:00:00">21:00</option>
                                        <option value="22:00:00">22:00</option>
                                    </select>
                        </div>
                    </div>
                    <div>&nbsp;</div>

                    <div class="form-group">
                        <div>
                            <label class="checkbox" style="left: -144px;">
                                每周固定时间：<input type="checkbox" id="period" name="period" style="margin-left: 7px">
                            </label>
                        </div>
                    </div>
                    <div>&nbsp;</div>

                    <div id="endTime" class="form-group" hidden>
                        <label class="col-sm-3 control-label">结束日期：</label>
                        <div class="col-sm-9">
                            <div class="input-group date">
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                <input id="datetimepicker2" type="Date" class="form-control" name="endTime">
                            </div>
                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="submit" class="btn btn-default" >保存</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>

            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 时间过期模态框（Modal） -->
<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel1"><span class="glyphicon glyphicon-warning-sign"></span></h4>
            </div>
            <div class="modal-body">时间已过期，请重新选择时机！</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 预约成功模态框（Modal） -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel2"><span class="glyphicon glyphicon-warning-sign"></span></h4>
            </div>
            <div class="modal-body">预约成功</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 时间冲突模态框（Modal） -->
<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel3"><span class="glyphicon glyphicon-warning-sign"></span></h4>
            </div>
            <div class="modal-body">所选会议室本时间段存在预约，换个时间段再试试！</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 时间选反模态框（Modal） -->
<div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel4"><span class="glyphicon glyphicon-warning-sign"></span></h4>
            </div>
            <div class="modal-body">是否时间选反呢，再检查一下~</div>
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
<script src="../js/bootstrap-datepicker.js"></script>
<script src="../js/bootstrap-datepicker.zh-CN.min.js"></script>


<script type="text/javascript">
    $(function(){

        $("#period").click(function () {
            if (this.checked == true) {
                $("#endTime").show();
            } else
                $("#endTime").hide();
        });


        var sel = document.getElementById( 'select');
        sel.value =  <%=request.getAttribute("selectRoomid").toString()%> ;
        init();


        $('#datetimepicker').datepicker({
            format: 'yyyy-mm-dd',
            todayBtn: "linked",
            keyboardNavigation: true,
            forceParse: false,
            calendarWeeks: true,
            autoclose: true,
            language:"zh-CN",
        }).on('changeDate',function(ev) {
            var  dateText=$("#datetimepicker").val();
            var selectRoom = $("#select").val();
            location.href="../room/admin?dateText="+dateText+"&selectRoom="+selectRoom;
        });


        $('#datetimepicker1').datepicker({
            format: 'yyyy-mm-dd',
            todayBtn: "linked",
            keyboardNavigation: true,
            forceParse: false,
            calendarWeeks: true,
            autoclose: true,
            language:"zh-CN"
        });

        $('#datetimepicker2').datepicker({
            format: 'yyyy-mm-dd',
            todayBtn: "linked",
            keyboardNavigation: true,
            forceParse: false,
            calendarWeeks: true,
            autoclose: true,
            language:"zh-CN"
        });

        <c:if  test= "${requestScope.error == 'over'}">
        $('#myModal1').modal('show')
        </c:if>
        <c:if  test= "${requestScope.error == 'success'}">
        $('#myModal2').modal('show')
        </c:if>
        <c:if  test= "${requestScope.error == 'repeat'}">
        $('#myModal3').modal('show')
        </c:if>
        <c:if  test= "${requestScope.error == 'fan'}">
        $('#myModal4').modal('show')
        </c:if>
    });

    function init(){
        <% int[][] day  = (int[][])request.getAttribute("day");
         String[][] lender  = (String[][])request.getAttribute("lender");
        for(int i =0;i<day.length;i++)
            {
            for(int j=0;j<day[i].length;j++)
                {
                if(day[i][j] == 1){%>
        document.getElementById("myTable").rows[<%=j+1%>].cells[<%=i+1%>].innerText  = "<%=lender[i][j]%>";
        document.getElementById("myTable").rows[<%=j+1%>].cells[<%=i+1%>].style.color='#FFFFFF';
        document.getElementById("myTable").rows[<%=j+1%>].cells[<%=i+1%>].style.backgroundColor = "DarkTurquoise";
                <%}
                }
            }%>
    }


    function deleteConfirm(deleteID)
    {
        if (confirm('确实要删除此预约吗?'))
        {
            location.href="../room/delete?Roomid="+deleteID;
        }
    }

</script>

</body>

</html>

