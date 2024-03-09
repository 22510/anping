package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Daishoutuihuo;
import com.ins.anping.base.service.impl.DaishoutuihuoServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 待收退货 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/daishoutuihuo")
public class DaishoutuihuoController {

    
    @Autowired
    private DaishoutuihuoServiceImpl  daishoutuihuoService;
    
    @ApiOperation("查询所有待收退货")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Daishoutuihuo> list= daishoutuihuoService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Daishoutuihuo result = daishoutuihuoService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Daishoutuihuo> page){
        IPage<Daishoutuihuo> daishoutuihuoIPage= daishoutuihuoService.page(page);
        if(daishoutuihuoIPage != null) {
            return ResponseResult.okResult(200, "success", daishoutuihuoIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Daishoutuihuo daishoutuihuo){
        if (daishoutuihuoService.save(daishoutuihuo)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Daishoutuihuo daishoutuihuo){
        if (daishoutuihuoService.updateById(daishoutuihuo)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (daishoutuihuoService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

