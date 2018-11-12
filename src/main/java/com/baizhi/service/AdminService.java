package com.baizhi.service;

import com.baizhi.entity.Admin;



public interface AdminService {
    void update(String id,String password);

    Admin queryOne(String id);

    Admin findByNamePassword(String name,String password);
}
