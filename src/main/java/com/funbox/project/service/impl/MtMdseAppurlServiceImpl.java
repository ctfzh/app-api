package com.funbox.project.service.impl;

import com.funbox.project.dao.oracle.MtMdseAppurlMapper;
import com.funbox.project.model.MtMdseAppurl;
import com.funbox.project.service.MtMdseAppurlService;
import com.funbox.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/10/31.
 */
@Service
@Transactional
public class MtMdseAppurlServiceImpl extends AbstractService<MtMdseAppurl> implements MtMdseAppurlService {
    @Resource
    private MtMdseAppurlMapper mtMdseAppurlMapper;

}
