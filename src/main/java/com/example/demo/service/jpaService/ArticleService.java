package com.example.demo.service.jpaService;

import com.example.demo.dataobject.jpaEntity.FAddress;
import com.example.demo.dataobject.jpaEntity.FArticle;

public interface ArticleService {
    FArticle findOne(Long id);
    FArticle saveFArticle( FArticle article);
    void remove(Long id);
}
