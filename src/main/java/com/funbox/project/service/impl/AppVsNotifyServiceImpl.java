package com.funbox.project.service.impl;

import com.funbox.project.dao.mysql.AppVsNotifyMapper;
import com.funbox.project.model.AppVsNotify;
import com.funbox.project.service.AppVsNotifyService;
import com.funbox.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/11/03.
 */
@Service
@Transactional
public class AppVsNotifyServiceImpl extends AbstractService<AppVsNotify> implements AppVsNotifyService {
    @Resource
    private AppVsNotifyMapper appVsNotifyMapper;

}
