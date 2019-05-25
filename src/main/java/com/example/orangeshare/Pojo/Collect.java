package com.example.orangeshare.Pojo;

import com.example.orangeshare.Tools.IPUtils;
import net.sf.json.JSONArray;

public class Collect {
    String id;
    String from_id;
    String  from_aid;
    String  name;
    String  user_photo;
    String  img;
    String  title;
    int collections;
    int stars;

    public Collect(String id, String from_id, String from_aid, String name, String user_photo, String img, String title, int collections, int stars) {
        this.id = id;
        this.from_id = from_id;
        this.from_aid = from_aid;
        this.name = name;
        this.user_photo = user_photo;
        this.img = img;
        this.title = title;
        this.collections = collections;
        this.stars = stars;
    }

    public void set(User user, Article article){
         this.setName(user.getName());
         this.setUser_photo(user.getUser_photo());
         String imgs=article.getImgs();
         this.title=article.getTitle();
         String ip="http://"+ IPUtils.getIP()+":8081/orange/image/"+from_id+"/"+from_aid+"/";
         this.setImg(ip+JSONArray.fromObject(imgs).get(0).toString());
         this.stars=article.getStars();this.collections=article.getCollections();
         IPUtils.handleUserPhoto(user);
         user_photo=user.getUser_photo();
    }

    public int getCollections() {
        return collections;
    }

    public void setCollections(int collections) {
        this.collections = collections;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Collect(String from_id, String from_aid) {
        this.from_id = from_id;
        this.from_aid = from_aid;
    }

    public Collect(String id, String from_id, String from_aid) {
        this.id = id;
        this.from_id = from_id;
        this.from_aid = from_aid;
    }

    public Collect(String id, String from_id, String from_aid, String name, String user_photo, String img) {
        this.id = id;
        this.from_id = from_id;
        this.from_aid = from_aid;
        this.name = name;
        this.user_photo = user_photo;
        this.img = img;
    }
    public Collect(){

    }

    public String getFrom_id() {
        return from_id;
    }

    public void setFrom_id(String from_id) {
        this.from_id = from_id;
    }

    public String getFrom_aid() {
        return from_aid;
    }

    public void setFrom_aid(String from_aid) {
        this.from_aid = from_aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
