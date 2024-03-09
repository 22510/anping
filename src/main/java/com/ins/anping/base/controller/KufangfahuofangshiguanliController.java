package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Kufangfahuofangshiguanli;
import com.ins.anping.base.service.impl.KufangfahuofangshiguanliServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 库房发货方式管理 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/kufangfahuofangshiguanli")
public class KufangfahuofangshiguanliController {

    
    @Autowired
    private KufangfahuofangshiguanliServiceImpl  kufangfahuofangshiguanliService;
    
    @ApiOperation("查询所有库房发货方式管理")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Kufangfahuofangshiguanli> list= kufangfahuofangshiguanliService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Kufangfahuofangshiguanli result = kufangfahuofangshiguanliService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Kufangfahuofangshiguanli> page){
        IPage<Kufangfahuofangshiguanli> kufangfahuofangshiguanliIPage= kufangfahuofangshiguanliService.page(page);
        if(kufangfahuofangshiguanliIPage != null) {
            return ResponseResult.okResult(200, "success", kufangfahuofangshiguanliIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Kufangfahuofangshiguanli kufangfahuofangshiguanli){
        if (kufangfahuofangshiguanliService.save(kufangfahuofangshiguanli)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Kufangfahuofangshiguanli kufangfahuofangshiguanli){
        if (kufangfahuofangshiguanliService.updateById(kufangfahuofangshiguanli)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (kufangfahuofangshiguanliService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

