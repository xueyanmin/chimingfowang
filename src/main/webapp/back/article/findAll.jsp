<%@ page  pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        $("#ArticleTb").datagrid({
            fit:true,
            url:'${pageContext.request.contextPath}/article/findAll',
            toolbar:'#DpTb',
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
                {title:'no',field:'no',checkbox:true},
                {title:'id',field:'id',width:150},
                {title:'title',field:'title',width:180},
                {title:'imgPath',field:'imgPath',width:180},
                {title:'content',field:'content',width:220},
                {title:'publishDate',field:'publishDate',width:180},
                {title:'link',field:'link',width:180},
                {title:'illuStration',field:'illuStration',width:180},
                {title:'guruName',field:'guruId.id',width:180},
                {title:"操作",field:"options",width:190,
                    formatter:function (value,row,index) {
                        return "<a href='javascript:;' onclick=\"delrows('"+row.id+"')\" class='options' data-options=\"iconCls:'icon-remove',height:30,plain:true\">删除</a>&nbsp;&nbsp;" +
                            "   <a href='javascript:;' onclick=\"editInputForm('"+row.id+"')\" class='options' data-options=\"iconCls:'icon-edit',height:30,plain:true\">修改</ahref>";
                    }
                }
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=3 style="border:0"><img src="${pageContext.request.contextPath}'+rowData.imgPath+'" style="height:80px;"></td>' +
                    '<td style="border:">' +
                    '<p>Title: ' + rowData.title + '</p>' +
                    '<p>PulishDate: ' + rowData.publishDate + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            onLoadSuccess:function () {
                $(".options").linkbutton();
            },
        });
    });

    //删除一行的功能
    function delrows(id) {
        $.post("${pageContext.request.contextPath}/article/delete",{"id":id},function (result) {//响应成功之后回调
            //刷新datagrid
            $("#ArticleTb").datagrid('reload');
            $.messager.show({title:'提示',msg:'删除文章成功！！！',showSpeed:700,timeout:5000,});
        });
    }
    function openSaveDialog() {
        $("#saveArticleDialog").dialog({
            title:'保存部门信息',
            iconCls:'icon-save',
            buttons:[{
                iconCls:'icon-save',
                text:'保存',
                handler:function () {
                    $("#articleSaveInputForm").form('submit',{
                        url:'${pageContext.request.contextPath}/article/add',
                        success:function (result) {
                            var resultObj = $.parseJSON(result);
                            var guru=resultObj.guru;
                                    for (var i = 0; i < guru.length; i++) {
                                        var option = $("<option ></option>").attr("value",resultObj[i].id).text(resultObj[i].name);
                                        //console.info(option);
                                        $("#province").append(option);
                                    };
                            if (resultObj.success) {
                                //提示信息
                                $.messager.show({title: '提示', msg: "文章添加成功！！！！"});
                            }else{
                                //提示信息
                                $.messager.show({title: '提示', msg:resultObj.message});
                            }

                            //关闭对话框
                            $("#saveArticleDialog").dialog('close');
                            //刷新datagrid
                            $("#ArticleTb").datagrid('reload');
                        }
                    })
                }
            },{
                iconCls:'icon-cancel',
                text:'删除',
                handler:function () {
                    //关闭对话框
                    $("#saveArticleDialog").dialog('close');
                }
            },],
        });
    }

    //更新用户操作
    function editInputForm(id) {
        $("#editArticleDialog").dialog({
            href:'${pageContext.request.contextPath}/back/article/edit.jsp?id='+id,
            title:'更新文章信息',
            iconCls:'icon-edit',
            buttons:[{
                iconCls:'icon-edit',
                text:'保存',
                handler:function () {
                    $("#articleEditInputForm").form('submit',{
                        url:'${pageContext.request.contextPath}/article/update',
                        success:function (result){
                            var resultObj = $.parseJSON(result);
                            if (resultObj.success) {
                                //提示信息
                                $.messager.show({title:'提示',msg:'更新文章成功！！！',showSpeed:700,timeout:5000,});
                            }else {
                                //提示信息
                                $.messager.show({title: '提示', msg:resultObj.message});
                            }
                            $("#editArticleDialog").dialog('close');
                            $("#ArticleTb").datagrid('reload');

                        },

                    })
                }
            },{
                iconCls:'icon-cancel',
                text:'关闭',
                handler:function (result) {
                    $("#editArticleDialog").dialog('close');
                },
            }]
        });
    }

    function delBatchRows() {
        var rows = $("#ArticleTb").datagrid('getSelections');
        if (rows.length<=0){
            $.messager.show({title:'提示',msg:'至少选中一行!!!'});
        } else{
            var ids = [];
            for(var i=0;i<rows.length;i++){
                //console.log(rows[i].id);
                ids.push(rows[i].id);
            }
            //alert(ids);
            $.ajax({
                url:"${pageContext.request.contextPath}/article/delRows",
                type:"POST",
                traditional:true,
                data:{"ids":ids},
                success:function (result) {
                    $.messager.show({title:'提示',msg:'删除成功！！！'});
                    $("#GuruTb").datagrid('reload');
                },
                error:function () {
                    $.messager.show({title:'提示',msg:'删除失败！！！'});
                    $("#GuruTb").datagrid('reload');
                }
            });
        }
    }
</script>

<table id="ArticleTb" data-options="fit:true"></table>
<div id="DpTb">
    <a href="#" class="easyui-linkbutton" onclick="openSaveDialog()" data-options="iconCls:'icon-save',plain:true">添加</a>
    <a href="#" class="easyui-linkbutton" onclick="delBatchRows()" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
</div>

<%--保存用户对话框--%>
<div id="saveArticleDialog" data-options="href:'${pageContext.request.contextPath}/back/article/save.jsp',width:600,height:400"></div>

<%--更新用户对话框--%>
<div id="editArticleDialog" data-options="href:'${pageContext.request.contextPath}/back/article/edit.jsp',width:600,height:400"></div>

