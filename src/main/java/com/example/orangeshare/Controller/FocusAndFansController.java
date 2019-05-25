package com.example.orangeshare.Controller;

import com.example.orangeshare.Pojo.User;
import com.example.orangeshare.ReturnData;
import com.example.orangeshare.ServiceImpl.FocusAndFansServiceImpl;
import com.example.orangeshare.Tools.L;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class FocusAndFansController {
    @Autowired
    FocusAndFansServiceImpl focusAndFansServiceImpl;
    @RequestMapping(value = "/focus",method= RequestMethod.POST)
    public ReturnData addFocus(String id,String from_id){
        L.log(id+"请求关注"+from_id);
        if(focusAndFansServiceImpl.add(id, from_id))
            return ReturnData.success();
        return ReturnData.fail("关注失败，请稍后再试");
    }

    @RequestMapping(value = "/focus",method= RequestMethod.DELETE)
    public ReturnData deleteFocus(String id,String from_id){
        L.log(id+"请求取消关注"+from_id);
        if(focusAndFansServiceImpl.delete(id, from_id))
            return ReturnData.success();
        return ReturnData.fail("取消关注失败");
    }
    @RequestMapping(value = "/focus",method= RequestMethod.GET)
    public List<User> getFocus(String id){
        return focusAndFansServiceImpl.getFocus(id);
    }
}
