package com.example.demo.repository;

import com.example.demo.dataobject.jpaEntity.FArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<FArticle,Long> {

}