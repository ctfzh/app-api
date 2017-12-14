package com.funbox.project.service.impl;

import com.funbox.project.bean.Menu;
import com.funbox.project.dao.oracle.MtVmChannelConfigInfoMapper;
import com.funbox.project.model.MtVmChannelConfigInfo;
import com.funbox.project.service.MtVmChannelConfigInfoService;
import com.funbox.project.core.AbstractService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2017/11/02.
 */
@Service
@Transactional
public class MtVmChannelConfigInfoServiceImpl extends AbstractService<MtVmChannelConfigInfo> implements MtVmChannelConfigInfoService {
    @Resource
    private MtVmChannelConfigInfoMapper mtVmChannelConfigInfoMapper;

    @Override
    public List<Menu> selectMenusByInnerCode(String innerCode) {
        return mtVmChannelConfigInfoMapper.selectMenusByInnerCode(innerCode);
    }
}
