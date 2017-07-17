package com.davidx.xth.controller;

import com.davidx.xth.Page;
import com.davidx.xth.ResultState;
import com.davidx.xth.dao.StatisticsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xc on 17-7-4.
 */
@RestController
@CrossOrigin
@RequestMapping("/app/statistics")
public class StatisticsController {

    @Autowired
    StatisticsDao statisticsDao;

    /**
     *
     * @param groupType 统计类型  1：按金额总数分组     2：按消费次数统计
     * @param bcreatetime
     * @param ecreatetime
     * @param pageSize
     * @param nowPage
     * @return
     */
    @RequestMapping("/statisticsGroup")
    public Map<String, Object> statisticsGroup(String groupType,String bcreatetime, String ecreatetime, String pageSize, String nowPage) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> paras = new HashMap<>();
        paras.put("bcreatetime", bcreatetime);
        paras.put("ecreatetime", ecreatetime);
        Page page =new Page(nowPage,pageSize);
        page.setCount(false);
        List reList=null;
        if("1".equals(groupType)){
            reList = statisticsDao.StatisticsGroupBySum(paras,page);
        }else if("2".equals(groupType)){
            reList = statisticsDao.StatisticsGroupByCount(paras,page);
        }
        if (reList == null) {
            result.put("state", ResultState.QUERYFAIL.toString());
        } else {
            result.put("state", ResultState.QUERYSUCCESS.toString());
            result.put("list", reList);
        }
        return result;
    }
}
