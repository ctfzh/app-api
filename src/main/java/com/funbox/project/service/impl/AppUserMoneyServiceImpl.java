package com.funbox.project.service.impl;

import com.funbox.project.dao.mysql.AppUserMoneyMapper;
import com.funbox.project.model.AppUserMoney;
import com.funbox.project.service.AppUserMoneyService;
import com.funbox.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/11/03.
 */
@Service
@Transactional
public class AppUserMoneyServiceImpl extends AbstractService<AppUserMoney> implements AppUserMoneyService {
    @Resource
    private AppUserMoneyMapper appUserMoneyMapper;

}
