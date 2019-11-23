<%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 2019/2/2
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html style="overflow-x: visible; overflow-y: visible;">

<head>
    <link rel="stylesheet" href="\static\media\css\bootstrap.min.css">

    <meta charset="utf-8"/>
    <title></title>
    <style>
        .container {
        / / margin-top: 10 %;
            width: 90%;
        / / border: 1 px solid #000000;

        }

        label {
        / / margin-left: 30 %;
            margin-top: 5%;
            margin-bottom: 3%;
            display: inline-table;
            font-size: 17px;
        }

        .container > .upload {
        / / margin-left: 30 %;
        }

        .upload > .blank {
            margin-bottom: 5%;
            height: 30px;
            line-height: 30px;
            font-size: 17px;
            border: 1px solid #ccc4c4;
            border-radius: 4px;
        }

        .btn1 {
            margin-bottom: 5%;
            background-color: none;
            height: 30px;
        / / width: 70 px;
            border: 1px solid #ccc4c4;
            border-radius: 4px;
            font-size: 17px;
            margin-right: 10px;
        }

        .back {
            margin-bottom: 5%;
            background-color: none;
            height: 30px;
        / / width: 60 px;
            border: 1px solid #ccc4c4;
            border-radius: 4px;
            font-size: 17px;
        }
    </style>

</head>
<body>
<div class="container">
    <label>请选择您需要提交的文件:</label>
    <form class="upload" action="/details/upload" method="post" enctype="multipart/form-data">
        <input type="file" class="blank" name="upfile" value=" "
               accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
        <input type="submit" class="btn1" value="提交">
        <input type="button" class="back" value="返回上一页" onclick="back()">
    </form>
</div>

<script src="/static/js/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="/static/res/query-1.10.2.min.js" type="text/javascript"></script>

<script>
    function back() {
        window.location.href = "adminIndex";
    }

</script>
</body>
</html>


