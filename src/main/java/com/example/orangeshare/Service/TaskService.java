package com.example.orangeshare.Service;

import java.util.List;
public interface TaskService {
    void CreateArticleWord(List<String> keys,String id,String aid);
    void  addUserHistory(List<String> words,String id);
}
