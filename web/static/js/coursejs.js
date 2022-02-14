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
function addPage(){
    var nowValue=$(".active").val()
    var begin=nowValue*10;
    var end=(nowValue+1)*10;
    if(nowValue>pagenumber-1)
        alert("当前是最后一页")
    else{
        $.post({
            url:urldomain+"/golimitcourse",
            data:{"username":username,"begin":begin,"end":end},
            success:function (data){
                var json=eval(data);
                var con="";
                for (var i=0;i<json.length;i++)
                {
                    con+="<tr onclick='getCourseinf(this)'><td>"+json[i].course_id+"</td>"
                        +"<td>"+json[i].title+"</td><td>"+json[i].create_user+"</td><td>"+
                        new Date(Number(json[i].create_time))+"</td><td>"+json[i].into_number+"</td><td><a>进入课程</a></td></tr>"
                }
                $("#tbody").html(con);
                $("#page"+nowValue).removeClass("active");
                $("#page"+(nowValue+1)).addClass("active");
            },
            error:function (data){
                alert("未得到")
            }
        })
    }
}
function dePage(){
    var nowValue=$(".active").val()
    var begin=(nowValue-2)*10;
    var end=(nowValue-1)*10;
    if(nowValue===1)
        alert("当前是第一页")
    else{
        $.post({
            url:urldomain+"/golimitcourse",
            data:{"username":username,"begin":begin,"end":end},
            success:function (data){
                var json=eval(data);
                var con="";
                for (var i=0;i<json.length;i++)
                {
                    con+="<tr onclick='getCourseinf(this)'><td>"+json[i].course_id+"</td>"
                        +"<td>"+json[i].title+"</td><td>"+json[i].create_user+"</td><td>"+
                        new Date(Number(json[i].create_time))+"</td><td>"+json[i].into_number+"</td><td><a>进入课程</a></td></tr>"
                }
                $("#tbody").html(con);
                $("#page"+nowValue).removeClass("active");
                $("#page"+(nowValue-1)).addClass("active");
            },
            error:function (data){
                alert("未得到")
            }
        })
    }
}
function thisPage(element){
    var nowValue=$(".active").val()
    var thisValue=element.value;
    var begin=(thisValue-1)*10;
    var end=(thisValue)*10;
    $.post({
        url:urldomain+"/golimitcourse",
        data:{"username":username,"begin":begin,"end":end},
        success:function (data){
            var json=eval(data);
            var con="";
            for (var i=0;i<json.length;i++)
            {
                con+="<tr onclick='getCourseinf(this)'><td>"+json[i].course_id+"</td>"
                    +"<td>"+json[i].title+"</td><td>"+json[i].create_user+"</td><td>"+
                    new Date(Number(json[i].create_time))+"</td><td>"+json[i].into_number+"</td><td><a>进入课程</a></td></tr>"
            }
            $("#tbody").html(con);
            $("#page"+nowValue).removeClass("active");
            $("#page"+thisValue).addClass("active");
        },
        error:function (data){
            alert("未得到")
        }
    })
}
function closeIt(){
    var form_2=document.getElementsByClassName("form_2");
    form_2[0].className="form_2";
}
function getCourseinf(element){
    var courseid=element.children[0].innerHTML;
    showinf(courseid)
}
function showinf(courseid){
    var form_2=document.getElementsByClassName("form_2");
    $.post({
        url:urldomain+"/getcourseinformation",
        data:{"courseid":courseid},
        success:function (data){
            var json=JSON.parse(data);
            var course=json.course;
            $("#org_id").html(course.course_id);
            $("#create_username").html(course.create_user);
            $("#create_time").html(dateTime(new Date(Number(course.create_time))));
            $("#org_name").html(course.title);
            $("#content").html(course.description);
            $("#into_number").html(course.into_number);
            var users=json.users;
            var con="";
            for(var i=0;i<users.length;i++)
            {
                con+="<tr>" +
                    "<td>"+users[i].username+"</td>" +
                    "<td>"+ users[i].name+"</td>" +
                    "<td>"+users[i].number+"</td>" +
                    "<td>"+ users[i].classes+"</td>" +
                    "<td>"+users[i].school+"</td>" +
                    "</tr>";
            }
            $("#userlist").html(con);
            form_2[0].className="form_2 open";
        }
    })
}
function addcourse(){
    var course_id=$("#addOrg").val();
    $.post({
        url:urldomain+"/addcourse",
        data:{"course_id":course_id,"username":username},
        success:function (data){
            if (data==="no")
            {
                alert("该组织不存在");
                window.location.reload();
            }
            else if(data==="no1")
            {
                alert("您被强制退出该课程。");
            }
            else{
                alert("添加成功");
                window.location.reload();
            }
        }
    })
}
function exitOrg(){
    var courseid=$("#org_id").html();
    $.post({
        url:urldomain+"/exitcourse",
        data:{"courseid":courseid,"username":username},
        success:function (data){
            alert("退出成功");
            window.location.reload();
        }
    })
}
function search(){
    var courseid=$("#searchOrg").val();
    $.post({
        url:urldomain+"/isInCourse",
        data:{"username":username,"courseid":courseid},
        success:function (data){
            if(data==="n")
                alert("您未加入该组织");
            else{
                showinf(courseid);
            }
        }
    })
}
function intoThisclass(element){
    var course_id=element.children[0].innerHTML;
    var url=urldomain+"/IntoMyCourse?username="+username+"&course_id="+course_id.substr(1,course_id.length-1);
    window.open(url);
}