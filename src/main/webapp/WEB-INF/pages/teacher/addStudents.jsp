<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html style="overflow-x: visible; overflow-y: visible;">

<head>
    <meta charset="utf-8"/>
    <title>新增页面</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <link href="/static/res/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/res/bootstrap/css/bootstrapValidator.min.css" rel="stylesheet">
    <link href="/static/res/jeasyui/themes/default/easyui.css" type="text/css" rel="stylesheet">
    <link href="/static/res/jeasyui/themes/icon.css" type="text/css" rel="stylesheet">
    <link href="/static/res/jeasyui/demo.css" type="text/css" rel="stylesheet">


</head>
<body>

<form class="form-horizontal" role="form" id="adduserForm">
    <div class="form-group">
        <label for="project" class="col-sm-2 control-label">项目</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="project" name="project">
        </div>
        <label for="subject" class="col-sm-2 control-label">科目</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="subject" name="subject">
        </div>

    </div>
    <div class="form-group">
        <label for="isContinue" class="col-sm-2 control-label">是否报春季班</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="isContinue" name="isContinue">
        </div>
        <label for="classId" class="col-sm-2 control-label">班号</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="classId" name="classId">
        </div>

    </div>
    <div class="form-group">
        <label for="teacher" class="col-sm-2 control-label">老师</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="teacher" name="teacher">
        </div>
        <label for="studentsId" class="col-sm-2 control-label">学员号</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="studentsId" name="studentsId">
        </div>

    </div>
    <div class="form-group">
        <label for="studentsName" class="col-sm-2 control-label">学员姓名</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="studentsName" name="studentsName">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-3 col-sm-push-7">
            <input type="button" onclick="add()" class="btn btn-default" style="float: right" value="确定"></input>
        </div>
    </div>
</form>


<script src="/static/media/js/jquery-1.10.1.min.js" type="text/javascript"></script>
<script src="/static/media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
<script src="/static/media/js/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="/static/res/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/static/res/bootstrap/js/bootstrapValidator.min.js" type="text/javascript"></script>
<script src="/static/res/jeasyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="/static/js/framework/util.min.js" type="text/javascript"></script>
<script src="/static/js/framework/mydate.js" type="text/javascript"></script>
<script src="/static/js/framework/config.js" type="text/javascript"></script>

<script type="text/javascript">
    function add() {
        var project = $("#project").val();
        var subject = $("#subject").val();
        var isContinue = $("#isContinue").val();
        var classId = $("#classId").val();
        var teacher = $("#teacher").val();
        var studentsId = $("#studentsId").val();
        var studentsName = $("#studentsName").val();
        /**
         if (loginPwd != cfmloginPwd) {
			window.parent.showDiag("Password and confirm password is not same!", "noexec");
			return;
		}**/
        var param = new Object();
        param["project"] = project;
        param["subject"] = subject;
        param["isContinue"] = isContinue;
        param["classId"] = classId;
        param["teacher"] = teacher;
        param["studentsId"] = studentsId;
        param["studentsName"] = studentsName;
        $.ajax({
            type: "POST",
            url: "addStudents",
            async: true,
            data: JSON.stringify(param),
            dataType: "json",
            contentType: "application/json",
            success: function (resp) {
                alert("新增成功");
                window.history.back();    //接口地址要改
            }
        });
    }
</script>

</body>
</html>

