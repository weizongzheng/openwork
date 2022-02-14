<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
    <script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/workManInfcss.css">
    <script src="${pageContext.request.contextPath}/static/js/workManInfjs.js"></script>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-4 column">
        </div>
        <h1>
            ${courseWork.work_name}
        </h1>
        <form></form>
        <div class="col-md-6 column cen">
            <div class="item">
                <span class="span1">作业名称:</span>
                <input class="inputd span2" id="workName" type="text" value="${courseWork.work_name}">
                <input  class="span2" type="button" onclick="updateWorkName()" value="修改">
            </div>
            <div class="item">
                <span class="span1" style="margin-top: 50px">作业细则:</span>
                <textarea id="workContent" class="inputBigSize span2" >${courseWork.work_content}</textarea>
                <input  class="span2"  style="margin-top: 50px" onclick="updateWorkContent()" type="button" value="修改">
            </div>
            <div class="item">
                <span class="span1">我上传的文件:<a onclick="downloadfile(this)">${courseWork.file}</a></span>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                <span class="span1"><button onclick="updatefile()">更改文件</button>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<input id="updatefile" type="file" style="display: inline"></span>
            </div>
            <div class="item">
                <a class="span1" style="margin-left: 50px" onclick="AllWorkDownload()">作业全部下载</a>
                <a class="span1" style="margin-left: 50px" onclick="downloadNoSubmit()">下载未提交作业名单</a>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
                <input class="inputd span2" id="addUserId" type="text" placeholder="为该作业添加成员">
                <input  class="span2" type="button" onclick="addUserToWork()" value="添加">
            </div>
            <div class="item">
            <div style="margin-left: 50px">
                <div id="contenter" style="overflow-x:auto;float: left;margin-bottom: 50px">
                    <div id="fixedDiv">
                        <table id="fixedTab" class="fixedTable" border="1" cellpadding="0" cellspacing="0">
                            <thead>
                            <tr>
                                <th>用户名</th>
                                <th>姓名</th>
                                <th>学号</th>
                                <th>操作</th>
                                <th>是否提交</th>
                                <th>下载</th>
                                <th>留言</th>
                            </tr>
                            </thead>
                        </table>
                    </div>
                    <div id="mainDiv">
                        <table id="grid" style="margin:0px;table-layout:fixed ;" class="fixedTable" border="1" cellpadding="0" cellspacing="0">
                            <thead style="">
                            <tr>
                                <th>用户名</th>
                                <th>姓名</th>
                                <th>学号</th>
                                <th>操作</th>
                                <th>是否提交</th>
                                <th>下载</th>
                                <th>留言</th>
                            </tr>
                            </thead>
                            <tbody id="userlist" style="margin: 0;padding: 0">
                            <c:forEach var="i" items="${users}" varStatus="loop">
                                <tr class="list1">
                                    <td>${i.username}</td>
                                    <td>${i.name}</td>
                                    <td>${i.number}</td>
                                    <td>
                                        <a onclick="deleteUserFromWork(this)">
                                        <span style="display: none">${i.username}</span>
                                            强制退出
                                        </a>
                                    </td>
                                    <td class="isSubmit"><span class="span1">${intoworks[loop.index].submited}</span></td>
                                    <td class="download">
                                        <a onclick="downloadOneUserWork(this)">
                                            <span style="display: none">${i.username}</span>
                                            <span style="display: none">${intoworks[loop.index].file}</span>
                                            下载
                                        </a>
                                    </td>
                                    <td class="posttalk">${intoworks[loop.index].content}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            </div>
            <div class="item1">
                <div class="input_1">
                    <input style="margin-left: 400px" class="submit_1 inputd" type="button" value="解散&nbsp;作业" onclick="deleteWork()">
                    <input style="margin-left: 70px" class="submit_1 inputd" type="button" value="进入自我提交" onclick="goSubmit()">
                </div>
            </div>
        </div>
        <div class="col-md-2 column">
        </div>
    </div>
</div>
</body>
<script>
    var urldomain="${pageContext.request.contextPath}";
    var course_id="${course_id}";
    var work_id="${courseWork.work_id}";
    var username="${username}";
</script>
</html>
