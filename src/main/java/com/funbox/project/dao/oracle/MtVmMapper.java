package com.funbox.project.dao.oracle;

import com.funbox.project.bean.MtVmNode;
import com.funbox.project.core.MyMapper;
import com.funbox.project.model.MtVm;
import org.apache.ibatis.annotations.Param;

public interface MtVmMapper extends MyMapper<MtVm> {
    MtVmNode selectByInnerCode(@Param("innerCode") String innerCode);
}