package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Wuliaojiageguanli;
import com.ins.anping.base.service.impl.WuliaojiageguanliServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 物料价格管理 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/wuliaojiageguanli")
public class WuliaojiageguanliController {

    
    @Autowired
    private WuliaojiageguanliServiceImpl  wuliaojiageguanliService;
    
    @ApiOperation("查询所有物料价格管理")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Wuliaojiageguanli> list= wuliaojiageguanliService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Wuliaojiageguanli result = wuliaojiageguanliService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Wuliaojiageguanli> page){
        IPage<Wuliaojiageguanli> wuliaojiageguanliIPage= wuliaojiageguanliService.page(page);
        if(wuliaojiageguanliIPage != null) {
            return ResponseResult.okResult(200, "success", wuliaojiageguanliIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Wuliaojiageguanli wuliaojiageguanli){
        if (wuliaojiageguanliService.save(wuliaojiageguanli)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Wuliaojiageguanli wuliaojiageguanli){
        if (wuliaojiageguanliService.updateById(wuliaojiageguanli)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (wuliaojiageguanliService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

