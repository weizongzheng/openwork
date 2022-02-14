<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title></title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/reset.css" />
  <link rel="stylesheet" type="text/css"   href="${pageContext.request.contextPath}/static/css/login.css" />
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js" charset="utf-8"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/login.js" charset="utf-8"></script>
  <script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.5.1.min.js"></script>
    <script>
        function goregist(){window.location.href="${pageContext.request.contextPath}/login/into";}
        function validate(){
            $.post({
                url: "${pageContext.request.contextPath}/login/validation",
                data: {"username":$("#username").val(),"password":$("#password").val()},
                success: function (data){
                    if(data==="Y") {

                      window.location.href="${pageContext.request.contextPath}/login/gomain?username="+$("#username").val();
                    }
                  else {
                      $("#error").css("color","red");
                      $("#error").html("用户名或密码错误")
                    }
                }
            })
        }
    </script>
</head>
<body>
<div class="page">
  <div class="loginwarrp" >
    <div class="logo" >openwork</div>
    <div class="login_form">
      <form id="Login" name="Login" method="post" onsubmit="" action="">
        <li class="login-item">
          <span >用户名：</span>
          <input type="text" id="username" name="UserName" class="login_input" >
          <span id="count-msg" class="error"></span>
        </li>
        <li class="login-item">
          <span>密　码：</span>
          <input type="password" id="password" name="password" class="login_input" >
          <span id="password-msg" class="error"></span>
        </li>
          <div id="error" style="color: #FF0000"></div>
        <li class="login-sub">
          <input type="button" name="Submit" value="登录" onclick="validate()"/>
          <input type="reset" id="reset" name="Reset" value="注册"  onclick="goregist()"/>
        </li>
      </form>
    </div>
  </div>
</div>
</body>
</html>
