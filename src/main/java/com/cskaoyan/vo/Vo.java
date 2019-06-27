package com.cskaoyan.vo;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/27 Time 14:00
 */
public class Vo<T> {
    long total;
    List<T> rows;

    public Vo() {
    }

    public Vo(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "Vo{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
