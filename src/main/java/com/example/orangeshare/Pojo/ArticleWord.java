package com.example.orangeshare.Pojo;

public class ArticleWord {
       String word;
       String id;
       String aid;

    public ArticleWord(String word, String id, String aid) {
        this.word = word;
        this.id = id;
        this.aid = aid;
    }

    public ArticleWord(String id, String aid) {
        this.id = id;
        this.aid = aid;
    }

    @Override
    public int hashCode() {
        return id.hashCode()+aid.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        ArticleWord a=(ArticleWord) obj;
        if(a.getAid().equals(aid) && a.getId().equals(id))
        return true;
        else
            return false;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }
}
