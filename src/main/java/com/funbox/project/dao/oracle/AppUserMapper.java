package com.funbox.project.dao.oracle;

import com.funbox.project.core.MyMapper;
import com.funbox.project.model.AppUser;
import org.apache.ibatis.annotations.Select;

public interface AppUserMapper extends MyMapper<AppUser> {
    @Select("select APP_USER_SEQ.Nextval  from Dual")
    Integer getUserId();
}