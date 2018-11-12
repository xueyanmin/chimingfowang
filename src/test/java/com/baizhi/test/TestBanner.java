package com.baizhi.test;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class TestBanner extends BaseTest {
    @Autowired
    private BannerService bannerService;

    @Test
    public void add(){
        Banner banner = new Banner();
        banner.setCreateDate(new Date());
        banner.setDesc("佛陀");
        banner.setTitle("佛陀");
        banner.setImgPath("/back/fotuo/find.jpg");
        banner.setStatus(1);
        bannerService.add(banner);
    }

    @Test
    public void update(){

       // bannerService.updateStatus("88033624-5e9f-414f-b693-8dd05e51c9bd",2);
    }

    @Test
    public void findall(){
        List<Banner> all = bannerService.findAll();
        for (Banner banner : all) {
            System.out.println(banner);
        }
    }

    @Test
    public void findone(){
        Banner f01 = bannerService.findOne("F01");
        System.out.println(f01);
    }

    @Test
    public void findbypage(){
        List<Banner> byPage = bannerService.findByPage(1, 3);
        for (Banner banner : byPage) {
            System.out.println(banner);
        }
    }

    @Test
    public void toles(){
        Long totals = bannerService.findTotals();
        System.out.println(totals);
    }

}
