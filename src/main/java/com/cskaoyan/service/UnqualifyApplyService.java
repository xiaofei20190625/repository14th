package com.cskaoyan.service;

import com.cskaoyan.bean.UnqualifyApply;
import com.cskaoyan.vo.Vo;

public interface UnqualifyApplyService {

    Vo<UnqualifyApply> queryAllUnqualifyApply(int page, int rows);
}
