package com.funbox.project.service;
import com.funbox.project.bean.Menu;
import com.funbox.project.model.MtVmChannelConfigInfo;
import com.funbox.project.core.Service;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by CodeGenerator on 2017/11/02.
 */
public interface MtVmChannelConfigInfoService extends Service<MtVmChannelConfigInfo> {
    List<Menu> selectMenusByInnerCode(@Param("innerCode") String innerCode);
}
