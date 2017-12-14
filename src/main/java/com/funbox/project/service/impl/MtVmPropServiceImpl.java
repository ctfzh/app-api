package com.funbox.project.service.impl;

import com.funbox.project.dao.oracle.MtVmPropMapper;
import com.funbox.project.model.MtVmProp;
import com.funbox.project.service.MtVmPropService;
import com.funbox.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/11/02.
 */
@Service
@Transactional
public class MtVmPropServiceImpl extends AbstractService<MtVmProp> implements MtVmPropService {
    @Resource
    private MtVmPropMapper mtVmPropMapper;

}
