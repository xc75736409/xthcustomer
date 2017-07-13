package com.davidx.xth.dao;

import com.davidx.xth.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by xc on 17-7-13.
 */
@Mapper
public interface StatisticsDao {
    List<Map<String,Object>> StatisticsGroupByCount(@Param(value = "c")Map<String, Object> paras, @Param(value = "p")Page page);
    List<Map<String,Object>> StatisticsGroupBySum(@Param(value = "c")Map<String, Object> paras, @Param(value = "p")Page page);
}
