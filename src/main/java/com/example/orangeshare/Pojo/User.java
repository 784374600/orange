package com.example.orangeshare.Pojo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class User {


    String id;
    String psw;
    String name;
    String sex;
    String user_photo;
    String sign;
    int fans;
    int anum;
    int focus;

    public User(String id, String psw, String name, String sex, String user_photo, String sign, int fans, int anum, int focus) {
        this.id = id;
        this.psw = psw;
        this.name = name;
        this.sex = sex;
        this.user_photo = user_photo;
        this.sign = sign;
        this.fans = fans;
        this.anum = anum;
        this.focus = focus;
    }


    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public User(String id, String psw, String name, String sex, String user_photo, String sign, int anum) {
        this.id = id;
        this.psw = psw;
        this.name = name;
        this.sex = sex;
        this.user_photo = user_photo;
        this.sign = sign;
        this.anum = anum;
    }

    public  User(){}

    public User(String id, String name, String sex, String sign) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.sign = sign;
    }

    public User(String id, String psw) {
        this.id = id;
        this.psw = psw;
    }

    public User(String id, String name, String sex, String user_photo, String sign) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.user_photo = user_photo;
        this.sign=sign;
    }

    public String getId() {
        return id;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public int getFocus() {
        return focus;
    }

    public void setFocus(int focus) {
        this.focus = focus;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public int getAnum() {
        return anum;
    }

    public void setAnum(int anum) {
        this.anum = anum;
    }
}
