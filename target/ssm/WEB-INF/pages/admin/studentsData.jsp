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
        <%--<a href="javascript:void(0);" class="easyui-linkbutton" plain="true" onclick="classdata()" style="width:70px;height:30px">班级数据</a>
        <a href="javascript:void(0);" class="easyui-linkbutton" plain="true" onclick="projectdata()" style="width:70px;height:30px">项目数据</a>--%>
        <a href="javascript:void(0);" class="easyui-linkbutton" plain="true" onclick="detail()" style="margin-left:5px"
           id="btnmodify">详情</a>
        <a href="javascript:void(0);" class="easyui-linkbutton" plain="true" onclick="add()" style="margin-left:5px"
           id="btnmodify">新增</a>
        <a href="javascript:void(0);" class="easyui-linkbutton" plain="true" onclick="modify()" style="margin-left:5px"
           id="btnmodify">修改</a>
        <a href="javascript:void(0);" class="easyui-linkbutton" plain="true" onclick="del()" style="margin-left:5px"
           id="btndelete">删除</a>
        <a href="javascript:void(0);" class="easyui-linkbutton" plain="true" onclick="save()"
           style="width:70px;height:30px;">保存</a>
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
</body>
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
                "data": "subject", "sTitle": "科目"
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
            }, {
                "data": "isUpdate", "sTitle": "是否修改"
            }]
        }).api();
        //此处需调用api()方法,否则返回的是JQuery对象而不是DataTables的API对象
        var timer;
        $('#orderList tbody').on('dblclick', 'tr', function () {
            clearTimeout(timer);
            $('tr.selected').removeClass('selected');
            $(this).toggleClass('selected');
        });
        $('#orderList tbody').on('click', 'td', function (event) {
            var columns = $(this).index();
            if (columns > 6 && columns < 17) {
                var tdObj = $(this);
                clearTimeout(timer);
                timer = setTimeout(function () {
                    //alert("haha");
                    //td中已经有了input,则不需要响应点击事件
                    if ($(this).children("input").length > 0)
                        return false;

                    var preText = tdObj.html();
                    //得到当前文本内容
                    var inputObj = $("<input type='text' />");
                    //创建一个文本框元素
                    tdObj.html(""); //清空td中的所有元素
                    inputObj
                        .css({width: "70px", height: "20px", border: "0px", fontSize: "17px", font: "宋体"})
                        .val(preText)
                        .appendTo(tdObj)
                        //把创建的文本框插入到tdObj子节点的最后
                        .trigger("focus")
                        //用trigger方法触发事件
                        .trigger("select");
                    inputObj.blur(function (event) {
                        var text = $(this).val();
                        tdObj.html(text);
                        isQualified();
                    });
                    //已进入编辑状态后，不再处理click事件
                    inputObj.click(function () {
                        return false;
                    });
                }, 500);
            }
        });
    });

    function back() {
        window.location.href = "adminIndex";
    }

    function countChg() {
        doSearch();
    }

    function doSearch() {
        oTable.ajax.reload();
    }

    function add() {
        window.location.href = 'adminAddStudents';
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

    function modify() {
        var rows = oTable.rows('.selected').data();
        if (!!rows && !!rows[0]) {
            var row = rows[0];
            window.location.href = 'adminModify?studentsId=' + row.studentsId + '&classId=' + row.classId;
        } else {
            window.parent.showDiag("请选择一条数据", "noexec");
        }
    }

    function save() {
        var array = [];
        var head = $("th");
        $(" tr").each(function () {
            var json = {};
            $(this).find("td").each(function (i) {
                json[head.eq(i).html()] = $(this).html();
            });
            array.push(json);
        });
        for (var i = 2; i < array.length; i++) {
            var params = new Object();
            params["project"] = array[i]["项目"];
            params["subject"] = array[i]["科目"];
            params["studentsName"] = array[i]["学员姓名"];
            params["classId"] = array[i]["班号"];
            params["teacher"] = array[i]["老师"];
            params["studentsId"] = array[i]["学员号"];
            params["count"] = array[i]["课时"];
            params["weChat"] = array[i]["微信入群"];
            params["zhangYou"] = array[i]["掌优安装"];
            params["shoppingCart"] = array[i]["购物车添加"];
            params["oneToOne"] = array[i]["一对一服务"];
            params["isContinue"] = array[i]["是否报春季班"];
            params["work"] = array[i]["当前课时作业完成"];
            params["video"] = array[i]["当前课时视频观看"];
            params["note"] = array[i]["当前课时笔记合格"];
            params["knowledgeMaster"] = array[i]["当前课时知识点掌握"];
            $.ajax({
                type: "POST",
                url: "updateStudentsData",
                async: true,
                data: JSON.stringify(params),
                dataType: "json",
                contentType: "application/json",
                success: function (resp) {
                }
            });
            sum = i;
        }
        if (sum == array.length - 1) {
            doSearch();
        }
    }

    function isQualified() {
        var array = [];
        var head = $("th");
        $(" tr").each(function () {
            var json = {};
            $(this).find("td").each(function (i) {
                json[head.eq(i).html()] = $(this).html();
            });
            array.push(json);
        });
        for (var i = 2; i < array.length; i++) {
            var ret = /^[01]$/;
            var weChat = ret.test(array[i]["微信入群"]);
            var zhangYou = ret.test(array[i]["掌优安装"]);
            var shoppingCart = ret.test(array[i]["购物车添加"]);
            var oneToOne = ret.test(array[i]["一对一服务"]);
            var isContinue = ret.test(array[i]["是否报春季班"]);
            var work = ret.test(array[i]["当前课时作业完成"]);
            var video = ret.test(array[i]["当前课时视频观看"]);
            var note = ret.test(array[i]["当前课时笔记合格"]);
            var knowledgeMaster = ret.test(array[i]["当前课时知识点掌握"]);
            if (weChat && zhangYou && shoppingCart && oneToOne && isContinue && work && video && note && knowledgeMaster) {
            } else {
                alert("第" + (i - 1) + "行数据格式有误，请在指定位置输入1或0");
                break;
            }
        }
    }

    function del() {
        var rows = oTable.rows('.selected').data();
        if (!!rows && !!rows[0]) {
            var row = rows[0];
            var param = {};
            param["classId"] = row.classId;
            param["studentsId"] = row.studentsId;
            if (confirm("删除学生将清空所有相关数据，确定要删除吗？")) {
                $.ajax({
                    type: "POST",
                    url: "delStudents",
                    async: true,
                    data: param,
                    dataType: "json",
                    contentType: "application/json",
                    success: function (resp) {
                        oTable.ajax.reload();
                    }
                });
                return;
            } else {
                alert("已经取消了删除操作");
            }
        } else {
            window.parent.showDiag("请选择一条数据", "noexec");
        }
    }
</script>
</html>

