<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>

</script>


<div style="text-align: center">

    <form id="album_form" class="easyui-form" method="post">
        <div>
            <label for="title">专辑名称:</label>
            <input class="easyui-validatebox" type="text" id="title" name="title" />
        </div>
        <div>
            <label for="count">专辑集数:</label>
            <input class="easyui-validatebox" type="text" name="count" id="count" />
        </div>
        <div>
            <label for="coverImg">专辑封面:</label>
            <input class="easyui-validatebox" type="text" name="coverImg" id="coverImg" />
           <%-- <img id="coverImg" name="coverImg" src="">--%>
        </div>
        <div>
            <label for="publishDate">专辑上传时间:</label>
            <input class="easyui-datebox" type="text" id="publishDate" name="publishDate" />
        </div>
        <div>
            <label for="star">评星:</label>
            <input class="easyui-validatebox" type="text" name="star" id="star" />
        </div>
        <div>
            <label for="author">作者:</label>
            <input class="easyui-validatebox" type="text" id="author" name="author" />
        </div>
        <div>
            <label for="broadCast">播音:</label>
            <input class="easyui-validatebox" type="text" name="broadCast" id="broadCast" />
        </div>
        <div>
            <label for="brief">简介:</label>
            <input class="easyui-combobox" type="text" id="brief" name="brief">
        </div>
    </form>
</div>


