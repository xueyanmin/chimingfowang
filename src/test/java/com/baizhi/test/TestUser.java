package com.baizhi.test;

import com.baizhi.entity.Chapter;
import com.baizhi.entity.User;
import com.baizhi.service.ChapterService;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class TestUser extends BaseTest implements TestBase  {
    @Autowired
    private UserService userService;

    @Override
    @Test
    public void update() {

    }

    @Override
    @Test
    public void findall() {

    }

    @Override
    @Test
    public void findone() {

    }

    @Override
    @Test
    public void findbypage() {
        List<User> byPage = userService.findByPage(1, 2);
        System.out.println(byPage);
    }

    @Override
    @Test
    public void toles() {
        Long totals = userService.findTotals();
        System.out.println(totals);
    }

    @Override
    @Test
    public void add() {
        User user = new User("",215403,"小叶u","123456","Jdi-*%%88**#$%^&*","山西","柳林","金轮法王","男","冻豆腐","tou/yixiang.jpg",1,new Date());
        userService.add(user);
    }
}
