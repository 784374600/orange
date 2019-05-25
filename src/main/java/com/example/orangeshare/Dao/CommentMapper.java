package com.example.orangeshare.Dao;

import com.example.orangeshare.Pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface CommentMapper {
       int add(Comment comment);
       int delete(String id,String aid,String from_id);
       List<Comment> getComments(String id, String aid, RowBounds rowBounds);
}
