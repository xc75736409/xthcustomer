package com.davidx.xth.controller;

import com.davidx.xth.Page;
import com.davidx.xth.ResultState;
import com.davidx.xth.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xc on 17-7-4.
 */
@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    /**
     * 添加客户信息
     * @param id
     * @param name
     * @param sex
     * @param phone
     * @param company
     * @param remarks
     * @param operateType 操作类型  add update delete
     * @return
     */
    @RequestMapping("/operateCustomer")
    public Map<String, Object> operateCustomer(String id, String name, String sex, String phone, String company, String remarks,String operateType) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> paras = new HashMap<>();
        paras.put("id", id);
        paras.put("name", name);
        paras.put("sex", sex);
        paras.put("phone", phone);
        paras.put("company", company);
        paras.put("remarks", remarks);
        int state=0;
        if("add".equals(operateType))
            state=customerService.addCustomer(paras);
        else if("update".equals(operateType))
            state=customerService.updateCustomer(paras);
        else if("delete".equals(operateType))
            state=customerService.deleteCustomer(paras);
        if(state<1)
            result.put("state", ResultState.ADDFAIL.toString());
        else
            result.put("state", ResultState.ADDSUCCESS.toString());
        return result;
    }



    /**
     * 根据id查询客户信息
     * @param customerId
     * @return
     */
    @RequestMapping("/getCustomerById")
    public Map<String, Object> getCustomerById(String customerId) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> paras = new HashMap<>();
        paras.put("id", customerId);
        List reList = customerService.getCustomer(paras, new Page());
        if (reList == null || reList.size() == 0) {
            result.put("state", ResultState.QUERYFAIL.toString());
        } else {
            result.put("state", ResultState.QUERYSUCCESS.toString());
            result.put("list", reList);
        }
        return result;
    }

    /**
     * 根据条件查询客户信息
     * @param id
     * @param name
     * @param sex
     * @param phone
     * @param company
     * @param bcreatetime
     * @param ecreatetime
     * @param pageSize
     * @param nowPage
     * @return
     */
    @RequestMapping("/getCustomer")
    public Map<String, Object> getCustomer(String id, String name, String sex, String phone, String company, String bcreatetime, String ecreatetime,
                                           String pageSize, String nowPage) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> paras = new HashMap<>();
        paras.put("id", id);
        paras.put("name", name);
        paras.put("sex", sex);
        paras.put("phone", phone);
        paras.put("company", company);
        paras.put("bcreatetime", bcreatetime);
        paras.put("ecreatetime", ecreatetime);
        Page page =new Page(nowPage,pageSize);
        List<Map<String,Object>> reTotal = customerService.getCustomer(paras,page);
        if (reTotal == null || reTotal.size() == 0) {
            result.put("state", ResultState.QUERYFAIL.toString());
        } else {
            page.setCount(false);
            List reList = customerService.getCustomer(paras,page);
            result.put("state", ResultState.QUERYSUCCESS.toString());
            result.put("list", reList);
            result.put("total", reTotal.get(0).get("total"));
        }
        return result;
    }

    ////////////////////////////////////////////客户消费信息//////////////////////////////////////////
    /**
     * 根据id查询客户信息
     * @param id
     * @return
     */
    @RequestMapping("/getConsumeById")
    public Map<String, Object> getConsumeById(String id,String pageSize, String nowPage) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> paras = new HashMap<>();
        paras.put("id", id);
        Page page =new Page(nowPage,pageSize);
        List<Map<String,Object>> reTotal = customerService.getConsumeById(paras,page);
        if (reTotal == null || reTotal.size() == 0) {
            result.put("state", ResultState.QUERYFAIL.toString());
        } else {
            page.setCount(false);
            List reList = customerService.getConsumeById(paras,page);
            result.put("state", ResultState.QUERYSUCCESS.toString());
            result.put("list", reList);
            result.put("total", reTotal.get(0).get("total"));
        }
        return result;
    }

    /**
     * 编辑客户消费信息
     * @param customerId
     * @param money
     * @param createperple
     * @param remarks
     * @param operateType 操作类型  add update delete
     * @return
     */
    @RequestMapping("/operateConsume")
    public Map<String, Object> operateConsume(String customerId, String money, String createperple, String remarks,String operateType) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> paras = new HashMap<>();
        paras.put("customer_id", customerId);
        paras.put("createperple", createperple);
        paras.put("money", money);
        paras.put("remarks", remarks);
        int state=customerService.operateConsume(paras,operateType);

        if(state<1)
            result.put("state", ResultState.ADDFAIL.toString());
        else
            result.put("state", ResultState.ADDSUCCESS.toString());
        return result;
    }

}
