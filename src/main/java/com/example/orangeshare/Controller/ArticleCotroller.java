package com.example.orangeshare.Controller;

import com.example.orangeshare.Pojo.Article;
import com.example.orangeshare.Pojo.UA;
import com.example.orangeshare.Pojo.User;
import com.example.orangeshare.ReturnData;
import com.example.orangeshare.ServiceImpl.ArticleServiceImpl;
import com.example.orangeshare.ServiceImpl.TaskServiceImpl;
import com.example.orangeshare.ServiceImpl.UserServiceImpl;
import com.example.orangeshare.Style.Section;
import com.example.orangeshare.Tools.FileUtils;
import com.example.orangeshare.Tools.IPUtils;
import com.example.orangeshare.Tools.KeyUtils;
import com.example.orangeshare.Tools.L;
import com.hankcs.hanlp.dependency.nnparser.util.Log;
import jdk.nashorn.internal.runtime.options.LoggingOption;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.hibernate.validator.internal.util.logging.Log_$logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/article")
public class ArticleCotroller {
    @Autowired
      ArticleServiceImpl articleServiceImpl;
    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    TaskServiceImpl taskServiceImpl;
   /* @RequestMapping(method = RequestMethod.GET)
    public  String getArticle(@RequestParam("id") String ID, @RequestParam("aid") String AID, Model model, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        User user=userServiceImpl.getUser(ID);
        Article article=articleServiceImpl.getArticle(ID, AID);
        String ip="http://"+ IPUtils.getIP()+":8081/orange/image/";
        //String ip="/image/";
        if(article!=null){
            model.addAttribute("title", article.getTitle());
            model.addAttribute("des", article.getDes());
            JSONArray jsonArray=JSONArray.fromObject(article.getImgs());
            List<Section> sections=new ArrayList<>();
            for(int i=0;i<jsonArray.size();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                Section section=new Section();
                section.setType(jsonObject.getInt("type"));
                section.setTitle(jsonObject.getString("title"));
                section.setSub_heading(jsonObject.getString("sub_heading"));
                section.setDes(jsonObject.getString("des"));
                section.setPhoto(ip+jsonObject.getString("photo"));
                System.out.println(section.getPhoto());
                sections.add(section);
            }

            model.addAttribute("sections", sections);
            model.addAttribute("name", user.getName());
            model.addAttribute("user_photo", ip+user.getUser_photo());
        }

        return "works";
    }*/



    @RequestMapping(method = RequestMethod.POST)
    public ReturnData addArticle(MultipartFile[] imgs,String title,String des,String[] titles,String[] deses,String id,int sort)throws IOException {

        ReturnData returnData=new ReturnData();
        String aid=String.valueOf(userServiceImpl.getANum(id)+1);
        if(FileUtils.saveImg(imgs,id,aid)){

            String[]  photos=new String[imgs.length];
            for(int i=0;i<imgs.length;i++){
                String name="";
                name=imgs[i].getOriginalFilename();//直接返回文件的名字
                String subffix = name.substring(name.lastIndexOf(".") + 1, name.length());
                photos[i]=i+"."+subffix;
            }
            String photos_1=JSONArray.fromObject(photos).toString();
            String titles_1=JSONArray.fromObject(titles).toString();
            String deses_1=JSONArray.fromObject(deses).toString();
            Article article=new Article(id,aid,sort,title,des,photos_1,titles_1,deses_1);
            if(articleServiceImpl.addArticle(article)){
                userServiceImpl.addANum(id);
                returnData.status="1";
                taskServiceImpl.CreateArticleWord(KeyUtils.getKeys(title),id,aid);
            }

        }
        return  returnData;
    }

    @RequestMapping(method =RequestMethod.GET)
    public  UA getArticle(String id,String aid){
        return  new UA(userServiceImpl.getUser(id),articleServiceImpl.getArticle(id,aid));
    }
    @RequestMapping(value = "/all",method =RequestMethod.GET)
    public  List<UA> getArticles(String id){
         User user=userServiceImpl.getUser(id);
         List<Article> articles=articleServiceImpl.getArticles(id);
         List<UA> uas=new ArrayList<>();
         for(Article article:articles){
             uas.add(new UA(user,article));
         }
         return  uas;
    }

}
