package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Wuliugongsiguanli;
import com.ins.anping.base.service.impl.WuliugongsiguanliServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 物流公司管理 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/wuliugongsiguanli")
public class WuliugongsiguanliController {

    
    @Autowired
    private WuliugongsiguanliServiceImpl  wuliugongsiguanliService;
    
    @ApiOperation("查询所有物流公司管理")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Wuliugongsiguanli> list= wuliugongsiguanliService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Wuliugongsiguanli result = wuliugongsiguanliService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Wuliugongsiguanli> page){
        IPage<Wuliugongsiguanli> wuliugongsiguanliIPage= wuliugongsiguanliService.page(page);
        if(wuliugongsiguanliIPage != null) {
            return ResponseResult.okResult(200, "success", wuliugongsiguanliIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Wuliugongsiguanli wuliugongsiguanli){
        if (wuliugongsiguanliService.save(wuliugongsiguanli)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Wuliugongsiguanli wuliugongsiguanli){
        if (wuliugongsiguanliService.updateById(wuliugongsiguanli)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (wuliugongsiguanliService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

