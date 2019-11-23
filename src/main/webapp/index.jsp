<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>登录页面</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>

    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <link href="/static/media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="/static/media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
    <link href="/static/media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="/static/media/css/style-metro.css" rel="stylesheet" type="text/css"/>
    <link href="/static/media/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/static/media/css/style-responsive.css" rel="stylesheet" type="text/css"/>
    <link href="/static/media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>
    <link href="/static/media/css/uniform.default.css" rel="stylesheet" type="text/css"/>

    <!-- END GLOBAL MANDATORY STYLES -->
    <!-- BEGIN PAGE LEVEL STYLES -->
    <link href="/static/media/css/login.css" rel="stylesheet" type="text/css"/>
    <!-- END PAGE LEVEL STYLES -->
    <link href="/static/res/jeasyui/themes/gray/easyui.css" type="text/css" rel="stylesheet">
    <link href="/static/res/jeasyui/themes/icon.css" type="text/css" rel="stylesheet">

    <link rel="shortcut icon" href="/static/media/image/favicon.ico"/>
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->
<!-- BEGIN LOGO -->


<body class="login">
<!-- END LOGO
BEGIN LOGIN -->
<div class="content">
    <label style="color: #000000;font-size: 32px; font-weight: bold;margin-left:17%;margin-top:-20%;margin-bottom:20%;">新东方学员跟盯系统</label>
    <!-- BEGIN LOGIN FORM -->
    <form class="form-vertical login-form">
        <div class="alert alert-error hide">
            <button class="close" data-dismiss="alert"></button>
            <span>Enter any username and password.</span>
        </div>
        <div class="control-group">
            <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
            <label class="control-label visible-ie8 visible-ie9">用户名</label>
            <div class="controls">
                <div class="input-icon left">
                    <i class="icon-user"></i>
                    <input class="m-wrap placeholder-no-fix" style="height: 33px;" type="text" placeholder="用户名"
                           id="loginid" name="loginid"/>
                </div>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label visible-ie8 visible-ie9">密码</label>
            <div class="controls">
                <div class="input-icon left">
                    <i class="icon-lock"></i>
                    <input class="m-wrap placeholder-no-fix" style="height:33px;" type="password" placeholder="密码"
                           id="loginpwd" name="loginpwd"/>
                </div>
            </div>
        </div>

        <div class="form-actions">

            <label class="checkbox">
                <input type="checkbox" id="rememberme" name="rememberme" onchange="remeberChg()" value=""/> 记住用户名
            </label>

            <button type="button" class="btn green pull-right" onclick="loginto()">登 录 <i
                    class="m-icon-swapright m-icon-white"></i></button>
            <div class="forget-password">
                <p class="remind" style="width:75px;margin-left:30%;display:block;" onclick="showmodel()">
                    修改密码
                </p>
            </div>
        </div>

    </form>

</div>

<!-- END LOGIN -->
<!-- BEGIN COPYRIGHT -->
<div class="modal fade" id="myModal" style="display:none;" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <!-- <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button> -->
                <h4 class="modal-title" id="myModalLabel">请修改您的密码</h4>
            </div>
            <div class="modal-body">
                <form role="form" id="resetPwdForm">
                    <div style="margin-bottom:30px;margin-top:30px;">
                        <label for="oldpwd" style="display:inline-block;margin-left:100px">原密码</label>
                        <div class="col-sm-3" style="margin-left:30px;display:inline-block">
                            <input type="text" id="oldpwd" name="oldpwd">
                        </div>
                    </div>
                    <div style="margin-bottom:30px;">
                        <label for="newpwd" style="display:inline-block;margin-left:100px">新密码</label>
                        <div class="col-sm-3" style="margin-left:30px;display:inline-block">
                            <input type="password" id="newpwd" name="newpwd">
                        </div>
                    </div>
                    <div style="margin-bottom:30px;">
                        <label for="cfmpwd" style="display:inline-block;margin-left:72px">确认新密码</label>
                        <div class="col-sm-3" style="margin-left:30px;display:inline-block">
                            <input type="password" id="cfmpwd" name="cfmpwd">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="resetpwd()">确定</button>
            </div>
        </div><!-- /.modal-content -->
    </div>
    <div id="sysDialog" action="close" execflag="noexec" closed="true" class="easyui-dialog" title="提示"
         style="width:400px;height:200px"
         data-options="iconCls:'icon-save',resizable:true,modal:true,
	    buttons:[{
	    	text:'确定',
	    	handler:function(){sysDialogSave()}
	    },{
	    	text:'关闭',
	    	handler:function(){sysDialogClose()}
	    }]">
        <div id="sysDialog_Content" style="margin: 50px auto;text-align:center;font-size:medium"></div>
    </div>
