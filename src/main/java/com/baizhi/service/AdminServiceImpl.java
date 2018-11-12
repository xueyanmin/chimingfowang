package com.baizhi.service;

import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {


    @Autowired
    private AdminDAO adminDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Admin queryOne(String id) {
        return adminDAO.queryOne(id);
    }
    @Override
    public void update(String id, String password) {
        adminDAO.update(id,password);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Admin findByNamePassword(String name,String password) {
        return adminDAO.queryByNamePassword(name,password);
    }
}
