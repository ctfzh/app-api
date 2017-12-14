package com.funbox.project.service.impl;

import com.funbox.project.dao.mysql.AppZfCacheMapper;
import com.funbox.project.model.AppZfCache;
import com.funbox.project.service.AppZfCacheService;
import com.funbox.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/11/08.
 */
@Service
@Transactional
public class AppZfCacheServiceImpl extends AbstractService<AppZfCache> implements AppZfCacheService {
    @Resource
    private AppZfCacheMapper appZfCacheMapper;

}
