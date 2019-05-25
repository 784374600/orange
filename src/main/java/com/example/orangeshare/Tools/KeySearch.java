package com.example.orangeshare.Tools;

import com.example.orangeshare.Pojo.Article;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import net.sf.json.JSONArray;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeySearch {
    public static void main(String[] args) {
        String content = "大地";
        List<String> keywordList = HanLP.extractKeyword(content, 6);
        System.out.println(keywordList);
        String[] imgs=new String[3];
        imgs[0]="0.jpg";imgs[1]="1.jpg";imgs[2]="1.jpg";
        System.out.println(JSONArray.fromObject(imgs));

    }
}
