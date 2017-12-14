package com.funbox.project.service;
import com.funbox.project.bean.MtVmNode;
import com.funbox.project.model.MtVm;
import com.funbox.project.core.Service;


/**
 * Created by CodeGenerator on 2017/11/02.
 */
public interface MtVmService extends Service<MtVm> {
   MtVmNode selectByInnerCode(String innerCode);
}
