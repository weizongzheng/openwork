window.onload=function(){
    var that=$(".isSubmit");
    var downloads=$(".download");
    for(var i=0;i<that.length;i++)
    {
        if(that[i].children[0].innerHTML==="0")
        {
            that[i].children[0].style.color="red";
            that[i].children[0].innerHTML="×";
            downloads[i].children[0].style.display="none";
        }
        else{
            that[i].children[0].style.color="green";
            that[i].children[0].innerHTML="√";
        }
    }
}
function updateWorkName(){
    var work_name=$("#workName").val();
    $.post({
        url:urldomain+"/updateWorkName",
        data:{"work_name":work_name,"work_id":work_id,"course_id":course_id},
        success:function (data){
            alert("修改成功！");
            window.location.reload();
        }
    })
}
function updateWorkContent(){
    var work_content=$("#workContent").val();
    $.post({
        url:urldomain+"/updateWorkContent",
        data:{"work_content":work_content,"work_id":work_id,"course_id":course_id},
        success:function (data){
            alert("修改成功！");
            window.location.reload();
        }
    })
}
function addUserToWork(){
    var username=$("#addUserId").val();
    $.post({
        url:urldomain+"/addUserToWork",
        data:{"username":username,"work_id":work_id,"course_id":course_id},
        success:function (data){
            if(data==='no1')
                alert("该用户不存在!");
            else if(data==='no2')
                alert("该用户在作业内!");
            else{
                alert("添加成功");
                window.location.reload();
            }
        }
    })
}
function deleteUserFromWork(element){
    var username=element.children[0].innerHTML;
    $.post({
        url:urldomain+"/deleteUserFromWork",
        data:{"username":username,"work_id":work_id,"course_id":course_id},
        success:function (data){
                alert("删除成功");
                window.location.reload();
        }
    })
}
function downloadfile(element) {
    var filename=element.innerHTML;
    var url = urldomain+"/downloadWorkFile";
    // 分装form表单
    var form = $("<form></form>").attr("action", url).attr("method", "post");
    // 封装参数
    form.append($("<input></input>").attr("type", "hidden").attr("name","filename").attr("value", filename));
    form.append($("<input></input>").attr("type", "hidden").attr("name","course_id").attr("value", course_id));
    form.append($("<input></input>").attr("type", "hidden").attr("name","work_id").attr("value", work_id));
    form.appendTo('body').submit().remove();
}
function updatefile(){
    var myform = new FormData();
    myform.append("work_id",work_id);
    myform.append("file",$("#updatefile")[0].files[0]);
    myform.append("course_id",course_id);
    $.post({
        url:urldomain+"/updateWorkFile",
        data:myform,
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        success:function (data){
            alert("更改文件成功");
            window.location.reload();
        },
        error:function (data){
            alert("文件上传失败！");
        }
    })
}
function downloadNoSubmit(){
    var list1=$(".list1");
    let str = `用户名,姓名,学号\n`;
    for(let i = 0 ; i < list1.length ; i++ ){
        if(list1[i].children[4].children[0].innerHTML==="×")
        {
            str+=list1[i].children[0].innerHTML+`\t,`+list1[i].children[1].innerHTML+`\t,`+list1[i].children[2].innerHTML+`\t,`;
            str+='\n';
        }
    }
    const uri = 'data:text/csv;charset=utf-8,\ufeff' + encodeURIComponent(str);// 通过创建a标签实现
    const link = document.createElement("a");
    link.href = uri;// 对下载的文件命名
    link.download = "未提交作业名单.csv";
    link.click();
}
function AllWorkDownload(){
    var url = urldomain+"/AllWorkDownload";// 分装form表单
    var form = $("<form></form>").attr("action", url).attr("method", "post");// 封装参数
    form.append($("<input></input>").attr("type", "hidden").attr("name","course_id").attr("value", course_id));
    form.append($("<input></input>").attr("type", "hidden").attr("name","work_id").attr("value", work_id));
    form.appendTo('body').submit().remove();
}
function goSubmit(){
    var url=urldomain+"/goSubmit?username="+username+
        "&course_id="+course_id.substr(1,course_id.length-1)+
        "&work_id="+work_id;
    window.open(url);
}
function deleteWork(){
    $.post({
        url:urldomain+"/deleteWork",
        data:{"work_id":work_id,"course_id":course_id},
        success:function (data){
            alert("删除成功");
            window.close();
        }
    })
}
function downloadOneUserWork(element){
    var username=element.children[0].innerHTML;
    var filename=element.children[1].innerHTML;
    var url = urldomain+"/downloadOneUserWork";// 分装form表单
    var form = $("<form></form>").attr("action", url).attr("method", "post");// 封装参数
    form.append($("<input></input>").attr("type", "hidden").attr("name","username").attr("value", username));
    form.append($("<input></input>").attr("type", "hidden").attr("name","filename").attr("value", filename));
    form.append($("<input></input>").attr("type", "hidden").attr("name","course_id").attr("value", course_id));
    form.append($("<input></input>").attr("type", "hidden").attr("name","work_id").attr("value", work_id));
    form.appendTo('body').submit().remove();
}