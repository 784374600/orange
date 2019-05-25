package com.example.orangeshare.ServiceImpl;

import com.example.orangeshare.Dao.ArticleWordMapper;
import com.example.orangeshare.Dao.ArticleMapper;
import com.example.orangeshare.Pojo.Article;
import com.example.orangeshare.Pojo.ArticleWord;
import com.example.orangeshare.ReturnData;
import com.example.orangeshare.Service.ArticleService;
import com.example.orangeshare.Tools.IPUtils;
import com.example.orangeshare.Tools.KeyUtils;
import com.example.orangeshare.Tools.L;
import com.hankcs.hanlp.dependency.nnparser.util.Log;
import net.sf.json.JSONObject;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

@Service
public class ArticleServiceImpl implements ArticleService {
    /*public static PriorityQueue<Article> hotArticles=new PriorityQueue<Article>(100,new Comparator<Article>() {
        @Override
        public int compare(Article o1, Article o2) {
            return o1.getStars()-o2.getStars();
        }
    });*/


    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    ArticleWordMapper articleWordMapper;

    @Override
    public List<Article> search(String content) {
            L.log("搜索"+content);
            Set<ArticleWord> sets=new HashSet<>();
           List<String> keys= KeyUtils.getKeys(content);
           for(int i=0;i<keys.size();i++){
               L.log("搜索"+keys.get(i));
              sets.addAll(articleWordMapper.search(keys.get(i),new RowBounds(0,30)));
           }

           List<ArticleWord> articlewords=new ArrayList<>(sets);
           List<Article> articles=new ArrayList<>();
           for(ArticleWord articleword:articlewords){
               articles.add(articleMapper.getArticle(articleword.getId(), articleword.getAid()));

           }
        IPUtils.handleImgURL(articles);
           return articles;
    }

    @Override
    public List<Article> getBySort(int sort) {
        return articleMapper.getBySort(sort, new RowBounds(0,20));

    }

    @Override
    @Transactional
    public boolean addArticle(Article article) {
        try {
            articleMapper.addArticle(article);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public  List<Article> home(int page) {
        PriorityQueue<Article> hotArticles=new PriorityQueue<Article>(100,new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                return o1.getStars()-o2.getStars();
            }
        });
        for(int n=0;n<8;n++){
            List<Article> articles=getBySort(n);
            if(articles==null)
                continue;
             for(int j=0;j<articles.size();j++){
                   if(hotArticles.size()<100){
                       hotArticles.add(articles.get(j));
                       continue;
                   }
                   if(articles.get(j).getStars()>hotArticles.peek().getStars()){
                            hotArticles.poll();
                         hotArticles.add(articles.get(j));
                   }
             }
        }

        List<Article> articleList=new ArrayList<>();
         Iterator<Article> iterator=hotArticles.iterator();
        while (iterator.hasNext())
        {
            articleList.add(iterator.next());
        }

        return articleList;

    }

    @Override
    public String deleteArticle(String id, String aid) {
        ReturnData   returndata=new ReturnData();
        try {
            returndata.data=articleMapper.deleteArticle(id,aid);
            returndata.status="1";
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
        JSONObject jsonObject=JSONObject.fromObject(returndata);
        return jsonObject.toString();
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public Article getArticle(String id, String aid) {
        Article article=null;
        try {
            article=articleMapper.getArticle(id,aid);
            if(article!=null)
            IPUtils.doImg(article);
        } catch (Exception e) {

            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return article;
    }

    @Override
    public List<Article> getArticles(String id) {
            List<Article> articles=articleMapper.getArticles(id);
        IPUtils.handleImgURL(articles);
            return  articles;
    }

    @Override
    public boolean setStars(String id, String aid,int num) {
        try {
            articleMapper.setStars(id,aid,num);
            return  true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
