package com.example.orangeshare.Service;

import com.example.orangeshare.Pojo.Comment;

import java.util.List;

public interface CommentService {
    boolean add(Comment comment);
    boolean delete(String id,String aid,String from_id);
    List<Comment> getComments(String id, String aid, int page);
}
