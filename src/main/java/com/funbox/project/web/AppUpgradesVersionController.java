package com.funbox.project.web;
import com.alibaba.fastjson.JSONObject;
import com.funbox.project.core.Result;
import com.funbox.project.core.ResultGenerator;
import com.funbox.project.model.AppUpgradesVersion;
import com.funbox.project.service.AppUpgradesVersionService;
import com.funbox.project.utils.CompareVersionUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2017/12/20.
*/
@RestController
@RequestMapping("/v4/app/upgrades/version")
public class AppUpgradesVersionController {
    @Resource
    private AppUpgradesVersionService appUpgradesVersionService;

    @PostMapping("/add")
    public Result add(AppUpgradesVersion appUpgradesVersion) {
        appUpgradesVersionService.save(appUpgradesVersion);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/list")
    public Result list(@RequestParam String appType,@RequestParam String version,@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        AppUpgradesVersion appUpgradesVersion = appUpgradesVersionService.findBy("appType",appType);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("newestVersion",appUpgradesVersion.getNewestVersion());

        if(StringUtils.isBlank(appType)||StringUtils.isBlank(version)){
            ResultGenerator.genFailResult("参数不能为空");
        }

        try {
           int newest = CompareVersionUtil.compareVersion(version,appUpgradesVersion.getNewestVersion());
           int lowest = CompareVersionUtil.compareVersion(version,appUpgradesVersion.getLowestVersion());

           //传过来得版本低于最低版本，强制更新
           if(lowest<=0){
                jsonObject.put("checkUpdate",2);
           }
           //传过来得版本大于最低版本，小于最新版本，建议更新
            if(lowest>=0&&newest<0){
                jsonObject.put("checkUpdate",1);
            }
          //传过来得版本等于最新版本，不更新
            if(newest==0){
                jsonObject.put("checkUpdate",0);
            }
          //传过来得版本大于最新版本，-1 提示错误
            if(newest>0){
                jsonObject.put("checkUpdate",-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultGenerator.genSuccessResult(jsonObject);
    }
}
