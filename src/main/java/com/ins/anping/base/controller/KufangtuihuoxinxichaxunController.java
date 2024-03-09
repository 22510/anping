package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Kufangtuihuoxinxichaxun;
import com.ins.anping.base.service.impl.KufangtuihuoxinxichaxunServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 库房退货信息查询 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/kufangtuihuoxinxichaxun")
public class KufangtuihuoxinxichaxunController {

    
    @Autowired
    private KufangtuihuoxinxichaxunServiceImpl  kufangtuihuoxinxichaxunService;
    
    @ApiOperation("查询所有库房退货信息查询")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Kufangtuihuoxinxichaxun> list= kufangtuihuoxinxichaxunService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Kufangtuihuoxinxichaxun result = kufangtuihuoxinxichaxunService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Kufangtuihuoxinxichaxun> page){
        IPage<Kufangtuihuoxinxichaxun> kufangtuihuoxinxichaxunIPage= kufangtuihuoxinxichaxunService.page(page);
        if(kufangtuihuoxinxichaxunIPage != null) {
            return ResponseResult.okResult(200, "success", kufangtuihuoxinxichaxunIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Kufangtuihuoxinxichaxun kufangtuihuoxinxichaxun){
        if (kufangtuihuoxinxichaxunService.save(kufangtuihuoxinxichaxun)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Kufangtuihuoxinxichaxun kufangtuihuoxinxichaxun){
        if (kufangtuihuoxinxichaxunService.updateById(kufangtuihuoxinxichaxun)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (kufangtuihuoxinxichaxunService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

