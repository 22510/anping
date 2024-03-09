package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Kufangbeihuolishishujuchaxun;
import com.ins.anping.base.service.impl.KufangbeihuolishishujuchaxunServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 库房备货历史数据查询 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/kufangbeihuolishishujuchaxun")
public class KufangbeihuolishishujuchaxunController {

    
    @Autowired
    private KufangbeihuolishishujuchaxunServiceImpl  kufangbeihuolishishujuchaxunService;
    
    @ApiOperation("查询所有库房备货历史数据查询")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Kufangbeihuolishishujuchaxun> list= kufangbeihuolishishujuchaxunService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Kufangbeihuolishishujuchaxun result = kufangbeihuolishishujuchaxunService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Kufangbeihuolishishujuchaxun> page){
        IPage<Kufangbeihuolishishujuchaxun> kufangbeihuolishishujuchaxunIPage= kufangbeihuolishishujuchaxunService.page(page);
        if(kufangbeihuolishishujuchaxunIPage != null) {
            return ResponseResult.okResult(200, "success", kufangbeihuolishishujuchaxunIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Kufangbeihuolishishujuchaxun kufangbeihuolishishujuchaxun){
        if (kufangbeihuolishishujuchaxunService.save(kufangbeihuolishishujuchaxun)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Kufangbeihuolishishujuchaxun kufangbeihuolishishujuchaxun){
        if (kufangbeihuolishishujuchaxunService.updateById(kufangbeihuolishishujuchaxun)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (kufangbeihuolishishujuchaxunService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

