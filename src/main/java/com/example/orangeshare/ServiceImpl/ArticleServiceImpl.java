package com.example.orangeshare.ServiceImpl;

import com.example.orangeshare.Dao.ArticleMapper;
import com.example.orangeshare.Pojo.Article;
import com.example.orangeshare.ReturnData;
import com.example.orangeshare.Service.ArticleService;
import com.sun.xml.internal.bind.v2.model.core.ID;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    @Override
    @Transactional
    public String addArticle(Article article) {
        ReturnData   returndata=new ReturnData();

        try {
            returndata.data=articleMapper.addArticle(article);
            returndata.status="1";
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
        JSONObject jsonObject=JSONObject.fromObject(returndata);
        return jsonObject.toString();
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public List<Article> index() {
        List<Article> lists=new ArrayList<>();
        try {
             lists=articleMapper.index();
              return lists;
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return lists;

    }

    @Override
    public String deleteArticle(String ID, String AID) {
        ReturnData   returndata=new ReturnData();
        try {
            returndata.data=articleMapper.deleteArticle(ID,AID);
            returndata.status="1";
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
        JSONObject jsonObject=JSONObject.fromObject(returndata);
        return jsonObject.toString();
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public Article getArticle(String ID, String AID) {
        Article article=null;
        try {
            article=articleMapper.getArticle(ID,AID);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return article;
    }

    @Override
    public String getArticles(String ID) {
        ReturnData   returndata=new ReturnData();

        try {
            returndata.data=articleMapper.getArticles(ID);
            returndata.status="1";
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
        JSONObject jsonObject=JSONObject.fromObject(returndata);
        return jsonObject.toString();
    }
}
