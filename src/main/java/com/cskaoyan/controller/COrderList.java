package com.cskaoyan.controller;

import com.cskaoyan.bean.COrder;
import com.cskaoyan.bean.COrderExample;
import com.cskaoyan.service.COrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class COrderList {
    int total;
    List<COrder> rows;


    public int getTotal() {

        return total;
    }

    public void setTotal(int total) {


        this.total = total;
    }

    public List<COrder> getRows() {

        return rows;
    }

    public void setRows(List<COrder> rows) {

        this.rows = rows;
    }


}
