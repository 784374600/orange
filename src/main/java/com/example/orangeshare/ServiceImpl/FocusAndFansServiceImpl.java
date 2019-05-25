package com.example.orangeshare.ServiceImpl;

import com.example.orangeshare.Dao.FansMapper;
import com.example.orangeshare.Dao.FocusMapper;
import com.example.orangeshare.Dao.UserMapper;
import com.example.orangeshare.Pojo.User;
import com.example.orangeshare.Service.FocusAndFansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;
@Service
public class FocusAndFansServiceImpl implements FocusAndFansService {
    @Autowired
    FocusMapper focusMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    FansMapper fansMapper;
    @Override
    @Transactional
    public boolean add(String id, String from_id) {
        try {
            focusMapper.add(id,from_id);
            fansMapper.add(from_id,id);
            userMapper.setFans(from_id, 1);
            userMapper.setFocus(id,1);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public boolean delete(String id, String from_id) {
        try {
            focusMapper.delete(id,from_id);
            fansMapper.delete(from_id,id);
            userMapper.setFans(from_id, -1);
            userMapper.setFocus(id,-1);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public List<User> getFocus(String id) {
        List<User> users=new ArrayList<>();
        try {
            List<String> ids=focusMapper.getFocus(id);
            for(String s :ids){
              users.add(userMapper.getUser(id));
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return users;
    }
    @Override
    public List<User> getFans(String id) {
        List<User> users=new ArrayList<>();
        try {
            List<String> ids=fansMapper.getFans(id);
            for(String s :ids){
                users.add(userMapper.getUser(id));
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return users;
    }
}
