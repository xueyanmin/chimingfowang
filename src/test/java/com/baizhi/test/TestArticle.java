package com.baizhi.test;

import com.baizhi.dao.BaseDAO;
import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class TestArticle extends BaseTest implements TestBase  {
    @Autowired
    private ArticleService articleService;

    @Override
    public void update() {

    }

    @Override
    @Test
    public void findall() {
        List<Article> list = articleService.findAll();
        for (Article article : list) {
            System.out.println(article);
        }
    }

    @Override
    @Test
    public void findone() {
        Article one = articleService.findOne("F003");
        System.out.println(one);

    }

    @Override
    @Test
    public void findbypage() {
        List<Article> list = articleService.findByPage(1, 5);
        for (Article article : list) {
            System.out.println(article);
        }
    }

    @Override
    @Test
    public void toles() {
        Long totals = articleService.findTotals();
        System.out.println(totals);
    }

    @Override
    public void add() {
        /*Article article = new Article("","ao",".jpg","dd",new Date(),"","");
        articleService.add(article);*/
    }
}
