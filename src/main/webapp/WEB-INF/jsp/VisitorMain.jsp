<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/6
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial scale=1">
    <meta name="renderer" content="webkit">
    <title>云计算与大数据实验室</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/font-awesome.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:/ / -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js "></script>
    <![endif]-->


</head>
<body>
<!--页头-->
<div id="container">
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <span><img alt="image" class="img-circle" src="images/logo_small.jpg" /></span>
                        <a  data-toggle="dropdown" class="dropdown-toggle"  href="index">
                        <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">云计算与大数据实验室</strong> </span></span>
                        </a>
                    </div>
                </li>

                <!-- 侧边栏-->
                <li><a href="index"><i class="fa fa-th-large"></i><span class="nav-label">主页</span></a></li>
                <li><a href="news/getAll"><i class="fa fa fa-globe"></i> <span class="nav-label">新闻动态</span></a></li>
                <li><a href="group/getAll"><i class="fa fa-comments"></i><span class="nav-label">组会通知</span></a></li>
                <li><a href="paper/getAll"><i class="fa fa-files-o"></i> <span class="nav-label"></span>论文展示</a></li>
                <li><a href="room/get"><i class="fa fa-calculator"></i> <span class="nav-label"></span>会议室租借情况</a></li>
            </ul>

        </div>
    </nav>

    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <span class="m-r-sm text-muted welcome-message"><a href="index" title="返回首页"><i class="fa fa-home"></i></a>欢迎使用实验室平台</span>
                    </li>
                    <li>
                        <a  href="user/login"><i class="fa fa-sign-out"></i>管理员登陆</a>
                    </li>
                </ul>
            </nav>
        </div>

        <div class="clearfix visible-xs-block"></div>

        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-sm-12">
                <h2>实验室简介</h2>
            </div>
        </div>

        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row" style="background-color: white">
                <div class="col-lg-12">
                    <div class="wrapper wrapper-content">
                        <div id="group-intro">
                            <img src="images/jssec.jpg" style="width: 650px; margin-left: 28%">
                            <div style="font-size: 16px">
                                <ul type="intro">
                                    <li>实验室简介:
                                        <ul>
                                            <li>江苏省“网络与信息安全”重点实验室（BM2003201，Jiangsu Provincial Key Laboratory of Network and Information Security）由江苏省科技厅于2003年8月开始在东南大学建立，计划总投资1050万元。实验室位于东南大学计算机楼，科研环境优异，总面积达2100平方米，设备固定资产近700万元。</li>
                                            <li>实验室的总体目标是建设支持网络与信息安全理论研究与技术开发的高性能网络平台和具有国际先进水平的开放式网络信息系统软硬件实验环境，成为江苏省网络与信息安全领域的研究基地；以网络和信息安全体系的构造及网络安全运行过程中涉及的科学原理、体系结构、实现方法和相关技术研究为重点，力争在研究和开发方面取得突破；为开发出具有自主知识产权和应用前景的网络与信息安全技术成果和产品，以及培养网络与信息安全方面的高级专业人才提供实验平台和实践环境；为提高江苏省在该研究领域的整体创新能力和国际竞争力创造必要的条件。</li>

                                        </ul>
                                    </li>
                                    <li>研究方向：
                                        <ul>
                                            <li>云计算与大数据处理</li>
                                            <li>数据中心网络研究</li>
                                            <li>海量数据存储</li>
                                            <li>资源调度</li>
                                        </ul>
                                    </li>
                                    <li>小组成员：
                                        <ul>
                                            <li>导师：东方、张竞慧、熊润群、金嘉辉</li>
                                            <li>博士：3名</li>
                                            <li>硕士：10名</li>
                                        </ul>
                                    </li>
                                    <li>主要活动：
                                        <ul>
                                            <li>举办全国高校云计算创意创新大赛</li>
                                            <li>举办CBD会议</li>
                                            <li>参与丁肇中AMS实验</li>
                                        </ul>
                                    </li>
                                    <li>科研成果：
                                        <ul>
                                            <li>
                                                在WWW、JSS、DPD、JCST、FGCS、ICPP、DASFAA、GlobeCom、CCGrid等国际国内核心期刊及学术会议上发表众多高水平文章
                                            </li>
                                            <li>
                                                参与多项国家、国际合作项目
                                            </li>
                                        </ul>
                                    </li>
                                </ul>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="footer">
            <div class="pull-right">
                <a style='color:grey' href="index"><span class="glyphicon glyphicon-arrow-up"></span>回到顶部</a>
            </div>
            <div>
                <strong>云计算与大数据研究组</strong> &copy; 2017
            </div>
        </div>
    </div>
</div>



<!-- jQuery 文件。务必在 bootstrap.min.js 之前引入 -->
<script src="js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="js/bootstrap.min.js"></script>
<!-- BEGIN CORE PLUGINS -->


</body>


</html>
