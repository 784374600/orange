package com.example.orangeshare.Dao;

import com.example.orangeshare.Pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface ArticleMapper {
    String getName(String id);
    int addArticle(Article article);
    boolean deleteArticle(@Param("id") String id, @Param("aid") String aid);
    Article getArticle(@Param("id") String id, @Param("aid") String aid);
    List<Article> getArticles(String id);
    List<Article> getBySort(int sort, RowBounds rowBounds);
    int   setCollections(String id,String aid,int num);
    int   setStars(String id,String aid,int num);

}
