<%@page pageEncoding="UTF-8" isELIgnored="false"%>

<div style="text-align: center;">
    <form id="addChapterInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 20px;">
            id: <input type="text" name="id"  class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            文件: <input name="file"  class="easyui-filebox">
        </div>
        <div style="margin-top: 20px;">
            路径: <input type="text" name="downPath"  class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            大小: <input name="size"  class="easyui-filebox">
        </div>
        <div style="margin-top: 20px;">
            时长: <input name="duration"  class="easyui-filebox">
        </div>
    </form>
</div>