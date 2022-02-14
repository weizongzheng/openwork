window.onload=function (){
    if(!isCreate)
        $("#iscreateli").css("display","none");
}
function openCreateWork(){
    var form_1=document.getElementsByClassName("form_1");
    form_1[0].className="form_1 open";
}
function closeIt(){
    var form_1=document.getElementsByClassName("form_1");
    form_1[0].className="form_1";
}
function createCourseWork(){
    var work_name=$("#work_name").val();
    var work_content=$("#work_content").val();
    if(work_name==='')
        alert("请输入名称");
    else if($("#file")[0].files[0]===undefined){
        alert("您还需要上传一个文件");
    }
    else{
        var myform = new FormData();
        myform.append("work_name",work_name);
        myform.append("work_content",work_content);
        myform.append("file",$("#file")[0].files[0]);
        myform.append("course_id",course_id);
        $.post({
            url:urldomain+"/createWork",
            data:myform,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success:function (data){
                alert("创建成功");
                window.location.reload();
            },
            error:function (data){
                alert("文件上传失败！");
            }
        })
    }
}
function intoWorkInf(element){
    var work_id=element.children[0].innerHTML;
    if(isCreate){
        var url=urldomain+"/goWorkManInf?username="+username+
            "&course_id="+course_id.substr(1,course_id.length-1)+
            "&work_id="+work_id;
        window.open(url);
    }
    else{
        var url=urldomain+"/goSubmit?username="+username+
            "&course_id="+course_id.substr(1,course_id.length-1)+
            "&work_id="+work_id;
        window.open(url);
    }
}