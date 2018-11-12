<%@ page  pageEncoding="UTF-8" isELIgnored="false" %>
    <script>
        $(function () {

            $("#BanTb").datagrid({
                fit:true,
                url:'${pageContext.request.contextPath}/banner/findAll',
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
                    {title:'imgPath',field:'imgPath',width:220},
                    {title:'desc',field:'desc',width:180},
                    {title:'status',field:'status',width:80},
                    {title:'createDate',field:'createDate',width:220},
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
                        '<p>Status: ' + rowData.status + '</p>' +
                        '<p>CteateDate              : ' + rowData.createDate + '</p>' +
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
            $.post("${pageContext.request.contextPath}/banner/delete",{"id":id},function (result) {//响应成功之后回调
                //刷新datagrid
                $("#BanTb").datagrid('reload');
                $.messager.show({title:'提示',msg:'删除轮播图片成功！！！',showSpeed:700,timeout:5000,});
            });
        }
        function openSaveDialog() {
            $("#saveBannerDialog").dialog({
                title:'保存部门信息',
                iconCls:'icon-save',
                buttons:[{
                    iconCls:'icon-save',
                    text:'保存',
                    handler:function () {
                        $("#bannerSaveInputForm").form('submit',{
                            url:'${pageContext.request.contextPath}/banner/add',
                            success:function (result) {
                                var resultObj = $.parseJSON(result);
                                //console.log(resultObj.success);
                                if (resultObj.success) {
                                    //提示信息
                                    $.messager.show({title: '提示', msg: "部门轮播图片信息成功！！！！"});
                                }else{
                                    //提示信息
                                    $.messager.show({title: '提示', msg:resultObj.message});
                                }

                                //关闭对话框
                                $("#saveBannerDialog").dialog('close');
                                //刷新datagrid
                                $("#BanTb").datagrid('reload');
                            }
                        })
                    }
                },{
                    iconCls:'icon-cancel',
                    text:'删除',
                    handler:function () {
                        //关闭对话框
                        $("#saveBannerDialog").dialog('close');
                    }
                },],
            });
        }

        //更新用户操作
        function editInputForm(id) {
            $("#editBannerDialog").dialog({
                href:'${pageContext.request.contextPath}/back/banner/edit.jsp?id='+id,
                title:'更新用户信息',
                iconCls:'icon-edit',
                buttons:[{
                    iconCls:'icon-edit',
                    text:'保存',
                    handler:function () {
                        $("#bannerEditInputForm").form('submit',{
                            url:'${pageContext.request.contextPath}/banner/update',
                            success:function (result){
                                var resultObj = $.parseJSON(result);
                                if (resultObj.success) {
                                    //提示信息
                                    $.messager.show({title:'提示',msg:'更新轮播图成功！！！',showSpeed:700,timeout:5000,});
                                }else {
                                    //提示信息
                                    $.messager.show({title: '提示', msg:resultObj.message});
                                }
                                $("#editBannerDialog").dialog('close');
                                $("#BanTb").datagrid('reload');

                            },

                        })
                    }
                },{
                    iconCls:'icon-cancel',
                    text:'关闭',
                    handler:function (result) {
                        $("#editBannerDialog").dialog('close');
                    },
                }]
            });
        }

        function delBatchRows() {
            var rows = $("#BanTb").datagrid('getSelections');
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
                    url:"${pageContext.request.contextPath}/banner/delRows",
                    type:"POST",
                    traditional:true,
                    data:{"ids":ids},
                    success:function (result) {
                        $.messager.show({title:'提示',msg:'删除成功！！！'});
                        $("#BanTb").datagrid('reload');
                    },
                    error:function () {
                        $.messager.show({title:'提示',msg:'删除失败！！！'});
                        $("#BanTb").datagrid('reload');
                    }
                });
            }
        }
    </script>

    <table id="BanTb" data-options="fit:true"></table>
    <div id="DpTb">
        <a href="#" class="easyui-linkbutton" onclick="openSaveDialog()" data-options="iconCls:'icon-save',plain:true">添加</a>
        <a href="#" class="easyui-linkbutton" onclick="delBatchRows()" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
    </div>

    <%--保存用户对话框--%>
    <div id="saveBannerDialog" data-options="href:'${pageContext.request.contextPath}/back/banner/save.jsp',width:600,height:400"></div>

    <%--更新用户对话框--%>
    <div id="editBannerDialog" data-options="href:'${pageContext.request.contextPath}/back/banner/edit.jsp',width:600,height:400"></div>

