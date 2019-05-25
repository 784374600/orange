package com.example.orangeshare.Service;

import com.example.orangeshare.Dao.ArticleMapper;
import com.example.orangeshare.Pojo.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ArticleService  {
    boolean addArticle(Article article);
    String deleteArticle(@Param("id") String id, @Param("aid") String aid);
    Article getArticle(@Param("id") String id, @Param("aid") String aid);
    List<Article> getArticles(String id);
    List<Article> home(int page);
    List<Article>  search(String content);
    List<Article>  getBySort(int sort);
    boolean setStars(String id,String aid,int num);
}
