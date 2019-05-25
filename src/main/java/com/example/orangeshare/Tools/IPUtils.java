package com.example.orangeshare.Tools;

import com.example.orangeshare.Pojo.Article;
import com.example.orangeshare.Pojo.User;
import com.hankcs.hanlp.dependency.nnparser.util.Log;
import net.sf.json.JSON;
import net.sf.json.JSONArray;

import java.net.InetAddress;
import java.util.List;

public class IPUtils {
    public  static String  getIP(){
        InetAddress ia=null;
        try {
            ia=ia.getLocalHost();

            String localname=ia.getHostName();
            String localip=ia.getHostAddress();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ia.getHostAddress();
    }
    public static void handleImgURL(List<Article> articles){
             for(Article article:articles)
                 doImg(article);
    }
    public  static void doImg(Article article){
        String ip="http://"+ IPUtils.getIP()+":8081/orange/image/";
        JSONArray jsonArray=JSONArray.fromObject(article.getImgs());
        String[] imgs=new String[jsonArray.size()];
        for(int i=0;i<jsonArray.size();i++){
             imgs[i]=ip+article.getId()+"/"+article.getAid()+"/"+jsonArray.get(i).toString();
        }
        article.setImgs(JSONArray.fromObject(imgs).toString());
    }
    public static void handleUserPhoto(User user){
        String user_photo=user.getUser_photo();
        if(user_photo==null || user_photo.equals(""))
            user_photo="undefined.png";
        user.setUser_photo("http://"+ IPUtils.getIP()+":8081/orange/image/"+user_photo);
    }


}
