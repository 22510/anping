package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Kufangfahuochaxun;
import com.ins.anping.base.service.impl.KufangfahuochaxunServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 库房发货查询 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/kufangfahuochaxun")
public class KufangfahuochaxunController {

    
    @Autowired
    private KufangfahuochaxunServiceImpl  kufangfahuochaxunService;
    
    @ApiOperation("查询所有库房发货查询")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Kufangfahuochaxun> list= kufangfahuochaxunService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Kufangfahuochaxun result = kufangfahuochaxunService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Kufangfahuochaxun> page){
        IPage<Kufangfahuochaxun> kufangfahuochaxunIPage= kufangfahuochaxunService.page(page);
        if(kufangfahuochaxunIPage != null) {
            return ResponseResult.okResult(200, "success", kufangfahuochaxunIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Kufangfahuochaxun kufangfahuochaxun){
        if (kufangfahuochaxunService.save(kufangfahuochaxun)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Kufangfahuochaxun kufangfahuochaxun){
        if (kufangfahuochaxunService.updateById(kufangfahuochaxun)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (kufangfahuochaxunService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

