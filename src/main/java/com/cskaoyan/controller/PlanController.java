package com.cskaoyan.controller;

import com.cskaoyan.bean.*;

import com.cskaoyan.bean.Process;
import com.cskaoyan.service.*;
import com.cskaoyan.vo.ResponseVo;
import com.cskaoyan.vo.Upload;
import com.cskaoyan.vo.UploadDelete;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
    ManufactureService manufactureService;
    @Autowired
    TaskService taskService;

    @Autowired
    DataSource dataSource;





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

    @RequestMapping("order/get/{order_id}")
    @ResponseBody
    public COrder order(@PathVariable("order_id")String order_id) {
        COrder cOrder = cOrderService.selectByPrimaryKey(order_id);
        return cOrder;
    }
    //回显COrderList数据
    @RequestMapping("order/get_data")
    @ResponseBody
    public List<COrder> order() {
        return cOrderService.selectCOrderlist();
    }

    @RequestMapping("order/add")
    public String orderAdd() {

        return "order_add";
    }

    @RequestMapping("order/add_judge")
    @ResponseBody
    public COrder orderAddJudge() {
        return null;
    }


    /**
     * 提交增加order
     * @param cOrder 添加的数据
     * @return 返回json的结果
     */
    @RequestMapping("order/insert")
    @ResponseBody
    public ResponseVo submitAddOrder(COrder cOrder) {

        int i = cOrderService.insertSelective(cOrder);
        ResponseVo responseVo = responseVo(i);
        return responseVo;

    }


    /**
     * 返回状态
     * @param i 返回值获得对应的状态
     * @return 封装responseVo
     */
    private ResponseVo responseVo(int i){
        if (i == 1) {
            ResponseVo responseVo = new ResponseVo();
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            responseVo.setData(null);
            return responseVo;
        } else {
            return null;
        }
    }

    /**
     * 订单文件上传
     * @param file 订单文件
     * @return json Upload
     * @throws IOException
     */
    @RequestMapping("file/upload")
    @ResponseBody
    public Upload orderFileUpload(MultipartFile file) throws IOException {
        String realurl = "D:\\Spring\\repository14th\\src\\main\\resources\\fileUpload\\";
        Upload upload = cOrderService.orderFileUpload(file,realurl);
        return upload;
    }

    /**
     * 订单文件删除
     * @param fileName 订单文件
     * @return success or failed
     */
    @RequestMapping("file/delete")
    @ResponseBody
    public UploadDelete orderDeleteUpload(String fileName) {

        File folder = new File("D:\\Spring\\repository14th\\src\\main\\resources\\fileUpload\\");
        UploadDelete uploadDelete = cOrderService.orderDeleteUpload(fileName, folder);
        return uploadDelete;

    }


    @RequestMapping("file/download")
    @ResponseBody
    public ResponseEntity<byte[]>  orderDownloadDownloadFile(String fileName) throws IOException {
        File folder = new File("D:\\Spring\\repository14th\\src\\main\\resources\\fileUpload\\");
        String regex = "/";
        String[] strings = fileName.split(regex);
        ResponseEntity<byte[]> responseEntity = cOrderService.orderDownloadDownloadFile(strings[strings.length-1], folder);
        return responseEntity;
    }

    /**
     * 图片上传
     * @param uploadFile 上传图片文件
     * @return 图片回显路径
     * @throws IOException
     */
    @RequestMapping("pic/upload")
    @ResponseBody
    public Upload uploadImage(MultipartFile uploadFile,String dir) throws IOException {
       if (dir.equals("image")){
           String realurl = "D:\\Spring\\repository14th\\src\\main\\webapp\\WEB-INF\\pic\\";
           Upload upload = cOrderService.orderFileUpload(uploadFile,realurl);
           return upload;
       }
        return null;
    }

    /**
     * 订单图片删除
     * @param picName 图片name
     * @return 是否删除成功
     */
    @RequestMapping("pic/delete")
    @ResponseBody
    public UploadDelete deleteImage(String picName) {

        File folder = new File( "D:\\Spring\\repository14th\\src\\main\\webapp\\WEB-INF\\pic\\");
        //File folder = new File( "");
        String regex = "/";
        String[] strings = picName.split(regex);
        UploadDelete uploadDelete = cOrderService.orderDeleteUpload(strings[strings.length-1], folder);
        return uploadDelete;

    }

    /*转到编辑order的页面*/
    @RequestMapping("order/edit")
    public String editOrderPage() {

        return "order_edit";
    }

    /*返回编辑order页面的json数据*/
    @RequestMapping("order/edit_judge")
    @ResponseBody
    public String returnToeditOrder() {
        return null;
    }

    /*提交增加order，返回json的结果*/
    @RequestMapping("order/update_all")
    @ResponseBody
    public ResponseVo submiteditOrder(COrder cOrder) {
        int update = cOrderService.updateByPrimaryKeySelective(cOrder);
        ResponseVo responseVo = responseVo(update);
        return responseVo;
    }
    /*根据order编号搜索order，返回json数据*/
    @RequestMapping("order/search_order_by_orderId")
    @ResponseBody
    public  Vo<COrder> search_order_by_orderId(int page , int rows,HttpServletRequest request) throws Exception{
        String searchValue = request.getParameter("searchValue");
        Vo<COrder> cOrderVo = cOrderService.searchCOderById(page,rows,searchValue);
        return cOrderVo;
    }

    /*根据custom名称搜索custom，返回json数据*/
    @RequestMapping("order/search_order_by_orderCustom")
    @ResponseBody
    public  Vo<COrder> search_order_by_orderCustom(int page , int rows,HttpServletRequest request) throws Exception{
        String searchValue = request.getParameter("searchValue");
        Vo<COrder> cOrderVo = cOrderService.searchCOderByOrderCustom(page,rows,searchValue);
        return cOrderVo;
    }

    /*根据product名称搜索product，返回json数据*/
    @RequestMapping("order/search_order_by_orderProduct")
    @ResponseBody
    public  Vo<COrder> search_order_by_orderProduct(int page , int rows,HttpServletRequest request) throws Exception{
        String searchValue = request.getParameter("searchValue");
        Vo<COrder> cOrderVo = cOrderService.searchCOderByOrderProduct(page,rows,searchValue);
        return cOrderVo;
    }

    //删除order，返回json数据
    @RequestMapping("order/delete_judge")
    @ResponseBody
    public String deleteDepartment() {
        return null;
    }

    //执行删除order，返回执行结果的json数据
    @RequestMapping("order/delete_batch")
    @ResponseBody
    public ResponseVo doDeleteOrderById(String[] ids) {
       int delete = cOrderService.deleteByPrimaryKeys(ids);
        ResponseVo responseVo = responseVo(delete);
        return responseVo;
    }

    @RequestMapping("custom/get_data")
    @ResponseBody
    public List<Custom> customGet_data() {
        List<Custom> customs = customService.selectCustomList();
        return customs;
    }

    /*@RequestMapping("product/get_data")
    @ResponseBody
    public List<Product> productGet_data() {
        List<Product> products = productService.selectProductList();
        return products;
    }*/


    @RequestMapping("custom/get/{custom_id}")
    @ResponseBody
    public Custom custom(@PathVariable("custom_id")String custom_id) {
        Custom custom = customService.selectByPrimaryKey(custom_id);
        return custom;
    }

    /*@RequestMapping("product/get/{product_id}")
    @ResponseBody
    public Product product(@PathVariable("product_id")String product_id) {

        Product product = productService.selectByPrimaryKey(product_id);
        return product;
    }*/


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

