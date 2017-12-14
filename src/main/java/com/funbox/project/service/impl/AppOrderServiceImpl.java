package com.funbox.project.service.impl;

import com.funbox.project.dao.mysql.AppOrderMapper;
import com.funbox.project.model.AppOrder;
import com.funbox.project.service.AppOrderService;
import com.funbox.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/10/31.
 */
@Service
@Transactional
public class AppOrderServiceImpl extends AbstractService<AppOrder> implements AppOrderService {
    @Resource
    private AppOrderMapper appOrderMapper;

}
