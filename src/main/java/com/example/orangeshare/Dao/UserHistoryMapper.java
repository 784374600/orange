package com.example.orangeshare.Dao;

import com.example.orangeshare.Pojo.UserHistory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface UserHistoryMapper {
      int add(String id,String word);
      int inc(String id,String word,int num);
      int delete(String id,String word);
      int contain(String id,String word);
      List<UserHistory> get(String id);
}
