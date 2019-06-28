package com.cskaoyan.mapper;

import com.cskaoyan.bean.MaterialReceive;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialReceiveMapper {
    int deleteByPrimaryKey(String receiveId);

    int insert(MaterialReceive record);

    int insertSelective(MaterialReceive record);

    MaterialReceive selectByPrimaryKey(String receiveId);

    int updateByPrimaryKeySelective(MaterialReceive record);

    int updateByPrimaryKey(MaterialReceive record);

    List<MaterialReceive> findMaterialReceive();

    MaterialReceive getMaterialReceive(@Param("mrid") int mrid);

    int deleteMaterialReceiveList(@Param("ids") String[] ids);

    List<MaterialReceive> searchMaterialReceiveByReceiveId(@Param("searchValue") String searchValue);

    List<MaterialReceive> searchMaterialReceiveByMaterialId(@Param("searchValue") String searchValue);
}