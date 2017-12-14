package com.funbox.project.bean;

import com.funbox.project.model.AppCommonProblem;

import java.util.List;

/**
 * Created by zhao6 on 2017/10/27.
 */
public class AppCommonProblemBean extends AppCommonProblem {
    private List<AppCommonProblem> childList;

    public List<AppCommonProblem> getChildList() {
        return childList;
    }

    public void setChildList(List<AppCommonProblem> childList) {
        this.childList = childList;
    }
}
