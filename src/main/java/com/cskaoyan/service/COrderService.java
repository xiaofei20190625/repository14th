package com.cskaoyan.service;

import com.cskaoyan.bean.COrder;
import com.cskaoyan.bean.COrderExample;
import com.cskaoyan.vo.Upload;
import com.cskaoyan.vo.UploadDelete;
import com.cskaoyan.vo.Vo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface COrderService {

    List<COrder> selectCOrderlist();
    Long countCOrder();
    Vo<COrder> findCOrderPage(int pag, int rows);
    COrder selectByPrimaryKey(String orderId);


    int deleteByPrimaryKey(String orderId);

    int insert(COrder record);

    int insertSelective(COrder record);


    int updateByPrimaryKeySelective(COrder record);

    int updateByPrimaryKey(COrder record);

    Vo<COrder> searchCOderById(int pag, int rows,String orderId);

    Vo<COrder> searchCOderByOrderCustom(int pag, int rows,String searchValue);

    Vo<COrder> searchCOderByOrderProduct(int pag, int rows,String searchValue);

    int deleteByPrimaryKeys(String[] ids);

    Upload orderFileUpload(MultipartFile file,String url) throws IOException;

    UploadDelete orderDeleteUpload(String fileName, File folder);

    ResponseEntity<byte[]> orderDownloadDownloadFile(String fileName, File folder) throws IOException;
}
