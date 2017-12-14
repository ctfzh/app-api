package com.funbox.project.service.impl;

import com.funbox.project.dao.oracle.MtNodeMapper;
import com.funbox.project.model.MtNode;
import com.funbox.project.service.MtNodeService;
import com.funbox.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/11/02.
 */
@Service
@Transactional
public class MtNodeServiceImpl extends AbstractService<MtNode> implements MtNodeService {
    @Resource
    private MtNodeMapper mtNodeMapper;

}
