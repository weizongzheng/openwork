<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
    <script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/coursecss.css">
    <script  src="${pageContext.request.contextPath}/static/js/index.js"></script>
    <script  src="${pageContext.request.contextPath}/static/js/coursejs.js"></script>
    <style type="text/css">
        tr{
            margin: 0;
            padding: 0;
            height: 50px;
        }
        td{
            margin: 0;
            padding: 0;
            word-wrap:break-word;
            height: 35px;
        }
        .fixedTable > thead > tr > th, .fixedTable > tbody > tr > td {
            width: 2%!important;
        }
        #fixedTab,#grid {
            width: 560px;
            border: 1px solid gray;
            margin: 0;
        }
        td,th{
            height:35px;
            text-align:center;
        }
        #contenter {
            position: relative;
            width: 563px;
            height: 488px;
            margin: auto;
            background-color: white;
            border: 1px solid black;
        }
        #fixedDiv {
            position: absolute;
            left: 0;
            overflow: hidden;
        }
        #fixedTab th {
            background-color: white;
            color: black;
            font-family: '仿宋';
            font-size: large;
        }
        #mainDiv{
            height:465px;
            width: 560px;
            overflow:auto;
            overflow-x:hidden;
        }
        table tr td:last-child{
            padding-right: 17px;
        }
        #tbody{
            overflow: hidden;
        }
        #tbody:hover{
            overflow-y: auto;
            margin-left: -17px;
        }
    </style>
</head>
<body style="margin: 0;padding: 0">
<div class="form_2" >
    <form method="post" action="">
        <div class="input_1"><div class="login_logo">课程详情信息</div><div class="close1" onclick="closeIt()">X</div></div>
        <hr>
        <div class="span2" >课程ID：<span id="org_id"></span></div>
        <div class="span2" >课程名称：<span id="org_name"></span></div>
        <div class="span2">创建者：<span id="create_username"></span></div>
        <div class="span2">创建时间：<span id="create_time"></span></div>
        <div class="span2" >公告：<span id="content"></span></div>
        <div class="span2" >人数：<span id="into_number"></span></div>
        <div class="span2" >人员列表：</div>
        <div id="contenter" style="overflow-x:auto;">
            <div id="fixedDiv">
                <table id="fixedTab" class="fixedTable" border="1" cellpadding="0" cellspacing="0">
                    <thead>
                    <tr>
                        <th>用户名</th>
                        <th>姓名</th>
                        <th>学号</th>
                        <th>班级</th>
                        <th>学校</th>
                    </tr>
                    </thead>
                </table>
            </div>
            <div id="mainDiv">
                <table id="grid"  style="margin:0px;table-layout:fixed;" class="fixedTable" border="1" cellpadding="0" cellspacing="0">
                    <thead style="display:none;">
                    <tr>
                        <th>用户名</th>
                        <th>姓名</th>
                        <th>学号</th>
                        <th>班级</th>
                        <th>学校</th>
                    </tr>
                    </thead>
                    <tbody id="userlist" style="margin: 0;padding: 0">
                    </tbody>
                </table>
            </div>
        </div>
        <div class="input_1"><input class="submit_1 inputd" type="button" value="退出&nbsp;课程" onclick="exitOrg()"></div>
    </form>
</div>
<div class="container" style="margin: 0;padding: 0">
    <div class="row clearfix" style="margin: 0;padding: 0">
        <h3>
            &nbsp; &nbsp;我的课程
        </h3>
        <p> &nbsp; &nbsp;&nbsp; 注意课程编号#开头</p>
        <br>
        <div class="progress progress-striped" style="margin-bottom: 10px;margin-left: 20px">
            <div class="progress-bar progress-success" style="margin-bottom: 0">
            </div>
        </div>
        <button  class="span" style="margin-left: 20px; font-weight: bolder" onclick="search()">搜索课程</button> &nbsp;<input id="searchOrg" type="text"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <button class="span" style="font-weight: bolder" id="btn_1" onclick="addcourse()">添加课程</button>&nbsp;<input id="addOrg" type="text"/>
        <br>
        <div style="display: block;height: 600px;">
            <table id="orgtable" class="table table-bordered">
                <thead>
                <tr>
                    <th> 课程编号 </th>
                    <th> 课程名称 </th>
                    <th> 创建者</th>
                    <th> 创建时间 </th>
                    <th> 课程人数 </th>
                    <th> 操作 </th>
                </tr>
                </thead>
                <tbody id="tbody">
                <div id="div1" >
                    <c:forEach var="i" items="${courses}">
                        <tr onclick="getCourseinf(this)">
                            <td>${i.course_id}</td>
                            <td>${i.title}</td>
                            <td>${i.create_user}</td>
                            <td>${i.create_time}</td>
                            <td>${i.into_number}</td>
                            <td>
                                <a onclick="intoThisclass(this)">
                                    <span style="display: none">${i.course_id}</span>
                                    进入课程
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </div>
                </tbody>
            </table>
        </div>
        <nav class="pagination-outer" aria-label="Page navigation">
            <ul class="pagination">
                <li class="page-item" onclick="dePage()">
                    <a  class="page-link" aria-label="Previous">
                        <span aria-hidden="true">«</span>
                    </a>
                </li>
                <li id="page1" class="page-item active" value="1" onclick="thisPage(this)"><a class="page-link">1</a></li>
                <c:forEach var="i" begin="2" end="${number/10+1}" step="1">
                    <li id="page${i}" class="page-item" value="${i}" onclick="thisPage(this)"><a class="page-link">${i}</a></li>
                </c:forEach>
                <li class="page-item" onclick="addPage()">
                    <a  class="page-link" aria-label="Next">
                        <span aria-hidden="true">»</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>
<script>
    var pagenumber=${number/10+1};
    var urldomain="${pageContext.request.contextPath}";
    var username="${username}";
</script>
</body>
</html>
