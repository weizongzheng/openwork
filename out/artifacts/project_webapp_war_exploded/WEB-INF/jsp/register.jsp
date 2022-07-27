<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <style type="text/css">
        body{
            text-align:center;
            background-color: #633763;
            background-size: cover;
            -webkit-background-size: cover;
            background-position: center 0;
           background-image: url("${pageContext.request.contextPath}/static/img/backgroud1.jpg");
            background-repeat: no-repeat;
            background-color: #fff;
            background-size: cover;
            -webkit-background-size: cover;
            -o-background-size: cover;
            background-position: center 0;
        }
        .main{
            margin:0 auto;
            display: inline;
        }
        .la{
            width: 70px;
        }
    </style>
    <script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        var t=1;
       function isregister(){
            $.post({
                url:"${pageContext.request.contextPath}/login/isregister",
                data:{"username":$("#myusername").val()},
                success:function (data){
                    if(data==="done")
                    {
                        $("#userInfo").css("color","red");
                        $("#userInfo").html("已注册");
                        t=0;
                    }
                    else{
                        $("#userInfo").css("color","green");
                        $("#userInfo").html("已通过");
                        t=1;
                    }
                }
            })
        }
        function check(){
           var name= document.getElementById("myname");
           var school= document.getElementById("myschool");
           var number= document.getElementById("mynumber");
            var myclass= document.getElementById("myclass");
            var username= document.getElementById("myusername");
            var pwd= document.getElementById("pwd");
            var rpwd= document.getElementById("rpwd");
            if(name.value==''){
                name.placeholder="未输入姓名";
                name.style.backgroundColor="red";
                return false;
            }
            else if(school.value ==='')
            {
                school.placeholder="未输入学校";
                school.style.backgroundColor="red";
                return false;
            }
            else if(number.value ==='')
            {
            number.placeholder="未输入学号";
            number.style.backgroundColor="red"
            return false
             }
            else if(myclass.value ==='')
            {
                myclass.placeholder="未输入班级";
                myclass.style.backgroundColor="red";
                return false
            }
            else if(username.value ==='')
            {
                username.placeholder="未输入用户名";
                username.style.backgroundColor="red";
                return false
            }
            else if(pwd.value ==='')
            {
                pwd.placeholder="未输入密码"
                pwd.style.backgroundColor="red"
                return false
            }
            else if(rpwd.value !==pwd.value  )
            {
                rpwd.placeholder="两次输入的密码不相同"
                rpwd.style.backgroundColor="red"
                return false
            }
            else if(t===0)
            {
                alert("用户名已经注册了，请换个试试")
                return false
            }
            else
            {
                alert("注册成功");
                return true
            }
        }
    </script>
</head>
<body class="jumbotron">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
            <br> <br> <br>
    <div style="background-color: white;width: 625px;height: 750px;margin-left: 490px">
            <h1 class="main">
                openwork 注册平台
            </h1>
                <br> <br> <br> <br>
            <form action="${pageContext.request.contextPath}/login/ok" method="post" onsubmit="return check();">
                <label class="la">姓名</label>     <input id="myname" type="text" class="form-control main" style="width: 250px;" name="name" placeholder="请输入" >
                <br><br>

                <label class="la">性别</label>  <div class="radio-inline">
                    <label class="radio">
                        <input type="radio" name="sex" value="男" checked="checked" />男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="sex" value="女" />女
                    </label>
                </div>
                <br><br>
                <label class="la">学校</label>     <input id="myschool" type="text" class="form-control main" style="width: 250px;" name="school" placeholder="请输入">
                <br><br>
               <label class="la">学号</label>      <input id="mynumber" type="text" class="form-control main" style="width: 250px;" name="number" placeholder="请输入">
                <br><br>
                <label class="la">班级</label>    <input id="myclass" type="text" class="form-control main" style="width: 250px;" name="classes" placeholder="请输入">
                <br><br>
                <label class="la">用户名</label>     <input id="myusername" type="text" class="form-control main" style="width: 250px;" name="username" placeholder="请输入" onblur="isregister()">
                <span id="userInfo"></span>
                <br><br>
                <label class="la">密码</label>       <input id="pwd" type="text" class="form-control main" style="width: 250px;" name="password" placeholder="请输入" >
                <br><br>
                <label class="la">确认密码</label>    <input id="rpwd" type="text" class="form-control main" style="width: 250px;"  placeholder="请输入">
                <br><br>
                <div class="checkbox" class="main">
                    <label>
                        <input type="checkbox">认真阅读使用守则
                    </label>
                </div>
                <br>
                <input type="submit" class="btn btn-info main" value="确认注册"/>
            </form>
</div>
</body>
</html>