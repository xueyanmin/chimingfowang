package com.baizhi.service;

import com.baizhi.dao.ChapterDAO;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterDAO chapterDAO;

    @Override
    public void add(Chapter chapter) {
        chapter.setId(UUID.randomUUID().toString());

        chapter.setUploadDate(new Date());

        chapterDAO.insert(chapter);
    }

    @Override
    public void motify(Chapter chapter) {
        chapterDAO.update(chapter);
    }

    @Override
    public void remove(String id) {
        chapterDAO.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Chapter findOne(String id) {
        return chapterDAO.queryOne(id);
    }

    @Override
    public Chapter findByUsernamePassword(String name, String password) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Chapter> findAll() {
        return chapterDAO.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Chapter> findByPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return chapterDAO.queryByPage(start,rows);
    }

    @Override
    public Long findTotals() {
        return chapterDAO.queryTotals();
    }
}
