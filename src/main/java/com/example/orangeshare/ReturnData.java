package com.example.orangeshare;

import com.example.orangeshare.Pojo.User;
import org.apache.ibatis.javassist.tools.reflect.ClassMetaobject;

public class ReturnData {
    public String status="0";
    public Object data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
