package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Kufangbeihuochaxun;
import com.ins.anping.base.service.impl.KufangbeihuochaxunServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 库房备货查询 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/kufangbeihuochaxun")
public class KufangbeihuochaxunController {

    
    @Autowired
    private KufangbeihuochaxunServiceImpl  kufangbeihuochaxunService;
    
    @ApiOperation("查询所有库房备货查询")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Kufangbeihuochaxun> list= kufangbeihuochaxunService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Kufangbeihuochaxun result = kufangbeihuochaxunService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Kufangbeihuochaxun> page){
        IPage<Kufangbeihuochaxun> kufangbeihuochaxunIPage= kufangbeihuochaxunService.page(page);
        if(kufangbeihuochaxunIPage != null) {
            return ResponseResult.okResult(200, "success", kufangbeihuochaxunIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Kufangbeihuochaxun kufangbeihuochaxun){
        if (kufangbeihuochaxunService.save(kufangbeihuochaxun)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Kufangbeihuochaxun kufangbeihuochaxun){
        if (kufangbeihuochaxunService.updateById(kufangbeihuochaxun)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (kufangbeihuochaxunService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

