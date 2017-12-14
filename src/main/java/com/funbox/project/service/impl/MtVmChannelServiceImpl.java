package com.funbox.project.service.impl;

import com.funbox.project.dao.oracle.MtVmChannelMapper;
import com.funbox.project.model.MtVmChannel;
import com.funbox.project.service.MtVmChannelService;
import com.funbox.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/11/03.
 */
@Service
@Transactional
public class MtVmChannelServiceImpl extends AbstractService<MtVmChannel> implements MtVmChannelService {
    @Resource
    private MtVmChannelMapper mtVmChannelMapper;

}
