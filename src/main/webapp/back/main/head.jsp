<%@ page pageEncoding="UTF-8" isELIgnored="false" %>

<script>
    function editPassword() {
        $("#eidtPasswrod").dialog({
            //href:'$pageContext.request.contextPath}/back/admin/passwordEdit.jsp?id='+,
            title:'修改管理员信息',
            iconCls:'icon-edit',
            buttons:[{
                iconCls:'icon-edit',
                text:'保存',
                handler:function () {
                    $("#passwordEditInputForm").form('submit',{
                        url:'${pageContext.request.contextPath}/admin/update',
                        success:function (result){
                            var resultObj = $.parseJSON(result);
                            if (resultObj.success) {
                                //提示信息
                                $.messager.show({title:'提示',msg:'修改密码成功！！！',showSpeed:700,timeout:5000,});
                            }else {
                                //提示信息
                                $.messager.show({title: '提示', msg:resultObj.message});
                            }
                            $("#eidtPasswrod").dialog('close');
                            $("#UserTb").datagrid('reload');

                        },

                    })
                }
            },{
                iconCls:'icon-cancel',
                text:'关闭',
                handler:function (result) {
                    $("#eidtPasswrod").dialog('close');
                },
            }]
        });

    }
</script>

<div style="font-size: 24px;color: rgba(241,240,253,0.77);font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 340px;float:right;padding-top:15px">欢迎您:${flag.name} &nbsp;<a href="#" onclick="editPassword()" id="editPassword" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/admin/logout" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">退出系统</a></div>

<div id="eidtPasswrod" data-options="href:'${pageContext.request.contextPath}/back/admin/passwordEdit.jsp',width:450,height:320"></div>