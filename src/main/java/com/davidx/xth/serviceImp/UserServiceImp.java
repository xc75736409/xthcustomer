package com.davidx.xth.serviceImp;

import com.davidx.xth.dao.UserMapper;
import com.davidx.xth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by xc on 17-7-4.
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Map<String, Object>> userLogin(Map<String, Object> paras) {
        return userMapper.userLogin(paras);
    }
}
