package com.example.orangeshare.Pojo;

public class UserHistory {
    String id;
    String word;
    int importance;

    @Override
    public int hashCode() {
        return id.hashCode()+word.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
         UserHistory userHistory=(UserHistory)obj;
         if(id.equals(userHistory.id) && word.equals(userHistory.word))
             return  true;
         return false;
    }

    public UserHistory(String id, String word) {
        this.id = id;
        this.word = word;
    }

    public UserHistory(String id, String word, int importance) {
        this.id = id;
        this.word = word;
        this.importance = importance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }
}
