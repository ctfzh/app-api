package com.funbox.project.dao.oracle;

import com.funbox.project.bean.Menu;
import com.funbox.project.core.MyMapper;
import com.funbox.project.model.MtVmChannelConfigInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MtVmChannelConfigInfoMapper extends MyMapper<MtVmChannelConfigInfo> {
 List<Menu> selectMenusByInnerCode(@Param("innerCode") String innerCode);
}