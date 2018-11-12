package com.baizhi.service;

import com.baizhi.entity.Menu;
import com.baizhi.dao.MenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDAO menuDAO;

    @Override
    public void add(Menu menu) {

    }

    @Override
    public void motify(Menu menu) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public Menu findOne(String id) {
        return null;
    }

    @Override
    public Menu findByUsernamePassword(String name, String password) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Menu> findAll() {
        return menuDAO.queryAll();
    }

    @Override
    public List<Menu> findByPage(Integer start, Integer rows) {
        return null;
    }

    @Override
    public Long findTotals() {
        return null;
    }
}
