package com.pinyougou.entity;


import java.io.Serializable;
import java.util.List;

/**
 * 分页返回类型
 */
public class PageEntity implements Serializable {
    private long total;
    private List rows;

    public PageEntity(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageEntity() {
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}

