package com.funbox.project.service.impl;

import com.funbox.project.dao.mysql.AppActivityMapper;
import com.funbox.project.model.AppActivity;
import com.funbox.project.service.AppActivityService;
import com.funbox.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/10/26.
 */
@Service
@Transactional
public class AppActivityServiceImpl extends AbstractService<AppActivity> implements AppActivityService {
    @Resource
    private AppActivityMapper appActivityMapper;

}
