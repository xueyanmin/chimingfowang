package com.baizhi.test;


import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestAdmin extends BaseTest {
    @Autowired
    private AdminService adminService;

    @Test
    public void update(){
        adminService.update("A35","999666");
    }

    @Test
    public void findone(){
        Admin xym123 = adminService.findByNamePassword("xym123", "999666");
        System.out.println(xym123);
    }
}
