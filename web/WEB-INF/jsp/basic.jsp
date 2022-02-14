<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
    </style>
</head>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
      crossorigin="anonymous">
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <h1 id="begin">
               欢迎来到 openwork
            </h1>
            <br><br><br>
            <blockquote>
                <p>
                    您现在未读取的消息数量——————&nbsp;&nbsp;&nbsp;<span>${friendnumber}</span>
                </p> <small>关键词 <cite>消息</cite></small>
            </blockquote>
            <blockquote>
                <p>
                    您现在拥有的好友数量——————&nbsp;&nbsp;&nbsp;<span>${friendnumber}</span>
                </p> <small>关键词 <cite>好友</cite></small>
            </blockquote>
            <blockquote>
                <p>
                    您现在创建的组织数量——————&nbsp;&nbsp;&nbsp;<span>${createcoursenumber}</span>
                </p> <small>关键词 <cite>组织</cite></small>
            </blockquote>
            <blockquote>
                <p>
                    您现在加入的组织数量——————&nbsp;&nbsp;&nbsp;<span>${friendnumber}</span>
                </p> <small>关键词 <cite>组织</cite></small>
            </blockquote>
            <blockquote>
                <p>
                    您现在创建的课程数量——————&nbsp;&nbsp;&nbsp;<span>${createcoursenumber}</span>
                </p> <small>关键词 <cite>课程</cite></small>
            </blockquote>
            <blockquote>
                <p>
                    您现在加入的课程数量——————&nbsp;&nbsp;&nbsp;<span>${intoclassnumber}</span>
                </p> <small>关键词 <cite>课程</cite></small>
            </blockquote>
        </div>
    </div>
</div>
</body>
</html>
