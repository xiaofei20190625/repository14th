package com.cskaoyan.controller;

import com.cskaoyan.bean.EmployeeResponse;
import com.cskaoyan.bean.Product;
import com.cskaoyan.bean.UnqualifyApply;
import com.cskaoyan.service.EmployeeService;
import com.cskaoyan.service.ProductService;
import com.cskaoyan.service.UnqualifyApplyService;
import com.cskaoyan.vo.ResponseVo;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UnqualifyController {
    @Autowired
    UnqualifyApplyService unqualifyApplyService;
    @Autowired
    ProductService productService;
    @Autowired
    EmployeeService employeeService;
    /*---------------------查询所有不合格项--------------------------*/
    @RequestMapping("unqualify/find")
    public String goTounqualifyListPage() {
        return "unqualify_list";
    }

    //返回不合格项的json数据
    @RequestMapping("unqualify/list")
    @ResponseBody
    public Vo<UnqualifyApply> returnUnqualify(int page, int rows) {
        Vo<UnqualifyApply> unqualifyApplyVo = unqualifyApplyService.queryAllUnqualifyApply(page, rows);
        return unqualifyApplyVo;
    }

    //产品回显
/*    @RequestMapping("product/get/{pid}")
    @ResponseBody
    public Product showProduct(@PathVariable("pid") String pid) {
        Product product = productService.selectByPrimaryKey(pid);
        return product;
    }*/
    //不合格品申请人的回显
    @RequestMapping("employee/get/{empId}")
    @ResponseBody
    public EmployeeResponse showEmployeeResponse(@PathVariable("empId") String empId) {
        return employeeService.selectByPrimaryKey(empId);
    }

    //增加不合格项时product的回显
/*    @RequestMapping("product/get_data")
    @ResponseBody
    public List<Product> showProduct() {
        List<Product> products = productService.selectProductList();
        return products;
    }*/

    //增加不合格项时所有EmployeeResponse(申请人)的回显
    /*Request URL: http://192.168.2.100:8080/erp/employee/get_data*/
    @RequestMapping("employee/get_data")
    @ResponseBody
    public List<EmployeeResponse> showEmployeeResponse() {
        return employeeService.queryAllEmployee();
    }

    //返回json-null
    @RequestMapping("unqualify/add_judge")
    @ResponseBody
    public String goToAddUnqualifyApply() {
        return null;
    }
    //返回增加UnqualifyApply的jsp页面
    @RequestMapping("unqualify/add")
    public String addUnqualifyApply() {
        return "unqualify_add";
    }

    /*----------------------新增不合格项--------------------------*/
    /*http://192.168.2.100:8080/erp/unqualify/insert*/
    @RequestMapping("unqualify/insert")
    @ResponseBody
    public ResponseVo insertUnqualifyApply(UnqualifyApply unqualifyApply) {
        int insert = unqualifyApplyService.insertSelective(unqualifyApply);
        if (insert == 1) {
            ResponseVo responseVo = new ResponseVo();
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            responseVo.setData(null);
            return responseVo;
        }
        return null;
    }

    /*------------编辑不合格项---------------*/
    //返回json-null
    @RequestMapping("unqualify/edit_judge")
    @ResponseBody
    public String goToEditUnqualifyApply() {
        return null;
    }
    //返回编辑UnqualifyApply的jsp页面
    @RequestMapping("unqualify/edit")
    public String editUnqualifyApply() {
        return "unqualify_edit";
    }

    //修改不合格项
    /*Request URL: http://192.168.2.100:8080/erp/unqualify/update_all
     */
    @RequestMapping("unqualify/update_all")
    @ResponseBody
    public ResponseVo updateUnqualifyApply(UnqualifyApply record) {
        int update = unqualifyApplyService.updateByPrimaryKeySelective(record);
        if (update == 1) {
            ResponseVo responseVo = new ResponseVo();
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            responseVo.setData(null);
            return responseVo;
        }
        return null;
    }


    //删除不合格项,执行删除并返回删除结果的状态码
    @RequestMapping("unqualify/delete_batch")
    @ResponseBody
    public ResponseVo unqualifyDelete(String[] ids) {
        int delete = unqualifyApplyService.deleteByIds(ids);
        if (delete > 0) {
            ResponseVo responseVo = new ResponseVo();
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            responseVo.setData(null);
            return responseVo;
        } else {
            return null;
        }
    }

    //返回json-null
    @RequestMapping("unqualify/delete_judge")
    @ResponseBody
    public String goToDeleteUnqualifyApply() {
        return null;
    }
}
