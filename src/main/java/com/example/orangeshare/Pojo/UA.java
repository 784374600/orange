package com.example.orangeshare.Pojo;

public class UA {
    String id;
    String aid;
    String user_photo;
    String title;
    String des;
    String imgs;
    String name;
    String sign;
    String titles;
    String deses;
    int stars;
    int collections;
    public UA(User user,Article article){
        this.id=user.getId();this.aid=article.getAid();
        this.user_photo=user.getUser_photo();this.title=article.getTitle();
        this.des=article.getDes();this.imgs=article.getImgs();this.name=user.getName();
        this.sign=user.getSign();this.stars=article.getStars();this.collections=article.getCollections();
        this.deses=article.getDeses();this.titles=article.getTitles();
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public UA(String id, String aid, String user_photo, String title, String des, String imgs, String name, String sign, String titles, String deses, int stars, int collections) {
        this.id = id;
        this.aid = aid;
        this.user_photo = user_photo;
        this.title = title;
        this.des = des;
        this.imgs = imgs;
        this.name = name;
        this.sign = sign;
        this.titles = titles;
        this.deses = deses;
        this.stars = stars;
        this.collections = collections;
    }

    public String getDeses() {
        return deses;
    }

    public void setDeses(String deses) {
        this.deses = deses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
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

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getCollections() {
        return collections;
    }

    public void setCollections(int collections) {
        this.collections = collections;
    }
}
