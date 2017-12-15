package com.funbox.project.web;

import com.funbox.project.bean.AppCommonProblemBean;
import com.funbox.project.core.Result;
import com.funbox.project.core.ResultGenerator;
import com.funbox.project.model.AppCommonProblem;
import com.funbox.project.service.AppCommonProblemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
* Created by CodeGenerator on 2017/10/27.
*/
@RestController
@RequestMapping("/v4/app/common/problem")
public class AppCommonProblemController {
    @Resource
    private AppCommonProblemService appCommonProblemService;

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) throws InvocationTargetException, IllegalAccessException {
        PageHelper.startPage(page, size);
        List<AppCommonProblem> list = appCommonProblemService.findAll();

        // 最后的结果
        List<AppCommonProblemBean> appCommonProblemList = new ArrayList<AppCommonProblemBean>();
        // 先找到所有的一级问题
        AppCommonProblemBean appCommonProblemBean;
        for (int i = 0; i < list.size(); i++) {
            appCommonProblemBean = new AppCommonProblemBean();
            // 一级问题没有parentId
            if (StringUtils.isBlank(list.get(i).getParentId())) {
                //复制属性值
                BeanUtils.copyProperties(appCommonProblemBean,list.get(i));
                appCommonProblemList.add(appCommonProblemBean);
            }
        }
        // 为一级问题设置子问题，getChild是递归调用的
        for (AppCommonProblemBean appCommonProblem : appCommonProblemList) {
            appCommonProblem.setChildList(getChild(appCommonProblem.getProblemId()+"", list));
        }
        PageInfo pageInfo = new PageInfo(appCommonProblemList);

        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 递归查找子问题
     *
     * @param id
     *            当前问题id
     * @param appCommonProblemList
     *            要查找的列表
     * @return
     */
    private List<AppCommonProblem> getChild(String id, List<AppCommonProblem> appCommonProblemList) {
        // 子问题
        List<AppCommonProblem> childList = new ArrayList<AppCommonProblem>();
        for (AppCommonProblem appCommonProblem : appCommonProblemList) {
            // 遍历所有节点，将父问题id与传过来的id比较
            if (StringUtils.isNotBlank(appCommonProblem.getParentId())) {
                if (appCommonProblem.getParentId().equals(id)) {
                    childList.add(appCommonProblem);
                }
            }
        }

         // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }
}
