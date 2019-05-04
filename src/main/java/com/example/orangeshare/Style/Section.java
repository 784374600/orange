package com.example.orangeshare.Style;

public class Section {
      String title;
      String sub_heading;
      String des;
      String photo;
      int type;

    public Section() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSub_heading() {
        return sub_heading;
    }

    public void setSub_heading(String sub_heading) {
        this.sub_heading = sub_heading;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Section(String title, String sub_heading, String des, String photo, int type) {
        this.title = title;
        this.sub_heading = sub_heading;
        this.des = des;
        this.photo = photo;
        this.type = type;
    }
}
