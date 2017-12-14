package com.funbox.project.service.impl;

import com.funbox.project.dao.mysql.AppUserTokenMapper;
import com.funbox.project.model.AppUserToken;
import com.funbox.project.service.AppUserTokenService;
import com.funbox.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/10/27.
 */
@Service
@Transactional
public class AppUserTokenServiceImpl extends AbstractService<AppUserToken> implements AppUserTokenService {
    @Resource
    private AppUserTokenMapper appUserTokenMapper;

}
