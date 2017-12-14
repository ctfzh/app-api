package com.funbox.project.service;
import com.funbox.project.core.Result;
import com.funbox.project.model.AppOrderMain;
import com.funbox.project.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2017/10/31.
 */
public interface AppOrderMainService extends Service<AppOrderMain> {
    public Result addOrder();
}
