package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Wuliaohuizong;
import com.ins.anping.base.service.impl.WuliaohuizongServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 物料汇总 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/wuliaohuizong")
public class WuliaohuizongController {

    
    @Autowired
    private WuliaohuizongServiceImpl  wuliaohuizongService;
    
    @ApiOperation("查询所有物料汇总")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Wuliaohuizong> list= wuliaohuizongService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Wuliaohuizong result = wuliaohuizongService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Wuliaohuizong> page){
        IPage<Wuliaohuizong> wuliaohuizongIPage= wuliaohuizongService.page(page);
        if(wuliaohuizongIPage != null) {
            return ResponseResult.okResult(200, "success", wuliaohuizongIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Wuliaohuizong wuliaohuizong){
        if (wuliaohuizongService.save(wuliaohuizong)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Wuliaohuizong wuliaohuizong){
        if (wuliaohuizongService.updateById(wuliaohuizong)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (wuliaohuizongService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

