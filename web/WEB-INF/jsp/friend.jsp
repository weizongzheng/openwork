<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
    <c:set var="url">${pageContext.request.requestURL}</c:set>
    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />
    <script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/friendcss.css">
    <script  src="${pageContext.request.contextPath}/static/js/index.js"></script>
    <script  src="${pageContext.request.contextPath}/static/js/friendjs.js"></script>
</head>
<body style="margin: 0;padding: 0">
<div class="form_1" >
    <form method="post" action="">
        <div class="input_1"><div class="login_logo">添加分组</div><div class="close">X</div></div>
        <hr>
        <div class="input_1"><input id="pro" class="inputd" type="text" placeholder="&nbsp;优先级"></div>
        <div class="input_1"><input class="inputd"  id="colum_name" placeholder="&nbsp;名称"></div>
        <div class="input_1"><input class="submit_1 inputd" type="button" value="提&nbsp;交" onclick="addColun()"></div>
        <div class="input_1"><input style="display: none" class="inputd" type="text" id="num" value=0></div>
        <div class="input_1"><input style="display: none" class="inputd" type="text" id="u1" value="${username}"></div>
    </form>
</div>
<div class="form_2" >
    <form method="post" action="">
        <div class="input_1"><div class="login_logo">删除分组</div><div class="close1">X</div></div>
        <hr>
        <div>
            <select id="deleSelect" class="shortselect span">
                <c:forEach var="i" items="${colums}">
                    <option class="span" value=${i.colum_id}>${i.colum_name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="input_1"><input class="submit_1 inputd" type="button" value="提&nbsp;交" onclick="deleteColun()"></div>
    </form>
</div>
<div class="form_3" >
    <form method="post" action="">
        <div class="input_1"><div class="login_logo">修改分组</div><div class="close2">X</div></div>
        <hr>
        <div>
            <select id="updSelect" class="shortselect span">
                <c:forEach var="i" items="${colums}">
                    <option class="span" value=${i.colum_id}>${i.colum_name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="input_1"><input id="uName"  class="inputd" type="text" placeholder="&nbsp;更改姓名"></div>
        <div class="input_1"><input id="uPor" class="inputd" type="text" placeholder="&nbsp;更改优先级"></div>
        <div class="input_1"><input class="submit_1 inputd" type="button" value="提&nbsp;交" onclick="updateColun()"></div>
    </form>
</div>
<div class="form_4" >
    <form method="post" action="">
        <div class="input_1"><div class="login_logo">添加好友</div><div class="close3">X</div></div>
        <hr>
        <div>
            <select id="addSelect" class="shortselect span">
                <c:forEach var="i" items="${colums}">
                    <option class="span" value=${i.colum_id}>${i.colum_name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="input_1"><input id="addusername" class="inputd" type="text" placeholder="&nbsp;用户名" onblur="haveUser()"></div>
        <div class="input_1"><input id="addmessage" class="inputd" type="text" placeholder="&nbsp;验证消息"></div>
        <div class="input_1"><input id="addnickname" class="inputd" type="text" placeholder="&nbsp;昵称"></div>
        <div class="input_1"><input class="submit_1 inputd" type="button" value="提&nbsp;交" onclick="putFriendMessage()"></div>
    </form>
</div>
<div class="container" style="margin: 0;padding: 0">
    <div class="row clearfix" style="margin: 0;padding: 0">
        <div class="col-md-6 column" style="margin: 0;padding: 0">
            <div class="form_5" style="position: absolute;left: 60px;bottom: 100px">
                <form method="post" action="">
                    <div class="input_1"><div class="login_logo">修改列级</div><div class="close4">X</div></div>
                    <hr>
                    <div>
                        <select id="updatecolum" class="shortselect span">
                            <c:forEach var="i" items="${colums}">
                                <option class="span" value=${i.colum_id}>${i.colum_name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="input_1"><span class="span" style="color: #333333"><span id="upcolumUsername"></span></span></div>
                    <div class="input_1"><input class="submit_1 inputd" type="button" value="提&nbsp;交" onclick="updateUserColum()"></div>
                </form>
            </div>
            <div class="form_6" style="position: absolute;left: 60px;bottom: 100px">
                <form method="post" action="">
                    <div class="input_1"><div class="login_logo">发送消息</div><div class="close5">X</div></div>
                    <hr>
                    <div class="span1" style="color: black">用户名：<span id="sendUser"></span></div>
                    <textarea id="text" style="resize: none;height: 100px;width: 280px"></textarea>
                    <div class="input_1"><input class="submit_1 inputd" type="button" value="发&nbsp;送" onclick="sendToUser()"></div>
                </form>
            </div>
            <h3>
               &nbsp; &nbsp;好友信息
            </h3>
            <div class="row clearfix" style="margin: 0;padding: 0">
                <div class="col-md-12 column">
                    <div id="informat" >
                        <div class="d" id="imgtext" style="display: none;margin-top: 30px">
                                <span id="imgspan" style="color: blue">您的好友未上传头像</span>
                                <img class="im" id="images" alt="" >

                        </div>
                        <br>
                       <div> <span id="username" class="span1" ></span></div>
                        <br>
                        <div> <span id="name" class="span1" ></span></div>
                        <br>
                        <div> <span id="sex" class="span1" ></span></div>
                        <br>
                        <div> <span id="create" class="span1" ></span></div>
                        <br>
                        <div> <span id="school" class="span1" ></span></div>
                        <br>
                        <div> <span id="number" class="span1" ></span></div>
                        <br>
                        <div> <span id="columName" class="span1" ></span></div>
                        <div id="bott" class="bott" style="display: none">
                            <button id="btn_5" class="button" onclick="showupdateUserColum()">修改列级</button>
                            <button class="button" onclick="deletefriend()">删除好友</button>
                            <button id="btn_6" class="button" onclick="showsend()">发送消息</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6 column " style="height: 100%;border: #333333 1px solid " >
            <h3>好友列表</h3>
            <div class="progress progress-striped">
                <div class="progress-bar progress-success">
                </div>
            </div>
           <span class="span" style="font-weight: bolder" onclick="search()">搜索</span> &nbsp;<input id="searchUser" type="text"/>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <span class="span" style="font-weight: bolder" id="btn_4" onclick="addfriend()">添加好友</span>&nbsp;
            <br>
            <br>
            <div id="sidebar">
                <ul>
                    <c:forEach var="i" items="${colums}">
                        <li class="submenu">
                            <a><table>
                                <tr onclick="getlist(this)">
                                    <td style="display: none">${i.username}</td>
                                    &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;
                                    <td style="display: none">${i.colum_id}</td>
                                    &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;
                                    <td class="span" style="font-weight: bolder">${i.colum_name}</td>
                                    &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;
                                    <td class="span" style="font-weight: bolder">${i.pro}</td>
                                    <td class="span" style="font-weight: bolder">${i.num}</td>
                                </tr>
                            </table></a>
                            <ul style="display: none;" class="goto">
                            </ul>
                        </li>
                    </c:forEach>
                    <br>
                    <li><a><img id="btn_1" style="width: 40px;height: 40px" src="${pageContext.request.contextPath}/static/img/add.png">
                        &nbsp; &nbsp; &nbsp;
                        <img id="btn_2" style="width: 30px;height: 30px" src="${pageContext.request.contextPath}/static/img/delete.jpg">
                        &nbsp; &nbsp; &nbsp;
                        <img id="btn_3" style="width: 35px;height: 35px" src="${pageContext.request.contextPath}/static/img/friupdate.jpg">
                    </a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<script>
    var urldomain="${pageContext.request.contextPath}";
    $(function () {
        $('.submenu>a').click(
            function (e) {
                e.preventDefault();//阻止点击a的默认动作
                var li = $(this).parents('li');
                var li_s = $('#sidebar .submenu');//所有.submenu的li目录
                var ul_s = $('#sidebar .submenu >ul');//所有.submenu 的下级ul目录
                var ul = $(this).siblings('ul');//遍历a元素的兄弟元素（限制为ul）
                if (li.hasClass('open')){  //假如点击的那个链接有open类，那么下拉菜单向上滑动，移除open类
                    ul.slideUp();
                    li.removeClass('open');
                }else{ //假如点击的那个链接没有open类，首先对所有的下拉菜单都让其收起来。然后点击的那个下拉，所有的li目录移除open类，点击的那个添加open类
                    ul_s.slideUp();
                    ul.slideDown();
                    li_s.removeClass('open')
                    li.addClass('open')
                }
            }
        )
    })

</script>
</body>
</html>
