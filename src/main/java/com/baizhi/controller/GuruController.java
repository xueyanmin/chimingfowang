package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.entity.FileParm;
import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import com.baizhi.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/guru")
public class GuruController {

    /*@RequestMapping("/find")
    public @ResponseBody String queryone(String enCode, HttpServletRequest request){
        System.out.println(enCode);
       ;HttpSession session = request.getSession();
        String code1 = (String) session.getAttribute("code");
        System.out.println(code1);
        return "index";
    }*/

    @Autowired
    private GuruService guruService;

    @RequestMapping("/upload")
    public @ResponseBody Map<String,Object> upload(String id,MultipartFile file, HttpServletRequest request, String filea) throws IOException {
        HashMap<String, Object> results = new HashMap<>();
        try {

            FileParm fileParm = UploadUtil.uploadFile(file,request,UploadUtil.FILE);

            guruService.upload(id,fileParm.getUrl().substring(fileParm.getUrl().length()-40));
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }



    @RequestMapping("/add")
    public @ResponseBody void add(Guru guru) {
       /* HashMap<String, Object> results = new HashMap<String,Object>();
        try {
            guruService.add(gurn);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;*/
       guruService.add(guru);
    }

    @RequestMapping("/findKey")
    public @ResponseBody List<Guru> findbyfind() {
        HashMap<String, Object> results = new HashMap<String,Object>();
        List<Guru> gurus = guruService.findAll();
        return gurus;
    }

    @RequestMapping("/findByPage")
    public @ResponseBody Map<String, Object> findbyPage(Integer page, Integer rows, HttpServletRequest request) {
        HashMap<String, Object> results = new HashMap<String,Object>();
        List<Guru> gurus = guruService.findByPage(page, rows);
        Long totals = guruService.findTotals();
        results.put("total",totals);
        results.put("rows",gurus);
        return results;
    }


    @RequestMapping("/findAll")
    public @ResponseBody List<Guru> findbyPage() {
       /* HashMap<String, Object> results = new HashMap<String,Object>();
        List<Guru> gurus = guruService.findByPage(page, rows);
        Long totals = guruService.findTotals();
        results.put("total",totals);
        results.put("rows",gurus);*/
        List<Guru> results = guruService.findAll();
        return results;
    }


    @RequestMapping("/findOne")
    public @ResponseBody Guru findone(String id) {
        return guruService.findOne(id);
    }


    @RequestMapping("/delete")
    public @ResponseBody void delect(String id) {
        guruService.remove(id);
    }


    @RequestMapping("/delRows")
    public @ResponseBody void delRows(String[] ids) {
        for (String id : ids) {
            guruService.remove(id);
        }
    }



    @RequestMapping("/update")
    public @ResponseBody void update(Guru guru) {
       /* HashMap<String, Object> results = new HashMap<>();
        //System.out.println(guru);
        try {
            guruService.motify(guru);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }

        return results;*/

       guruService.motify(guru);
    }
}
