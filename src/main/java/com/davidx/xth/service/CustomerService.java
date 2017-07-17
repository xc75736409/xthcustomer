package com.davidx.xth.service;

import com.davidx.xth.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by xc on 17-7-4.
 */
public interface CustomerService {

    /**
     * 检查电话是否存在
     * @param paras
     * @return
     */
    int ExistsPhone(Map<String, Object> paras);
    /**
     * 查询客户信息
     * @param paras 条件
     * @param page  分页
     * @return
     */
    List<Map<String, Object>> getCustomer(Map<String, Object> paras, Page page);

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
    List<Map<String, Object>> getConsume(Map<String, Object> paras, Page page);


    /**
     * 操作客户消费信息
     * @param paras
     * @param operateType
     * @return
     */
    int operateConsume(Map<String, Object> paras,String operateType);
}
