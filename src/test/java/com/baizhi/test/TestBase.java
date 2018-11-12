package com.baizhi.test;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import com.baizhi.service.GuruService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public interface TestBase  {


    @Test
    public void add();

    @Test
    public void update();

    @Test
    public void findall();

    @Test
    public void findone();

    @Test
    public void findbypage();

    @Test
    public void toles();
}
