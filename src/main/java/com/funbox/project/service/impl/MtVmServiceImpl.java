package com.funbox.project.service.impl;

import com.funbox.project.bean.MtVmNode;
import com.funbox.project.dao.oracle.MtVmMapper;
import com.funbox.project.model.MtVm;
import com.funbox.project.service.MtVmService;
import com.funbox.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/11/02.
 */
@Service
@Transactional
public class MtVmServiceImpl extends AbstractService<MtVm> implements MtVmService {
    @Resource
    private MtVmMapper mtVmMapper;

    @Override
    public MtVmNode selectByInnerCode(String innerCode) {
        return mtVmMapper.selectByInnerCode(innerCode);
    }
}
