package com.example.orangeshare.ServiceImpl;

import com.example.orangeshare.Dao.UserMapper;
import com.example.orangeshare.Pojo.User;
import com.example.orangeshare.ReturnData;
import com.example.orangeshare.Service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    @Transactional
    public String addUser(User user) {

        ReturnData returndata=new ReturnData();
        try {
            userMapper.addUser(user);
            returndata.status="1";
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
        JSONObject jsonObject=JSONObject.fromObject(returndata);
        return jsonObject.toString();
    }

    @Override
    public String getANum(String ID) {
        ReturnData returndata=new ReturnData();
        try {
            System.out.println(userMapper.getANum(ID));
            System.out.println("获取数量");
            returndata.status="1";
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
        JSONObject jsonObject=JSONObject.fromObject(returndata);
        return jsonObject.toString();
    }

    @Override
    public String getName(String ID) {
        try {
            return userMapper.getName(ID);
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public User getUser(String ID) {
         User user=null;
        try {
            user=userMapper.getUser(ID);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return user;
    }
}
