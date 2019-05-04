package com.example.orangeshare.Pojo;

public class Article {
    String ID;
    String AID;
    int    stars;
    String des;
    String title;
    String content;
    String aphoto;

    public String getID() {
        return ID;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
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

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAphoto() {
        return aphoto;
    }

    public void setAphoto(String aphoto) {
        this.aphoto = aphoto;
    }

    public Article(String ID, String AID, String title, String des) {
        this.ID = ID;
        this.AID = AID;
        this.title = title;
        this.des = des;
    }

    public Article(String ID, String AID, int stars, String des, String title, String content, String aphoto) {
        this.ID = ID;
        this.AID = AID;
        this.stars = stars;
        this.des = des;
        this.title = title;
        this.content = content;
        this.aphoto = aphoto;
    }


    public  String toString(){
        return ID+" "+AID+" "+aphoto+" "+ title+" "+content+" "+stars;
    }
}
