<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>无标题文档</title>
    <link rel="stylesheet" href="/static/res/datatables/1.10.9/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="/static/res/bootstrap/css/bootstrapValidator.min.css">
    <link rel="stylesheet" href="/static/res/datatables/1.10.9/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="/static/res/datatables/1.10.9/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/static/res/jeasyui/themes/default/easyui.css">
    <link rel="stylesheet" href="/static/res/jeasyui/themes/icon.css">
    <link rel="stylesheet" href="/static/res/jeasyui/demo.css">
    <link rel="stylesheet" href="/static/res/bootstrap/css/bootstrap.css">
    <style>
        table > thead:first-child > tr:first-child > th {
            text-align: center;
        }
    </style>
</head>
<body>
<div id="orderlistWraper">
    <div style="padding:3px">
        <div style="height:2px;width:100%;background-color:#eee;margin-bottom:15px;margin-top:-5px;"></div>
        <select name="count" id="count" onchange="countChg()"
                style="display:inline-block;margin-left:15px;height:30px;font-size:13px;">
            <option value="">请选择课时</option>
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
        学员姓名:
        <input type="text" class="citic-text" id="name" placeholder="请输入学员姓名"></input>
        <a href="javascript:void(0);" class="easyui-linkbutton" plain="true" onclick="doSearch()">搜索</a>
        <a href="javascript:void(0);" class="easyui-linkbutton" plain="true" onclick="back()"
           style="width:70px;height:30px" id="btnadd">返回首页</a>
        <a href="javascript:void(0);" class="easyui-linkbutton" plain="true" onclick="detail()" style="margin-left:5px"
           id="btnmodify">详情</a>
        <%--<a href="javascript:void(0);" class="easyui-linkbutton" plain="true" onclick="classdata()" style="width:70px;height:30px">班级数据</a>
            <a href="javascript:void(0);" class="easyui-linkbutton" plain="true" onclick="projectdata()" style="width:70px;height:30px">项目数据</a>--%>
        <%--<a href="javascript:void(0);" class="easyui-linkbutton" plain="true" onclick="modify()" style="margin-left:5px" id="btnmodify">修改</a>
        <a href="javascript:void(0);" class="easyui-linkbutton" plain="true" onclick="del()" style="margin-left:5px" id="btndelete">删除</a>--%>
    </div>
    <table id="orderList"
           class="display table-bordered table-condensed"
           cellspacing="0" width="100%">
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
    var classId = "<%=request.getParameter("classId")%>";
    var teacher = "<%=request.getParameter("teacher")%>";
    var oTable;
    $(document).ready(function () {
        //提示信息
        var lang = {
            "sProcessing": "处理中...",
            // "sLengthMenu" : "每页 _MENU_ 项",
            "sZeroRecords": "没有匹配结果",
            "sInfo": "当前显示第 _START_ 至 _END_ 项，共 _TOTAL_ 项。",
            "sInfoEmpty": " ",
            "sInfoFiltered": " ",
            "sInfoPostFix": "",
            "sSearch": "搜索:",
            "sUrl": "",
            "sEmptyTable": "表中数据为空",
            "sLoadingRecords": "载入中...",
            "sInfoThousands": ",",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "上页",
                "sNext": "下页",
                "sLast": "末页",
                "sJump": "跳转"
            },
        };

        oTable = $('#orderList').dataTable({
            scrollY: "80%",
            scrollCollapse: true,
            bLengthChange: true, //开关，是否显示每页显示多少条数据的下拉框
            aLengthMenu: [10, 25, 50, 100],//设置每页显示数据条数的下拉选项
            iDisplayLength: 10, //每页初始显示5条记录
            language: lang, //提示信息
            autoWidth: false, //禁用自动调整列宽
            //stripeClasses: ["odd", "even"],  //为奇偶行加上样式，兼容不支持CSS伪类的场合
            processing: true, //隐藏加载提示,自行处理
            serverSide: true, //启用服务器端分页
            searching: false, //禁用原生搜索
            //bLengthChange: false,   //去掉每页显示多少条数据
            //orderMulti: false,  //启用多列排序
            ordering: false,
            destroy: true,
            retrieve: true,
            paging: false,
            //order: [],  //取消默认排序查询,否则复选框一列会出现小箭头
            //renderer: "bootstrap",  //渲染样式：Bootstrap和jquery-ui
            pagingType: "simple_numbers", //分页样式：simple,simple_numbers,full,full_numbers
            ajax: function (data, callback, settings) {
                var param = {};
                param["classId"] = classId;
                param["teacher"] = teacher;
                param["studentsName"] = $("#name").val();
                param["count"] = $("#count").val();


                $.ajax({
                    url: "findStudents",
                    type: "post",
                    contentType: "application/json;charset=utf-8",
                    cache: false, //禁用缓存
                    data: param,
                    dataType: "json",
                    success: function (result) {
                        console.log(result);
                        //setTimeout仅为测试延迟效果
                        setTimeout(function () {
                            //封装返回数据
                            var returnData = {};
                            returnData.draw = data.totalPage;//这里直接自行返回了draw计数器,应该由后台返回
                            returnData.recordsTotal = result.total;//返回数据全部记录
                            returnData.recordsFiltered = result.total;//后台不实现过滤功能，每次查询均视作全部结果
                            returnData.data = result.rows;//返回的数据列表
                            //console.log(returnData);
                            //调用DataTables提供的callback方法，代表数据已封装完成并传回DataTables进行渲染
                            //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
                            callback(returnData);
                            $("#orderList").find("td").css("text-align", "center");
                            $("#orderList_paginate").parent().append($(".dataTables_length"));
                            $(".dataTables_length").css("float", "right");
                            $(".dataTables_length").css("margin-top", "10px");
                            $.fn.dataTable.tables({visible: true, api: true}).columns.adjust();
                        }, 200);
                    }
                });
            },

            //列表表头字段
            columns: [{
                "data": "project", "sTitle": "项目"
            }, {
                "data": "classId", "sTitle": "班号"
            }, {
                "data": "teacher", "sTitle": "老师"
            }, {
                "data": "studentsId", "sTitle": "学员号"
            }, {
                "data": "studentsName", "sTitle": "学员姓名"
            }, {
                "data": "count", "sTitle": "课时"
            }, {
                "data": "weChat", "sTitle": "微信入群"
            }, {
                "data": "zhangYou", "sTitle": "掌优安装"
            }, {
                "data": "shoppingCart", "sTitle": "购物车添加"
            }, {
                "data": "oneToOne", "sTitle": "一对一服务"
            }, {
                "data": "isContinue", "sTitle": "是否报春季班"
            }, {
                "data": "nps", "sTitle": "NPS"
            }, {
                "data": "work", "sTitle": "当前课时作业完成"
            }, {
                "data": "video", "sTitle": "当前课时视频观看"
            }, {
                "data": "note", "sTitle": "当前课时笔记合格"
            }, {
                "data": "knowledgeMaster", "sTitle": "当前课时知识点掌握"
            }, {
                "data": "workTotal", "sTitle": "作业完成"
            }, {
                "data": "videoTotal", "sTitle": "视频观看"
            }, {
                "data": "noteTotal", "sTitle": "笔记合格"
            }, {
                "data": "knowledgeMasterTotal", "sTitle": "知识点掌握"
            }]
        }).api();
        //此处需调用api()方法,否则返回的是JQuery对象而不是DataTables的API对象

        $('#orderList tbody').on('click', 'tr', function () {
            $('tr.selected').removeClass('selected');
            $(this).toggleClass('selected');
        });
    });

    function back() {
        window.location.href = "bossIndex";
    }

    function countChg() {
        doSearch();
    }

    function detail() {
        var rows = oTable.rows('.selected').data();
        if (!!rows && !!rows[0]) {
            var row = rows[0];
            window.location.href = 'adminDetail?teacher=' + row.teacher + '&studentsName=' + row.studentsName + '&classId=' + row.classId;
        } else {
            window.parent.showDiag("请选择一条数据", "noexec");
        }
    }

    function doSearch() {
        oTable.ajax.reload();
    }
</script>
</body>
</html>

