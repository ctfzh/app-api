package ${basePackage}.web;

import ${basePackage}.Page.Response;
import ${basePackage}.core.ResponseGenerator;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Date;

/**
* Created by ${author} on ${date}.
*/
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {
    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping
    public Response add(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        Date now = new Date();
        ${modelNameLowerCamel}.setCreatetime(now);
        ${modelNameLowerCamel}.setUpdatetime(now);
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        return ResponseGenerator.genSuccessResponse();
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable String id) {
        ${modelNameLowerCamel}Service.deleteById(id);
        return ResponseGenerator.genSuccessResponse();
    }

    @PutMapping
    public Response update(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
         Date now = new Date();
        ${modelNameLowerCamel}.setUpdatetime(now);
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
        return ResponseGenerator.genSuccessResponse();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Response<${modelNameUpperCamel}> detail(@PathVariable String id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        return ResponseGenerator.genSuccessResponse(${modelNameLowerCamel});
    }

    @GetMapping
    @ResponseBody
    public  Response<PageInfo<${modelNameUpperCamel}>> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResponseGenerator.genSuccessResponse(pageInfo);
    }
}
