package com.example.orangeshare.Controller;


import com.example.orangeshare.Pojo.Comment;
import com.example.orangeshare.ReturnData;
import com.example.orangeshare.ServiceImpl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentServiceImpl commentServiceImpl;
      @RequestMapping(method= RequestMethod.POST)
      public ReturnData  add(@RequestBody Comment comment){
          if(commentServiceImpl.add(comment)){
              return  ReturnData.success();
          }
          return  ReturnData.fail("添加失败，请稍后再试");
      }

    @RequestMapping(method= RequestMethod.DELETE)
      public  ReturnData delete(String id,String aid,String from_id){
          if(commentServiceImpl.delete(id, aid, from_id))
              return  ReturnData.success();
           return  ReturnData.fail("删除失败，稍后再试");
      }


    @RequestMapping(method= RequestMethod.GET)
      public  ReturnData getComments(String id,String aid,int page){
            return  ReturnData.success(commentServiceImpl.getComments(id,aid,page));
      }



}
