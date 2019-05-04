package com.example.orangeshare.Tools;

import com.hankcs.hanlp.dependency.nnparser.util.Log;

import java.net.InetAddress;

public class IPUtils {
    public  static String  getIP(){
        InetAddress ia=null;
        try {
            ia=ia.getLocalHost();

            String localname=ia.getHostName();
            String localip=ia.getHostAddress();
            System.out.println("本机名称是："+ localname);
            System.out.println("本机的ip是 ："+localip);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ia.getHostAddress();
    }

}
