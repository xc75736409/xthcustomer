package com.davidx.xth.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by xc on 17-6-30.
 */
@Mapper
public interface UserMapper {

    public List<Map<String, Object>> userLogin(Map<String, Object> paras);
}
