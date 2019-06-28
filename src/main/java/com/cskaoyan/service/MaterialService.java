package com.cskaoyan.service;

import com.cskaoyan.bean.Material;
import com.cskaoyan.vo.Vo;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/28 Time 16:09
 */
public interface MaterialService {
    Vo<Material> findMaterial(int page, int rows);

    Material getMaterial(String mid);

    int insertMaterial(Material material);

    int updateMaterial(Material material);

    int deleteMaterialList(String[] ids);

    Vo<Material> searchMaterialByMaterialId(String searchValue, int page, int rows);

    Vo<Material> searchMaterialByMaterialType(String searchValue, int page, int rows);

    List<Material> findAllMaterial();

}
