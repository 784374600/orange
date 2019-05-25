package com.example.orangeshare.Service;

import com.example.orangeshare.Pojo.User;

import java.util.List;

public interface FocusAndFansService {
    boolean  add(String id,String from_id);
    boolean  delete(String id,String from_id);
    List<User>  getFocus(String id);
    List<User>  getFans(String id);
}
