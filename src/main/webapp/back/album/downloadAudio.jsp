<%--
<%@page pageEncoding="UTF-8" isELIgnored="false"%>

<div style="text-align: center;">
    <form id="downloadVideoInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 30px;">
            头像:<input class="easyui-filebox" name="fileName"/>
        </div>
        <div style="margin-top: 20px;">
            名字: <input type="text" name="name"  class="easyui-textbox">
        </div>

    </form>
</div>--%>
杨少婷 15:47:36
@RequestMapping("download")
public  @ResponseBody  void download(HttpSession session, HttpServletResponse response, String  fileName) throws Exception{
String realPath = session.getServletContext().getRealPath("/upload/chapter");
System.out.println("-----------realpath---------------"+realPath);
//1.通过输入流 读入下载的文件                    将用户要下载的名字获取到           自带的方法   将文件读成字节数组
byte[] downloadFile = FileUtils.readFileToByteArray(new File(realPath+"/"+fileName));
//2.通过response获得输出流   输出
//设置下载方式是 下载文件，热不是直接打开  在struts2中是在配置文件中写的
//attachment是指以附件形式打开  filename=xx.txt是指打开的名字
response.setHeader("Content-Disposition", "attachment;filename="+fileName);
OutputStream os = response.getOutputStream();
os.write(downloadFile);
os.flush();
IOUtils.closeQuietly(os);
}
