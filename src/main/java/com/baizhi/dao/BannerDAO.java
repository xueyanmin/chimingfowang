package com.baizhi.dao;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

public interface BannerDAO extends BaseDAO<Banner> {

    //void updateStatus(@Param("id") String id,@Param("status") Integer status);
}
