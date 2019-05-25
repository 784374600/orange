package com.example.orangeshare.ServiceImpl;

import com.example.orangeshare.Dao.ArticleWordMapper;
import com.example.orangeshare.Dao.UserHistoryMapper;
import com.example.orangeshare.Pojo.Article;
import com.example.orangeshare.Pojo.ArticleWord;
import com.example.orangeshare.Pojo.User;
import com.example.orangeshare.Pojo.UserHistory;
import com.example.orangeshare.Service.TaskService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TaskServiceImpl implements TaskService {
        @Autowired
        ArticleWordMapper articleWordMapper;

        @Autowired
        UserHistoryMapper userHistoryMapper;



        @Async
        @Override
        public void CreateArticleWord(List<String> words, String id, String aid) {
                try {
                        for(int i=0;i<words.size();i++)  {
                                articleWordMapper.add(new ArticleWord(words.get(i), id, aid));
                        }

                } catch (Exception e) {
                        System.out.println("出现异常");
                        e.printStackTrace();

                }

        }
        @Async
        @Override
        public  void addUserHistory(List<String> words,String id){
                List<UserHistory> histories=userHistoryMapper.get(id);
                for(String word:words){
                        if(histories.contains(new UserHistory(id, word))){
                                userHistoryMapper.inc(id,word,2);
                        }
                        else{
                                if(histories.size()==0){
                                        userHistoryMapper.add(id,word);
                                        break;
                                }
                                       UserHistory temp=null;
                                       int min=10000;
                                for(UserHistory userHistory:histories){
                                        double similarity=compare(userHistory.getWord(), word);
                                        if(similarity>=0.7){
                                                userHistoryMapper.inc(id,userHistory.getWord(),2);
                                                userHistory.setImportance(userHistory.getImportance()+2);
                                        }else if(similarity>=0.5){
                                                userHistoryMapper.inc(id,userHistory.getWord(),1);
                                                userHistory.setImportance(userHistory.getImportance()+1);
                                        }
                                        if(userHistory.getImportance()<=min)
                                                temp=userHistory;

                                }
                                if(histories.size()>=30){
                                        userHistoryMapper.delete(temp.getId(), temp.getWord());
                                }
                                userHistoryMapper.add(id,word);

                        }

                }


        }


        public double compare(String w1, String w2) {
                double s; int count=0;
                List<ArticleWord> W1=articleWordMapper.search(w1, new RowBounds(0,50));
                List<ArticleWord> W2=articleWordMapper.search(w2, new RowBounds(0,50));
                Set<ArticleWord> commons=new HashSet<>(W1);
                for(ArticleWord article:W2){
                        if(commons.contains(article))
                                count++;
                }
                return Math.max(count/(double)(W1.size()), count/(double)(W2.size()));
        }


}
