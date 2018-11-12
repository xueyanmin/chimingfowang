package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Banner;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @RequestMapping("/add")
    public @ResponseBody Map<String,Object> add(Album album){
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            albumService.add(album);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }



    @RequestMapping("/findAll")
    public @ResponseBody List<Album> findbyPage(Integer page,Integer rows){
        List<Album> results = albumService.queryAnd();
        return results;
    }

    @RequestMapping("/findOne")
    public @ResponseBody Album findone(String id){
        return albumService.findOne(id);
    }

    @RequestMapping("/delete")
    public @ResponseBody void delect(String id){
        albumService.remove(id);
    }

    @RequestMapping("/delRows")
    public @ResponseBody void delRows(String[] ids){
        for (String  id : ids) {
            albumService.remove(id);
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
