package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService extends BaseService<Album> {
    List<Album> queryAnd();
}
