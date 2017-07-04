package com.davidx.xth.service;

import java.util.List;
import java.util.Map;

/**
 * Created by xc on 17-7-4.
 */

public interface UserService {
    /**
     * 用户登录
     * @param paras
     * @return
     */
    public List<Map<String, Object>> userLogin(Map<String, Object> paras);

}
