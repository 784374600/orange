package com.example.orangeshare;

import com.example.orangeshare.Pojo.Article;
import com.example.orangeshare.Pojo.IndexArticleBox;
import com.example.orangeshare.Pojo.User;
import com.example.orangeshare.ServiceImpl.ArticleServiceImpl;
import com.example.orangeshare.ServiceImpl.UserServiceImpl;

import com.example.orangeshare.Style.Section;
import com.example.orangeshare.Tools.IPUtils;
import net.sf.json.JSONArray;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@MapperScan("com.examole.orangeshare.Dao")
@RequestMapping("/")
@SpringBootApplication//exclude = DataSourceAutoConfiguration.class
public class OrangeshareApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrangeshareApplication.class, args);
    }
    @Autowired
    ArticleServiceImpl articleService;
    @Autowired
    UserServiceImpl userService;

    @RequestMapping(method = RequestMethod.GET)
    public  String index(){
        return "index";
    }
   /* @RequestMapping(value="/index",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public  @ResponseBody String index(HttpServletResponse response, Model model){
        response.setHeader("Access-Control-Allow-Origin", "*");
            List<IndexArticleBox> boxs=new ArrayList<>();
            List<Article> articles=articleService.index();
        String ip="http://"+ IPUtils.getIP()+":8081/orange/image/";
            for(int i=0;i<articles.size();i++){
                Article t=articles.get(i);
                User s=userService.getUser(t.getID());
                   IndexArticleBox box=new IndexArticleBox(t.getID(),t.getAID(),ip+t.getAphoto(),ip+ s.getUser_photo(),s.getName(),t.getTitle(),t.getDes(), t.getStars());
                  boxs.add(box);
            }
            model.addAttribute("boxes",boxs);
            return  JSONArray.fromObject(boxs).toString();

    }*/
    public  void addUser(){

    }
}
