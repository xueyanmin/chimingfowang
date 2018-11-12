<%@ page  pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        $("#UserTb").datagrid({
            fit:true,
            url:'${pageContext.request.contextPath}/user/findAll',
            //toolbar:'#DpTb',
            pagination:true,
            pageList:[2,5,8,10,16],
            pageSize:2,
            pageNumber:1,
            pagePosition:'both',
            ctrlSelect:true,
            idField:'id',
            striped:true,
            loadMsg:'加载中...~',
            fitColumns:true,
            remoteSort:false,
            resizeHandle:'both',
            columns:[[
                {title:'id',field:'id',width:110},
                {title:'phoneNum',field:'phoneNum'},
                {title:'username',field:'username'},
                {title:'password',field:'password'},
                {title:'salt',field:'salt'},
                {title:'province',field:'province'},
                {title:'city',field:'city'},
                {title:'nickName',field:'nickName'},
                {title:'sex',field:'sex'},
                {title:'sign',field:'sign'},
                {title:'headPicPath',field:'headPicPath'},
                {title:'status',field:'status'},
                {title:'createDate',field:'createDate'}
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=3 style="border:0"><img src="${pageContext.request.contextPath}'+rowData.headPicPath+'" style="height:80px;"></td>' +
                    '<td style="border:">' +
                    '<p>联系方式: ' + rowData.phoneNum + '</p>' +
                    '<p>所在省: ' + rowData.province + '</p>' +
                    '<p>注册时间: ' + rowData.createDate + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            onLoadSuccess:function () {
                $(".options").linkbutton();
            },
        });
    });


    //更新用户操作
    function editInputForm(id) {
        $("#editGuruDialog").dialog({
            href:'${pageContext.request.contextPath}/back/guru/edit.jsp?id='+id,
            title:'更新用户信息',
            iconCls:'icon-edit',
            buttons:[{
                iconCls:'icon-edit',
                text:'保存',
                handler:function () {
                    $("#guruEditInputForm").form('submit',{
                        url:'${pageContext.request.contextPath}/guru/update',
                        success:function (result){
                            var resultObj = $.parseJSON(result);
                            if (resultObj.success) {
                                //提示信息
                                $.messager.show({title:'提示',msg:'更新上师信息成功！！！',showSpeed:700,timeout:5000,});
                            }else {
                                //提示信息
                                $.messager.show({title: '提示', msg:resultObj.message});
                            }
                            $("#editGuruDialog").dialog('close');
                            $("#GuruTb").datagrid('reload');

                        },

                    })
                }
            },{
                iconCls:'icon-cancel',
                text:'关闭',
                handler:function (result) {
                    $("#editGuruDialog").dialog('close');
                },
            }]
        });
    }

</script>

<table id="UserTb" data-options="fit:true"></table>
<div id="DpTb">
    <a href="#" class="easyui-linkbutton" onclick="openSaveDialog()" data-options="iconCls:'icon-save',plain:true">添加</a>
    <a href="#" class="easyui-linkbutton" onclick="delBatchRows()" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
</div>

<%--更新用户对话框--%>
<div id="editGuruDialog" data-options="href:'${pageContext.request.contextPath}/',width:600,height:400"></div>

