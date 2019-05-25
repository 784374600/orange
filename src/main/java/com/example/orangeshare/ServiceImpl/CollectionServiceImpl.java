package com.example.orangeshare.ServiceImpl;

import com.example.orangeshare.Dao.ArticleMapper;
import com.example.orangeshare.Dao.CollectionMapper;
import com.example.orangeshare.Dao.UserMapper;
import com.example.orangeshare.Pojo.Article;
import com.example.orangeshare.Pojo.Collect;
import com.example.orangeshare.Pojo.User;
import com.example.orangeshare.Service.CollectionService;
import com.example.orangeshare.Tools.L;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    CollectionMapper collectionMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ArticleMapper articleMapper;

    @Override
    @Transactional
    public boolean add(Collect collect) {
        try {
            collectionMapper.add(collect);
            articleMapper.setCollections(collect.getFrom_id(), collect.getFrom_aid(),1);
            L.log("添加收藏成功");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            L.log("添加收藏失败");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(Collect collect) {
        try {
            collectionMapper.delete(collect);
            articleMapper.setCollections(collect.getFrom_id(), collect.getFrom_aid(),-1);
            L.log("删除收藏成功");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            L.log("删除收藏失败");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public List<Collect> getCollections(String id) {
        List<Collect> collects =new ArrayList<>();
        try {
            collects =collectionMapper.getCollections(id);
            for(Collect collect : collects){
                User user=userMapper.getUser(collect.getFrom_id());
                Article article=articleMapper.getArticle(collect.getFrom_id(), collect.getFrom_aid());
                collect.set(user,article);
            }
            L.log("获取收藏成功");
        } catch (Exception e) {
            e.printStackTrace();
            L.log("获取收藏失败");
        }
        return collects;
    }
}
