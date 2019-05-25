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


    public ReturnData() {
    }

    public static ReturnData success(Object data){
         ReturnData returnData=new ReturnData();
         returnData.setStatus("1");
         returnData.setData(data);
         return returnData;
    }
    public  static ReturnData success(){
        ReturnData returnData=new ReturnData();
        returnData.setStatus("1");
        return returnData;
    }
    public static ReturnData fail(String message){
        ReturnData returnData=new ReturnData();
        returnData.setData(message);
        return returnData;
    }

}
