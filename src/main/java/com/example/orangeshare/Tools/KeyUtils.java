package com.example.orangeshare.Tools;

import com.hankcs.hanlp.HanLP;

import java.util.List;

public class KeyUtils {
    public  static List<String> getKeys(String title){
            int count=3;
            if(title.length()<4)
                count=1;
            else if(title.length()<10)
                count=2;
            if(title.length()>20)
                 count=5;
        List<String> keywordList = HanLP.extractKeyword(title, count);
        return keywordList;

    }
}
