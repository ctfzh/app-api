package com.funbox.project.service.impl;

import com.funbox.project.dao.oracle.AppUserPhoneMapper;
import com.funbox.project.model.AppUserPhone;
import com.funbox.project.service.AppUserPhoneService;
import com.funbox.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/10/27.
 */
@Service
@Transactional
public class AppUserPhoneServiceImpl extends AbstractService<AppUserPhone> implements AppUserPhoneService {
    @Resource
    private AppUserPhoneMapper appUserPhoneMapper;

    public Integer getAppUserPhoneId(){
      return  appUserPhoneMapper.getAppUserPhoneId();
    }
}
