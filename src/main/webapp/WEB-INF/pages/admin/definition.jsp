<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html style="overflow-x: visible; overflow-y: visible;">

<head>
    <link rel="stylesheet" href="/static/media/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/booteasyui.css">

    <link rel="stylesheet" href="/static/res/datatables/1.10.9/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="/static/res/bootstrap/css/bootstrapValidator.min.css">
    <link rel="stylesheet" href="/static/res/datatables/1.10.9/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="/static/res/datatables/1.10.9/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/static/res/jeasyui/themes/default/easyui.css">
    <link rel="stylesheet" href="/static/res/jeasyui/themes/icon.css">
    <link rel="stylesheet" href="/static/res/jeasyui/demo.css">
    <link rel="stylesheet" href="/static/res/bootstrap/css/bootstrap.css">
    <meta charset="utf-8"/>
    <title>跟盯数据定义</title>

</head>
<body>
<div id="orderlistWraper">
    <div style="padding:3px">
        <div style="height:2px;width:100%;background-color:#eee;margin-bottom:15px;margin-top:-5px;"></div>
        <a href="javascript:void(0);" class="easyui-linkbutton" plain="true" onclick="back()"
           style="width:70px;height:30px" id="btnadd">返回上一级</a>
    </div>
    <table class="table table-striped" style="line-height:30px;font-size:15px;">
        <caption style="font-size:20px;margin-bottom:15px;font-weight:600;">跟盯数据定义</caption>
        <thead>
        <tr>
            <th>类别</th>
            <th>核算方法</th>
            <th>信息收集平台</th>
            <th>收集范围</th>
            <th>收集频次</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>微信入群率</td>
            <td>群信群内家长实名人头数/学员总人数</td>
            <td>助教收集</td>
            <td>全体学员</td>
            <td>一次性收集</td>
        </tr>
        <tr>
            <td>作业完成率</td>
            <td>每日作业完成人数/学员总人数</td>
            <td>掌上优能APP</td>
            <td>全体学员</td>
            <td>每天收集</td>
        </tr>
        <tr>
            <td>视频观看率</td>
            <td>每日视频观看人数/学员总人数</td>
            <td>产品经理收集</td>
            <td>全体学员</td>
            <td>每天收集</td>
        </tr>
        <tr>
            <td>一对一服务率</td>
            <td>一对一服务人数/学员总人数</td>
            <td>掌上优能APP</td>
            <td>全体学员</td>
            <td>每天收集1/7学员</td>
        </tr>
        <tr>
            <td>笔记合格率</td>
            <td>学员笔记合格人数/学员总人数</td>
            <td>掌上优能APP</td>
            <td>未达标教师学员</td>
            <td>每天收集</td>
        </tr>
        <tr>
            <td>知识点掌握率</td>
            <td>每日知识点掌握得分/学员总人数</td>
            <td>助教收集</td>
            <td>全体学员</td>
            <td>每天收集</td>
        </tr>
        <tr>
            <td>掌优安装率</td>
            <td>掌优安装人数/学员总人数</td>
            <td>掌上优能APP</td>
            <td>全体学员</td>
            <td>一次性收集</td>
        </tr>
        <tr>
            <td>购物车添加率</td>
            <td>购物车添加人数/学员总人数</td>
            <td>掌上优能APP</td>
            <td>全体学员</td>
            <td>一次性收集</td>
        </tr>
        <tr>
            <td>NPS</td>
            <td>NPS填写人头数/学员总人头数</td>
            <td>客服数据</td>
            <td>全体学员</td>
            <td>一次性收集</td>
        </tr>
        <tr>
            <td>续班率</td>
            <td>续班人数/学员总人数</td>
            <td>教务数据</td>
            <td>全体学员</td>
            <td>一次性收集</td>
        </tr>
        </tbody>
    </table>
</div>
<script src="/static/js/jquery-1.8.0.min.js"></script>
<script src="/static/media/js/jquery-migrate-1.2.1.min.js"></script>
<script src="/static/media/js/jquery.slimscroll.min.js"></script>
<script src="/static/res/bootstrap/js/bootstrap.min.js"></script>
<script src="/static/res/bootstrap/js/bootstrapValidator.min.js"></script>
<script src="/static/res/datatables/1.10.9/js/jquery.dataTables.min.js"></script>
<script src="/static/res/datatables/1.10.9/js/dataTables.bootstrap.min.js"></script>
<script src="/static/res/jeasyui/jquery.easyui.min.js"></script>
<script src="/static/js/framework/util.min.js"></script>
<script src="/static/js/framework/mydate.js"></script>
<script src="/static/js/framework/config.js"></script>
<script type="text/javascript">


    function back() {
        window.location.href = "adminIndex";
    }

</script>
</body>
</html>

