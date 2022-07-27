function closeIt(){
    var form_1=document.getElementsByClassName("form_1");
    form_1[0].className="form_1";
}
function closeIt2(){
    var form_2=document.getElementsByClassName("form_2");
    form_2[0].className="form_2";
}
function showIt(){
    var form_1=document.getElementsByClassName("form_1");
    form_1[0].className="form_1 open";
}
function showItformOrg(){
    var form_2=document.getElementsByClassName("form_2");
    form_2[0].className="form_2 open";
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
function selectOrg(){
    var selectcheck=$(".selectOrgcheckbox");
    var selecttr=$(".selectOrgtr");
    var showtr=$(".orgshowtr");
    for(var i=0;i<selectcheck.length;i++)
    {
        if(selectcheck[i].checked)
        {
            selecttr[i].style.display = 'none';
            showtr[i].style.display = '';
        }
    }
    var form_2=document.getElementsByClassName("form_2");
    form_2[0].className="form_2";
}
function deselsect(element){
    var index=element.children[0].innerHTML;
    var selecttr=$(".selecttr");
    var showtr=$(".showtr");
    selecttr[index].style.display = '';
    showtr[index].style.display = 'none';
}
function deOrgselsect(element){
    var index=element.children[0].innerHTML;
    var selecttr=$(".selectOrgtr");
    var showtr=$(".orgshowtr");
    selecttr[index].style.display = '';
    showtr[index].style.display = 'none';
}
function createcourse(){
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
    var orgshowtr=$(".orgshowtr");
    var orglist=new Array();
    for(var j=0;j<orgshowtr.length;j++)
    {
        if(orgshowtr[j].style.display==='')
        {
            orglist.push(orgshowtr[j].children[0].innerHTML);
        }
    }
    var course_id=$("#org_id").val();
    var course_name=$("#org_name").val();
    var content=$("#content").val();
    if(course_id==="#" || (course_id.substr(0,1))!=='#')
    {
        alert("请输入正确课程名");
        window.location.reload();
    }
    else if(course_name==='')
    {
        alert("请输入课程名称");
        window.location.reload();
    }
    else{
        $.post({
            url:urldomain+"/Course_exsits",
            data:{"course_id":course_id},
            success:function (data){
                if(data==="no")
                {
                    $.post({
                        url:urldomain+"/createCourse",
                        data:{"course_id":course_id,"course_name":course_name,"content":content,
                            "list":JSON.stringify(list),"orglist":JSON.stringify(orglist)},
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
        url:urldomain+"/getUserAllCourse",
        data: {"username":username},
        success:function (data){
            var courses=JSON.parse(data);
            var con=""
            for(var i=0;i<courses.length;i++)
            {
                con+=" <li onclick='showCourseInf(this)'><div class='paw1'><span class='span3'>" +
                    "ID:"+"<span>"+courses[i].course_id +"</span>"+"&nbsp;"+";"+"名称:"+courses[i].title+
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
function showCourseInf(element){
    var course_id=element.children[0].children[0].children[0].innerHTML;
    $.post({
        url:urldomain+"/showCourseInf",
        data:{"course_id":course_id},
        success:function (data){
            var json=JSON.parse(data);
            var users=json.users;
            var course=json.course;
            $("#org_id_inf").html(course.course_id);
            $("#org_name_inf").val(course.title);
            $("#org_content_inf").val(course.description);
            $("#org_num_inf").html(course.into_number);
            var con="";
            for(var i=0;i<users.length;i++)
            {
                con+="<tr><td>"+users[i].username+"</td>" +
                    "<td> "+users[i].name+"</td>" +
                    "<td> "+users[i].number+"</td>" +
                    "<td>"+"<a onclick='deleUserFromCourse(this)'><span style='display: none'>" +users[i].username+
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
function deleCourse(){
    if(!confirm("确认要删除？请谨慎考虑！")){
        window.event.returnValue = false;
    }
    if(window.event.returnValue) {
        var course_id = $("#org_id_inf").html();
        $.post({
            url:urldomain+"/deleCourse",
            data:{"course_id":course_id},
            success:function (data){
                alert("删除成功！");
                window.location.reload();
            }
        })
    }
}
function upContent(){
    var courseContent=$("#org_content_inf").val();
    var course_id=$("#org_id_inf").html();
    $.post({
        url:urldomain+"/upCourseContent",
        data:{"courseContent":courseContent,"course_id":course_id},
        success:function (data){
            alert("修改公告成功！");
            window.location.reload();
        }
    })
}
function upCourseName(){
    var name=$("#org_name_inf").val();
    var course_id=$("#org_id_inf").html();
    $.post({
        url:urldomain+"/upCourseName",
        data:{"name":name,"course_id":course_id},
        success:function (data){
            alert("修改名称成功！");
            window.location.reload();
        }
    })
}
function addUsertoCourse(){
    var course_id=$("#org_id_inf").html();
    var addusername=$("#addusername").val();
    $.post({
        url:urldomain+"/addUsertoCourse",
        data:{"addusername":addusername,"course_id":course_id},
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
function deleUserFromCourse(element){
    if(!confirm("确认要删除？")){
        window.event.returnValue = false;
    }
    if(window.event.returnValue){
        var deleusername=element.children[0].innerHTML;
        var course_id=$("#org_id_inf").html();
        if(deleusername===username)
        {
            alert("创建者无法被删除！！！")
        }
        else{
            $.post({
                url:urldomain+"/deleUserFromCourse",
                data:{"deleusername":deleusername,"course_id":course_id},
                success:function (data){
                    alert("删除成功！");
                    window.location.reload();
                }
            })
        }
    }
}
function intoMyCourse(){
    var course_id=$("#org_id_inf").html();
    var url=urldomain+"/IntoMyCourse?username="+username+"&course_id="+course_id.substr(1,course_id.length-1);
    window.open(url);
}