//    @RequestMapping("process/get/{process_id}")
    /*@RequestMapping("work/get/{wid}")
    @ResponseBody
    public Work getWork(@PathVariable("wid") String wid){
        Work work = workService.getWork(wid);
        return work;
    }*/

    @RequestMapping("work/get_data")
    @ResponseBody
    public List<Work> findAllWork(){
        return workService.findAllWork();
    }

    @RequestMapping("work/get/{work_id}")
    @ResponseBody
    public Work work(@PathVariable("work_id")String work_id) {
        Work work = workService.selectWork(work_id);
        return work;
    }

    /*@RequestMapping("process/get/{process_id}")
    @ResponseBody
    public Process process(@PathVariable("process_id")String process_id) {
        Process process = processService.selectByPrimaryKey(process_id);
        return process;
    }

    @RequestMapping("deviceList/get/{device_id}")
    @ResponseBody
    public Device device(@PathVariable("device_id")String device_id) {
        Device device = deviceService.selectByPrimaryKey(device_id);
        return device;
    }*/



    @RequestMapping("manufacture/find")
    public String manufactureFind() {

        return "manufacture_list";
    }

    @RequestMapping("manufacture/list")
    @ResponseBody
    public Vo<Manufacture> manufactureList(int page , int rows) {
        Vo<Manufacture> manufacturePage = manufactureService.findManufacturePage(page, rows);
        return manufacturePage;
    }

    @RequestMapping("manufacture/get/{manufacture_id}")
    @ResponseBody
    public Manufacture manufacture(@PathVariable("manufacture_id")String manufacture_id) {
        Manufacture manufacture = manufactureService.selectManufacture(manufacture_id);
        return manufacture;

    }

    @RequestMapping("task/find")
    public String taskFind() {

        return "task_list";
    }

    @RequestMapping("task/list")
    @ResponseBody
    public Vo<Task> taskList(int page , int rows) {
        Vo<Task> taskPage = taskService.findTaskPage(page, rows);
        return taskPage;
    }



}
