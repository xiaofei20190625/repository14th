package com.cskaoyan.mapper;

import com.cskaoyan.bean.MaterialConsume;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialConsumeMapper {
    int deleteByPrimaryKey(String consumeId);

    int insert(MaterialConsume record);

    int insertSelective(MaterialConsume record);

    MaterialConsume selectByPrimaryKey(String consumeId);

    int updateByPrimaryKeySelective(MaterialConsume record);

    int updateByPrimaryKey(MaterialConsume record);

    List<MaterialConsume> findMaterialConsume();

    MaterialConsume getMaterialConsume(@Param("mcid") int mcid);

    int deleteMaterialConsumeList(@Param("ids") String[] ids);

    List<MaterialConsume> materialConsumeSearchByConsumeId(@Param("searchValue") String searchValue);

    List<MaterialConsume> materialConsumeSearchByWorkId(@Param("searchValue") String searchValue);

    List<MaterialConsume> materialConsumeSearchByMaterialId(@Param("searchValue") String searchValue);
}