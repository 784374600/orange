package com.example.orangeshare.Tools;

import com.hankcs.hanlp.HanLP;

import java.util.List;

public class KeySearch {
    public static void main(String[] args) {
        String content=" 爱情是没有界限的，就算两个人相隔两处，也终究会因为爱而重逢，爱是两个人的事，如果你还一个人执著着，纠缠着，原地打滚痛苦地爱着。时过境迁之后你会发现，是自己挖了坑，下面埋葬的全部都是青春。";
        List<String> keywordList = HanLP.extractKeyword(content, 1);
        System.out.println(keywordList);
    }
}
