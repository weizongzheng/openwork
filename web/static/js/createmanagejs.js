function closeIt(){
    var form_1=document.getElementsByClassName("form_1");
    form_1[0].className="form_1";
}
function showIt(){
    var form_1=document.getElementsByClassName("form_1");
    form_1[0].className="form_1 open";
}
function selectfriend(){
    var selectcheck=$(".selectcheckbox");
    var selecttr=$(".selecttr");
    var showtr=$(".showtr");
    for(var i=0;i<selectcheck.length;i++)
    {
        if(selectcheck[i].checked)
        {
            selecttr[i].style.display = 'none';
            showtr[i].style.display = '';
        }
    }
    var form_1=document.getElementsByClassName("form_1");
    form_1[0].className="form_1";
}
function deselsect(element){
    var index=element.children[0].innerHTML;
    var selecttr=$(".selecttr");
    var showtr=$(".showtr");
    selecttr[index].style.display = '';
    showtr[index].style.display = 'none';
}
function createorg(){
    var showtr=$(".showtr");
    var list=new Array();
    list.push(username);
    for(var i=0;i<showtr.length;i++)
    {
        if(showtr[i].style.display==='')
        {
            list.push(showtr[i].children[0].innerHTML);
        }
    }
    var org_id=$("#org_id").val();
    var org_name=$("#org_name").val();
    var content=$("#content").val();
    if(org_id==="@" || (org_id.substr(0,1))!=='@')
    {
        alert("请输入正确组织名");
        window.location.reload();
    }
    else if(org_name==='')
    {
        alert("请输入组织名称");
        window.location.reload();
    }
    else{
        $.post({
            url:urldomain+"/Org_exsits",
            data:{"org_id":org_id},
            success:function (data){
                if(data==="no")
                {
                    $.post({
                        url:urldomain+"/createOrg",
                        data:{"org_id":org_id,"org_name":org_name,"content":content,"list":JSON.stringify(list)},
                        success:function (data){
                            alert("创建成功");
                        }
                    })
                }
                else{
                    alert("该组织名已经创建过了！");
                }
            }
        })
    }
}
function showlist(){
    $.post({
        url:urldomain+"/getUserAllOrg",
        data: {"username":username},
        success:function (data){
            var orgs=JSON.parse(data);
            var con=""
            for(var i=0;i<orgs.length;i++)
            {
                con+=" <li onclick='showOrgInf(this)'><div class='paw1'><span class='span3'>" +
                    "ID:"+"<span>"+orgs[i].org_id +"</span>"+"&nbsp;"+";"+"名称:"+orgs[i].org_name+
                    "</span></div></li>"
            }
            $("#listUl").html(con);
            var li_s=$("#showlist ul >li");
            if($("#showlist").hasClass("open"))
            {
                $("#showlist>ul").slideUp();
                $("#showlist").removeClass('open');
            }
            else{ //假如点击的那个链接没有open类，首先对所有的下拉菜单都让其收起来。然后点击的那个下拉，所有的li目录移除open类，点击的那个添加open类
                $("#showlist>ul").slideDown();
                li_s.removeClass('open')
                $("#showlist").addClass('open')
            }
        }
    })
}
function showOrgInf(element){
    var org_id=element.children[0].children[0].children[0].innerHTML;
    $.post({
        url:urldomain+"/showOrgInf",
        data:{"org_id":org_id},
        success:function (data){
            var json=JSON.parse(data);
            var users=json.users;
            var org=json.org;
            $("#org_id_inf").html(org.org_id);
            $("#org_name_inf").val(org.org_name);
            $("#org_content_inf").val(org.content);
            $("#org_num_inf").html(org.into_number);
            var con="";
            for(var i=0;i<users.length;i++)
            {
                con+="<tr><td>"+users[i].username+"</td>" +
                    "<td> "+users[i].name+"</td>" +
                    "<td> "+users[i].number+"</td>" +
                    "<td>"+"<a onclick='deleUser(this)'><span style='display: none'>" +users[i].username+
                    "</span><span>强制退出</span></a>"+"</td>" +
                    "</tr>"
            }
            $("#userlist3").html(con)
            $("#content2").css("display","");
            $("#content1").css("display","none");
        }
    })
}
function showCreate(){
    $("#content2").css("display","none");
    $("#content1").css("display","");
}
function deleOrg(){
    if(!confirm("确认要删除？请谨慎考虑！")){
        window.event.returnValue = false;
    }
    if(window.event.returnValue) {
        var org_id = $("#org_id_inf").html();
        $.post({
            url:urldomain+"/deleOrg",
            data:{"org_id":org_id},
            success:function (data){
                alert("删除成功！");
                window.location.reload();
            }
        })
    }
}
function upContent(){
    var content=$("#org_content_inf").val();
    var org_id=$("#org_id_inf").html();
    $.post({
        url:urldomain+"/upContent",
        data:{"content":content,"org_id":org_id},
        success:function (data){
            alert("修改公告成功！");
            window.location.reload();
        }
    })
}
function upOrgName(){
    var name=$("#org_name_inf").val();
    var org_id=$("#org_id_inf").html();
    $.post({
        url:urldomain+"/upOrgName",
        data:{"name":name,"org_id":org_id},
        success:function (data){
            alert("修改名称成功！");
            window.location.reload();
        }
    })
}
function addUser(){
    var org_id=$("#org_id_inf").html();
    var addusername=$("#addusername").val();
    $.post({
        url:urldomain+"/addUser",
        data:{"addusername":addusername,"org_id":org_id},
        success:function (data){
            if(data==="no")
            {
                alert("不存在该用户！");
            }
            else if(data==="no1"){
                alert("该用户已存在！");
            }
            else{
                alert("添加用户成功！")
            }
        }
    })
}
function deleUser(element){
    if(!confirm("确认要删除？")){
        window.event.returnValue = false;
    }
    if(window.event.returnValue){
        var deleusername=element.children[0].innerHTML;
        var org_id=$("#org_id_inf").html();
        if(deleusername===username)
        {
            alert("创建者无法被删除！！！")
        }
        else{
            $.post({
                url:urldomain+"/deteUser",
                data:{"deleusername":deleusername,"org_id":org_id},
                success:function (data){
                    alert("删除成功！");
                    window.location.reload();
                }
            })
        }
    }
}
