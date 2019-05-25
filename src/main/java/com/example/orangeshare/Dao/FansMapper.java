package com.example.orangeshare.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface FansMapper {
    int add(String id,String from_id);
    int delete(String id,String from_id);
    List<String> getFans(String id);
}
