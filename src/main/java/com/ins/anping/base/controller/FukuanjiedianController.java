package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Fukuanjiedian;
import com.ins.anping.base.service.impl.FukuanjiedianServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 付款节点 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/fukuanjiedian")
public class FukuanjiedianController {

    
    @Autowired
    private FukuanjiedianServiceImpl  fukuanjiedianService;
    
    @ApiOperation("查询所有付款节点")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Fukuanjiedian> list= fukuanjiedianService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Fukuanjiedian result = fukuanjiedianService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Fukuanjiedian> page){
        IPage<Fukuanjiedian> fukuanjiedianIPage= fukuanjiedianService.page(page);
        if(fukuanjiedianIPage != null) {
            return ResponseResult.okResult(200, "success", fukuanjiedianIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Fukuanjiedian fukuanjiedian){
        if (fukuanjiedianService.save(fukuanjiedian)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Fukuanjiedian fukuanjiedian){
        if (fukuanjiedianService.updateById(fukuanjiedian)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (fukuanjiedianService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

