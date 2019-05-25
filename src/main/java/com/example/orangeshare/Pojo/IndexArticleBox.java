package com.example.orangeshare.Pojo;

import com.example.orangeshare.Tools.IPUtils;

public class IndexArticleBox {
    String ID;
    String AID;
    String aphoto;
    String user_photo;
    String name;
    String title;
    String des;
    int    stars;
    String url="http://"+ IPUtils.getIP()+":8081/orange/article?";
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getAID() {
        return AID;
    }

    public void setAID(String AID) {
        this.AID = AID;
    }

    public String getAphoto() {
        return aphoto;
    }

    public void setAphoto(String aphoto) {
        this.aphoto = aphoto;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }


    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public IndexArticleBox(String ID, String AID, String aphoto, String user_photo, String name, String title, String des, int stars) {
        this.ID = ID;
        this.AID = AID;
        this.aphoto = aphoto;
        this.user_photo = user_photo;
        this.name = name;
        this.title = title;
        this.des = des;
        this.stars = stars;
        this.url = this.url+"ID="+ID+"&AID="+AID;
    }
    public void set(String ID, String AID, String aphoto, String user_photo, String name, String title, String content, int stars) {
        this.ID = ID;
        this.AID = AID;
        this.aphoto = aphoto;
        this.user_photo = user_photo;
        this.name = name;
        this.title = title;
        this.des = des;
        this.stars = stars;
        this.url = this.url+"ID="+ID+"&AID="+AID;
    }
    public  String toString(){
        return ID+" "+AID+" "+aphoto+user_photo+" "+name+"  "+ title+" "+des+" "+stars;
    }
}
