package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.entity.Chapter;
import com.baizhi.entity.FileParm;
import com.baizhi.service.ChapterService;
import com.baizhi.util.UploadUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.Style;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/download")
    public @ResponseBody void download(String fileName,String openStyle,HttpServletRequest request,HttpServletResponse response) throws Exception{
        Map<String,Object> results = new HashMap<String,Object>();


            //1.根据接收的文件名去服务中指定目录读取文件
            String realPath = request.getSession().getServletContext().getRealPath("/back/img/upload");
            //2.以文件输入流读取文件
            FileInputStream is = new FileInputStream(new File(realPath,fileName));
            //2.1 设置响应头
            response.setHeader("content-disposition", openStyle+";fileName="+URLEncoder.encode(fileName, "UTF-8"));

            results.put("success",true);

            //3.获取响应输出流
            ServletOutputStream os = response.getOutputStream();
            //4.使用IOUtils工具类
            IOUtils.copy(is, os);
            //5.关流
            IOUtils.closeQuietly(is);//安静关流
            IOUtils.closeQuietly(os);


    }
    /*@RequestMapping("download")
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
    }*/
    //上传音频文件
    @RequestMapping("/addAudio")
    public @ResponseBody Map<String,Object> addAudio(Chapter chapter , HttpServletRequest request, MultipartFile fileName,String parsetId){
        Map<String,Object> results = new HashMap<String,Object>();
        String type = fileName.getContentType();
        String audioSize="";
        int MB = 1024 * 1024;
        DecimalFormat df = new DecimalFormat("0.00");
        if(type.equals("audio/mp3")){
        try {
            FileParm fileParm = UploadUtil.uploadFile(fileName,request,UploadUtil.FILE);
            File file = new File(fileParm.getUrl());

            MP3File fe = (MP3File)AudioFileIO.read(file);
            MP3AudioHeader audioHeader = (MP3AudioHeader)fe.getAudioHeader();
            System.out.println(audioHeader.getTrackLength());
            String tracklen = audioHeader.getTrackLengthAsString();
            chapter.setDuration(tracklen);


            long size = fileName.getSize();
            /*audioSize = df.format(size / (float) MB);
            long l = Long.parseLong([audioSize]);*/
            chapter.setSize(size/1000000);

            chapter.setParsetId(parsetId);
            chapter.setTitle(fileParm.getOldFileName());
            chapter.setDownPath(fileParm.getUrl().substring(fileParm.getUrl().length()-40));

            chapterService.add(chapter);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
        }else {
            results.put("message","请上传音频文件！！");
        }
        return results;
    }


    @RequestMapping("/findAll")
    public @ResponseBody Map<String,Object> findbyPage(Integer page,Integer rows){
        //System.out.println(page+rows);
        Map<String,Object> results = new HashMap<>();
        List<Chapter> chapters = chapterService.findByPage(page, rows);
        Long totals = chapterService.findTotals();
        results.put("total",totals);
        results.put("rows",chapters);
        return results;
    }

    @RequestMapping("/findOne")
    public @ResponseBody Chapter findone(String id){
        return chapterService.findOne(id);
    }

    @RequestMapping("/delete")
    public @ResponseBody void delect(String id){
        chapterService.remove(id);
    }

    @RequestMapping("/delRows")
    public @ResponseBody void delRows(String[] ids){
        for (String  id : ids) {
            chapterService.remove(id);
        }
    }

    @RequestMapping("/update")
    public @ResponseBody Map<String,Object> update(Chapter chapter){
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            chapterService.motify(chapter);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
}
