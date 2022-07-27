<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/messagecss.css">
    <script  src="${pageContext.request.contextPath}/static/js/messagejs.js"></script>
    <script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.5.1.min.js"></script>
    <title>Title</title>
</head>
<body>
<div id="form_6" style="height: 378px">
    <form method="post" action="">
        <div class="input_1"><div class="login_logo">发送消息</div><div class="close5" onclick="close5()">X</div></div>
        <hr>
        <div class="span" style="color: black" >用户名：<span id="sendUser"></span></div>
        <textarea id="text" style="resize: none;height: 100px;width: 280px"></textarea>
        <div class="input_1"><input class="submit_1 inputd" type="button" value="发&nbsp;送" onclick="sendToUser()"></div>
    </form>
</div>
    <div id="form_1">
        <form >
            <div class="input_1"><div class="login_logo">好友请求</div><div id="close1" onclick="close1()">X</div></div>
            <hr>
            <div class="input_1"><span class="span" style="color: #333333">发起用户名:</span><span id="fquser" class="span" style="color: #333333"></span></div>
            <div class="input_1"><span class="span" style="color: #333333">发起人姓名:</span><span id="fquname" class="span" style="color: #333333"></span></div>
            <div class="input_1" ><span class="span" style="color: #333333">验证消息:</span><span id="invenmessage" class="span" style="color: #333333;font-weight: bolder"></span></div>
            <div class="input_1" id="messd"><span class="span" style="color: #333333">状态:</span><span id="status" class="span" style="color: #333333;font-weight: bolder"></span></div>
            <select class="span" style="color: #333333" id="friendselect">
            </select>
            <div class="input_1"><input id="nickname" type="text" placeholder="输入昵称"></div>
            <div class="input_1" id="back" style="display: none"><input  class="submit_1" type="button" value="回&nbsp;复" onclick="backMessage()"></div>
            <div class="input_1"><input id="overIt1" class="submit_1" type="button" value="确&nbsp;认" onclick="okIt()"></div>
            <div class="input_1"><input id="deleteIt1" class="submit_1" type="button" value="删&nbsp;除" onclick="deleteFriendIt()"></div>
            <div class="input_1"><input id="okfriend" class="submit_1" type="button" value="同&nbsp;意" onclick="addfriend1()"></div>
            <div class="input_1"><input id="nofriend" class="submit_1" type="button" value="拒&nbsp;绝" onclick="refuse()"></div>
        </form>
    </div>
    <div id="form_2" >
        <form >
            <div class="input_1"><div class="login_logo">组织消息</div><div id="close2" onclick="close2()">X</div></div>
            <hr>
            <div class="input_1"><span class="span" style="color: #333333">组织ID:</span><span id="org_id" class="span" style="color: #333333"></span></div>
            <div class="input_1"><span class="span" style="color: #333333">组织名称:</span><span id="org_name" class="span" style="color: #333333"></span></div>
            <div class="input_1"><span class="span" style="color: #333333">组织公告:</span><span id="content" class="span" style="color: #333333"></span></div>
            <div class="input_1"><span class="span" style="color: #333333">创建时间:</span><span id="org_create" class="span" style="color: #333333"></span></div>
            <div class="input_1"><span class="span" style="color: #333333">发送原因:</span><span id="org_reason" class="span" style="color: #333333;font-weight: bolder"></span></div>
            <div class="input_1"><input id="overIt2" class="submit_1" type="button" value="确&nbsp;认" onclick="okIt1()"></div>
            <div class="input_1"><input id="deleteIt2" class="submit_1" type="button" value="删&nbsp;除" onclick="deleteOrgIt()"></div>
        </form>
    </div>
    <div id="form_3" >
        <form >
            <div class="input_1"><div class="login_logo">课程消息</div><div id="close3" onclick="close3()">X</div></div>
            <hr>
            <div class="input_1"><span class="span" style="color: #333333">课程ID:</span><span id="course_id" class="span" style="color: #333333"></span></div>
            <div class="input_1"><span class="span" style="color: #333333">课程名称:</span><span id="course_name" class="span" style="color: #333333"></span></div>
            <div class="input_1"><span class="span" style="color: #333333">课程公告:</span><span id="course_content" class="span" style="color: #333333"></span></div>
            <div class="input_1"><span class="span" style="color: #333333">创建时间:</span><span id="course_create" class="span" style="color: #333333"></span></div>
            <div class="input_1"><span class="span" style="color: #333333">发送原因:</span><span id="course_reason" class="span" style="color: #333333;font-weight: bolder"></span></div>
            <div class="input_1"><input id="overIt3" class="submit_1" type="button" value="确&nbsp;认" onclick="okIt3()"></div>
            <div class="input_1"><input id="deleteIt3" class="submit_1" type="button" value="删&nbsp;除" onclick="deleteCourseIt()"></div>
        </form>
    </div>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <h3>
                <br>
                我的消息
                <br>
            </h3>
            <div class="progress">
                <div class="bar">
                </div>
            </div>
            <ul class="nav nav-tabs">
                <li id="mess" onclick="liMess()" class="active">
                    <a><span class="text">已读消息</span></a>
                </li>
                <li id="demess" onclick="liDeMess()">
                    <a><span class="text">未读消息</span><span class="badge badge-warning mess"><span id="noread" class="num">${sumNread}</span></span></a>
                </li>
            </ul>
            <div id="sidebar">
                <ul>
                    <li class="submenu">
                        <a>
                            <div class="progress lan" onclick="friendMelist()">
                                <div class="bar" >
                                   <span class="span"> 好 友 消 息<span id="friendMe" class="badge badge-warning">${friendNread}</span></span>
                                </div>
                            </div>
                        </a>
                        <ul style="display: none;" id="friendmess">
                        </ul>
                    </li>
                    <li class="submenu">
                        <a>
                                <div class="progress lan" onclick="courseMelist()">
                                    <div class="bar">
                                        <span class="span"> 课 程 消 息<span id="courseMe" class="badge badge-warning">${courseNread}</span></span>
                                    </div>
                                </div>
                        </a>
                        <ul style="display: none;" id="classmess">
                        </ul>
                    </li>
                    <li class="submenu">
                        <a>
                <div class="progress lan" onclick="orgMelist()">
                    <div class="bar">
                        <span class="span"> 组 织 消 息<span id="OrgMe" class="badge badge-warning">${orgNread}</span></span>
                    </div>
                </div>
                        </a>
                   <ul style="display: none;" id="organizmess">
                   </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<script>
    var friendMessage;
    var OrgMessage;
    var CourseMessage;
    var username="${username}";
    var over=1;
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
