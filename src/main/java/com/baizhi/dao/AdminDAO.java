package com.baizhi.dao;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDAO {
    Admin queryOne(@Param("id") String id);

    void update(@Param("id") String id, @Param("password") String password);

    Admin queryByNamePassword(@Param("name") String name, @Param("password") String password);
}