</div>
<script src="/static/media/js/jquery-1.10.1.min.js" type="text/javascript"></script>
<script src="/static/media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
<script src="/static/media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
<script src="/static/media/js/bootstrap.min.js" type="text/javascript"></script>

<!--[if lt IE 9]>
<script src="/static/media/js/excanvas.min.js"></script>
<script src="/static/media/js/respond.min.js"></script>
<![endif]-->

<script src="/static/media/js/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="/static/media/js/jquery.blockui.min.js" type="text/javascript"></script>
<script src="/static/media/js/jquery.cookie.min.js" type="text/javascript"></script>
<script src="/static/media/js/jquery.uniform.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->

<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="/static/media/js/jquery.validate.min.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="/static/res/jeasyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="/static/media/js/app.js" type="text/javascript"></script>

<script src="/static/media/js/login.js" type="text/javascript"></script>
<script src="/static/js/framework/util.min.js" type="text/javascript"></script>
<script src="/static/js/framework/config.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).on('keypress', function (e) {
        if (e.keyCode == 13) {
            //alert("haha");
            loginto();
        }
    });

    function loginto() {
        var username = $("#loginid").val();
        var password = $("#loginpwd").val();
        var param = {};
        param["username"] = username;
        param["password"] = password;
        $.ajax({
            url: "details/user/login",
            type: "post",
            contentType: "application/json;charset=utf-8",
            cache: false, //禁用缓存
            data: param, //传入组装的参数
            dataType: "json",
            success: function (result) {
                console.log(result.username);
                if (result.permission == "1") {
                    window.location.href = "details/adminIndex";
                } else if (result.permission == "2") {
                    window.location.href = "details/teacherClass?teacher1=" + result.teacher;
                } else if (result.permission == "3") {
                    window.location.href = "details/bossIndex";
                } else if (result.permission == "4") {
                    window.location.href = "details/projectProject?project=" + result.teacher;
                } else {
                    alert("用户名或密码错误");
                }

                /* if(resp == "1"){
                     window.location.href = "details/index";
                 }else{
                     window.showDiag("用户名或密码错误");
                 }*/
            }
        });
    }

    function showDiag(content, execflag) {
        $("#sysDialog").attr("execflag", execflag);
        $("#sysDialog").dialog("open");
        $("#sysDialog_Content").text(content);
    }

    function closeDiag() {
        $("#sysDialog").dialog("close");
    }

    function sysDialogSave() {
        closeDiag();
    }

    function sysDialogClose() {
        closeDiag();
    }

    function remeberChg() {
        //alert(11);
        if ($('#rememberme').prop('checked') == true) {
            $.cookie("rememberme", "true", {expires: 7});
            var loginid = $("#loginid").val();
            $.cookie("loginid", loginid, {expires: 7});
        } else {
            $.cookie("rememberme", "false", {expires: -1});
            $.cookie("loginid", "", {expires: -1});
        }
    }

    function showmodel() {
        $("#myModal").modal('show');
    }

    function closemodel() {
        $("#myModal").modal('hide');
    }

    function resetpwd() {
        /* $('#resetPwdForm').data('bootstrapValidator').validate();
         if (!$('#resetPwdForm').data('bootstrapValidator').isValid()) {
             //alert("no pass");
         } else {*/
        var userid = $("#loginid").val();
        var oldpwd = $("#oldpwd").val();
        var newpwd = $("#newpwd").val();
        var cfmpwd = $("#cfmpwd").val();
        /**
         if (loginPwd != cfmloginPwd) {
					window.parent.showDiag("Password and confirm password is not same!", "noexec");
					return;
				}**/
        var param = {};
        param["userid"] = userid;
        param["oldpwd"] = oldpwd;
        param["newpwd"] = newpwd;
        param["cfmpwd"] = cfmpwd;
        $.ajax({
            type: "POST",
            url: "details/user/modifyPassword",
            async: true,
            data: param,
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            success: function (resp) {
                console.log(resp);
                closemodel();
                alert(resp.permission);
            }
        });
    }
</script>

</body>
</html>