package com.davidx.xth.dao;

import com.davidx.xth.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by xc on 17-7-4.
 */
@Mapper
public interface CustomerMapper {
    /**
     * 查询客户信息
     * @param paras
     * @param page
     * @return
     */
    List<Map<String, Object>> getCustomer(@Param(value = "c") Map<String, Object> paras, @Param(value = "p") Page page);
    /**
     * 添加客户信息
     * @param paras
     * @return
     */
    int addCustomer(Map<String, Object> paras);

    /**
     * 修改客户信息
     * @param paras
     * @return
     */
    int updateCustomer(Map<String, Object> paras);

    /**
     * 删除客户信息
     * @param paras
     * @return
     */
    int deleteCustomer(Map<String, Object> paras);

    /**
     * 查询客户消费信息
     * @param paras
     * @param page
     * @return
     */
    List<Map<String, Object>> getConsumeById(@Param(value = "c")Map<String, Object> paras, @Param(value = "p")Page page);

    /**
     * 添加客户消费信息
     * @param paras
     * @return
     */
    int addConsume(Map<String, Object> paras);

    /**
     * 修改客户消费信息
     * @param paras
     * @return
     */
    int updateConsume(Map<String, Object> paras);

    /**
     * 删除客户消费信息
     * @param paras
     * @return
     */
    int deleteConsume(Map<String, Object> paras);
}
