package com.baizhi.controller;

import com.baizhi.entity.Article;
import com.baizhi.entity.Banner;
import com.baizhi.entity.Guru;
import com.baizhi.service.ArticleService;
import com.baizhi.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private GuruService guruService;

    @RequestMapping("/add")
    public @ResponseBody Map<String,Object> add(Article article){
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            articleService.add(article);
            List<Guru> gurus = guruService.findAll();
            results.put("guru",gurus);
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
        //
        // System.out.println(page);
        Long totals = articleService.findTotals();
        //System.out.println(totals);
        // System.out.println(rows);
        List<Article> articles = articleService.findByPage(page, rows);

        results.put("total",totals);
        results.put("rows",articles);

        return results;
    }

    @RequestMapping("/findOne")
    public @ResponseBody Article findone(String id){
        return articleService.findOne(id);
    }

    @RequestMapping("/delete")
    public @ResponseBody void delect(String id){
        articleService.remove(id);
    }

    @RequestMapping("/delRows")
    public @ResponseBody void delRows(String[] ids){
        for (String  id : ids) {
            articleService.remove(id);
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

