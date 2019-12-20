package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by admin on 2019/12/18.
 */
@RestController
@CrossOrigin
@RequestMapping("/label")
public class BaseController {

    @Autowired
    LabelService labelService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        List<Label> labelList = labelService.findAll();
        return new Result(true, StatusCode.OK, "查询成功", labelList);
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String labelId) {
        Label label = labelService.findById(labelId);
        return new Result(true, StatusCode.OK, "查询成功", label);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label) {
        labelService.save(label);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.PUT)
    public Result update(@PathVariable("labelId") String labelId, @RequestBody Label label) {
        label.setId(labelId);
        labelService.update(label);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable("labelId") String labelId) {
        labelService.deleteById(labelId);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     * 根据条件查询
     *
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Label label) {
        List<Label> listLable = labelService.findSearch(label);
        return new Result(true, StatusCode.OK, "查询成功", listLable);
    }

    @RequestMapping(value = "/pageQuery/{page}/{size}", method = RequestMethod.POST)
    public Result pageQuery(@PathVariable int page, @PathVariable int size, @RequestBody Label label){
        Page<Label> pageData = labelService.pageQuery(label, page, size);
        return new Result(true,StatusCode.OK, "查询成功",
                new PageResult<Label>(pageData.getTotalElements(), pageData.getContent()));
    }
}
