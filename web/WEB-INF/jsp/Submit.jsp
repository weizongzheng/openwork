<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/Submitcss.css" rel="stylesheet">
    <script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.5.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/submitjs.js"></script>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-2 column " style="width: 440px">
        </div>
        <div class="col-md-8 column ">
            <div class="item">
            <h2>
                &nbsp;&nbsp;&nbsp;${courseWork.work_name}
            </h2>
            <p class="span2">------欢迎 ${user.name}</p>
            </div>
            <div class="item wapp">
                <div class="item innerItem">
                    <span class="span2">作业细则：</span>
                    <span class="span2 ">${courseWork.work_content}</span>
                </div>
                <div class="item innerItem">
                    <span class="span2">已有文件（点击下载）：<a onclick="downloadfile(this)">${courseWork.file}</a></span>
                </div>
                <div class="item innerItem noSubmit">
                    <span class="span2">上传文件：<input id="submitfile" style="display: inline" type="file"></span>
                </div>
                <div class="item innerItem isSubmit">
                    <span class="span2">文件已经上传(若修改请选择文件修改)：</span>
                    <a>${intoWork.file}</a>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    <span class="span2">
                        <input id="updatefile" style="display: inline" type="file">
                    </span>
                </div>
                <div class="item innerItem noSubmit">
                    <textarea id="content" class="span2 textar"></textarea>
                </div>
                <div class="item innerItem isSubmit">
                    <textarea id="updatecontent" class="span2 textar">${intoWork.content}</textarea>
                </div>
                <div class="item innerItem noSubmit" >
                    <div class="input_1" style="text-align: center">
                        <input class="submit_1 inputd" type="button" value="提&nbsp;交" onclick="submitWork()">
                    </div>
                </div>
                <div class="item innerItem isSubmit">
                    <div class="input_1" style="text-align: center">
                        <input class="submit_1 inputd" type="button" value="修&nbsp;改" onclick="updateSubmitWork()">
                    </div>
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
   var work_id=${courseWork.work_id};
   var username="${username}";
   var submited=${intoWork.submited};
</script>
</html>
