package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService extends BaseService<User> {
    void updateStatus(String id,Integer status);
}
