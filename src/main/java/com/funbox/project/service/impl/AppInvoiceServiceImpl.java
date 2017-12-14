package com.funbox.project.service.impl;

import com.funbox.project.dao.mysql.AppInvoiceMapper;
import com.funbox.project.model.AppInvoice;
import com.funbox.project.service.AppInvoiceService;
import com.funbox.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/11/10.
 */
@Service
@Transactional
public class AppInvoiceServiceImpl extends AbstractService<AppInvoice> implements AppInvoiceService {
    @Resource
    private AppInvoiceMapper appInvoiceMapper;

}
