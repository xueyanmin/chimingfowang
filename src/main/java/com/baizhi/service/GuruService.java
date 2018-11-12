package com.baizhi.service;

import com.baizhi.entity.Guru;

public interface GuruService extends BaseService<Guru> {
    void upload(String id,String head);
}
