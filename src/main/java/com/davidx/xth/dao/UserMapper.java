package com.davidx.xth.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by xc on 17-6-30.
 */
public interface UserMapper {

    public List<Map<String, Object>> userLogin(Map<String, Object> paras);
}
