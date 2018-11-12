package com.baizhi.test;

import com.baizhi.entity.Article;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ArticleService;
import com.baizhi.service.ChapterService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class TestChapter extends BaseTest implements TestBase  {
    @Autowired
    private ChapterService chapterService;

    @Override
    public void update() {

    }

    @Override
    @Test
    public void findall() {
        List<Chapter> all = chapterService.findAll();
        for (Chapter chapter : all) {
            System.out.println(chapter);
        }
    }

    @Override
    @Test
    public void findone() {
        Chapter one = chapterService.findOne("");
        System.out.println(one);

    }

    @Override
    @Test
    public void findbypage() {
        List<Chapter> byPage = chapterService.findByPage(1, 5);
        for (Chapter chapter : byPage) {
            System.out.println(chapter);
        }
    }

    @Override
    @Test
    public void toles() {
        Long totals =chapterService.findTotals();
        System.out.println(totals);
    }

    @Override
    @Test
    public void add() {
       /* Chapter chapter = new Chapter("","",5.0,new Date(),"445",new Date(),"B002");
        chapterService.add(chapter);*/
    }
}
