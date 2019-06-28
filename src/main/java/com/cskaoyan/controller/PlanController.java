package com.cskaoyan.controller;

import com.cskaoyan.bean.*;

import com.cskaoyan.bean.Process;
import com.cskaoyan.service.*;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.util.List;


@Controller
public class PlanController {
    @Autowired
    COrderService cOrderService;
    @Autowired
    CustomService customService;
    @Autowired
    ProductService productService;
    @Autowired
    WorkService workService;
    @Autowired
    ProcessService processService;
    @Autowired
    DeviceService deviceService;

    @Autowired
    DataSource dataSource;


    @RequestMapping("order/search_order_by_orderId")
    @ResponseBody
    public  Vo<COrder> search_order_by_orderId(int page , int rows,HttpServletRequest request) throws Exception{
        String searchValue = new String((request.getParameter("searchValue")).getBytes("iso-8859-1"),"utf-8");
        Vo<COrder> cOrderVo = cOrderService.selectByPrimaryKey(page,rows,searchValue);
        return cOrderVo;
    }

    @RequestMapping("order/list")
    @ResponseBody
    public Vo<COrder> cOrderList(int page , int rows) {
        Vo<COrder> cOrderPage = cOrderService.findCOrderPage(page, rows);
        return cOrderPage;
    }
    @RequestMapping("order/find")
    public String orderFind() {

        return "order_list";
    }

    @RequestMapping("custom/get/{custom_id}")
    @ResponseBody
    public Custom custom(@PathVariable("custom_id")String custom_id) {
        Custom custom = customService.selectByPrimaryKey(custom_id);
        return custom;
    }

    @RequestMapping("product/get/{product_id}")
    @ResponseBody
    public Product product(@PathVariable("product_id")String product_id) {

        Product product = productService.selectByPrimaryKey(product_id);
        return product;
    }


    @RequestMapping("custom/find")
    public String customFind() {

        return "custom_list";
    }
    @RequestMapping("custom/list")
    @ResponseBody
    public Vo<Custom> customList(int page , int rows) {
        Vo<Custom> customPage = customService.findCustomPage(page, rows);
        return customPage;
    }


    @RequestMapping("product/find")
    public String productFind() {

        return "product_list";
    }
    @RequestMapping("product/list")
    @ResponseBody
    public Vo<Product> productList(int page , int rows) {
        Vo<Product> productPage = productService.findProductPage(page, rows);
        return productPage;
    }



    @RequestMapping("work/find")
    public String workFind() {

        return "work_list";
    }
    /*technologyPlan/get_data

    deviceType/get_data

    employee/get_data*/

    @RequestMapping("work/list")
    @ResponseBody
    public Vo<Work> workList(int page , int rows) {
        Vo<Work> workPage = workService.findWorkPage(page, rows);
        return workPage;
    }

    @RequestMapping("process/get/{process_id}")
    @ResponseBody
    public Process process(@PathVariable("process_id")String process_id) {
        Process process = processService.selectByPrimaryKey(process_id);
        return process;
    }

  /*  @RequestMapping("deviceList/get/{device_id}")
    @ResponseBody
    public Device device(@PathVariable("device_id")String device_id) {
        Device device = deviceService.selectByPrimaryKey(device_id);
        return device;
    }*/
}
