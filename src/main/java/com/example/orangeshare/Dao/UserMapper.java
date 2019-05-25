package com.example.orangeshare.Dao;

import com.example.orangeshare.Pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    User getUser(String id);
    int  addUser(User user);
    Integer   getANum(String id);
    String   getName(String id);
    String   getPsw(String id);
    int   addANum(String id);
    boolean updateUser(User user);
    int   contain(String id);
    int   setFans(String id,int num);
    int   setFocus(String id,int num);

}
