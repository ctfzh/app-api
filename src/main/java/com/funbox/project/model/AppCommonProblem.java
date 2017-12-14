package com.funbox.project.model;

import javax.persistence.*;
import java.util.List;

@Table(name = "app_common_problem")
public class AppCommonProblem {
    /**
     * 问题ID
     */
    @Id
    @Column(name = "problem_id")
    private Integer problemId;

    /**
     * 问题标题
     */
    @Column(name = "problem_title")
    private String problemTitle;

    /**
     * 问题内容
     */
    @Column(name = "problem_content")
    private String problemContent;

    /**
     * 父级ID
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 问题顺序
     */
    @Column(name = "problem_order")
    private String problemOrder;

    /**
     * 获取问题ID
     *
     * @return problem_id - 问题ID
     */
    public Integer getProblemId() {
        return problemId;
    }

    /**
     * 设置问题ID
     *
     * @param problemId 问题ID
     */
    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    /**
     * 获取问题标题
     *
     * @return problem_title - 问题标题
     */
    public String getProblemTitle() {
        return problemTitle;
    }

    /**
     * 设置问题标题
     *
     * @param problemTitle 问题标题
     */
    public void setProblemTitle(String problemTitle) {
        this.problemTitle = problemTitle;
    }

    /**
     * 获取问题内容
     *
     * @return problem_content - 问题内容
     */
    public String getProblemContent() {
        return problemContent;
    }

    /**
     * 设置问题内容
     *
     * @param problemContent 问题内容
     */
    public void setProblemContent(String problemContent) {
        this.problemContent = problemContent;
    }

    /**
     * 获取父级ID
     *
     * @return parent_id - 父级ID
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父级ID
     *
     * @param parentId 父级ID
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取问题顺序
     *
     * @return problem_order - 问题顺序
     */
    public String getProblemOrder() {
        return problemOrder;
    }

    /**
     * 设置问题顺序
     *
     * @param problemOrder 问题顺序
     */
    public void setProblemOrder(String problemOrder) {
        this.problemOrder = problemOrder;
    }

}