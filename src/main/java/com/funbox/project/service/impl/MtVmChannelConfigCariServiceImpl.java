package com.funbox.project.service.impl;

import com.funbox.project.bean.Code;
import com.funbox.project.dao.oracle.MtVmChannelConfigCariMapper;
import com.funbox.project.model.MtVmChannelConfigCari;
import com.funbox.project.service.MtVmChannelConfigCariService;
import com.funbox.project.core.AbstractService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2017/11/03.
 */
@Service
@Transactional
public class MtVmChannelConfigCariServiceImpl extends AbstractService<MtVmChannelConfigCari> implements MtVmChannelConfigCariService {
    @Resource
    private MtVmChannelConfigCariMapper mtVmChannelConfigCariMapper;

    @Override
    public List<Code> selectCodeByInnerCodeandvalidTs(String innerCode, List<String> validTslist) {
        return mtVmChannelConfigCariMapper.selectCodeByInnerCodeandvalidTs(innerCode,validTslist);
    }

    @Override
    public int updateByMvvcccIds(String orderId,List<String> validTslist) {
       return   mtVmChannelConfigCariMapper.updateByMvvcccIds(orderId,validTslist);
    }
}
