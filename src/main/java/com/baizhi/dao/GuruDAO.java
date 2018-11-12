package com.baizhi.dao;

import com.baizhi.entity.Guru;
import org.apache.ibatis.annotations.Param;

public interface GuruDAO extends BaseDAO<Guru> {

    void upload(@Param("id")String id,@Param("headPicPath")String head);
}
