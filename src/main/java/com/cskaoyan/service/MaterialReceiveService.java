package com.cskaoyan.service;

import com.cskaoyan.bean.MaterialReceive;
import com.cskaoyan.vo.Vo;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/28 Time 16:40
 */
public interface MaterialReceiveService {
    Vo<MaterialReceive> findMaterialReceive(int page, int rows);

    MaterialReceive getMaterialReceive(int mrid);

    int insertMaterialReceive(MaterialReceive materialReceive);

    int updateMaterialReceive(MaterialReceive materialReceive);

    int deleteMaterialReceiveList(String[] ids);

    Vo<MaterialReceive> searchMaterialReceiveByReceiveId(String searchValue, int page, int rows);

    Vo<MaterialReceive> searchMaterialReceiveByMaterialId(String searchValue, int page, int rows);

    List<MaterialReceive> findAllMaterialReceive();

}
