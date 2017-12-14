package com.funbox.project.dao.oracle;

import com.funbox.project.core.MyMapper;
import com.funbox.project.model.AppUserPhone;
import org.apache.ibatis.annotations.Select;

public interface AppUserPhoneMapper extends MyMapper<AppUserPhone> {
    @Select("select APP_USER_PHONE_SEQ.Nextval as appUserPhoneId from Dual")
    Integer getAppUserPhoneId();
}