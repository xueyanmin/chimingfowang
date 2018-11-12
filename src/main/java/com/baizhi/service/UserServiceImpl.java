package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public void updateStatus(String id, Integer stutas) {
        userDAO.updateStart(id,stutas);
    }

    @Override
    public void add(User user) {
        user.setId(UUID.randomUUID().toString());
        user.setStatus(1);
        user.setCreateDate(new Date());
        userDAO.insert(user);
    }

    @Override
    public void motify(User user) {
        userDAO.update(user);
    }

    @Override
    public void remove(String id) {
        userDAO.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User findOne(String id) {
        return userDAO.queryOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User findByUsernamePassword(String name, String password) {
        return userDAO.queryByUsernamePassword(name,password);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> findAll() {
        return userDAO.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> findByPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return userDAO.queryByPage(start,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return userDAO.queryTotals();
    }
}
