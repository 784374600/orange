package com.example.orangeshare.Controller;

import com.example.orangeshare.Pojo.Article;
import com.example.orangeshare.Pojo.User;
import com.example.orangeshare.ReturnData;
import com.example.orangeshare.ServiceImpl.ArticleServiceImpl;
import com.example.orangeshare.ServiceImpl.TaskServiceImpl;
import com.example.orangeshare.ServiceImpl.UserServiceImpl;
import com.example.orangeshare.Tools.IPUtils;
import com.example.orangeshare.Tools.KeyUtils;
import com.example.orangeshare.Tools.L;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.PriorityQueue;

@RestController
public class ActionController {

    @Autowired
    ArticleServiceImpl articleServiceImpl;
    @Autowired
    TaskServiceImpl taskService;
    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ReturnData home(int page){
        ReturnData returnData=new ReturnData();
        List<Article> articles= articleServiceImpl.home(page);
        IPUtils.handleImgURL(articles);
        returnData.data=articles;
        returnData.status="1";
        if(articles.size()==0)
            returnData.setStatus("0");
        return  returnData;
    }


    @RequestMapping(value ="/search",method = RequestMethod.GET)
    public  List<Article> search(String content,String id){
        L.log(id+"开始搜索");
        if(!id.equals(""))
        taskService.addUserHistory(KeyUtils.getKeys(content),id);
        return  articleServiceImpl.search(content);
    }


    @RequestMapping(value ="/love",method = RequestMethod.GET)
    public  ReturnData love(String id,String aid,int num){
        if(articleServiceImpl.setStars(id, aid, num))
            return ReturnData.success();
        return ReturnData.fail("点赞失败，请稍后再试");
    }

    @RequestMapping(value = "/otherUser",method= RequestMethod.GET)
    public User getOther(String id){
        User user=userServiceImpl.getUser(id);
        return user;
    }
}
