<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/15
  Time: 22:26
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
    <title>云计算与大数据实验室-会议室租借情况</title>

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

        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-sm-12">
                <h2>会议室租借</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="../index"><span class="nav-label">主页</span></a>
                    </li>
                    <li>
                        <strong>会议室租借情况</strong>
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
        </div>

        <div class="footer">
            <div class="pull-right">
                <a style='color:grey' href="../room/get"><span class="glyphicon glyphicon-arrow-up"></span>回到顶部</a>
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
<script src="../js/bootstrap-datepicker.js"></script>
<script src="../js/bootstrap-datepicker.zh-CN.min.js"></script>


<script>
    $(function(){
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
            location.href="../room/get?dateText="+dateText+"&selectRoom="+selectRoom;
        });
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
</script>

</body>

</html>