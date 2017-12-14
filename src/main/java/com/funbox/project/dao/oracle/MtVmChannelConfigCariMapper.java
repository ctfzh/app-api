package com.funbox.project.dao.oracle;

import com.funbox.project.bean.Code;
import com.funbox.project.core.MyMapper;
import com.funbox.project.model.MtVmChannelConfigCari;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MtVmChannelConfigCariMapper extends MyMapper<MtVmChannelConfigCari> {
  List<Code>  selectCodeByInnerCodeandvalidTs(@Param("innerCode") String innerCode, @Param("validTslist") List<String> validTslist);

 int updateByMvvcccIds(@Param("orderId") String orderId, @Param("validTslist") List<String> validTslist);
}
