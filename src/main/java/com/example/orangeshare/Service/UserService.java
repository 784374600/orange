package com.example.orangeshare.Service;

import com.example.orangeshare.Pojo.User;

public interface UserService {
    String addUser(User user);
    User getUser(String id);
    int getANum(String id);
    String  getName(String id);
    int addANum(String id);
    boolean updateUser(User user);
    boolean  contain(String id);
    String getPsw(String id);
}
