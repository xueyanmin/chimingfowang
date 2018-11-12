package com.baizhi.service;

import com.baizhi.dao.ArticleDAO;
import com.baizhi.dao.GuruDAO;
import com.baizhi.entity.Article;
import com.baizhi.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDAO articleDAO;
    @Autowired
    private GuruDAO guruDAO;

    @Override
    public void add(Article article) {
        article.setId(UUID.randomUUID().toString());
        articleDAO.insert(article);
        List<Guru> gurus = guruDAO.queryAll();
    }

    @Override
    public void motify(Article article) {
        articleDAO.update(article);
    }

    @Override
    public void remove(String id) {
        articleDAO.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Article findOne(String id) {
        return articleDAO.queryOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Article findByUsernamePassword(String name, String password) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Article> findAll() {
        return articleDAO.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Article> findByPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return articleDAO.queryByPage(start,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return articleDAO.queryTotals();
    }
}
