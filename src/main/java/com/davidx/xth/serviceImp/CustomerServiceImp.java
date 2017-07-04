package com.davidx.xth.serviceImp;

import com.davidx.xth.Page;
import com.davidx.xth.dao.CustomerMapper;
import com.davidx.xth.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by xc on 17-7-4.
 */
@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    CustomerMapper dao;

    @Override
    public List<Map<String, Object>> getCustomer(Map<String, Object> paras, Page page) {
        return dao.getCustomer(paras, page);
    }

    @Override
    public synchronized int addCustomer(Map<String, Object> paras) {
        return dao.addCustomer(paras);
    }

    @Override
    public int updateCustomer(Map<String, Object> paras) {
        return dao.updateCustomer(paras);
    }

    @Override
    public int deleteCustomer(Map<String, Object> paras) {
        return dao.deleteCustomer(paras);
    }

    @Override
    public List<Map<String, Object>> getConsumeById(Map<String, Object> paras, Page page) {
        return dao.getConsumeById(paras, page);
    }

    @Override
    public int operateConsume(Map<String, Object> paras, String operateType) {
        int state = 0;
        if ("add".equals(operateType))
            state = dao.addConsume(paras);
        else if ("update".equals(operateType))
            state = dao.updateConsume(paras);
        else if ("delete".equals(operateType))
            state = dao.deleteConsume(paras);
        return state;
    }
}
