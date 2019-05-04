package com.example.orangeshare.Dao;

import com.example.orangeshare.Pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    User getUser(String ID);
    boolean  addUser(User user);
    String   getANum(String ID);
    String   getName(String ID);
}
