package com.funbox.project.web;
import com.funbox.project.core.Result;
import com.funbox.project.core.ResultGenerator;
import com.funbox.project.model.MtMdseType;
import com.funbox.project.service.MtMdseTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2017/11/24.
*/
@RestController
@RequestMapping("/v4/mt/mdse/type")
public class MtMdseTypeController {
    @Resource
    private MtMdseTypeService mtMdseTypeService;

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        Condition condition = new Condition(MtMdseType.class);
        condition.createCriteria().andCondition(" parent_id is null and delete_mark =0");
        condition.orderBy("typeOrder").desc();
        PageHelper.startPage(page, size);
        List<MtMdseType> list = mtMdseTypeService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
