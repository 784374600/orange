package com.example.orangeshare.ServiceImpl;

import com.example.orangeshare.Dao.UserMapper;
import com.example.orangeshare.Pojo.User;
import com.example.orangeshare.Service.UserService;
import com.example.orangeshare.Tools.IPUtils;
import com.example.orangeshare.Tools.L;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean contain(String id) {
        return userMapper.contain(id)==1;
    }

    @Override
    @Transactional
    public String addUser(User user) {
        try {
            L.log("注册用户"+user.getId());
            if(contain(user.getId())){
                L.log(user.getId()+"用户已存在");
                return "用户已存在";
            }
            else{
                L.log("add注册用户"+user.getId());
                userMapper.addUser(user);
                return "1";
            }
        } catch (Exception e) {
            e.printStackTrace();
            L.log("注册用户"+user.getId()+"出现异常");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return "注册失败，请稍后再试";

        }
    }

    @Override
    public boolean updateUser(User user) {
        try {
            L.log("开始更新user");
            userMapper.updateUser(user);
            L.log("更新user结束");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    @Override
    public int getANum(String id) {
        return userMapper.getANum(id);
    }

    @Override
    public int addANum(String id) {
         return userMapper.addANum(id);
    }

    @Override
    public String getName(String id) {
        try {
            return userMapper.getName(id);
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }

    @Override
    public User getUser(String id) {
         User user=null;
        try {
            user=userMapper.getUser(id);
            if(user!=null){
                L.log("获取User"+user.getId());
                IPUtils.handleUserPhoto(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public String getPsw(String id) {
        return userMapper.getPsw(id);
    }
}
