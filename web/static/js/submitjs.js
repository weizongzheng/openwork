window.onload=function (){
    var isSubmits=$(".isSubmit");
    var noSubmits=$(".noSubmit");
    if(submited===0)
    {
        for(var i=0;i<isSubmits.length;i++)
        {
            isSubmits[i].style.display="none";
        }
    }
    else {
        for(var j=0;j<noSubmits.length;j++)
        {
            noSubmits[j].style.display="none";
        }
    }
}
function downloadfile(element) {
    var filename=element.innerHTML;
    var url = urldomain+"/downloadWorkFile";// 分装form表单
    var form = $("<form></form>").attr("action", url).attr("method", "post");// 封装参数
    form.append($("<input></input>").attr("type", "hidden").attr("name","filename").attr("value", filename));
    form.append($("<input></input>").attr("type", "hidden").attr("name","course_id").attr("value", course_id));
    form.append($("<input></input>").attr("type", "hidden").attr("name","work_id").attr("value", work_id));
    form.appendTo('body').submit().remove();
}
function submitWork(){
    var content=$("#content").val();
    var myform = new FormData();
    myform.append("work_id",work_id);
    myform.append("file",$("#submitfile")[0].files[0]);
    myform.append("course_id",course_id);
    myform.append("username",username);
    myform.append("content",content);
    $.post({
        url:urldomain+"/submitWork",
        data:myform,
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        success:function (data){
            alert("提交成功");
            window.location.reload();
        },
        error:function (data){
            alert("提交失败！");
        }
    })
}
function updateSubmitWork(){
    var content=$("#updatecontent").val();
    var myform = new FormData();
    if($("#updatefile")[0].files[0]!==undefined)
    {
    myform.append("work_id",work_id);
    myform.append("file",$("#updatefile")[0].files[0]);
    myform.append("course_id",course_id);
    myform.append("username",username);
    myform.append("content",content);
    $.post({
        url:urldomain+"/updateSubmitWork",
        data:myform,
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        success:function (data){
            alert("修改成功！");
            window.location.reload();
        },
        error:function (data){
            alert("修改失败！");
        }
    })
    }
    else{
        myform.append("work_id",work_id);
        myform.append("course_id",course_id);
        myform.append("username",username);
        myform.append("content",content);
        $.post({
            url:urldomain+"/updateSubmitWorkNofile",
            data:myform,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success:function (data){
                alert("修改成功！");
                window.location.reload();
            },
            error:function (data){
                alert("修改失败！");
            }
        })
    }
}