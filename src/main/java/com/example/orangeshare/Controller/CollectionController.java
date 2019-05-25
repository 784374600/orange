package com.example.orangeshare.Controller;

import com.example.orangeshare.Pojo.Collect;
import com.example.orangeshare.ReturnData;
import com.example.orangeshare.ServiceImpl.CollectionServiceImpl;
import com.example.orangeshare.Tools.L;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/collection")
public class CollectionController {
     @Autowired
    CollectionServiceImpl collectionServiceImpl;
     @RequestMapping(method = RequestMethod.POST)
     public ReturnData add( Collect collect){
         L.log(collect.getId()+"请求添加收藏");
         if(collectionServiceImpl.add(collect))
          return ReturnData.success();
         return ReturnData.fail("收藏失败");
     }
    @RequestMapping(method = RequestMethod.DELETE)
     public ReturnData  delete(String id,String from_id,String from_aid){
        L.log(id+"请求删除收藏"+from_id+" "+from_aid);
         if(collectionServiceImpl.delete(new Collect(id, from_id,from_aid)))
             return ReturnData.success();
         return ReturnData.fail("删除收藏失败");
     }
    @RequestMapping(method = RequestMethod.GET)
     public List<Collect> getCollections(String id){
         return  collectionServiceImpl.getCollections(id);
     }
}
