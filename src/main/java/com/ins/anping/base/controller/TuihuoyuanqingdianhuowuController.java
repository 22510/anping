package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Tuihuoyuanqingdianhuowu;
import com.ins.anping.base.service.impl.TuihuoyuanqingdianhuowuServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 退货员清点货物 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/tuihuoyuanqingdianhuowu")
public class TuihuoyuanqingdianhuowuController {

    
    @Autowired
    private TuihuoyuanqingdianhuowuServiceImpl  tuihuoyuanqingdianhuowuService;
    
    @ApiOperation("查询所有退货员清点货物")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Tuihuoyuanqingdianhuowu> list= tuihuoyuanqingdianhuowuService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Tuihuoyuanqingdianhuowu result = tuihuoyuanqingdianhuowuService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Tuihuoyuanqingdianhuowu> page){
        IPage<Tuihuoyuanqingdianhuowu> tuihuoyuanqingdianhuowuIPage= tuihuoyuanqingdianhuowuService.page(page);
        if(tuihuoyuanqingdianhuowuIPage != null) {
            return ResponseResult.okResult(200, "success", tuihuoyuanqingdianhuowuIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Tuihuoyuanqingdianhuowu tuihuoyuanqingdianhuowu){
        if (tuihuoyuanqingdianhuowuService.save(tuihuoyuanqingdianhuowu)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Tuihuoyuanqingdianhuowu tuihuoyuanqingdianhuowu){
        if (tuihuoyuanqingdianhuowuService.updateById(tuihuoyuanqingdianhuowu)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (tuihuoyuanqingdianhuowuService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

