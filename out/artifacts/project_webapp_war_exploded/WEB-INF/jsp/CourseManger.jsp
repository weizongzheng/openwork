<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
    <script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/coursemanger.css">
    <script  src="${pageContext.request.contextPath}/static/js/cousemangerjs.js"></script>
</head>
<body>
<div class="form_1" >
    <form method="post" action="">
        <div class="input_1"><div class="login_logo">选择好友</div><div class="close" onclick="closeIt()">X</div></div>
        <hr>
        <div id="contenter1" style="overflow-x:auto;margin-bottom: 50px">
            <div id="fixedDiv1">
                <table id="fixedTab1" class="fixedTable" border="1" cellpadding="0" cellspacing="0">
                    <thead>
                    <tr>
                        <th>用户名</th>
                        <th>姓名</th>
                        <th>学号</th>
                        <th>昵称</th>
                        <th>选择</th>
                    </tr>
                    </thead>
                </table>
            </div>
            <div id="mainDiv1">
                <table id="grid1" class="fixedTable" border="1" cellpadding="0" cellspacing="0">
                    <thead style="">
                    <tr>
                        <th>用户名</th>
                        <th>姓名</th>
                        <th>学号</th>
                        <th>昵称</th>
                        <th>选择</th>
                    </tr>
                    </thead>
                    <tbody id="userlist1" style="margin: 0;padding: 0;">
                    <c:forEach var="i"  items="${users}" varStatus="loop">
                        <tr class="selecttr">
                            <td>${i.username}</td>
                            <td>${i.name}</td>
                            <td>${i.number}</td>
                            <td>${friends[loop.index].nickname}</td>
                            <td><input class="selectcheckbox" type="checkbox" value="${i.username}"></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="input_1"><input class="submit_1 inputd" type="button" value="确&nbsp;认" onclick="selectfriend()"></div>
    </form>
</div>
<div class="form_2" >
    <form method="post" action="">
        <div class="input_1"><div class="login_logo">选择好友</div><div class="close" onclick="closeIt2()">X</div></div>
        <hr>
        <div id="contenter4" style="overflow-x:auto;margin-bottom: 50px">
            <div id="fixedDiv4">
                <table id="fixedTab4" class="fixedTable" border="1" cellpadding="0" cellspacing="0">
                    <thead>
                    <tr>
                        <th>组织ID</th>
                        <th>组织名</th>
                        <th>创建者</th>
                        <th>选择</th>
                    </tr>
                    </thead>
                </table>
            </div>
            <div id="mainDiv4">
                <table id="grid4" class="fixedTable" border="1" cellpadding="0" cellspacing="0">
                    <thead style="">
                    <tr>
                        <th>组织ID</th>
                        <th>组织名</th>
                        <th>创建者</th>
                        <th>选择</th>
                    </tr>
                    </thead>
                    <tbody id="orglist1" style="margin: 0;padding: 0;">
                    <c:forEach var="i"  items="${orgs}" varStatus="loop">
                        <tr class="selectOrgtr">
                            <td>${i.org_id}</td>
                            <td>${i.org_name}</td>
                            <td>${i.create_username}</td>
                            <td><input class="selectOrgcheckbox" type="checkbox" value="${i.org_id}"></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="input_1"><input class="submit_1 inputd" type="button" value="确&nbsp;认" onclick="selectOrg()"></div>
    </form>
