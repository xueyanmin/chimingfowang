package com.baizhi.test;

import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.PrivateKey;
import java.util.List;

public class TestGuru extends BaseTest implements TestBase  {
    @Autowired
    private GuruService guruService;

    @Override
    @Test
    public void add() {
        Guru guru = new Guru("","佛陀","/10.jpg","m",1);
        guruService.add(guru);
    }

    @Override
    @Test
    public void update() {
        Guru guru = new Guru("be73c27f-1451-4b6c-b83e-7ee2a407dd45","佛陀","/10.jpg","m",2);
        guruService.motify(guru);
    }

    @Override
    @Test
    public void findall() {

        List<Guru> gurus = guruService.findAll();
        for (Guru guru : gurus) {
            System.out.println(guru);
        }
    }

    @Override
    @Test
    public void findone() {
        Guru guru = guruService.findOne("G006");
        System.out.println(guru);
    }

    @Override
    @Test
    public void findbypage() {
        List<Guru> byPage = guruService.findByPage(1, 3);
        for (Guru guru : byPage) {
            System.out.println(guru);
        }
    }

    @Override
    @Test
    public void toles() {
        Long totals = guruService.findTotals();
        System.out.println(totals);
    }
}
