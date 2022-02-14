<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
    <script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.5.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/mycoursejs.js"></script>
    <link href="${pageContext.request.contextPath}/static/css/Mycoursecss.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<div class="form_1" >
    <form method="post" action="">
        <div class="input_1"><div class="login_logo">创建作业</div><div class="close" onclick="closeIt()">X</div></div>
        <hr>
        <br>
        <div class="input_1"><input class="inputd" id="work_name" placeholder="&nbsp;作业名称"></div>
        <div class="input_1"><input class="inputd" id="work_content" placeholder="&nbsp;作业须知"></div>
        <div id="fileToUpload" class="input_1" style="margin-left: 60px"> <input class="inputd span1" type="file" id="file" name="file"></div>
        <div class="input_1"><input class="submit_1 inputd" type="button" value="提&nbsp;交" onclick="createCourseWork()"></div>
    </form>
</div>
<h2 style="text-align: center">${course.title}</h2>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-2 column">
        </div>
        <div class="col-md-6 column cent">
            <span class="span3">我的作业</span>
            <div class="progress">
                <div class="progress-bar progress-success">
                </div>
            </div>
                <ul class="box">
                    <c:forEach var="i"  items="${courseAllWork}">
                        <li><a onclick="intoWorkInf(this)"><span>${i.work_id}</span><br>${i.work_name}</a></li>
                    </c:forEach>
                        <li id="iscreateli"><a onclick="openCreateWork()"><br>创建作业</a></li>
                </ul>
        </div>
    </div>
</div>
</body>
<script>
    var isCreate=${isCreate};
    var username="${username}";
    var course_id="${course.course_id}";
    var urldomain="${pageContext.request.contextPath}";
</script>
</html>
