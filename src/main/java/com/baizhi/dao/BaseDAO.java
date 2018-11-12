package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDAO<T> {
    void insert(T t);

    void update(T t);

    void delete(@Param("id") String id);

    T queryOne(@Param("id") String id);

    T queryByUsernamePassword(@Param("username") String name,@Param("password") String password);

    List<T> queryAll();

    //参数1:起始条数 //参数2:每页显示的记录数
    List<T> queryByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    Long queryTotals();
}
