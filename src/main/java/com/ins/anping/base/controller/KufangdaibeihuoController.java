package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Kufangdaibeihuo;
import com.ins.anping.base.service.impl.KufangdaibeihuoServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 库房待备货 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/kufangdaibeihuo")
public class KufangdaibeihuoController {

    
    @Autowired
    private KufangdaibeihuoServiceImpl  kufangdaibeihuoService;
    
    @ApiOperation("查询所有库房待备货")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Kufangdaibeihuo> list= kufangdaibeihuoService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Kufangdaibeihuo result = kufangdaibeihuoService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Kufangdaibeihuo> page){
        IPage<Kufangdaibeihuo> kufangdaibeihuoIPage= kufangdaibeihuoService.page(page);
        if(kufangdaibeihuoIPage != null) {
            return ResponseResult.okResult(200, "success", kufangdaibeihuoIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Kufangdaibeihuo kufangdaibeihuo){
        if (kufangdaibeihuoService.save(kufangdaibeihuo)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Kufangdaibeihuo kufangdaibeihuo){
        if (kufangdaibeihuoService.updateById(kufangdaibeihuo)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (kufangdaibeihuoService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

