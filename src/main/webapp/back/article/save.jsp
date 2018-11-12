<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(".text").textbox({
        required:true
    });

</script>

<div style="text-align: center">
    <form class="easyui-form" id="articleSaveInputForm" method="post">
        <div style="margin-top: 50px;">
            文章标题：<input type="text" name="title" class="text" data-options="validType:'CHS'"/>
        </div>
        <div style="margin-top: 20px;">
            文章图片路径：<input type="text" name="imgPath" class="text" data-options="validType:'image'"/>
        </div>
        <div style="margin-top: 20px;">
            文章内容：<input type="text" name="content" class="text" data-options="validType:'image'"/>
        </div>
        <div style="margin-top: 20px;">
            文章创建时间：<input type="text" name="publishDate" class="text" data-options="validType:'image'"/>
        </div>
        <div style="margin-top: 20px;">
            文章跳转路径：<input type="text" name="link" class="text" data-options="validType:'image'"/>
        </div>
        <div style="margin-top: 20px;">
            文章插图路径：<input type="text" name="illuStration" class="text" data-options="validType:'image'"/>
        </div>
        <div style="margin-top: 20px;">
            省份：<select id="province" >
                        <option value="">---请选择----</option>
                  </select>
        </div>
    </form>
</div>