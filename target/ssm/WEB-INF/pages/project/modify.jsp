<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html style="overflow-x: visible; overflow-y: visible;">

<head>
    <meta charset="utf-8"/>
    <title>编辑页面</title>
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
        <label for="studentsId" class="col-sm-2 control-label">学员号</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="studentsId" name="studentsId" readonly>
        </div>
        <label for="studentsName" class="col-sm-2 control-label">学员姓名</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="studentsName" name="studentsName" readonly>
        </div>
    </div>
    <div class="form-group">
        <label for="work" class="col-sm-2 control-label">作业完成</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="work" name="work" value="1">
        </div>
        <label for="video" class="col-sm-2 control-label">视频观看</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="video" name="video" value="0">
        </div>
    </div>
    <div class="form-group">
        <label for="note" class="col-sm-2 control-label">笔记合格</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="note" name="note" value="0">
        </div>
        <label for="knowledgeMaster" class="col-sm-2 control-label">知识点掌握</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="knowledgeMaster" name="knowledgeMaster" value="0">
        </div>
    </div>
    <div class="form-group">
        <label for="weChat" class="col-sm-2 control-label">微信入群</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="weChat" name="weChat">
        </div>
        <label for="zhangYou" class="col-sm-2 control-label">掌优安装</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="zhangYou" name="zhangYou">
        </div>

    </div>
    <div class="form-group">
        <label for="shoppingCart" class="col-sm-2 control-label">购物车添加</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="shoppingCart" name="shoppingCart">
        </div>
        <label for="oneToOne" class="col-sm-2 control-label">一对一服务</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="oneToOne" name="oneToOne">
        </div>

    </div>
    <div class="form-group">
        <label for="isContinue" class="col-sm-2 control-label">是否续报春季班</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="isContinue" name="isContinue">
        </div>
        <label for="count" class="col-sm-2 control-label">课时</label>
        <div class="col-sm-3">
            <select id="count" class="form-control" name="课时">
                <option value="">-select-</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
                <option value="13">13</option>
                <option value="14">14</option>
                <option value="15">15</option>
                <option value="16">16</option>
                <option value="17">17</option>
                <option value="18">18</option>
                <option value="19">19</option>
                <option value="20">20</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-3 col-sm-push-7">
            <input type="button" onclick="modify()" class="btn btn-default" style="float: right" value="确定"></input>
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
    var studentsId = "<%=request.getParameter("studentsId")%>";
    var classId = "<%=request.getParameter("classId")%>";
    $(document).ready(function () {
        $.ajax({
            type: "POST",
            url: "queryStudentsData",
            async: true,
            data: {"studentsId": studentsId, "classId": classId},
            dataType: "json",
            contentType: "application/x-www-form-urlencoded",
            success: function (resp) {
                console.log(resp);
                if (!!resp.data) {
                    $("#studentsId").val(resp.data.studentsId);
                    $("#studentsName").val(resp.data.studentsName);
                    $("#weChat").val(resp.data.weChat);
                    $("#zhangYou").val(resp.data.zhangYou);
                    $("#shoppingCart").val(resp.data.shoppingCart);
                    $("#oneToOne").val(resp.data.oneToOne);
                    $("#isContinue").val(resp.data.isContinue);
                    $("#count").val(resp.data.count);
                }
                classId = resp.data.classId;
            }
        });
    });

    function modify() {
        var studentsId = $("#studentsId").val();
        var studentsName = $("#studentsName").val();
        var work = $("#work").val();
        var video = $("#video").val();
        var note = $("#note").val();
        var knowledgeMaster = $("#knowledgeMaster").val();
        var weChat = $("#weChat").val();
        var zhangYou = $("#zhangYou").val();
        var shoppingCart = $("#shoppingCart").val();
        var oneToOne = $("#oneToOne").val();
        var isContinue = $("#isContinue").val();
        var count = $("#count").val();
        /**
         if (loginPwd != cfmloginPwd) {
			window.parent.showDiag("Password and confirm password is not same!", "noexec");
			return;
		}**/
        var param = new Object();
        param["studentsId"] = studentsId;
        param["studentsName"] = studentsName;
        param["work"] = work;
        param["video"] = video;
        param["note"] = note;
        param["knowledgeMaster"] = knowledgeMaster;
        param["weChat"] = weChat;
        param["zhangYou"] = zhangYou;
        param["shoppingCart"] = shoppingCart;
        param["oneToOne"] = oneToOne;
        param["isContinue"] = isContinue;
        param["count"] = count;
        param["teacher"] = teacher;
        $.ajax({
            type: "POST",
            url: "updateStudentsData",
            async: true,
            data: JSON.stringify(param),
            dataType: "json",
            contentType: "application/json",
            success: function (resp) {
                alert("修改成功");
                window.location.href = "projectStudents?classId=" + classId + '&teacher=' + teacher;
            }
        });
    }
</script>

</body>
</html>

