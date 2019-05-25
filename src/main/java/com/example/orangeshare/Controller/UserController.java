package com.example.orangeshare.Controller;

import com.example.orangeshare.Pojo.Article;
import com.example.orangeshare.Pojo.UA;
import com.example.orangeshare.Pojo.User;
import com.example.orangeshare.ReturnData;
import com.example.orangeshare.ServiceImpl.ArticleServiceImpl;
import com.example.orangeshare.ServiceImpl.UserServiceImpl;
import com.example.orangeshare.Tools.FileUtils;
import com.example.orangeshare.Tools.L;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    ArticleServiceImpl articleServiceImpl;
     @RequestMapping(method= RequestMethod.POST)
      public ReturnData register(User user){
           String message=null;
           if((message=userServiceImpl.addUser(user)).equals("1")){
               L.log("注册用户"+user.getId()+"成功");
               return ReturnData.success();
           }
           else{
               return ReturnData.fail(message);
           }

      }




    @RequestMapping(method= RequestMethod.GET)
    public  ReturnData login(String psw,String id){
         L.log("请求登录");
        User user=userServiceImpl.getUser(id);
        String message=null;
        if(user==null){
             message= "账户不存在";
             L.log(id+"用户不存在");
        }else{
            if(psw.equals(userServiceImpl.getPsw(id))){
                L.log(id+"用户登录成功");
                return ReturnData.success(user);
            }
            else{
                message="密码错误";
                L.log(user.getId()+"密码错误");
            }

        }
         return ReturnData.fail(message);
    }



    @RequestMapping(method= RequestMethod.PUT)
    public ReturnData updateUser(boolean photo_change, String id, String name,String sex, String sign, @RequestParam(required = false) String psw, @RequestParam(required = false)String new_psw,@RequestParam(required = false) MultipartFile user_photo)throws IOException {
        if(photo_change){
            String subffix;
            if((subffix=FileUtils.saveUserPhoto(user_photo, id))!=null){
                User user=new User(id,name,sex,id+"/user_photo"+subffix,sign);
                if(userServiceImpl.updateUser(user))
                    return ReturnData.success();
            }

        }else{
            User user=new User(id,name,sex,sign);
            if(userServiceImpl.updateUser(user))
                return ReturnData.success();
        }
        return  ReturnData.fail("更新信息失败");
    }



}
