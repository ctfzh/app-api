package com.funbox.project.service.impl;

import com.funbox.project.dao.mysql.AuthUserMapper;
import com.funbox.project.model.AuthUser;
import com.funbox.project.service.AuthUserService;
import com.funbox.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/10/26.
 */
@Service
@Transactional
public class AuthUserServiceImpl extends AbstractService<AuthUser> implements AuthUserService {
    @Resource
    private AuthUserMapper authUserMapper;

}
