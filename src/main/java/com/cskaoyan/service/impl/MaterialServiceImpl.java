package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Material;
import com.cskaoyan.mapper.MaterialMapper;
import com.cskaoyan.service.MaterialService;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/28 Time 16:09
 */
@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    MaterialMapper materialMapper;

    @Override
    public Vo<Material> findMaterial(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Material> materials = materialMapper.findMaterial();
        PageInfo<Material> pageInfo = new PageInfo<>(materials);
        Vo<Material> materialList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return materialList;
    }
    @Override
    public List<Material> findAllMaterial() {
        return materialMapper.findMaterial();
    }
    //查询指定工艺
    @Override
    public Material getMaterial(String mid) {
        return materialMapper.getMaterial(mid);
    }

    @Override
    public int insertMaterial(Material material) {
        int insert = materialMapper.insert(material);
        return insert;
    }
    @Override
    public int updateMaterial(Material material) {
        return materialMapper.updateByPrimaryKeySelective(material);
    }
    @Override
    public int deleteMaterialList(String[] ids) {
        return materialMapper.deleteMaterialList(ids);
    }
    @Override
    public Vo<Material> searchMaterialByMaterialId(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Material> materials = materialMapper.searchMaterialByMaterialId(searchValue);
        PageInfo<Material> pageInfo = new PageInfo<>(materials);
        Vo<Material> materialList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return materialList;
    }
    @Override
    public Vo<Material> searchMaterialByMaterialType(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Material> materials = materialMapper.searchMaterialByMaterialType(searchValue);
        PageInfo<Material> pageInfo = new PageInfo<>(materials);
        Vo<Material> materialList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return materialList;
    }
}
