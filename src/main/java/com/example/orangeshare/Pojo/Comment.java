package com.example.orangeshare.Pojo;

public class Comment {
    String id;
    String aid;
    String from_id;
    String content;
    String data;
    String user_photo;
    String name;

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

    public String getFrom_id() {
        return from_id;
    }

    public void setFrom_id(String from_id) {
        this.from_id = from_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public Comment(String user_photo, String name) {
        this.user_photo = user_photo;
        this.name = name;
    }

    public Comment(String id, String aid, String from_id, String content, String data, String user_photo, String name) {
        this.id = id;
        this.aid = aid;
        this.from_id = from_id;
        this.content = content;
        this.data = data;
        this.user_photo = user_photo;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Comment(String id, String aid, String from_id, String content) {
        this.id = id;
        this.aid = aid;
        this.from_id = from_id;
        this.content = content;
    }
}
