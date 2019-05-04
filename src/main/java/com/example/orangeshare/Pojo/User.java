package com.example.orangeshare.Pojo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class User {


    String ID;
    String PSW;
    String name;
    String sex;
    String user_photo;
    int anum;

    public User(String ID, String PSW, String name, String sex, String user_photo) {
        this.ID = ID;
        this.PSW = PSW;
        this.name = name;
        this.sex = sex;
        this.user_photo = user_photo;
    }
    public User(String ID, String name, String sex, String user_photo,int anum) {
        this.ID = ID;
        this.name = name;
        this.sex = sex;
        this.user_photo = user_photo;
        this.anum=anum;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPSW() {
        return PSW;
    }

    public void setPSW(String PSW) {
        this.PSW = PSW;
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
