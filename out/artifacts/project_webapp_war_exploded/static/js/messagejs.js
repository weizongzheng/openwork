function dateTime(dateTime){
    var year = dateTime.getFullYear();
    var month = dateTime.getMonth() + 1;
    var day = dateTime.getDay()+3;
    var hour = dateTime.getHours();
    var min = dateTime.getMinutes();
    var ss = dateTime.getMilliseconds();
    return year+"-"+addZero(month) + "-" + addZero(day) +" "+ addZero(hour) + ":" + addZero(min)
}
function addZero(num){
    var str = JSON.stringify(num);
    if(str.length <= 1){
        str = '0'+str
    }
    return str
}
function liMess(){
    over=1;
    $("#mess").addClass("active");
    $("#demess").removeClass("active");
    $.post({
        url:urldomain+"/getReadedMessage",
        data:{"username":username,"readed":over},
        success:function (data){
            var map=JSON.parse(data);
            $("#friendMe").innerHTML='';
            $("#friendMe").html(map.friendread);
            $("#courseMe").innerHTML='';
            $("#courseMe").html(map.courseread);
            $("#OrgMe").innerHTML='';
            $("#OrgMe").html(map.orgread);
        }
    })
}
function liDeMess(){
    over=0;
    $("#mess").removeClass("active");
    $("#demess").addClass("active");
    $.post({
        url:urldomain+"/getReadedMessage",
        data:{"username":username,"readed":over},
        success:function (data){
            var map=JSON.parse(data);
            $("#friendMe").innerHTML='';
            $("#friendMe").html(map.friendread);
            $("#courseMe").innerHTML='';
            $("#courseMe").html(map.courseread);
            $("#OrgMe").innerHTML='';
            $("#OrgMe").html(map.orgread);
        }
    })
}
function friendMelist(){
    $.post({
        url:urldomain+"/getfriendMelist",
        data:{"username":username,"readed":over},
        success:function (data){
            var json=JSON.parse(data)
            var friendlist=json.friendMessageList;
            var namelist=json.name;
            var con="";
            for(var i=0;i<friendlist.length;i++){
                var s1=friendlist[i].m_username;
                var s2=namelist[i];
                var s3=friendlist[i].create_time;
                var create=new Date(Number(s3))
                con+=  ("<li> <a> <span class='span' onclick='showIt1(this)'>" +
                    "&nbsp;&nbsp;&nbsp;&nbsp;<span style='color: #333333'>"+"发起用户名：<span>"+s1+
                    "</span></span>&nbsp;&nbsp;&nbsp;&nbsp;<span style='color: #333333'>"+"真实姓名:"+s2+
                    "</span>&nbsp;&nbsp;&nbsp;&nbsp;<span style='display:none'>"+s3+"</span><span style='color: #333333'>"+"发起时间："+dateTime(create)+
                    "</span></span></a></li>")
            }
            $("#friendmess").html(con)
        },
        error:function (data){
            alert("未得到");
        }
    })
}
function courseMelist(){
    $.post({
        url:urldomain+"/getcourseMelist",
        data:{"username":username,"readed":over},
        success:function (data){
            var json=JSON.parse(data)
            var courselist=json.courseMessageList;
            var namelist=json.name;
            var unamelist=json.uname;
            var urealnamelist=json.urealname;
            var con="";
            for(var i=0;i<courselist.length;i++){
                var s1=courselist[i].course_id;
                var s2=namelist[i];
                var s3=courselist[i].create_time;
                var s4=unamelist[i];
                var s5=urealnamelist[i];
                var create=new Date(Number(s3))
                con+=  ("<li> <a> <span class='span' onclick='showItCourse(this)'>" +
                    "&nbsp;&nbsp;&nbsp;&nbsp;<span style='color: #333333'>"+"课程id：<span>"+s1+
                    "</span></span>&nbsp;&nbsp;&nbsp;&nbsp;<span style='color: #333333'>"+"课程名:"+s2+
                    "</span>&nbsp;&nbsp;&nbsp;&nbsp;<span style='color: #333333'>"+"创建用户名:"+s4+
                    "</span>&nbsp;&nbsp;&nbsp;&nbsp;<span style='color: #333333'>"+"创建真实姓名:"+s5+
                "</span>&nbsp;&nbsp;&nbsp;&nbsp;<span style='color: #333333'>"+"创建时间：<span style='display: none'>"+create+
                    "</span>"+dateTime(create)+"</span></span></a></li>")
            }
            $("#classmess").html(con)
        },
        error:function (data){
            alert("未得到")
        }
    })
}
function orgMelist(){
    $.post({
        url:urldomain+"/getorgMelist",
        data:{"username":username,"readed":over},
        success:function (data){
            var json=JSON.parse(data)
            var courselist=json.OrgMessageList;
            var namelist=json.name;
            var unamelist=json.uname;
            var urealnamelist=json.urealname;
            var con="";
            for(var i=0;i<courselist.length;i++){
                var s1=courselist[i].org_id;
                var s2=namelist[i];
                var s3=courselist[i].create_time;
                var s4=unamelist[i];
                var s5=urealnamelist[i];
                var create=new Date(Number(s3))
                con+=  ("<li> <a> <span class='span' onclick='showItOrg(this)'>" +
                    "&nbsp;&nbsp;&nbsp;&nbsp;<span style='color: #333333'>"+"组织id："+"<span>" +s1+
                    "</span>"+
                    "</span>&nbsp;&nbsp;&nbsp;&nbsp;<span style='color: #333333'>"+"组织名:"+s2+
                    "</span>&nbsp;&nbsp;&nbsp;&nbsp;<span style='color: #333333'>"+"创建用户名:"+s4+
                    "</span>&nbsp;&nbsp;&nbsp;&nbsp;<span style='color: #333333'>"+"创建真实姓名:"+s5+
                    "</span>&nbsp;&nbsp;&nbsp;&nbsp;<span style='display:none;'>"+create+"</span><span style='color: #333333'>"+"创建时间："+dateTime(create)+
                    "</span></span></a></li>")
            }
            $("#organizmess").html(con)
        },
        error:function (data){
            alert("未得到")
        }
    })
}
function showIt1(element){
    $("#back").css("display","none")
    $("#messd").css("visibility","visible")
    var m_username=element.children[0].children[0].innerHTML;
    var create=element.children[2].innerHTML;
    $.post({
        url:urldomain+"/getFriendRequestInformation",
        data:{"m_username":m_username,"username":username,"readed":over,"create":new Date(Number(create))},
        success:function (data){
            var json=JSON.parse(data);
           var friendMessagelocal=json.friendMessage;
            var name=json.name;
            var colums=json.colums;
            var con="";
            for(var i=0;i<colums.length;i++){
                var s1=colums[i].colum_name;
                var s2=colums[i].colum_id;
                con+=  ("<option class='span' style='color: #333333 'value='"+s2+"'>"+s1+"</option>");
            }
            friendMessage=friendMessagelocal;
            $("#invenmessage").html(friendMessagelocal.content)
            $("#friendselect").html(con)
            $("#fquser").html(m_username);
            $("#fquname").html(name);
            if(friendMessagelocal.isok===-1)
            {
                $("#status").css("color","yellow")
                $("#status").html("代处理")
            }
            if(friendMessagelocal.isok===0)
            {
                $("#status").css("color","red")
                $("#status").html("已拒绝")
            }
            if(friendMessagelocal.isok===1)
            {
                $("#status").css("color","green")
                $("#status").html("已同意")
            }
            if(friendMessagelocal.isok!==-1)
            {
                $("#nofriend").css("visibility","hidden")
                $("#okfriend").css("visibility","hidden")
                $("#nickname").css("visibility","hidden")
                $("#friendselect").css("visibility","hidden")
                $("#overIt1").css("visibility","visible")
                if(friendMessagelocal.isok==2){//好友消息
                    $("#messd").css("visibility","hidden")
                    $("#back").css("display","")
                }
            }
            else {
                $("#nofriend").css("visibility","visible")
                $("#okfriend").css("visibility","visible")
                $("#nickname").css("visibility","visible")
                $("#friendselect").css("visibility","visible")
                $("#overIt1").css("visibility","hidden")
            }
            $("#form_1").css("visibility","visible")
        }
    })
}
function close1(){
    $("#form_1").css("visibility","hidden")
    $("#nofriend").css("visibility","hidden")
    $("#okfriend").css("visibility","hidden")
    $("#nickname").css("visibility","hidden")
    $("#friendselect").css("visibility","hidden")
    $("#overIt1").css("visibility","hidden")
    $("#back").css("display","none")
    $("#messd").css("visibility","hidden")
}
function close2(){
    $("#form_2").css("visibility","hidden")
    $("#nofriend2").css("visibility","hidden")
    $("#okfriend2").css("visibility","hidden")
    $("#nickname2").css("visibility","hidden")
    $("#friendselect2").css("visibility","hidden")
    $("#overIt2").css("visibility","hidden")
}
function close3(){
    $("#form_3").css("visibility","hidden")
    $("#overIt3").css("visibility","hidden")
}
function addfriend1(){
    var nickname=$("#nickname").val();
    var obj = document.getElementById("friendselect");
    var index=obj.selectedIndex;
    var columId=obj.options[index].value;
    friendMessage.nickname=nickname;
    friendMessage.colum_id=columId;
    $.post({
        url:urldomain+"/addfriend",
        data:{"m_username":friendMessage.m_username,"username":friendMessage.username
            ,"create_time":new Date(Number(friendMessage.create_time)),"readed":Number(friendMessage.readed),
            "content":friendMessage.content,"m_colum_id":friendMessage.m_colum_id,
            "colum_id":friendMessage.colum_id,"m_nickname":friendMessage.m_nickname,
            "nickname":friendMessage.nickname,"isok":friendMessage.isok,
            "sub_time":friendMessage.sub_time},
        success:function (data)
        {
            alert("添加成功");
            if(over===0)
                readIt(new Date(Number(friendMessage.create_time)),friendMessage.m_username,"friend");
            window.location.reload()

        },
        error:function (data){
            alert("添加失败")
        }

    })
}
function readIt(create_time,m_username,message){
    $.post({
        url:urldomain+"/alertRead",
        data:{"username":username,"m_username":m_username,"create_time":create_time,"message":message},
        success:function (data)
        {
            window.location.reload();
        }
    })
}
function refuse(){
    var nickname=$("#nickname").val();
    var obj = document.getElementById("friendselect");
    var index=obj.selectedIndex;
    var columId=obj.options[index].value;
    friendMessage.nickname=nickname;
    friendMessage.colum_id=columId;

    $.post({
        url:urldomain+"/refusefriend",
        data:{"m_username":friendMessage.m_username,"username":friendMessage.username
            ,"create_time":new Date(Number(friendMessage.create_time)),"readed":Number(friendMessage.readed),
            "content":friendMessage.content,"m_colum_id":friendMessage.m_colum_id,
            "colum_id":friendMessage.colum_id,"m_nickname":friendMessage.m_nickname,
            "nickname":friendMessage.nickname,"isok":friendMessage.isok,
            "sub_time":friendMessage.sub_time},
        success:function (data)
        {
            if(over===0)
                readIt(new Date(Number(friendMessage.create_time)),friendMessage.m_username,"friend");
            window.location.reload()

        },
        error:function (data){
        }
    })

}
function okIt(){
    if(over===0){
        readIt(new Date(Number(friendMessage.create_time)),friendMessage.m_username,"friend");
        window.location.reload()
    }
    close1();
}
function okIt1(){
    var org_id= $("#org_id").html();
    var create_time=$("#org_create").html();
    if(over===0)
    {
        $.post({
            url:urldomain+"/Read_Org",
            data:{"org_id":org_id,"username":username,"create_time":create_time},
            success:function (data){
                close2();
                window.location.reload();
            }
        })
    }
    else{
        close2();
    }
}
function okIt3(){
    var course_id= $("#course_id").html();
    var create_time=$("#course_create").html();
    if(over===0)
    {
        $.post({
            url:urldomain+"/Read_Course",
            data:{"course_id":course_id,"username":username,"create_time":create_time},
            success:function (data){
                close2();
                window.location.reload();
            }
        })
    }
    else{
        close3();
    }
}
function showItOrg(element){
    var org_id=element.children[0].children[0].innerHTML;
    var create=element.children[4].innerHTML;
    $.post({
        url:urldomain+"/getOrgInformation",
        data:{"org_id":org_id,"username":username,"create":create,"readed":over},
        success:function (data){
           var json= JSON.parse(data);
           var org=json.org;
           OrgMessage=json.orgMessage;
           var orgMessagelocal=json.orgMessage;
           $("#org_id").html(org.org_id);
           $("#org_name").html(org.org_name);
           $("#content").html(org.content);
           $("#org_create").html(new Date(Number(orgMessagelocal.create_time)));
           $("#org_reason").html(orgMessagelocal.content);
           $("#overIt2").css("visibility","visible");
           $("#form_2").css("visibility","visible");
        }
    })
}
function showItCourse(element){
    var course_id=element.children[0].children[0].innerHTML;
    var create=element.children[4].children[0].innerHTML;
    $.post({
        url:urldomain+"/getCourseInformation",
        data:{"course_id":course_id,"username":username,"create":create,"readed":over},
        success:function (data){
            var json= JSON.parse(data);
            var course=json.course;
            CourseMessage=json.courseMessage;
            var courseMessage=json.courseMessage;
            $("#course_id").html(course.course_id);
            $("#course_name").html(course.title);
            $("#course_content").html(course.description);
            $("#course_create").html(new Date(Number(courseMessage.create_time)));
            $("#course_reason").html(courseMessage.content);
            $("#overIt3").css("visibility","visible");
            $("#form_3").css("visibility","visible");
        }
    })
}
function deleteFriendIt(){
    if(!confirm("确认要删除？")){
        window.event.returnValue = false;
    }
    if(window.event.returnValue) {
        var m_username = $("#fquser").html();
        var createtime = new Date(friendMessage.create_time);
        $.post({
            url: urldomain + "/deleteFriendMessage",
            data: {"createtime": createtime, "username": username, "m_username": m_username},
            success: function (data) {
                alert("删除成功！");
                window.location.reload();
            }
        })
    }
}
function deleteOrgIt(){
    if(!confirm("确认要删除？")){
        window.event.returnValue = false;
    }
    if(window.event.returnValue) {
        var  org_id= $("#org_id").html();
        var createtime = new Date(OrgMessage.create_time);
        $.post({
            url: urldomain + "/deleteOrgMessage",
            data: {"createtime": createtime, "username": username, "org_id": org_id},
            success: function (data) {
                alert("删除成功！");
                window.location.reload();
            }
        })
    }
}
function deleteCourseIt(){
    if(!confirm("确认要删除？")){
        window.event.returnValue = false;
    }
    if(window.event.returnValue) {
        var  course_id= $("#course_id").html();
        var createtime = new Date(CourseMessage.create_time);
        $.post({
            url: urldomain + "/deleteCourseMessage",
            data: {"createtime": createtime, "username": username, "course_id": course_id},
            success: function (data) {
                alert("删除成功！");
                window.location.reload();
            }
        })
    }
}
function backMessage(){
    $("#form_6").css("visibility","visible");
    $("#form_1").css("visibility","hidden");
    $("#overIt1").css("visibility","hidden");
    $("#sendUser").html($("#fquser").html());

}
function close5(){
    $("#form_6").css("visibility","hidden");
}
function sendToUser(){
    var Tousername= $("#sendUser").html();
    var text=$("#text").val();
    var formData = new FormData();
    formData.append("username",Tousername);
    formData.append("m_username",username);
    formData.append("text",text);
    $.post({
        url:urldomain+"/sendToUser",
        data:formData,
        processData: false,
        contentType : false,
        success:function (data){
            alert("发送成功！");
        },
        error:function (data){
            alert("发送失败！");
            window.location.reload();
        }
    })
    if(over===0){
        readIt(new Date(Number(friendMessage.create_time)),friendMessage.m_username,"friend");
        window.location.reload()
    }
    close5();
}