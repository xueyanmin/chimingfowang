<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
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
            if(${sessionScope.admin==null}){
                location.href="${pageContext.request.contextPath}/back/admin/login.jsp";
            }
            $.post("${pageContext.request.contextPath}/menu/findAll",function(result){
                $.each(result,function (index,menu) {
                    var content="<div style='text-align: center;'>";
                    $.each(menu.parentId,function (index,child) {
                        content += "<div style='margin-top:7px;'><a onclick=\"addTabs('"+child.title+"','"+child.iconCls+"','"+child.href+"')\" style='border:1px #ccc solid;width:92%;' class='easyui-linkbutton' data-options=\" plain:true,iconCls:'"+child.iconCls+"'\">"+child.title+"</a></div><br/>";
                    })
                    content+="</div>"

                    $("#menu").accordion('add',{
                        title:menu.title,
                        iconCls:menu.iconCls,
                        content:content,
                    });
                });
            });
        });
        function addTabs(title,iconCls,href) {
            if(!$("#tabs").tabs('exists',title)){
                $("#tabs").tabs('add',{
                    title:title,
                    iconCls:iconCls,
                    closable:true,
                    href:"${pageContext.request.contextPath}/"+href,
                });
            }else{
                $("#tabs").tabs('select',title);
            }
        }
    </script>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',split:true,href:'${pageContext.request.contextPath}/back/main/head.jsp'" style="height:60px;background-color:  #5C160C"></div>
    <div data-options="region:'south',split:true,href:'${pageContext.request.contextPath}/back/main/foot.jsp'" style="height: 40px;background: #5C160C"></div>

    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
        <div id="menu" class="easyui-accordion" data-options="fit:true"></div>
    </div>
    <div data-options="region:'center'">
        <div id="tabs" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
            <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
        </div>
    </div>
</body>
</html>