<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(".text").textbox({
        required:true
    })
</script>

<div style="text-align: center">
    <form class="easyui-form" id="albumSaveInputForm" method="post">
        <div style="margin-top: 50px;">
            专辑名称：<input type="text" name="title" class="text" data-options="validType:'CHS'"/>
        </div>
        <div style="margin-top: 20px;">
            专辑封面：<input type="text" name="coverImg" class="text" data-options="validType:'image'"/>
        </div>
        <div style="margin-top: 20px;">
            专辑上传时间：<input class="easyui-datebox" name="publishDate" type="text" data-options="validType:''"/>
        </div>
        <div style="margin-top: 20px;">
            评星：<input type="text" name="star" class="text" data-options="validType:'number'"/>
        </div>
        <div style="margin-top: 20px;">
            作者：<input type="text" name="author" class="text" data-options="validType:''"/>
        </div>
        <div style="margin-top: 20px;">
            播音：<input type="text" name="broadCast" class="text" data-options="validType:''"/>
        </div>
        <div style="margin-top: 20px;">
            上师状态：<input type="text" name="status" class="text" data-options="validType:'number'"/>
        </div>
    </form>
</div>