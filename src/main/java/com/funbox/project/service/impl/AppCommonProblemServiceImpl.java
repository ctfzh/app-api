package com.funbox.project.service.impl;

import com.funbox.project.dao.mysql.AppCommonProblemMapper;
import com.funbox.project.model.AppCommonProblem;
import com.funbox.project.service.AppCommonProblemService;
import com.funbox.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/10/27.
 */
@Service
@Transactional
public class AppCommonProblemServiceImpl extends AbstractService<AppCommonProblem> implements AppCommonProblemService {
    @Resource
    private AppCommonProblemMapper appCommonProblemMapper;

}
