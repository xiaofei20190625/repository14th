package com.cskaoyan.service;

import com.cskaoyan.bean.MaterialConsume;
import com.cskaoyan.vo.Vo;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/28 Time 20:01
 */
public interface MaterialConsumeService {
    Vo<MaterialConsume> findMaterialConsume(int page, int rows);
    List<MaterialConsume> findAllMaterialConsume();
    MaterialConsume getMaterialConsume(int tid);
    int insertMaterialConsume(MaterialConsume materialConsume);
    int updateMaterialConsume(MaterialConsume materialConsume);
    int deleteMaterialConsumeList(String[] ids);
    Vo<MaterialConsume> materialConsumeSearchByConsumeId(String searchValue, int page, int rows);
    Vo<MaterialConsume> materialConsumeSearchByWorkId(String searchValue, int page, int rows);
    Vo<MaterialConsume> materialConsumeSearchByMaterialId(String searchValue, int page, int rows);
}
