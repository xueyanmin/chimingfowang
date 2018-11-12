<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    var toolbar= [{
        iconCls: 'icon-edit',
        text:'专辑详情',
        handler: function(){
            var selectRow1=$("#album").treegrid("getSelected");
            if(selectRow1!=null){
                if(selectRow1.size==null){
                    $("#album_dialog").dialog("open");
                    $("#album_form").form("load",selectRow1);
                }else{
                    alert('您选的是章节~');
                }
            }else{
                alert('请选择您要了解的专辑~');
            }
        }
    },'-',

        {
            iconCls: 'icon-add',
            text:'添加专辑',
            handler: function(){
                $("#addAlbumdialog").dialog({
                    toolbar:[{
                        text:'编辑',
                        iconCls:'icon-edit',
                    },{
                        text:'帮助',
                        iconCls:'icon-help',
                    }],
                    buttons:[{
                        text:'保存',
                        iconCls:'icon-help',
                        handler:function(){
                            $("#albumSaveInputForm").form('submit',{
                                url:'${pageContext.request.contextPath}/album/add',
                                success:function(result){
                                    var resultObj = $.parseJSON(result);
                                    if(resultObj.success){
                                        //提示信息
                                        $.messager.show({title:'提示',msg:"添加成功!!!"});
                                    }else{
                                        //提示信息
                                        $.messager.show({title:'提示',msg:resultObj.message});
                                    }
                                    //关闭对话框
                                    $("#addAlbumdialog").dialog('close');
                                    //刷新datagrid
                                    $("#album").treegrid('reload');
                                }
                            });
                        }
                    },{
                        text:'关闭',
                        iconCls:'icon-cancel',
                        handler:function(){
                            $("#addAlbumdialog").treegrid('close');
                        }
                    }]
                });
            }
        },'-',

        {
            iconCls: 'icon-add',
            text:'添加章节',
            handler: function(){
                var selectRow1=$("#album").treegrid("getSelected");
                if(selectRow1==null){
                    alert('请选择一个专辑~');
                }else{
                    if(selectRow1.size==null){
                        $("#addChapterdialog").dialog({
                            toolbar:[{
                                text:'编辑',
                                iconCls:'icon-edit',
                            },{
                                text:'帮助',
                                iconCls:'icon-help',
                            }],
                            buttons:[{
                                text:'保存',
                                iconCls:'icon-help',
                                handler:function(){
                                    $("#addChapterInputForm").form('submit',{
                                        url:'${pageContext.request.contextPath}/chapter/addAudio?parsetId='+selectRow1.id,
                                        success:function(result){
                                            var resultObj = $.parseJSON(result);
                                            if(resultObj.success){
                                                //提示信息
                                                $.messager.show({title:'提示',msg:"添加成功!!!"});
                                            }else{
                                                //提示信息
                                                $.messager.show({title:'提示',msg:resultObj.message});
                                            }
                                            //关闭对话框
                                            $("#addChapterdialog").dialog('close');
                                            //刷新datagrid
                                            $("#album").treegrid('reload');
                                        }
                                    });
                                }
                            },{
                                text:'关闭',
                                iconCls:'icon-cancel',
                                handler:function(){
                                    $("#addChapterdialog").dialog('close');
                                }
                            }]
                        });
                    }else{
                        alert('请选中一张专辑而并不是一个章节~');
                    }
                }
            }
        },'-',

        {
            iconCls: 'icon-add',
            text:'下载音频',
            handler: function(){
                var jQuery = $("#album").treegrid('getSelected');
                var down = jQuery.downPath;
                var id = jQuery.parsetId;
                //alert(typeof (id));
                if (jQuery==""||jQuery==null||typeof (id)=="undefined"){
                    $.messager.show({title:'提示',msg:'请选择章节下载.......'});
                } else {
                    location.href='${pageContext.request.contextPath}/chapter/download?openStyle=attachment&fileName='+down;
                }
            }
        }]

    $(function(){
        $("#album").treegrid({
            url:'${pageContext.request.contextPath}/album/findAll',
            idField:'id',
            treeField:'title',
            fit:true,
            fitColumns:true,
            toolbar:toolbar,
            pagination:true,
            lines:true,
                columns:[[
                {field:'title',title:'名字',width:350,align:'left'},
                {field:'downPath',title:'下载路径',width:220,align:'left'},
                {field:'size',title:'音频大小',width:220,align:'left'},
                {field:'duration',title:'音频时长',width:220,align:'left'},
            ]]
        });

    });

</script>

<table id="album"></table>

<%--专辑详情展示--%>
<div id="album_dialog" class="easyui-dialog" title="专辑详情展示" style="width:420px;height:320px;padding-left: 50px;" data-options="readonly:true,iconCls:'icon-add',resizable:true,modal:true,closed:true">
    <form id="album_form" method="post">
        <div style="margin-top: 20px;">
            名称: <input type="text" name="title"  class="easyui-textbox"  data-options="readonly:true">
        </div>
        <div style="margin-top: 20px;">
            星级: <input type="text" name="star"  class="easyui-textbox" data-options="readonly:true">
        </div>
        <div style="margin-top: 20px;">
            封面: <input type="text" name="coverImg"  class="easyui-textbox" data-options="readonly:true,resizable:false,draggable:false">
        </div>
        <div style="margin-top: 20px;">
            作者: <input type="text" name="author"  class="easyui-textbox" data-options="readonly:true,resizable:false,draggable:false">
        </div>
        <div style="margin-top: 20px;">
            播音: <input type="text" name="broadCast"  class="easyui-textbox" data-options="readonly:true,resizable:false,draggable:false">
        </div>
        <div style="margin-top: 20px;">
            日期: <input type="text" name="publishDate"  class="easyui-textbox" data-options="readonly:true,resizable:false,draggable:false">
        </div>
        <div style="margin-top: 20px;" >
            简介:<input type="text" name="brief" style="height: 100px" class="easyui-textbox"  data-options="multiline:true,readonly:true,resizable:false,draggable:false">
        </div>
    </form>
</div>

<%-- 保存专辑对话框--%>
<div id="addAlbumdialog" data-options="href:'${pageContext.request.contextPath}/back/album/save.jsp',iconCls:'icon-add',draggable:false,width:430,height:460,title:'添加专辑'"></div>

<%-- 保存章节对话框--%>
<div id="addChapterdialog" data-options="href:'${pageContext.request.contextPath}/back/album/addChapter.jsp',iconCls:'icon-add',draggable:false,width:430,height:250,title:'添加章节'"></div>

 <%--下载音频对话框
<div id="downloadVideodialog" style="width:420px;height:320px;padding-left: 100px;" data-options="iconCls:'icon-save',draggable:false,width:430,height:350,title:'下载音频'">
    <form id="downloadVideoInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 30px;">
            名字: <input type="text" name="title"  class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            路径: <input type="text" name="downPath"  class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            大小: <input type="text" name="size"  class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            时长: <input type="text" name="duration"  class="easyui-textbox">
        </div>
    </form>
</div>
--%>