package com.example.orangeshare.ServiceImpl;

import com.example.orangeshare.Dao.CommentMapper;
import com.example.orangeshare.Dao.UserMapper;
import com.example.orangeshare.Pojo.Comment;
import com.example.orangeshare.Pojo.User;
import com.example.orangeshare.Service.CommentService;
import com.example.orangeshare.Tools.L;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    @Transactional
    public boolean add(Comment comment) {
        try {
            commentMapper.add(comment);
            L.log("来自"+comment.getFrom_id()+"对"+comment.getId()+" "+comment.getAid()+"的评论成功");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            L.log("来自"+comment.getId()+"对"+comment.getId()+" "+comment.getAid()+"的评论失败");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return  false;
        }
    }

    @Override
    public boolean delete(String id, String aid, String from_id) {
        try {
            commentMapper.delete(id, aid, from_id);
            L.log("删除"+from_id+"对"+id+" "+aid+"的评论成功");
        } catch (Exception e) {
            e.printStackTrace();
            L.log("删除"+from_id+"对"+id+" "+aid+"的评论成功");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public List<Comment> getComments(String id, String aid, int page) {
        List<Comment> comments=commentMapper.getComments(id, aid,new RowBounds((page-1)*10,10));
        for(Comment comment:comments){
            User user=userMapper.getUser(comment.getFrom_id());
            comment.setUser_photo(user.getUser_photo());
            comment.setName(user.getName());
        }
        return comments;
    }
}
