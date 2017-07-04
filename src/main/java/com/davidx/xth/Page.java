package com.davidx.xth;

/**
 * Created by xc on 17-7-4.
 */
public class Page {
    private int indexPage=0; //查询开始位置
    private int pageSize=10; //分页大小
    private int nowPage=1;  //当前页
    private boolean isCount=true; //是否统计总数

    public Page(){
        this.isCount=false;
    }
    public Page(String nowPage,String pageSize){
        this.nowPage=nowPage==null?1:Integer.parseInt(nowPage);
        this.pageSize=pageSize==null?10:Integer.parseInt(pageSize);
        if(nowPage!=null && pageSize!=null){
            this.indexPage=(this.nowPage-1)*this.pageSize;
        }
    }

    public int getIndexPage() {
        return indexPage;
    }

    public void setIndexPage(int indexPage) {
        this.indexPage = indexPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public boolean isCount() {
        return isCount;
    }

    public void setCount(boolean count) {
        isCount = count;
    }
}
