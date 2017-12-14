package com.funbox.project.service.impl;

import com.funbox.project.dao.mysql.H5OrderMapper;
import com.funbox.project.model.H5Order;
import com.funbox.project.service.H5OrderService;
import com.funbox.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/11/08.
 */
@Service
@Transactional
public class H5OrderServiceImpl extends AbstractService<H5Order> implements H5OrderService {
    @Resource
    private H5OrderMapper h5OrderMapper;

}
