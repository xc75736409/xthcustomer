package com.davidx.xth.controller;

import com.davidx.xth.ResultState;
import com.davidx.xth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xc on 17-6-30.
 */
@RestController
@CrossOrigin
@RequestMapping("/app")
public class UserController {

    @Autowired
    private UserService uService;

    @RequestMapping("/userLogin")
    public  Map<String,Object> userLogin(String userName,String passWord) {
        Map<String,Object> result= new HashMap<>();
        Map<String,Object> paras= new HashMap<>();
        paras.put("username",userName);
        paras.put("password",passWord);
        List reList=uService.userLogin(paras);
        if(reList==null || reList.size()==0){
            result.put("state",ResultState.LOGINFAIL.toString());
        }else{
            result.put("state",ResultState.LOGINSUCCESS.toString());
            result.put("user",reList.get(0));
        }
        return result;
    }
}
