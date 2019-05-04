package com.example.orangeshare.Service;

import com.example.orangeshare.Dao.ArticleMapper;
import com.example.orangeshare.Pojo.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ArticleService  {
    String addArticle(Article article);
    String deleteArticle(@Param("ID") String ID, @Param("AID") String AID);
    Article getArticle(@Param("ID") String ID, @Param("AID") String AID);
    String getArticles(String ID);
    List<Article> index();
}
