<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        $("#passwordEditInputForm").form('load','${pageContext.request.contextPath}/admin/findOneID?id=${flag.id}');
    });
</script>
<div style="text-align: center">
    <form class="easyui-form" id="passwordEditInputForm" method="post">
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 50px;">
            昵称：<input type="text" name="name" class="easyui-textbox" data-options=""/>
        </div>
        <div style="margin-top: 20px;">
            新密码：<input type="text" name="password" class="easyui-textbox" data-options="validType:'uname'"/>
        </div>
    </form>
</div>