package com.baizhi.test;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestMenu extends BaseTest {
    @Autowired
    private MenuService menuService;

    @Test
    public void fingall(){
        List<Menu> menus = menuService.findAll();
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }

}
