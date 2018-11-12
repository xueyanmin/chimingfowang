<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<head>
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/easyui-lang-zh_CN.js"></script>
    <script>
        $(function () {
            $(".text").textbox();
            /*$('#ffdd').form('submit', {
                url:'',
                onSubmit: function(param){

                }
            });

                    $("#ff").form('submit',{
                        url:'pageContext.request.contextPath}/user/test',
                        success:function (result) {
                        }
                    })
*/
        });

    </script>
</head>
<body>
<div style="margin:5em auto;text-align:center;width:600px;height:470px;border: #8f95a1 1px solid;">
    <h2>用户注册页面</h2>
    <form class="easyui-form" id="ff" action="${pageContext.request.contextPath}/user/add"  method="post">
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
            <input type="submit" value="注册"  data-options="width:80"/>
        </div>
    </form>
</div>

</body>
</html>