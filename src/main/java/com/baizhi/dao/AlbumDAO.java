package com.baizhi.dao;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumDAO extends BaseDAO<Album> {
    List<Album> queryAnd();
}
