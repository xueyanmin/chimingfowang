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
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/add")
    public @ResponseBody Map<String,Object> add(Banner banner){
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            bannerService.add(banner);
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
        List<Banner> banners=bannerService.findByPage(page,rows);
        Long totals = bannerService.findTotals();
        results.put("total",totals);
        results.put("rows",banners);
        return results;
    }

    @RequestMapping("/findOne")
    public @ResponseBody Banner findone(String id){
        //System.out.println(id);
        Banner banner = bannerService.findOne(id);
        return banner;
    }

    @RequestMapping("/delete")
    public @ResponseBody void delect(String id){
        bannerService.remove(id);
        /*Map<String,Object> results = new HashMap<String,Object>();
        try {
            bannerService.remove(id);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;*/
    }

    @RequestMapping("/delRows")
    public @ResponseBody void delRows(String[] ids){
        for (String  id : ids) {
            bannerService.remove(id);
        }
    }

    @RequestMapping("/update")
    public @ResponseBody Map<String,Object> update(Banner banner){
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            bannerService.motify(banner);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
}
