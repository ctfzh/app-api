package com.funbox.project.service;
import com.funbox.project.bean.Code;
import com.funbox.project.model.MtVmChannelConfigCari;
import com.funbox.project.core.Service;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by CodeGenerator on 2017/11/03.
 */
public interface MtVmChannelConfigCariService extends Service<MtVmChannelConfigCari> {
    List<Code> selectCodeByInnerCodeandvalidTs( String innerCode, List<String> validTslist);

    int updateByMvvcccIds(String orderId,List<String> validTslist);
}
