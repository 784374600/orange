package com.example.orangeshare.Controller;

import com.example.orangeshare.Pojo.Article;
import com.example.orangeshare.Pojo.User;
import com.example.orangeshare.ServiceImpl.ArticleServiceImpl;
import com.example.orangeshare.ServiceImpl.UserServiceImpl;
import com.example.orangeshare.Style.Section;
import com.example.orangeshare.Tools.IPUtils;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleCotroller {
    @Autowired
      ArticleServiceImpl articleService;
    @Autowired
    UserServiceImpl userService;
    @RequestMapping(method = RequestMethod.GET)
    public  String getArticle(@RequestParam("ID") String ID, @RequestParam("AID") String AID, Model model, HttpServletResponse response){
        System.out.println("哈哈哈");
        response.setHeader("Access-Control-Allow-Origin", "*");
        User user=userService.getUser(ID);
        Article article=articleService.getArticle(ID, AID);
        String ip="http://"+ IPUtils.getIP()+":8080/orange/image/";
        //String ip="/image/";
        if(article!=null){
            model.addAttribute("title", article.getTitle());
            model.addAttribute("des", article.getDes());
            JSONArray jsonArray=JSONArray.fromObject(article.getContent());
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
    }
}
