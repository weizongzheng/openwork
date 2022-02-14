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
        url:urldomain+"/golimitorg",
        data:{"username":username,"begin":begin,"end":end},
        success:function (data){
            var json=eval(data);
            var con="";
            for (var i=0;i<json.length;i++)
            {
                con+="<tr onclick='getOrginf(this)'><td>"+json[i].org_id+"</td>"
                    +"<td>"+json[i].org_name+"</td><td>"+json[i].create_username+"</td><td>"+
                    new Date(Number(json[i].create_time))+"</td><td>"+json[i].into_number+"</td></tr>"
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
            url:urldomain+"/golimitorg",
            data:{"username":username,"begin":begin,"end":end},
            success:function (data){
                var json=eval(data);
                var con="";
                for (var i=0;i<json.length;i++)
                {
                    con+="<tr onclick='getOrginf(this)'><td>"+json[i].org_id+"</td>"
                        +"<td>"+json[i].org_name+"</td><td>"+json[i].create_username+"</td><td>"+
                        new Date(Number(json[i].create_time))+"</td><td>"+json[i].into_number+"</td></tr>"
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
            url:urldomain+"/golimitorg",
            data:{"username":username,"begin":begin,"end":end},
            success:function (data){
                var json=eval(data);
                var con="";
                for (var i=0;i<json.length;i++)
                {
                    con+="<tr onclick='getOrginf(this)'><td>"+json[i].org_id+"</td>"
                        +"<td>"+json[i].org_name+"</td><td>"+json[i].create_username+"</td><td>"+
                        new Date(Number(json[i].create_time))+"</td><td>"+json[i].into_number+"</td></tr>"
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
function getOrginf(element){
    var gropid=element.children[0].innerHTML;
    showinf(gropid)
}
function showinf(gropid){
    var form_2=document.getElementsByClassName("form_2");
    $.post({
        url:urldomain+"/getorginformation",
        data:{"gropid":gropid},
        success:function (data){
            var json=JSON.parse(data);
            var org=json.org;
            $("#org_id").html(org.org_id);
            $("#create_username").html(org.create_username);
            $("#create_time").html(dateTime(new Date(Number(org.create_time))));
            $("#org_name").html(org.org_name);
            $("#content").html(org.content);
            $("#into_number").html(org.into_number);
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
function addorg(){
    var org_id=$("#addOrg").val();
    $.post({
        url:urldomain+"/addorg",
        data:{"org_id":org_id,"username":username},
        success:function (data){
            if (data==="no")
            {
                alert("该组织不存在")
                window.location.reload();
            }
            else{
                alert("添加成功");
                window.location.reload();
            }
        }
    })
}
function exitOrg(){
    var org_id=$("#org_id").html();
    $.post({
        url:urldomain+"/exitorg",
        data:{"org_id":org_id,"username":username},
        success:function (data){
            alert("退出成功");
            window.location.reload();
        }
    })
}
function search(){
    var orgid=$("#searchOrg").val();
    $.post({
        url:urldomain+"/isInOrg",
        data:{"username":username,"org_id":orgid},
        success:function (data){
            if(data==="n")
                alert("您未加入该组织");
            else{
                showinf(orgid);
            }
        }
    })
}