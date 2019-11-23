<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html style="overflow-x: visible; overflow-y: visible;">

<head>
    <link rel="stylesheet" href="/static/media/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/booteasyui.css">

    <meta charset="utf-8"/>
    <title>首页</title>
    <style>
        .container {
            margin: 0;
            padding: 0;
            width: 100%;
            height: 800px;
            background-color: #adc3ba9c;
        }

        .container > .content {
            margin-left: 25%;
            margin-top: 3%;
            width: 50%;
            height: 80%;
            display: inline-block;
        }

        .content > .title {
            display: inline-block;
            font-size: 30px;
            margin-left: 21%;
            font-weight: 700;
            margin-top: 40px;
            margin-bottom: 80px;
        }

        .content > .center {
        / / border: 1 px solid #000;
            height: 50px;
            margin-bottom: 20px;
        }

        .center > .logo {
            margin-bottom: 90px;
            margin-top: 20px;
        }

        .center > .lesson {
        / / border: 1 px solid #a3bba5;
            margin-left: 7%;
        }

        .center > .operation {
        / / border: 1 px solid #a3bba5;
            margin-left: 7%;
            margin-top: 15px;
        / / margin-bottom: 30 %;
        }

        .lesson > button {
            height: 40px;
            width: 80px;
            background: none;
            border: 2px solid #a3bba5;
            border-radius: 5px;
            margin-right: 15px;
            margin-bottom: 20px;
            background-color: #d4e3e4;
        }

        .operation > button {
            height: 40px;
            width: 80px;
            background: none;
            border: 2px solid #a3bba5;
            border-radius: 5px;
            margin-right: 15px;
            background-color: #d2c9e0;
            margin-bottom: 20px;
        }
    </style>

</head>
<body>
<div class="container">
    <div class="content">
        <a class="title">新东方高中部学员跟盯系统</a>
        <div class="center">
            <img class="logo" src="/static/images/xindongfang-logo.png">
            <div class="lesson">
                <button class="btn1" onclick="highSchool()">高中部</button>
                <button class="btn2" onclick="English()">英语</button>
                <button class="btn3" onclick="math()">数学</button>
                <button class="btn4" onclick="physical()">物理</button>
                <button class="btn5" onclick="Chemistry()">化学</button>
                <button class="btn6" onclick="complex()">综合</button>
                <button class="btn7" onclick="definition()">定义</button>
                <button class="btn8" onclick="logout()">退出登录</button>
            </div>
        </div>
    </div>
</div>

<script src="/static/js/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="/static/media/js/bootstrap.min.js" type="text/javascript"></script>

<script>
    var project;

    function highSchool() {
        window.location.href = "bossHighSchool";
    }

    function English() {
        project = $(".btn2").html();
        window.location.href = "bossProject?project=" + project;
    }

    function math() {
        project = $(".btn3").html();
        window.location.href = "bossProject?project=" + project;
    }

    function physical() {
        project = $(".btn4").html();
        window.location.href = "bossProject?project=" + project;
    }

    function Chemistry() {
        project = $(".btn5").html();
        window.location.href = "bossProject?project=" + project;
    }

    function complex() {
        project = $(".btn6").html();
        window.location.href = "bossProject?project=" + project;
    }

    function start() {
        $.ajax({
            type: "POST",
            url: "course/start",
            async: true,
            //data: param,
            dataType: "json",
            contentType: "application/x-www-form-urlencoded",
            success: function (resp) {
                alert("开启课程成功");
            }
        });
        return;
    }

    function end() {
        $.ajax({
            type: "POST",
            url: "course/end",
            async: true,
            //data: param,
            dataType: "json",
            contentType: "application/x-www-form-urlencoded",
            success: function (resp) {
                alert("结束课程成功");
            }
        });
    }

    function count() {
        $.ajax({
            type: "POST",
            url: "course/count",
            async: true,
            //data: param,
            dataType: "json",
            contentType: "application/x-www-form-urlencoded",
            success: function (resp) {
                alert("进入下一课程");
            }
        });
    }

    function upload() {
        window.location.href = "bossUpload";
    }

    function logout() {
        window.location.href = "login";
    }

    function definition() {
        window.location.href = "bossDefinition";
    }
</script>
</body>
</html>

