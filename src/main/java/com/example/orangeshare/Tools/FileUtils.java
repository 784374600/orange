package com.example.orangeshare.Tools;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class FileUtils {
    static String path;
     public static boolean saveImg(MultipartFile[] file,String ID,String AID)throws IOException {
            for(int i=0;i<file.length;i++){
                String name="";

                name=file[i].getOriginalFilename();//直接返回文件的名字
                String subffix = name.substring(name.lastIndexOf(".") + 1, name.length());
                String filePath = "D:/orangeshare/src/main/resources/image" + "/" +ID+"/"+AID+"/"+i+"."+subffix;
                File desFile = new File(filePath);
                if(!desFile.getParentFile().exists()){
                    desFile.getParentFile().mkdirs();
                }
                try {
                    file[i].transferTo(desFile);
                } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
                    return false;

                }
            }
            return true;
     }
     public  static String saveUserPhoto(MultipartFile file,String ID)throws IOException{
         String name="";

         name=file.getOriginalFilename();//直接返回文件的名字
         String subffix = name.substring(name.lastIndexOf(".") + 1, name.length());
         String filePath = "D:/orangeshare/src/main/resources/image" + "/" +ID+"/"+"user_photo"+"."+subffix;
         File desFile = new File(filePath);
         if(!desFile.getParentFile().exists()){
             desFile.getParentFile().mkdirs();
         }
         try {
             file.transferTo(desFile);
         } catch (IllegalStateException | IOException e) {
             e.printStackTrace();
             return null;

         }
         return "."+subffix;
     }


    public static  String  getUrl() {
        String path = null;
        try {
            String serverpath= ResourceUtils.getURL("classpath:static").getPath().replace("%20"," ").replace('/', '\\');
            path=serverpath.substring(1);//从路径字符串中取出工程路径
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return path;
    }
    public  static String getPath(){
         if(path==null){
             path=getUrl();
         }
         return path;
    }

}
