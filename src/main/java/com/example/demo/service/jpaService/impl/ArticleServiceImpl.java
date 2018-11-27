package com.example.demo.service.jpaService.impl;

import com.example.demo.dataobject.jpaEntity.FArticle;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.service.jpaService.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleRepository articleRepository;
    @Override
    public FArticle findOne(Long id) {
        return articleRepository.findOne(id);
    }

    @Override
    @Transactional
    public FArticle saveFArticle(FArticle article) {
        return articleRepository.save(article);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        articleRepository.delete(id);
    }
}
