<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(".text").textbox({
        required:true
    });
    $(function () {
        $("#bannerEditInputForm").form('load','${pageContext.request.contextPath}/banner/findOne?id=${param.id}');
    });
</script>

<div style="text-align: center">
    <form class="easyui-form" id="bannerEditInputForm" method="post">
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 50px;">
            图片标题：<input type="text" name="title" class="text" data-options="validType:'CHS'"/>
        </div>
        <div style="margin-top: 20px;">
            图片路径：<input type="text" name="imgPath" class="text" data-options="validType:'image'"/>
        </div>
        <div style="margin-top: 20px;">
            图片描述：<input type="text" name="desc" class="text" data-options="validType:'CHS'"/>
        </div>
        <div style="margin-top: 20px;">
            图片状态：<input type="text" name="status" class="text" data-options="validType:'number'"/>
        </div>
        <div style="margin-top: 20px;">
            创建时间：<input type="text" name="createDate" class="easyui-datebox" />
        </div>
    </form>
</div>