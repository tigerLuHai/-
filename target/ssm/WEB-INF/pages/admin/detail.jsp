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
        <a href="javascript:void(0);" class="easyui-linkbutton" plain="true" onclick="back()"
           style="width:70px;height:30px" id="btnadd">&#60; &lt;返回</a>
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
    var studentsName = "<%=request.getParameter("studentsName")%>";
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
                //封装请求参数
                //alert(JSON.stringify(data));
                //$("#multisel").find('option:selected').val();
                var param = {};
                //param.rows = $('select[name="orderList_length"]').val();//页面显示记录条数，在页面显示每页显示多少项的时候
                param.start = 0;//开始的记录序号
                param.page = (data.start / data.length) + 1;//当前页码
                //console.log(param);
                //ajax请求数据*/

                $.ajax({
                    url: "findStudentsDetail",
                    type: "post",
                    contentType: "application/json;charset=utf-8",
                    cache: false, //禁用缓存
                    data: {"classId": classId, "teacher": teacher, "studentsName": studentsName}, //传入组装的参数
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
                "data": "count", "sTitle": "课时"
            }, {
                "data": "work", "sTitle": "作业完成"
            }, {
                "data": "note", "sTitle": "笔记"
            }, {
                "data": "video", "sTitle": "视频观看"
            }, {
                "data": "knowledgeMaster", "sTitle": "知识点掌握"
            }]
        }).api();
        //此处需调用api()方法,否则返回的是JQuery对象而不是DataTables的API对象

        $('#orderList tbody').on('click', 'tr', function () {
            $('tr.selected').removeClass('selected');
            $(this).toggleClass('selected');
        });
    });

    function back() {
        window.history.back();
    }

</script>
</body>
</html>

