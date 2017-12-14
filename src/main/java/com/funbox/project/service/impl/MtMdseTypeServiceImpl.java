package com.funbox.project.service.impl;

import com.funbox.project.dao.oracle.MtMdseTypeMapper;
import com.funbox.project.model.MtMdseType;
import com.funbox.project.service.MtMdseTypeService;
import com.funbox.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/11/24.
 */
@Service
@Transactional
public class MtMdseTypeServiceImpl extends AbstractService<MtMdseType> implements MtMdseTypeService {
    @Resource
    private MtMdseTypeMapper mtMdseTypeMapper;

}
