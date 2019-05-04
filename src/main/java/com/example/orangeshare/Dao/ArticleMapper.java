package com.example.orangeshare.Dao;

import com.example.orangeshare.Pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface ArticleMapper {
    String getName(String ID);
    boolean addArticle(Article article);
    boolean deleteArticle(@Param("ID") String ID, @Param("AID") String AID);
    Article getArticle(@Param("ID") String ID, @Param("AID") String AID);
    List<Article> getArticles(String ID);
    List<Article> index();
}
