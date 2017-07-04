package com.davidx.xth;


/**
 * Created by xc on 17-7-4.
 */
public enum ResultState {
    ////**********************成功***********************/
    SUCCESS(200), //请求成功
    LOGINSUCCESS(201),//登录成功
    QUERYSUCCESS(202),//查询成功
    ADDSUCCESS(203),//添加成功
    ////**********************失败***********************/
    FAIL(500), //请求失败
    LOGINFAIL(501),  //登录失败
    QUERYFAIL(502),//查询失败
    ADDFAIL(503);//添加失败

    // 定义私有变量
    private int nCode;

    ResultState(int _nCode) {
        this.nCode = _nCode;
    }

    @Override
    public String toString() {
        return String.valueOf(this.nCode);
    }
}
