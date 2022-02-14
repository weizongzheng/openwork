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
function getfriendinf(element){
    $("#bott").css("display","");
    $("#imgtext").css("display","");
    $("#imgspan").html("");
    $("#images").attr("src", "");
    var userid=element.children[0].innerHTML;
    var create=element.children[1].innerHTML;
    var m_username=document.getElementById("u1").value;
    create= new Date(Number(create))
    create=dateTime(create)
    $.post({
        url:urldomain+"/getfriendinf",
        data:{"username":userid,"m_username":m_username},
        success:function (data){
            var json=JSON.parse(data);
           // alert(json.columName)
            var user=json.user;
            var img=json.pUrl;
            if(img!=='no')
            {
                $("#images").attr("src", urldomain+"/"+img);
            }
            else{
                $("#imgspan").html("您的好友未上传头像");
            }
            $("#username").html("用户名："+user.username);
            $("#name").html("姓名："+user.name);
            $("#sex").html("性别："+user.sex);
            $("#create").html("添加时间："+create);
            $("#school").html("学校："+user.school);
            $("#number").html("学号："+user.number);
            $("#columName").html("从属列："+json.columName);
        }
    })
}
function getlist(element){
    var userid=element.children[0].innerHTML;
    var columid=element.children[1].innerHTML;
    $.post({
        url:urldomain+"/getlistfriend",
        data:{"username":userid,"colum":columid},
        success:function (data){
            var json=eval(data);
            var con="";
            for(var i=0;i<json.length;i++){
                var s1=json[i].username;
                var s2=json[i].nickname;
                var s3=json[i].create_time;
                con+=  (" <li> <a> <span class=\"span\" onclick='getfriendinf(this)'>" +
                    "&nbsp;&nbsp;&nbsp;&nbsp;<span>"+s1+"</span><span style='display: none;'>"+s3+
                    "</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>"+s2+
                    "</span></span></a></li>")
            }
            $(".goto").html(con)
        },
        error: function (data){
            alert("结果错误")
        }
    })
}
window.onload=function(){
    var btn_1=document.getElementById("btn_1");
    var close=document.getElementsByClassName("close");
    var form_1=document.getElementsByClassName("form_1");
    btn_1.addEventListener('click',function(){
        form_1[0].className="form_1 open";
    })
    close[0].addEventListener('click',function(){
        form_1[0].className="form_1";
    })
    var btn_2=document.getElementById("btn_2");
    var close1=document.getElementsByClassName("close1");
    var form_2=document.getElementsByClassName("form_2");
    btn_2.addEventListener('click',function(){
        form_2[0].className="form_2 open";
    })
    close1[0].addEventListener('click',function(){
        form_2[0].className="form_2";
    })
    var btn_3=document.getElementById("btn_3");
    var close2=document.getElementsByClassName("close2");
    var form_3=document.getElementsByClassName("form_3");
    btn_3.addEventListener('click',function(){
        form_3[0].className="form_3 open";
    })
    close2[0].addEventListener('click',function(){
        form_3[0].className="form_3";
    })
    var btn_4=document.getElementById("btn_4");
    var close3=document.getElementsByClassName("close3");
    var form_4=document.getElementsByClassName("form_4");
    btn_4.addEventListener('click',function(){
        form_4[0].className="form_4 open";
    })
    close3[0].addEventListener('click',function(){
        form_4[0].className="form_4";
    })
    var btn_5=document.getElementById("btn_5");
    var close4=document.getElementsByClassName("close4");
    var form_5=document.getElementsByClassName("form_5");
    btn_5.addEventListener('click',function(){
        form_5[0].className="form_5 open";
    })
    close4[0].addEventListener('click',function(){
        form_5[0].className="form_5";
    })
    var btn_6=document.getElementById("btn_6");
    var close5=document.getElementsByClassName("close5");
    var form_6=document.getElementsByClassName("form_6");
    btn_6.addEventListener('click',function(){
        form_6[0].className="form_6 open";
    })
    close5[0].addEventListener('click',function(){
        form_6[0].className="form_6";
    })
}
function  addColun(){
    $.post({
        url:urldomain+"/addColum",
        data:{"pro":$("#pro").val(),"colum_name":$("#colum_name").val(),"num":$("#num").val(),"username":$("#u1").val()},
        success:function (data){
            console.log(data)
            window.location.reload();
        }
    })
}
function  deleteColun(){
    var obj = document.getElementById("deleSelect");
    var index=obj.selectedIndex;
    var columId=obj.options[index].value;
    var username=document.getElementById("u1").value;
    if(index==0)
    {
        alert("优先级为0无法改动")
    }
    else {
        $.post({
            url: urldomain + "/deleteColum",
            data: {"conlumId": columId, "username": username},
            success: function (data) {
                console.log(data)
                window.location.reload();
            }
        })
    }
}
function  updateColun(){
    var obj = document.getElementById("updSelect");
    var index=obj.selectedIndex;
    var columId=obj.options[index].value;
    var username=document.getElementById("u1").value;
    var uName=document.getElementById("uName").value;
    var uPor=document.getElementById("uPor").value;
    if(index===0 && uPor!=='')
    {
        alert("优先级为0的优先级无法改动")
    }
    else if(Number(uPor)<=0 && uPor!=='')
    {
        alert("优先级无法修改为小于等于零的值")
    }
    else if ((uName==='')&&(uPor===''))
    {
      alert("请至少修改一项")
    }
    else {
        if(uName==='')
        {
            uName="；sldkssdlkskd；";
        }
        if(uPor==='')
        {
            uPor=0;
        }
        $.post({
            url: urldomain + "/updateColum",
            data: {"username":username,"columId":columId,"uName":uName,"uPor":uPor},
            success: function (data) {
                console.log(data)
                window.location.reload();
                     },
            error:function (data){
                alert("出现错误")
            }
        })
    }
}
function search(){
    var m_username=document.getElementById("u1").value;
    var username=$("#searchUser").val();
    $.post({
        url:urldomain+"/isFriend",
        data:{"m_username":m_username,"username":username},
        success:function (data){
            if(data==="no")
                alert("不存在该好友")
            else{
                $.post({
                    url:urldomain+"/searchFriendinf",
                    data:{"username":username,"m_username":m_username},
                    success:function (data){
                        var json=JSON.parse(data);
                        // alert(json.columName)
                        var create= new Date(Number(json.create))
                        create=dateTime(create)
                        var user=json.user;
                        $("#username").html("用户名："+user.username);
                        $("#name").html("姓名："+user.name);
                        $("#sex").html("性别："+user.sex);
                        $("#create").html("添加时间："+create);
                        $("#school").html("学校："+user.school);
                        $("#number").html("学号："+user.number);
                        $("#columName").html("从属列："+json.columName);
                    }
                })
            }
        }
    })
}
function haveUser(){
    var username=$("#addusername").val();
    $.post({
        url: urldomain + "/haveuser",
        data: {"username": username},
        success: function (data) {
            if (data === "no")
            {
                alert("不存在该用户");
                window.location.reload();
            }
        }
    })
}
function putFriendMessage(){
    var m_username=document.getElementById("u1").value;
    var addusername=$("#addusername").val();
    var addmessage=$("#addmessage").val();
    var addnickname=$("#addnickname").val();
    var obj = document.getElementById("addSelect");
    var index=obj.selectedIndex;
    var columId=obj.options[index].value;
    $.post({
        url: urldomain + "/putFriendMessage",
        data: {"username": addusername,"m_username": m_username,"addmessage": addmessage
            ,"addnickname": addnickname,"columId": columId},
        success:function (data){
            alert("消息已发送！")
            window.location.reload();
        }
    })
}
function showupdateUserColum(){
    $("#upcolumUsername").html($("#username").html());
}
function updateUserColum(){
    var m_username=document.getElementById("u1").value;
    var username=$("#upcolumUsername").html().substr(4);
    var obj = document.getElementById("updatecolum");
    var index=obj.selectedIndex;
    var columId=obj.options[index].value;
    $.post({
        url:urldomain + "/updateUserColum",
        data:{"m_username":m_username,"username":username,"columId":columId},
        success:function (data){
            alert("修改成功！");
            window.location.reload();
        }
    })
}
function deletefriend(){
    if(!confirm("确认要删除？请谨慎考虑！")){
        window.event.returnValue = false;
    }
    if(window.event.returnValue) {
        var username = $("#username").html().substr(4);
        var m_username = document.getElementById("u1").value;
        $.post({
            url:urldomain + "/deletefriend",
            data:{"m_username":m_username,"username":username},
            success:function (data){
                alert("删除成功！");
                window.location.reload();
            }
        })
    }
}
function showsend(){
    var username = $("#username").html().substr(4);
    $("#sendUser").html(username);
}
function sendToUser(){
    var Tousername=$("#sendUser").html();
    var text=$("#text").val();
    var formData = new FormData();
    formData.append("username",Tousername);
    formData.append("m_username",document.getElementById("u1").value);
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
    var form_6=document.getElementsByClassName("form_6");
    form_6[0].className="form_6";
}