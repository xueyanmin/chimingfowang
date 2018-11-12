<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>

<head>
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/form.validator.rules.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/datagrid-detailview.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.etree.js"></script>
    <script>
        $(function () {
            $(".text").textbox();
        });
    </script>
</head>
<body>
<div style="margin:5em auto;text-align: center;width:600px;height:470px;border: #8f95a1 1px solid;">
    <h2>用户注册页面</h2>
    <form class="easyui-form" action="${pageContext.request.contextPath}/user/update" method="post">
        <div style="margin-top: 50px;">
            用户联系：<input type="hidden" value="6f43be55-151c-438d-b429-60898bfcc661" name="id" class="text" data-options="validType:''"/>
        </div>
        <div style="margin-top: 50px;">
            用户联系：<input type="text" name="phoneNum" class="text" data-options="validType:''"/>
        </div>
        <div style="margin-top: 20px;">
            用户昵称：<input type="text" name="username" class="text" data-options="validType:''"/>
        </div>
        <div style="margin-top: 20px;">
            密&nbsp;&nbsp;码：<input type="text" name="password" class="text" data-options="validType:''"/>
        </div>
        <div style="margin-top: 20px;">
            用户法号：<input type="text" name="nickName" class="text" data-options="validType:''"/>
        </div>
        <div style="margin-top: 20px;">
            用户性别：<select  name="sex" class="easyui-combobox" data-options="width:159">
                            <option value="M">男</option>
                            <option value="W">女</option>
                        </select>
        </div>
        <div style="margin-top: 20px;">
            用户法号：<input type="text" name="sign" class="text" data-options="validType:''"/>
        </div>
        <div style="margin-top: 20px;">
            用户头像：<input type="text" name="headPicPath" class="text" data-options="validType:''"/>
        </div>

        <div style="margin-top: 20px;">
            <input type="submit" value="注册" class="text" data-options="width:80"/>
        </div>
    </form>
</div>

</body>
</html>