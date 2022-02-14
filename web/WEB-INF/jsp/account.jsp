<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <style type="text/css">
        #open{
            width: 1000px;
            height: 609px;
            padding-left:70px;
            padding-top:50px;
            margin-left: 370px ;
            margin-top: 60px;
            border:1px solid #dedede;
            border-radius: 8px;
        }
        #login_click{ margin-top:32px; margin-left:340px;height:40px;}
        #login_click input
        {
            text-decoration:none;
            background: #a1a3aa;
            color:#f2f2f2;
            padding: 10px 30px 10px 30px;
            font-size:16px;
            font-family: 微软雅黑,宋体,Arial,Helvetica,Verdana,sans-serif;
            font-weight:bold;
            border-radius:3px;
            -webkit-transition:all linear 0.30s;
            -moz-transition:all linear 0.30s;
            transition:all linear 0.30s;
        }
        #login_click input:hover { background: #2b7d76; }
        .login-item{
            padding: 2px 8px;
            border:1px solid #dedede;
            border-radius: 8px;
            margin-top: 25px;
            font-family: '微软雅黑','文泉驿正黑','黑体';
            width: 300px;
        }
        .login-it{
            padding: 2px 8px;
            margin-top: 25px;
            font-family: '微软雅黑','文泉驿正黑','黑体';
            width: 300px;
        }
        .d{
            position: absolute /*914 214*/;
            margin-left: 950px;
            bottom: 440px;
            width: 244px;
            height: 282px;
            border:1px solid #dedede;
            border-radius: 8px;
            float: left;
            background-color: #cccccc;
        }
        .im{
            width: 244px;
            height: 279px;
        }
    </style>
    <script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.5.1.min.js"></script>
    <script>
        function put(){
            if($("#number").val()==='')
                alert("旧密码处不能为空")
            else if($("#newpass").val()==='')
                alert("新密码处不能为空")
            else if($("#number").val()!=="${password}")
                alert("密码错误")
            else{
                $.post({
                    url:"${pageContext.request.contextPath}/updatepassword",
                    data:{"username":"${user.username}","newpassword":$("#newpass").val()},
                    success: function (data){
                        $("#tip").css("display","block")
                        window.setTimeout("back()", 2000)
                    }
                })
            }
        }
        function back(){
            $("#tip").css("display","none")
        }
    </script>
</head>
<body>
<div class="container-fluid">
    <div id="tip" style="display:none;" class="span12">
        <div class="alert alert-success">
            <button type="button" class="close" data-dismiss="alert">×</button>
            <h4>
                提示!
            </h4> <strong>修改个人信息已提交!</strong>  修改成功！
        </div>
    </div>
    <h2>
        账户基本信息
    </h2>
    <p>
        您可以在这里只能够修改密码，但不可以修改为空值。
    </p>
    <div id="open" >
        <form id="Login" name="Login" method="post" >
            <li class="login-item">
                <span >用户名&nbsp;&nbsp;&nbsp;：</span>
                <input type="text" style="outline: none" id="username" name="UserName" class="login_input" readonly="readonly" value="${user.username}">
            </li>
            <li class="login-item ">
                <span>姓名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：</span>
                <input type="text" style="outline: none" id="name" class="login_input" readonly="readonly" value="${user.name}">
            </li>
            <li class="login-item">
                <span>创建日期：</span>
                <input type="text" style="outline: none" id="class" class="login_input" readonly="readonly" value="${createtime}">
            </li>
            <li class="login-item">
                <span>旧密码&nbsp;&nbsp;&nbsp;：</span>
                <input type="password" id="number" class="login_input" >
            </li>
            <li class="login-item">
                <span>新密码&nbsp;&nbsp;&nbsp;：</span>
                <input type="text" id="newpass" class="login_input" >
            </li>
            <br><br><br><br>
            <div id="login_click">
                <input type="button"  value="确认修改" style="margin:0 auto;" onclick="put()"/>
            </div>
        </form>
    </div>
    <div class="d">
        <c:if test="${pUrl!=null }">
        <img class="im" id="images" alt="" src="${pageContext.request.contextPath}/${pUrl}">
        </c:if>
    </div>
</div>
</div>
</div>
</body>
</html>