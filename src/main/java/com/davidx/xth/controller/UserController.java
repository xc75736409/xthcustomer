package com.davidx.xth.controller;

import com.davidx.xth.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by xc on 17-6-30.
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper dao;

    @RequestMapping("/getuser")
    public List<Map<String,Object>> index() {
        return dao.getAll();
    }
}
