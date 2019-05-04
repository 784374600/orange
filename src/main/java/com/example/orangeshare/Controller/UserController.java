package com.example.orangeshare.Controller;

import com.example.orangeshare.Dao.UserMapper;
import com.example.orangeshare.Pojo.User;
import com.example.orangeshare.Service.UserService;
import com.example.orangeshare.ServiceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;
     @RequestMapping(method= RequestMethod.POST)
      public String register(@RequestBody User user){

             return userServiceImpl.addUser(user);
      }
    @RequestMapping(method= RequestMethod.GET)
    public  String  getUser(String ID){
        //return userServiceImpl.getUser(ID);
        return "lalalal";

    }
    @RequestMapping(value = "/ANum",method= RequestMethod.GET)
    public  String getANum(String ID){
         return userServiceImpl.getANum(ID);
    }
}
