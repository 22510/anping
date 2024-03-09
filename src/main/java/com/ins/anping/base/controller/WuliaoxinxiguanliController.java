package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Wuliaoxinxiguanli;
import com.ins.anping.base.service.impl.WuliaoxinxiguanliServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 物料信息管理 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/wuliaoxinxiguanli")
public class WuliaoxinxiguanliController {

    
    @Autowired
    private WuliaoxinxiguanliServiceImpl  wuliaoxinxiguanliService;
    
    @ApiOperation("查询所有物料信息管理")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Wuliaoxinxiguanli> list= wuliaoxinxiguanliService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Wuliaoxinxiguanli result = wuliaoxinxiguanliService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Wuliaoxinxiguanli> page){
        IPage<Wuliaoxinxiguanli> wuliaoxinxiguanliIPage= wuliaoxinxiguanliService.page(page);
        if(wuliaoxinxiguanliIPage != null) {
            return ResponseResult.okResult(200, "success", wuliaoxinxiguanliIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Wuliaoxinxiguanli wuliaoxinxiguanli){
        if (wuliaoxinxiguanliService.save(wuliaoxinxiguanli)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Wuliaoxinxiguanli wuliaoxinxiguanli){
        if (wuliaoxinxiguanliService.updateById(wuliaoxinxiguanli)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (wuliaoxinxiguanliService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

