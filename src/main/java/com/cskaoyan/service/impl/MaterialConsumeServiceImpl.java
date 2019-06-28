package com.cskaoyan.service.impl;

import com.cskaoyan.bean.MaterialConsume;
import com.cskaoyan.mapper.MaterialConsumeMapper;
import com.cskaoyan.service.MaterialConsumeService;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/28 Time 20:02
 */
@Service
public class MaterialConsumeServiceImpl implements MaterialConsumeService {
    @Autowired
    MaterialConsumeMapper materialConsumeMapper;

    @Override
    public Vo<MaterialConsume> findMaterialConsume(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<MaterialConsume> technologies = materialConsumeMapper.findMaterialConsume();
        PageInfo<MaterialConsume> pageInfo = new PageInfo<>(technologies);
        Vo<MaterialConsume> materialConsumeList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return materialConsumeList;
    }
    @Override
    public List<MaterialConsume> findAllMaterialConsume() {
        return materialConsumeMapper.findMaterialConsume();
    }
    //查询指定工艺
    @Override
    public MaterialConsume getMaterialConsume(int mcid) {
        return materialConsumeMapper.getMaterialConsume(mcid);
    }

    @Override
    public int insertMaterialConsume(MaterialConsume materialConsume) {
        int insert = materialConsumeMapper.insert(materialConsume);
        return insert;
    }
    @Override
    public int updateMaterialConsume(MaterialConsume materialConsume) {
        return materialConsumeMapper.updateByPrimaryKeySelective(materialConsume);
    }
    @Override
    public int deleteMaterialConsumeList(String[] ids) {
        return materialConsumeMapper.deleteMaterialConsumeList(ids);
    }
    @Override
    public Vo<MaterialConsume> materialConsumeSearchByConsumeId(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<MaterialConsume> technologies = materialConsumeMapper.materialConsumeSearchByConsumeId(searchValue);
        PageInfo<MaterialConsume> pageInfo = new PageInfo<>(technologies);
        Vo<MaterialConsume> materialConsumeList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return materialConsumeList;
    }
    @Override
    public Vo<MaterialConsume> materialConsumeSearchByWorkId(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<MaterialConsume> technologies = materialConsumeMapper.materialConsumeSearchByWorkId(searchValue);
        PageInfo<MaterialConsume> pageInfo = new PageInfo<>(technologies);
        Vo<MaterialConsume> materialConsumeList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return materialConsumeList;
    }
    @Override
    public Vo<MaterialConsume> materialConsumeSearchByMaterialId(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<MaterialConsume> technologies = materialConsumeMapper.materialConsumeSearchByMaterialId(searchValue);
        PageInfo<MaterialConsume> pageInfo = new PageInfo<>(technologies);
        Vo<MaterialConsume> materialConsumeList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return materialConsumeList;
    }

}
