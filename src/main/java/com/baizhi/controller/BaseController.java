package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class BaseController {

    @RequestMapping("/add")
    public @ResponseBody Map<String,Object> add(Object o){
        Map<String,Object> results = new HashMap<String,Object>();
        try {

            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }



    @RequestMapping("/findAll")
    public @ResponseBody Map<String,Object> findbyPage(Integer page,Integer rows){
        Map<String,Object> results = new HashMap<>();

        results.put("total",page);
        results.put("rows",rows);
        return results;
    }

    @RequestMapping("/findOne")
    public @ResponseBody String findone(String id){
       // System.out.println(id);

        return null;
    }

    @RequestMapping("/delete")
    public @ResponseBody void delect(String id){

    }

    @RequestMapping("/delRows")
    public @ResponseBody void delRows(String[] ids){
        for (String  id : ids) {

        }
    }

    @RequestMapping("/update")
    public @ResponseBody Map<String,Object> update(Banner banner){
        Map<String,Object> results = new HashMap<String,Object>();
        try {

            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
}
