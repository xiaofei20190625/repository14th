package com.cskaoyan.service.impl;

import com.cskaoyan.bean.MaterialReceive;
import com.cskaoyan.mapper.MaterialReceiveMapper;
import com.cskaoyan.service.MaterialReceiveService;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/28 Time 16:40
 */
@Service
public class MaterialReceiveServiceImpl implements MaterialReceiveService {
    @Autowired
    MaterialReceiveMapper materialReceiveMapper;

    @Override
    public Vo<MaterialReceive> findMaterialReceive(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<MaterialReceive> materialReceives = materialReceiveMapper.findMaterialReceive();
        PageInfo<MaterialReceive> pageInfo = new PageInfo<>(materialReceives);
        Vo<MaterialReceive> materialReceiveList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return materialReceiveList;
    }
    @Override
    public List<MaterialReceive> findAllMaterialReceive() {
        return materialReceiveMapper.findMaterialReceive();
    }
    //查询指定工艺
    @Override
    public MaterialReceive getMaterialReceive(int mrid) {
        return materialReceiveMapper.getMaterialReceive(mrid);
    }

    @Override
    public int insertMaterialReceive(MaterialReceive materialReceive) {
        int insert = materialReceiveMapper.insert(materialReceive);
        return insert;
    }
    @Override
    public int updateMaterialReceive(MaterialReceive materialReceive) {
        return materialReceiveMapper.updateByPrimaryKeySelective(materialReceive);
    }
    @Override
    public int deleteMaterialReceiveList(String[] ids) {
        return materialReceiveMapper.deleteMaterialReceiveList(ids);
    }
    @Override
    public Vo<MaterialReceive> searchMaterialReceiveByReceiveId(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<MaterialReceive> materialReceives = materialReceiveMapper.searchMaterialReceiveByReceiveId(searchValue);
        PageInfo<MaterialReceive> pageInfo = new PageInfo<>(materialReceives);
        Vo<MaterialReceive> materialReceiveList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return materialReceiveList;
    }
    @Override
    public Vo<MaterialReceive> searchMaterialReceiveByMaterialId(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<MaterialReceive> materialReceives = materialReceiveMapper.searchMaterialReceiveByMaterialId(searchValue);
        PageInfo<MaterialReceive> pageInfo = new PageInfo<>(materialReceives);
        Vo<MaterialReceive> materialReceiveList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return materialReceiveList;
    }
}
