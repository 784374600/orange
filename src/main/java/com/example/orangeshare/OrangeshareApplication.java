package com.example.orangeshare;

import com.example.orangeshare.Pojo.Article;
import com.example.orangeshare.Pojo.IndexArticleBox;
import com.example.orangeshare.Pojo.User;
import com.example.orangeshare.ServiceImpl.ArticleServiceImpl;
import com.example.orangeshare.ServiceImpl.UserServiceImpl;

import com.example.orangeshare.Style.Section;
import com.example.orangeshare.Tools.IPUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@MapperScan("com.examole.orangeshare.Dao")
@SpringBootApplication//exclude = DataSourceAutoConfiguration.class
public class OrangeshareApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrangeshareApplication.class, args);
    }
    @Autowired
    ArticleServiceImpl articleService;
    @Autowired
    UserServiceImpl userService;
    @RequestMapping("/")
    public @ResponseBody String inde(){
        List<Section> sections=new ArrayList<>();

        for(int i=1;i<=2;i++){
            Section section=new Section();
            section.setPhoto("3.jpg");
            section.setDes("啊哈哈哈");
            section.setSub_heading("2019.09.11");
            section.setTitle("才徐坤打篮球");
            section.setType(i);
            sections.add(section);
        }
        JSONArray jsonArray=JSONArray.fromObject(sections);
        IPUtils.getIP();
        System.out.println("cai"+jsonArray.toString());
        return "123";
    }
    @RequestMapping(value="/index",method = RequestMethod.GET)
    public  String index(HttpServletResponse response, Model model){
        response.setHeader("Access-Control-Allow-Origin", "*");
            List<IndexArticleBox> boxs=new ArrayList<>();
            List<Article> articles=articleService.index();
        String ip="http://"+ IPUtils.getIP()+":8080/orange/image/";
            for(int i=0;i<articles.size();i++){
                Article t=articles.get(i);
                User s=userService.getUser(t.getID());
                   IndexArticleBox box=new IndexArticleBox(t.getID(),t.getAID(),ip+t.getAphoto(),ip+ s.getUser_photo(),s.getName(),t.getTitle(),t.getDes(), t.getStars());
                  boxs.add(box);
            }
            model.addAttribute("boxes",boxs);
            return  "index";

    }
    public  void addUser(){

    }
}
