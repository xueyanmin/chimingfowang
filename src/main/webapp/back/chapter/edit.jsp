<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(".text").textbox({
        required:true
    });
    $(function () {
        $("#guruEditInputForm").form('load','${pageContext.request.contextPath}/guru/findOne?id=${param.id}');
    });
</script>

<div style="text-align: center">
    <form class="easyui-form" id="guruEditInputForm" method="post">
        <input type="hidden" name="id" value="${param.id}"/>
        <div style="margin-top: 50px;">
            上师名称：<input type="text" name="name" class="text" data-options="validType:'CHS'"/>
        </div>
        <div style="margin-top: 20px;">
            上师头像路径：<input type="text" name="headPicPath" class="text" data-options="validType:'image'"/>
        </div>
        <div style="margin-top: 20px;">
            上师性别：
            <select  name="sex" class="easyui-combobox" data-options="width:159">
                <option value="M">男</option>
                <option value="W">女</option>
            </select>
        </div>
        <div style="margin-top: 20px;">
            上师状态：<input type="text" name="status" class="text" data-options="validType:'number'"/>
        </div>
    </form>
</div>