</div>
<div id="global">
    <div id="heading"><h1>课程管理与创建</h1></div>
    <div id="content1" style="" class="content_menu">
        <div class="titl"><span class="span2" style="font-size: 30px"> 创建课程</span></div>
        <div class="iteam"><span class="span3">课程ID</span><input id="org_id" type="text" class="input_1 inputd" value="#"/></div>
        <div class="iteam"><span class="span3">课程名称</span><input id="org_name" type="text" class="input_1 inputd"/></div>
        <div class="iteam"><span class="span3">课程公告</span><input id="content" type="text" class="input_1 inputd"/></div>
        <div style="margin-bottom: 20px">
            <div class="iteam" style="float: left;margin-top: 30px">
                <span class="span3">课程人员添加</span>
                <input type="button" value="选择好友" onclick="showIt()" class="input_1 inputd"/>
                <input type="button" value="选择组织" onclick="showItformOrg()" class="input_1 inputd"/>
            </div>
            <div>
            <div id="contenter" style="overflow-x:auto;float: left;margin-bottom: 50px">
                <div id="fixedDiv">
                    <table id="fixedTab" class="fixedTable" border="1" cellpadding="0" cellspacing="0">
                        <thead>
                        <tr>
                            <th>用户名</th>
                            <th>姓名</th>
                            <th>学号</th>
                            <th>昵称</th>
                            <th>操作</th>
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
                            <th>昵称</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody id="userlist" style="margin: 0;padding: 0">
                        <c:forEach var="i"  items="${users}" varStatus="loop">
                            <tr class="showtr" style="display: none">
                                <td>${i.username}</td>
                                <td>${i.name}</td>
                                <td>${i.number}</td>
                                <td>${friends[loop.index].nickname}</td>
                                <td><a onclick="deselsect(this)"><span style="display: none">${loop.index}</span>删除</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div id="contenter3" style="overflow-x:auto;float: left;margin-bottom: 50px">
                <div id="fixedDiv3">
                    <table id="fixedTab3" class="fixedTable" border="1" cellpadding="0" cellspacing="0">
                        <thead>
                        <tr>
                            <th>组织ID</th>
                            <th>组织名</th>
                            <th>创建者</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                    </table>
                </div>
                <div id="mainDiv3">
                    <table id="grid3" style="margin:0px;table-layout:fixed;" class="fixedTable" border="1" cellpadding="0" cellspacing="0">
                        <thead style="">
                        <tr>
                            <th>组织ID</th>
                            <th>组织名</th>
                            <th>创建者</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody id="orglist" style="margin: 0;padding: 0">
                        <c:forEach var="i"  items="${orgs}" varStatus="loop">
                            <tr class="orgshowtr" style="display: none">
                                <td>${i.org_id}</td>
                                <td>${i.org_name}</td>
                                <td>${i.create_username}</td>
                                <td><a onclick="deOrgselsect(this)"><span style="display: none">${loop.index}</span>删除</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            </div>
        </div>
        <div class="input_1" style="text-align: center;bottom: 20px;"><input class="submit_1 inputd" type="button" value="提&nbsp;交" onclick="createcourse()"></div>
    </div>
    <div id="content2"  style="display: none" class="content_menu">
        <div class="titl"><span class="span2" style="font-size: 30px"> 我的课程</span></div>
        <div class="iteam"><span class="span3">课程ID:</span><span id="org_id_inf" class="span3"></span></div>
        <div class="iteam"><span class="span3">课程名称:</span><input id="org_name_inf" class="span3">
            <input type="button" onclick="upCourseName()" value="更改名称">
        </div>
        <div class="iteam"><span class="span3">课程公告:</span><input id="org_content_inf" class="span3">
            <input type="button" onclick="upContent()" value="更改公告">
        </div>
        <div class="iteam"><span class="span3">课程人数:</span><span id="org_num_inf" class="span3"></span></div>
        <div style="margin-top: 35px"><input style="margin-left: 190px"  id="addusername" type="text" >&nbsp;&nbsp;&nbsp;
            <input type="button" value="添加人员" onclick="addUsertoCourse()"></div>
        <div style="margin-bottom: 50px">
            <div class="iteam" style="float: left;margin-top: 150px">
                <span class="span3">课程人员列表</span>
            </div>
            <div id="contenter2" style="overflow-x:auto;float: left;margin-bottom: 50px">
                <div id="fixedDiv2">
                    <table id="fixedTab2" class="fixedTable" border="1" cellpadding="0" cellspacing="0">
                        <thead>
                        <tr>
                            <th>用户名</th>
                            <th>姓名</th>
                            <th>学号</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                    </table>
                </div>
                <div id="mainDiv2">
                    <table id="grid2" style="margin:0px;table-layout:fixed ;" class="fixedTable" border="1" cellpadding="0" cellspacing="0">
                        <thead style="">
                        <tr>
                            <th>用户名</th>
                            <th>姓名</th>
                            <th>学号</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody id="userlist3" style="margin: 0;padding: 0">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="input_1" style="text-align: center;bottom: 20px"><input class="submit_1 inputd" type="button" value="进入&nbsp;课程" onclick="intoMyCourse()"></div>
        <div class="input_1" style="text-align: center;bottom: 20px"><input class="submit_1 inputd" type="button" value="解散&nbsp;课程" onclick="deleCourse()"></div>
    </div>
    <div id="content_body">
        <ul>
            <li onclick="showCreate()"><div class="paw" > <span class="span2">创建课程</span></div></li>
            <li id="showlist">
                <div class="paw" onclick="showlist()"> <span class="span2">我创建的课程</span></div>
                <ul style="display: none;" id="listUl"> </ul>
            </li>
        </ul>
    </div>
</div>
</body>
<script>
    var urldomain="${pageContext.request.contextPath}";
    var username="${username}";
</script>
</html>
