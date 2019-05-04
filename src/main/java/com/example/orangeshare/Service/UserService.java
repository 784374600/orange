package com.example.orangeshare.Service;

import com.example.orangeshare.Pojo.User;

public interface UserService {
    String addUser(User user);
    User getUser(String ID);
    String getANum(String ID);
    String  getName(String ID);
}
