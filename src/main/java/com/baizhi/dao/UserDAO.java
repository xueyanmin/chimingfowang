package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDAO extends BaseDAO<User>{
    void updateStart(@Param("id") String id,@Param("status") Integer status);
}
