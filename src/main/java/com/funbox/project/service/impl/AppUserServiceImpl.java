package com.funbox.project.service.impl;

import com.funbox.project.dao.oracle.AppUserMapper;
import com.funbox.project.dao.oracle.AppOracleUserMapper;
import com.funbox.project.model.AppUser;
import com.funbox.project.service.AppUserService;
import com.funbox.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/10/27.
 */
@Service
@Transactional
public class AppUserServiceImpl extends AbstractService<AppUser> implements AppUserService {
    @Resource
    private AppUserMapper appUserMapper;

    @Resource
    private AppOracleUserMapper appOracleUserMapper;

   public Integer getUserId(){
       return appUserMapper.getUserId();
    }
}
