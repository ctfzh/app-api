package com.funbox.project.service.impl;

import com.funbox.project.dao.mysql.AppUpgradesVersionMapper;
import com.funbox.project.model.AppUpgradesVersion;
import com.funbox.project.service.AppUpgradesVersionService;
import com.funbox.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/12/20.
 */
@Service
@Transactional
public class AppUpgradesVersionServiceImpl extends AbstractService<AppUpgradesVersion> implements AppUpgradesVersionService {
    @Resource
    private AppUpgradesVersionMapper appUpgradesVersionMapper;

}
