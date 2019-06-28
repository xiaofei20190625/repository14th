package com.cskaoyan.mapper;

import com.cskaoyan.bean.Material;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialMapper {
    int deleteByPrimaryKey(String materialId);

    int insert(Material record);

    int insertSelective(Material record);

    Material selectByPrimaryKey(String materialId);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);

    List<Material> findMaterial();

    Material getMaterial(@Param("mid")String mid);

    int deleteMaterialList(@Param("ids") String[] ids);

    List<Material> searchMaterialByMaterialId(@Param("searchValue") String searchValue);

    List<Material> searchMaterialByMaterialType(@Param("searchValue") String searchValue);
}