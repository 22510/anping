package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Tianjiabiaodanceshi;
import com.ins.anping.base.service.impl.TianjiabiaodanceshiServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 添加表单测试 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/tianjiabiaodanceshi")
public class TianjiabiaodanceshiController {

    
    @Autowired
    private TianjiabiaodanceshiServiceImpl  tianjiabiaodanceshiService;
    
    @ApiOperation("查询所有添加表单测试")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Tianjiabiaodanceshi> list= tianjiabiaodanceshiService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Tianjiabiaodanceshi result = tianjiabiaodanceshiService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Tianjiabiaodanceshi> page){
        IPage<Tianjiabiaodanceshi> tianjiabiaodanceshiIPage= tianjiabiaodanceshiService.page(page);
        if(tianjiabiaodanceshiIPage != null) {
            return ResponseResult.okResult(200, "success", tianjiabiaodanceshiIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Tianjiabiaodanceshi tianjiabiaodanceshi){
        if (tianjiabiaodanceshiService.save(tianjiabiaodanceshi)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Tianjiabiaodanceshi tianjiabiaodanceshi){
        if (tianjiabiaodanceshiService.updateById(tianjiabiaodanceshi)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (tianjiabiaodanceshiService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

