package com.example.orangeshare.Dao;

import com.example.orangeshare.Pojo.Collect;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CollectionMapper {
     int add(Collect collect);
     int delete(Collect collect);
     List<Collect> getCollections(String id);
}
