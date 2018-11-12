package com.baizhi.test;

import com.baizhi.entity.Album;
import com.baizhi.entity.Article;
import com.baizhi.service.AlbumService;
import com.baizhi.service.ArticleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestAlbum extends BaseTest implements TestBase  {
    @Autowired
    private AlbumService albumService;

    @Override
    public void update() {

    }

    @Override
    @Test
    public void findall() {
        List<Album> all = albumService.findAll();
        for (Album album : all) {
            System.out.println(album);
        }
    }

    @Override
    @Test
    public void findone() {
        Album one = albumService.findOne("Ba003");
        System.out.println(one);

    }

    @Override
    @Test
    public void findbypage() {
        List<Album> list = albumService.queryAnd();
        for (Album album : list) {
            System.out.println(album);
        }
    }

    @Override
    @Test
    public void toles() {
        Long totals = albumService.findTotals();
        System.out.println(totals);
    }

    @Override
    public void add() {
        /*Article article = new Article("","ao",".jpg","dd",new Date(),"","");
        articleService.add(article);*/
    }
}
