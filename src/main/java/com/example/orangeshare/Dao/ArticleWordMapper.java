package com.example.orangeshare.Dao;

import com.example.orangeshare.Pojo.Article;
import com.example.orangeshare.Pojo.ArticleWord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface ArticleWordMapper {
        int  add(ArticleWord articleWord);
        int  delete(@Param("id")String id,@Param("aid")String aid);
        List<ArticleWord>  search(String word, RowBounds rowBounds);
}
