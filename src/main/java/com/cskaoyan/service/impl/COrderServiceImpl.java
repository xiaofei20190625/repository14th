package com.cskaoyan.service.impl;

import com.cskaoyan.bean.COrder;

import com.cskaoyan.mapper.COrderMapper;
import com.cskaoyan.service.COrderService;

import com.cskaoyan.vo.Upload;
import com.cskaoyan.vo.UploadDelete;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.*;
import java.util.List;

@Service
public class COrderServiceImpl implements COrderService {
    @Autowired
    COrderMapper cOrderMapper;

    @Override
    public List<COrder> selectCOrderlist() {
        List<COrder> cOrders = cOrderMapper.selectCOrderlist();
        return cOrders;
    }

    @Override
    public Long countCOrder() {
        Long orderNum = cOrderMapper.countCOrder();
        return orderNum;
    }

    @Override
    public Vo<COrder> findCOrderPage(int pag, int rows) {
        PageHelper.startPage(pag,rows);
        List<COrder> cOrders = cOrderMapper.selectCOrderlist();
        PageInfo<COrder> cOrderPageInfo = new PageInfo<>(cOrders);
        Vo<COrder> cOrderVo = new Vo<>(cOrderPageInfo.getTotal(), cOrderPageInfo.getList());

        return cOrderVo;
    }

    @Override
    public COrder selectByPrimaryKey(String orderId) {

        COrder cOrder = cOrderMapper.selectByPrimaryKey(orderId);

        return cOrder;
    }

    @Override
    public Vo<COrder> searchCOderById(int pag, int rows, String orderId) {

        PageHelper.startPage(pag,rows);
        List<COrder> cOrders = cOrderMapper.searchCOderById(orderId);
        PageInfo<COrder> cOrderPageInfo = new PageInfo<>(cOrders);
        Vo<COrder> cOrder = new Vo<>(cOrderPageInfo.getTotal(), cOrderPageInfo.getList());

        return cOrder;
    }

    @Override
    public Vo<COrder> searchCOderByOrderCustom(int pag, int rows, String searchValue) {
        PageHelper.startPage(pag,rows);
        List<COrder> cOrders = cOrderMapper.searchCOderByOrderCustom(searchValue);
        PageInfo<COrder> cOrderPageInfo = new PageInfo<>(cOrders);
        Vo<COrder> cOrder = new Vo<>(cOrderPageInfo.getTotal(), cOrderPageInfo.getList());

        return cOrder;
    }

    @Override
    public Vo<COrder> searchCOderByOrderProduct(int pag, int rows, String searchValue) {
        PageHelper.startPage(pag,rows);
        List<COrder> cOrders = cOrderMapper.searchCOderByOrderProduct(searchValue);
        PageInfo<COrder> cOrderPageInfo = new PageInfo<>(cOrders);
        Vo<COrder> cOrder = new Vo<>(cOrderPageInfo.getTotal(), cOrderPageInfo.getList());

        return cOrder;
    }

    @Override
    public int deleteByPrimaryKeys(String[] ids) {
        return cOrderMapper.deleteByPrimaryKeys(ids);
    }

    @Override
    public Upload orderFileUpload(MultipartFile file,String  realurl) throws IOException {
        Upload upload = new Upload();
        if (!file.equals(null)) {
            File directory = new File(realurl);
            if (!directory.exists()){
                directory.mkdir();
            }
            String fileName = file.getOriginalFilename();
            String fileurl =realurl + fileName;
            file.transferTo(new File(fileurl));
            upload.setError(0);
            upload.setUrl(fileName);
            if (fileName.endsWith(".jpg")){
                upload.setUrl("/pic/"+fileName);
            }
            return upload;
        } else {
            return upload;
        }

    }

    @Override
    public UploadDelete orderDeleteUpload(String fileName,File folder) {

        File[] files = folder.listFiles();
        UploadDelete uploadDelete = new UploadDelete();
        for(File file:files){
            if(file.getName().equals(fileName)){
                file.delete();
                uploadDelete.setData("success");
                return uploadDelete;
            }
        }
        uploadDelete.setData("failed");
        return uploadDelete;
    }

    @Override
    public ResponseEntity<byte[]> orderDownloadDownloadFile(String fileName, File folder) throws IOException {
        InputStream in=new FileInputStream(folder+"\\"+fileName);//将该文件加入到输入流之中
        byte[] body=null;
        body=new byte[in.available()];// 返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取（或跳过）的估计剩余字节数
        in.read(body);//读入到输入流里面

        fileName=new String(fileName.getBytes("gbk"),"iso8859-1");//防止中文乱码
        HttpHeaders headers=new HttpHeaders();//设置响应头
        headers.add("Content-Disposition", "attachment;filename="+fileName);
        HttpStatus statusCode = HttpStatus.OK;//设置响应吗
        ResponseEntity<byte[]> response=new ResponseEntity<byte[]>(body, headers, statusCode);
        return response;
    }

    @Override
    public int deleteByPrimaryKey(String orderId) {
        return cOrderMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public int insert(COrder record) {
        return cOrderMapper.insert(record);
    }

    @Override
    public int insertSelective(COrder record) {
        return cOrderMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(COrder record) {
        return cOrderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(COrder record) {
        return cOrderMapper.updateByPrimaryKey(record);
    }


}
