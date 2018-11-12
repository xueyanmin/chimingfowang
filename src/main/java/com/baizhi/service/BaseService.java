package com.baizhi.service;



import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseService<T> {
    void add(T t);

    void motify(T t);

    void remove(String id);

    T findOne(String id);

    T findByUsernamePassword(@Param("username") String username,@Param("password") String password);

    List<T> findAll();

    //参数1:起始条数 //参数2:每页显示的记录数
    List<T> findByPage(Integer page,Integer rows);

    Long findTotals();
}
