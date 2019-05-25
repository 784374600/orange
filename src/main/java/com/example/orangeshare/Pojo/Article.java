package com.example.orangeshare.Pojo;

public class Article implements Comparable<Article>{
    String id;
    String aid;
    int stars;
    String des;
    String title;
    int collections;
    int   sort;

    public Article(String id, String aid) {
        this.id = id;
        this.aid = aid;
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

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
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

    String imgs;
    String titles;
    String deses;

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getDeses() {
        return deses;
    }

    public void setDeses(String deses) {
        this.deses = deses;
    }



    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }





    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Article(String id, String aid, int sort, String title, String des,String imgs, String titles, String deses ,int stars,int collections) {
        this.id = id;
        this.aid = aid;
        this.stars = stars;
        this.des = des;
        this.title = title;
        this.collections = collections;
        this.sort = sort;
        this.imgs = imgs;
        this.titles = titles;
        this.deses = deses;
    }

    public Article(String id, String aid, int sort, String title, String des,String imgs, String titles, String deses) {
        this.id = id;
        this.aid = aid;
        this.des = des;
        this.title = title;
        this.imgs = imgs;
        this.titles = titles;
        this.deses = deses;
        this.sort=sort;
    }


    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    @Override
    public int hashCode() {
        return id.hashCode()+aid.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Article s=(Article)obj;
        if(id.equals(s.id)&& aid.equals(s.aid))
            return  true;
        return false;
    }

    @Override
    public int compareTo(Article o) {
        return o.stars-this.stars;
    }
}
